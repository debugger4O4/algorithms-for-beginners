public class MinimalPerfectMapping {

    // Массив значений для каждой буквы алфавита
    private static final int[] C = new int[]{
            3, 23, -1, 17, 7, 11, -1, 5, 0,
            -1, -1, -1, 16, 17, 9, -1, -1, 13,
            4, 0, 23, -1, 8, -1, 4, -1
    };

    // Алгоритм
    public static int minimalPerfectMapping(String s) {
        int length = s.length();
        int firstLetterIndex = ordinal(s.charAt(0));
        int lastLetterIndex = ordinal(s.charAt(length - 1));
        int result = length + C[firstLetterIndex] + C[lastLetterIndex];
        return result;
    }

    private static int ordinal(char c) {
        return Character.toLowerCase(c) - 'a';
    }
}
