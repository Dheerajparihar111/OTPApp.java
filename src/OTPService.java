import java.security.SecureRandom;

public class OTPService {

    private static final SecureRandom random = new SecureRandom();
    private static final long VALIDITY_DURATION = 60000;

    private static final String NUMERIC_POOL = "0123456789";
    private static final String ALPHANUMERIC_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public OTP generateOTP(int length, OTPType type) {

        String pool = (type == OTPType.NUMERIC)
                ? NUMERIC_POOL
                : ALPHANUMERIC_POOL;

        StringBuilder otpBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(pool.length());
            otpBuilder.append(pool.charAt(index));
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
