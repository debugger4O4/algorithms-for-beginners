import java.util.HashMap;

public class BoyerMooreHorspool {

    // Алгоритм
    public void boyerMooreHorspool(char[] needle, char[] haystack) {

        int[] result = new int[haystack.length];

        if (needle.length > haystack.length || needle == haystack) {
            System.out.println("Needle is longer or the same as haystack");
            return;
        }

        HashMap<Character, Integer> badShift = new HashMap<>();

        int offset = 0, scan;
        int last = needle.length - 1;
        int maxOffset = haystack.length - needle.length;
        for (int i = 0; i < needle.length; i++) {
            if (last - i == 0) {
                badShift.put(needle[i], 1);
            } else {
                badShift.put(needle[i], last - i);
            }
        }
        StringBuilder match = new StringBuilder();
        while (offset <= maxOffset) {
            for (scan = last; needle[scan] == haystack[scan + offset] || needle[scan] == '_'; scan--) {
                if (scan == 0) {
                    match = new StringBuilder();
                    for (int i = 0; i < needle.length; i++) {
                        match.append(haystack[offset + i]);
                    }
                    System.out.println("Match: " + match);
                    break;
                }
            }

            if (needle[scan] == '_') {
                offset += 1;
            } else if (badShift.containsKey(haystack[offset + last])) {
                offset += badShift.get(haystack[offset + last]);
            } else {
                offset += needle.length;
            }
        }
        if (match.toString().equals("")) {
            System.out.println("No match found");
        }
    }
}
