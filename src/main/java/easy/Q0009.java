package easy;

public class Q0009 {
    public static void main(String[] args) {
        final Q0009 q = new Q0009();
        for (int x : new int[]{
                121, -121, 10, 100, 101
        }) {
            System.out.println(q.isPalindrome(x));
        }
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = (revertedNumber * 10) + (x % 10);
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber/10;
    }
}
