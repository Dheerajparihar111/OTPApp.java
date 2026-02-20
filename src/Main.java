import java.util.Scanner;

public class Main {

    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OTPService service = new OTPService();

        System.out.println("_________________________________");
        System.out.println("         OTP AUTH SYSTEM         ");
        System.out.println("=================================");

        // ---------------- OTP LENGTH ----------------
        System.out.println("=====================");
        System.out.println("| Select OTP Length:|");
        System.out.println("| 1) 4 characters   |");
        System.out.println("| 2) 6 characters   |");
        System.out.println("| 3) 8 characters   |");
        System.out.println("=====================");
        System.out.print("Enter choice: ");

        int lengthChoice = scanner.nextInt();
        scanner.nextLine();

        int length;
        switch (lengthChoice) {
            case 1: length = 4; break;
            case 2: length = 6; break;
            case 3: length = 8; break;
            default:
                System.out.println("Invalid choice. Defaulting to 6 characters.");
                length = 6;
        }

        // ---------------- OTP TYPE ----------------
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

        // ---------------- DELIVERY MODE ----------------
        System.out.println("=================================");
        System.out.println("| Select Delivery Mode:         |");
        System.out.println("| 1) Display on Console         |");
        System.out.println("| 2) Send to Mobile (Simulation)|");
        System.out.println("=================================");
        System.out.print("Enter choice: ");

        int deliveryChoice = scanner.nextInt();
        scanner.nextLine();

        DeliveryMode mode = (deliveryChoice == 2)
                ? DeliveryMode.MOBILE
                : DeliveryMode.CONSOLE;

        // ---------------- GENERATE OTP ----------------
        OTP otp = service.generateOTP(length, type);

        String mobileNumber = null;

        if (mode == DeliveryMode.MOBILE) {
            System.out.print("Enter mobile number: ");
            mobileNumber = scanner.nextLine();
        }

        service.deliverOTP(otp, mode, mobileNumber);

        System.out.println("\nOTP valid for 60 seconds.");
        System.out.println("Maximum attempts allowed: 3");

        // ---------------- VERIFICATION LOOP ----------------
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
            System.out.println("\n______________________________");
            System.out.println(" | OTP Verified Successfully! | ");
            System.out.println("--------------------------------");
        } else if (attempts >= MAX_ATTEMPTS) {
            System.out.println("\nAccount Locked. Maximum attempts exceeded.");
        }

        scanner.close();
    }
}