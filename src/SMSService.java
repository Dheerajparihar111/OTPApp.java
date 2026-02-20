public class SMSService {

    public void sendOTP(String mobileNumber, String otpCode) {

        System.out.println("\nSending OTP to " + mobileNumber + "...");

        try {
            Thread.sleep(1500); // simulate network delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("OTP sent successfully!");

        // For simulation/testing purpose only
        System.out.println("(Simulation) OTP delivered: " + otpCode);
    }
}