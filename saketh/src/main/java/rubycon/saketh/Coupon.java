package rubycon.saketh;

import java.nio.charset.Charset;
import java.util.Random;

public class Coupon {
    //public static String givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect() {
    // String generatedString = RandomStringUtils.randomAlphanumeric(7);

    //return (generatedString);
    //}

    public String givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect() {
        final byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        final String generatedString = new String(array, Charset.forName("ASCII"));

        System.out.println(generatedString);
        return generatedString;
    }

}
