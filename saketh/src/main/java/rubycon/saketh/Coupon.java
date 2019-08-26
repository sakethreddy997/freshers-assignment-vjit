package rubycon.saketh;

import java.util.Random;

public class Coupon {


    public String generate_code() {
        final int leftLimit = 65; // letter 'A'
        final int rightLimit = 90; // letter 'Z' if we need both capital and small then set limit as 65-97-122
        final int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);

        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = (int) (leftLimit + random.nextFloat() * (rightLimit - leftLimit));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();


        return generatedString;
    }
    }


