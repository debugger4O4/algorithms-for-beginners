public class AESDecipher {
    private static ExpandKeyDecipher rk;

    private static short[][] inverseSBox =
            {{0x52, 0x09, 0x6a, 0xd5, 0x30, 0x36, 0xa5, 0x38, 0xbf, 0x40, 0xa3, 0x9e, 0x81, 0xf3, 0xd7, 0xfb},
                    {0x7c, 0xe3, 0x39, 0x82, 0x9b, 0x2f, 0xff, 0x87, 0x34, 0x8e, 0x43, 0x44, 0xc4, 0xde, 0xe9, 0xcb},
                    {0x54, 0x7b, 0x94, 0x32, 0xa6, 0xc2, 0x23, 0x3d, 0xee, 0x4c, 0x95, 0x0b, 0x42, 0xfa, 0xc3, 0x4e},
                    {0x08, 0x2e, 0xa1, 0x66, 0x28, 0xd9, 0x24, 0xb2, 0x76, 0x5b, 0xa2, 0x49, 0x6d, 0x8b, 0xd1, 0x25},
                    {0x72, 0xf8, 0xf6, 0x64, 0x86, 0x68, 0x98, 0x16, 0xd4, 0xa4, 0x5c, 0xcc, 0x5d, 0x65, 0xb6, 0x92},
                    {0x6c, 0x70, 0x48, 0x50, 0xfd, 0xed, 0xb9, 0xda, 0x5e, 0x15, 0x46, 0x57, 0xa7, 0x8d, 0x9d, 0x84},
                    {0x90, 0xd8, 0xab, 0x00, 0x8c, 0xbc, 0xd3, 0x0a, 0xf7, 0xe4, 0x58, 0x05, 0xb8, 0xb3, 0x45, 0x06},
                    {0xd0, 0x2c, 0x1e, 0x8f, 0xca, 0x3f, 0x0f, 0x02, 0xc1, 0xaf, 0xbd, 0x03, 0x01, 0x13, 0x8a, 0x6b},
                    {0x3a, 0x91, 0x11, 0x41, 0x4f, 0x67, 0xdc, 0xea, 0x97, 0xf2, 0xcf, 0xce, 0xf0, 0xb4, 0xe6, 0x73},
                    {0x96, 0xac, 0x74, 0x22, 0xe7, 0xad, 0x35, 0x85, 0xe2, 0xf9, 0x37, 0xe8, 0x1c, 0x75, 0xdf, 0x6e},
                    {0x47, 0xf1, 0x1a, 0x71, 0x1d, 0x29, 0xc5, 0x89, 0x6f, 0xb7, 0x62, 0x0e, 0xaa, 0x18, 0xbe, 0x1b},
                    {0xfc, 0x56, 0x3e, 0x4b, 0xc6, 0xd2, 0x79, 0x20, 0x9a, 0xdb, 0xc0, 0xfe, 0x78, 0xcd, 0x5a, 0xf4},
                    {0x1f, 0xdd, 0xa8, 0x33, 0x88, 0x07, 0xc7, 0x31, 0xb1, 0x12, 0x10, 0x59, 0x27, 0x80, 0xec, 0x5f},
                    {0x60, 0x51, 0x7f, 0xa9, 0x19, 0xb5, 0x4a, 0x0d, 0x2d, 0xe5, 0x7a, 0x9f, 0x93, 0xc9, 0x9c, 0xef},
                    {0xa0, 0xe0, 0x3b, 0x4d, 0xae, 0x2a, 0xf5, 0xb0, 0xc8, 0xeb, 0xbb, 0x3c, 0x83, 0x53, 0x99, 0x61},
                    {0x17, 0x2b, 0x04, 0x7e, 0xba, 0x77, 0xd6, 0x26, 0xe1, 0x69, 0x14, 0x63, 0x55, 0x21, 0x0c, 0x7d}};

    private static short[][] invMixMatrix = {{14, 11, 13, 9}, {9, 14, 11, 13}, {13, 9, 14, 11}, {11, 13, 9, 14}};

    // Алгоритм
    public static KeyDecipher aesDecipher(byte[] b, KeyDecipher k, int n) {
        short[][] s = createState(b);
        rk = new ExpandKeyDecipher(k);
        s = addRoundKey(s, rk.getRoundKey(n));
        for (int i = 1; i < n; i++) {
            s = invSubBytes(s);
            s = invShiftRows(s);
            s = addRoundKey(s, rk.getRoundKey(n - i));
            s = invMixColumns(s);
        }
        s = invShiftRows(s);
        s = invSubBytes(s);
        s = addRoundKey(s, rk.getRoundKey(0));
        return new KeyDecipher(s);
    }

    private static short[][] createState(byte[] b) {
        short[][] result = new short[4][4];
        for (int i = 0; i < b.length; i++) {
            int j = i % 4, k = i / 4;
            result[j][k] = (byte) i;
        }
        return result;
    }

    // Выполняет XOR i-й ключ раунда с stateMatrix и обновляет матрицу состояний. Вокруг текущего раунда (от 0 до 10)
    private static short[][] addRoundKey(short[][] s, short[][] rk) {
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                int intermediate = rk[row][column] ^ s[row][column];
                s[row][column] = (short) intermediate;
            }
        }
        return s;
    }

    // Заменяет все байты в матрице состояний с помощью S-блока
    private static short[][] invSubBytes(short[][] s) {
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                short value = s[row][column];
                s[row][column] = inverseSBox[rk.highNibble(value)][rk.lowNibble(value)];
            }
        }
        return s;
    }

    /*
        Выполняет этап расшифровки InvShiftRows. Циклически сдвигает последние три строки stateMatrix вправо на 1, 2 и 3
        соответственно
     */
    private static short[][] invShiftRows(short[][] s) {
        /*
            Сдвигает строку 1 вправо на 1, строку 2 вправо на 2 и строку 3 вправо на 3. Строка 0 остается прежней.
            1 ряд, сдвиг вправо на 1
        */
        short temp = s[1][3];
        for (int column = 3; column > 0; column--) {
            s[1][column] = s[1][column - 1];
        }
        s[1][0] = temp;

        /*
            Сдвиг вправо строки 2 на 2 аналогичен сдвигу строки 2 влево на 2, поэтому мы используем тот же код из
            shiftRows() AESCipher
        */
        int row = 2;
        short[] old2 = {s[row][0], s[row][1], s[row][2], s[row][3]};
        for (int column = 0; column < 4; column++) {
            s[row][column] = old2[(column + 2) % 4];
        }

        /*
            Сдвиг вправо на 3 строки 3 аналогичен строке 3, сдвиг влево на 1, поэтому мы используем сдвиг влево на 1
            из shiftRows() AESCipher, за исключением строки 3 на этот раз
        */
        temp = s[3][0];
        for (int column = 0; column < 3; column++) {
            s[3][column] = s[3][column + 1];
        }
        s[3][3] = temp;
        return s;
    }


    // Выполняет шаг mixColumns() для расшифрования AES
    private static short[][] invMixColumns(short[][] s) {
        for (int c = 0; c < 4; c++) {
            mixColumn(c, s);
        }
        return s;
    }

    // Смешивает один столбец
    private static void mixColumn(int stateColumn, short[][] s) {
        /*
            Код такой же, как и у шифрования, он просто вызывает InvGMultiply вместо gMultiply и использует invMixMatrix
            вместо mixMatrix
        */
        short[] result = {0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            short currentSum = 0;
            for (int j = 0; j < 4; j++) {
                short intermediate = invGMultiply(s[j][stateColumn], invMixMatrix[i][j]);
                currentSum = (short) (intermediate ^ currentSum);
            }
            result[i] = currentSum;
        }
        for (int i = 0; i < 4; i++) {
            s[i][stateColumn] = result[i]; // Помещает результат в s в столбце stateColumn
        }
    }

    /*
        Умножает значение на коэффициент 9, 11, 13 или 14 по GF(2^8)
        value — значение, на которое мы умножаем
        param — коэффициент, на который мы умножаем (должно быть 9, 11, 13 или 14). Возвращает значение, если фактор недействителен
        return произведение value * factor на GF(2^8) как short
     */
    private static short invGMultiply(short value, int factor) {
        if (factor == 2) {
            byte set = (byte) ((0x80 & value) >> 7); // Принимает старшее битовое значение

            value = (short) ((value << 1) & 0xff); // Сдвинуть значение влево на единицу
            if (set == 1) {
                value = (short) (value ^ 0x1b);
            }
            return value;
        } else if (factor == 9) {
            value = (short) (invGMultiply(invGMultiply(invGMultiply(value, 2), 2), 2) ^ value);

            return value;
        } else if (factor == 11) {
            value = (short) (invGMultiply((short) (invGMultiply(invGMultiply(value, 2), 2) ^ value), 2) ^ value);
            return value;
        } else if (factor == 13) {
            value = (short) (invGMultiply(invGMultiply((short) (invGMultiply(value, 2) ^ value), 2), 2) ^ value);
            return value;
        } else if (factor == 14) {
            value = invGMultiply((short) (invGMultiply((short) (invGMultiply(value, 2) ^ value), 2) ^ value), 2);
            return value;
        } else {
            System.out.println("ВЫ ЧТО-ТО СДЕЛАЛИ НЕ ТАК!");
            return value;
        }
    }
}
