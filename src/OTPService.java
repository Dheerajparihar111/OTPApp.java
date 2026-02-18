import java.security.SecureRandom;

public class OTPService {

    private static final SecureRandom random = new SecureRandom();
    private static final long VALIDITY_DURATION = 60000; // 60 seconds

    // Allowed characters (uppercase + digits)
    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public OTP generateOTP(int length) {

        StringBuilder otpBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHAR_POOL.length());
            otpBuilder.append(CHAR_POOL.charAt(index));
        }

        long expiryTime = System.currentTimeMillis() + VALIDITY_DURATION;

        return new OTP(otpBuilder.toString(), expiryTime);
    }

    public boolean verifyOTP(OTP otp, String input) {
        return otp.getCode().equalsIgnoreCase(input);
    }

    public boolean isExpired(OTP otp) {
        return System.currentTimeMillis() > otp.getExpiryTime();
    }
}
