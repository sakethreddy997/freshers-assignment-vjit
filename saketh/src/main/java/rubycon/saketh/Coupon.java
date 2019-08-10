package rubycon.saketh;

import java.util.Random;

public class Coupon {



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


