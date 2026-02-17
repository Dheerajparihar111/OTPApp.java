import java.security.SecureRandom;

public class OTPService {

    private static final SecureRandom random = new SecureRandom();

    public OTP generateOTP(int length) {

        int bound = (int) Math.pow(10, length);
        int otpValue = random.nextInt(bound);

        String format = "%0" + length + "d";
        String otpCode = String.format(format, otpValue);

        long expiryTime = System.currentTimeMillis() + 60000;

        return new OTP(otpCode, expiryTime);
    }

    public boolean verifyOTP(OTP otp, String input) {

        if (System.currentTimeMillis() > otp.getExpiryTime()) {
            return false;
        }

        return otp.getCode().equals(input);
    }
}
