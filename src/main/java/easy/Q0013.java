package easy;

public class Q0013 {
    private static final int[] ROMAN_TABLE = new int['X' - 'C' + 1];

    static {
        ROMAN_TABLE['I' - 'C'] = 1;
        ROMAN_TABLE['V' - 'C'] = 5;
        ROMAN_TABLE['X' - 'C'] = 10;
        ROMAN_TABLE['L' - 'C'] = 50;
        ROMAN_TABLE['C' - 'C'] = 100;
        ROMAN_TABLE['D' - 'C'] = 500;
        ROMAN_TABLE['M' - 'C'] = 1000;
    }

    public static void main(String[] args) {
        final Q0013 q = new Q0013();
        for (String testcase : new String[]{
                "III",
                "LVIII",
                "MCMXCIV"
        })
        System.out.println(q.romanToInt(testcase));
    }

    private static int convert(char c) {
        return ROMAN_TABLE[c - 'C'];
    }

    public int romanToInt(String s) {
        int ret = 0, prev = 0;
        for (int i = s.length() - 1; i > -1; --i) {
            final char c = s.charAt(i);
            final int num = convert(c);
            ret = num < prev ? ret - num : ret + num;
            prev = num;
        }
        return ret;
    }
}
