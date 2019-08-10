package rubycon.saketh;

import java.util.Random;

public class Coupon {
    //public static String givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect() {
    // String generatedString = RandomStringUtils.randomAlphanumeric(7);

    //return (generatedString);
    //}

    //public String givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect() {
    //final byte[] array = new byte[7]; // length is bounded by 7
    //new Random().nextBytes(array);
    //final String generatedString = new String(array, Charset.forName("ASCII"));

    //System.out.println(generatedString);

    //return generatedString;
    public String givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {
        final int leftLimit = 97; // letter 'a'
        final int rightLimit = 122; // letter 'z'
        final int targetStringLength = 10;
        final StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            final int randomLimitedInt = leftLimit + (int) (new Random().nextFloat() * (rightLimit - leftLimit));
            buffer.append((char) randomLimitedInt);
        }
        final String generatedString = buffer.toString();


        return generatedString;
    }
    }


