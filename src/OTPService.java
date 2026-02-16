import java.security.SecureRandom;

public class OTPService {

    private static final int OTP_LENGTH = 6;
    private static final int EXPIRY_SECONDS = 60;

    private SecureRandom random = new SecureRandom();

    public OTP generateOTP() {

        int number = random.nextInt(900000) + 100000;
        String code = String.valueOf(number);

        long expiryTime = System.currentTimeMillis() + (EXPIRY_SECONDS * 1000);

        return new OTP(code, expiryTime);
    }

    public boolean verifyOTP(OTP otp, String userInput) {

        if (System.currentTimeMillis() > otp.getExpiryTime()) {
            System.out.println("OTP Expired.");
            return false;
        }

        return otp.getCode().equals(userInput);
    }
}
