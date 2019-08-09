package rubycon.saketh;

import org.apache.commons.lang3.RandomStringUtils;

public class Coupon {
    public static String givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect() {
        String generatedString = RandomStringUtils.randomAlphanumeric(7);

        return (generatedString);
    }
}
