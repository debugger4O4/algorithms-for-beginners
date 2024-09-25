import java.security.SecureRandom;

/**
 * Класс для того, чтобы ключи можно было легко распечатать в целях тестирования. Он также может генерировать случайный ключ
 */
public class KeyDecipher {
    // short, потому что byte не позволяет сохранять соответствующие шестнадцатеричные значения
    private short[][] keyValue = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

    //Генерирует криптографически безопасный случайный ключ
    public KeyDecipher() {
        SecureRandom random = new SecureRandom();

        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        // Количество блоков в расширенном ключе (4 для AES-128, 6 для AES-192 и 8 для AES-256)
        int b = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                keyValue[i][j] = (short) (bytes[b] & 0xff);
                b++;
            }
        }
    }

    public KeyDecipher(short[][] k) {
        keyValue = k;
    }

    public short[][] getKeyValue() {
        return keyValue;
    }

    // Настраивает ключ как список шестнадцатеричных цифр
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (short[] x : keyValue)
            for (short y : x)
                result.append(String.format("%02X", y)).append(" ");
        return result.toString();
    }
}
