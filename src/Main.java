import java.util.Scanner;

public class Main {

    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OTPService service = new OTPService();
        System.out.println("=====================");
        System.out.println("| Select OTP Length:|");
        System.out.println("| 1) 4-characters   |");
        System.out.println("| 2) 6-characters    |");
        System.out.println("| 3) 8-characters   |");
        System.out.println("=====================");
        System.out.print("Enter choice: ");

        int lengthChoice = scanner.nextInt();
        scanner.nextLine();

        int length = (lengthChoice == 1) ? 4 : 6;

        // OTP Type Selection
        System.out.println("====================");
        System.out.println("| Select OTP Type: |");
        System.out.println("| 1) Digits only   |");
        System.out.println("| 2) Alphanumeric  |");
        System.out.println("====================");
        System.out.print("Enter choice: ");

        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        OTPType type = (typeChoice == 1)
                ? OTPType.NUMERIC
                : OTPType.ALPHANUMERIC;

        OTP otp = service.generateOTP(length, type);

        System.out.println("\nGenerated OTP: " + otp.getCode());
        System.out.println("OTP valid for 60 seconds.");
        System.out.println("Maximum attempts allowed: 3");

        int attempts = 0;
        boolean verified = false;

        while (attempts < MAX_ATTEMPTS) {

            if (service.isExpired(otp)) {
                System.out.println("\nOTP Expired.");
                break;
            }

            System.out.print("\nEnter OTP: ");
            String input = scanner.nextLine();

            attempts++;

            if (service.verifyOTP(otp, input)) {
                verified = true;
                break;
            } else {
                System.out.println("Invalid OTP. Attempts left: "
                        + (MAX_ATTEMPTS - attempts));
            }
        }

        if (verified) {
            System.out.println("______________________________");
            System.out.println("| OTP Verified Successfully! |");
            System.out.println("------------------------------");
        } else if (attempts >= MAX_ATTEMPTS) {
            System.out.println("\nAccount Locked. Maximum attempts exceeded.");
        }

        scanner.close();
    }
}
