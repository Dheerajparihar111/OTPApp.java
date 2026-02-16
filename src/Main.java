import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OTPService service = new OTPService();

        OTP otp = service.generateOTP();

        System.out.println("Generated OTP: " + otp.getCode());
        System.out.println("OTP valid for 60 seconds.");

        System.out.print("Enter OTP: ");
        String input = scanner.nextLine();

        boolean isValid = service.verifyOTP(otp, input);

        if (isValid) {
            System.out.println("OTP Verified Successfully!");
        } else {
            System.out.println("Invalid OTP.");
        }

        scanner.close();
    }
}
