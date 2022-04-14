package easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q0020Test {

    @Test
    void isValid() {
        final Q0020 q = new Q0020();
        final String[] testcases = new String[]{
                "()",
                "()[]{}",
                "(]",
                "{{}[][[[]]]}",
                "[",
                "]"
        };
        final boolean[] expected = new boolean[]{
               true, true, false, true, false, false
        };
        for (int i = 0; i < testcases.length; i++) {
            final boolean actual = q.isValid(testcases[i]);
            assertEquals(expected[i], actual);
            System.out.println(actual);
        }
    }
}