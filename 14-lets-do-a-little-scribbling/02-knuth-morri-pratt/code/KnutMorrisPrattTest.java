import org.junit.Test;

public class KnutMorrisPrattTest {

    @Test
    public void test() {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KnuthMorrisPratt.knuthMorrisPratt(pat, txt);
    }
}
