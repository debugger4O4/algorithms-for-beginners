/**
 * Advanced Encryption Standard(AES) (Расширенный стандарт шифрования)
 * 128 бит
 */
public class AESCipher {

    private static ExpandKeyCipher rk;
    private static final short[][] sBox = {
            {0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76},
            {0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0},
            {0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15},
            {0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75},
            {0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84},
            {0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf},
            {0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8},
            {0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2},
            {0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73},
            {0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb},
            {0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79},
            {0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08},
            {0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a},
            {0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e},
            {0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf},
            {0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16}
    };
    private static final short[][] mixMatrix = {{2, 3, 1, 1}, {1, 2, 3, 1}, {1, 1, 2, 3}, {3, 1, 1, 2}};

    // Алгоритм
    public static KeyCipher aesCipher(byte[] b, KeyCipher k, int n) {
        short[][] s = createState(b);
        rk = new ExpandKeyCipher(k);
        s = addRoundKey(s, rk.getRoundKey(0));
        // 9 нормальных раундов
        for (int i = 1; i < n; i++) {
            s = subBytes(s);
            s = shiftRows(s);
            s = mixColumns(s);
            s = addRoundKey(s, rk.getRoundKey(i));
        }
        s = subBytes(s);
        s = shiftRows(s);
        s = addRoundKey(s, rk.getRoundKey(n));
        return new KeyCipher(s);
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
    private static short[][] subBytes(short[][] s) {
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                short value = s[row][column];
                s[row][column] = sBox[rk.highNibble(value)][rk.lowNibble(value)];
            }
        }
        return s;
    }

    /*
        Выполняет AES ShiftRows в stateMatrix. Сдвигает строку 1 влево на 1, строку 2 влево на 2 и строку 3 влево на 3.
        Строка 0 остается прежней
     */
    private static short[][] shiftRows(short[][] s) {
        // Строка 1, сдвиг влево на 1
        short temp = s[1][0];
        for (int column = 0; column < 3; column++) {
            s[1][column] = s[1][column + 1];
        }
        s[1][3] = temp;

        // 2 ряд, сдвиг влево на 2
        int row = 2;
        short[] old2 = {s[row][0], s[row][1], s[row][2], s[row][3]};
        for (int column = 0; column < 4; column++) {
            s[row][column] = old2[(column + 2) % 4];
        }

        // 3-я строка, сдвиг влево на 3
        row = 3;
        short[] old3 = {s[row][0], s[row][1], s[row][2], s[row][3]};
        for (int column = 0; column < 4; column++) {
            s[row][column] = old3[(column + 3) % 4];
        }
        return s;
    }


    // Выполняет шаг mixColumns() шифрования AES
    private static short[][] mixColumns(short[][] s) {
        for (int c = 0; c < 4; c++) {
            mixColumn(c, s);
        }
        return s;
    }

    // Смешивает один столбец
    private static void mixColumn(int stateColumn, short[][] s) {
        short[] result = {0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            short currentSum = 0;
            for (int j = 0; j < 4; j++) {
                short intermediate = gMultiply(s[j][stateColumn], mixMatrix[i][j]);
                currentSum = (short) (intermediate ^ currentSum);
            }
            result[i] = currentSum;
        }
        for (int i = 0; i < 4; i++) {
            s[i][stateColumn] = result[i]; // Помещает результат в s в столбце stateColumn
        }
    }

    /*
        Умножает значение на коэффициент 1, 2 или 3 по GF(2^8) (Поле Галуа, состоящее из конечного числа элементов (2^8 = 256))
        value значение, на которое мы умножаем коэффициент, на который мы умножаем (должен быть 1, 2 или 3).
        Возвращает 0, если коэффициент недействителен
        return произведение коэффициента стоимости на G(2^8)
     */
    private static short gMultiply(short value, int factor) {
        if (factor == 1) {
            return value;
        } else if (factor == 2) {
            byte set = (byte) (0x80 & value >> 7); // Принимает старшее битовое значение
            value = (short) ((value << 1) & 0xff); // Сдвинуть значение влево на единицу
            if (set == 1) {
                value = (short) (value ^ 0x1b);
            }
            return value;
        } else if (factor == 3) {
            value = (short) (value ^ gMultiply(value, (byte) 2));
            return value;
        } else {
            System.out.println("ЧТО-ТО ПОШЛО НЕ ТАК!");
            return 0;
        }
    }
}
