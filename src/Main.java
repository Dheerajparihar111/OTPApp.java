import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        OTPService service = new OTPService();
        System.out.println("=====================");
        System.out.println("| Select OTP Length:|");
        System.out.println("| 1) 4-digit OTP    |");
        System.out.println("| 2) 6-digit OTP    |");
        System.out.println("| 3) 8-digit OTP    |");
        System.out.println("=====================");
        System.out.print("Enter choice:");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        int length;
        if (choice == 1) {
            length = 4;
        } else if (choice == 2) {
            length = 6;
        }else if (choice == 3) {
            length = 8;
        }else {
            System.out.println("Invalid choice. Defaulting to 6-digit OTP.");
            length = 6;
        }

        OTP otp = service.generateOTP(length);

        System.out.println("\nGenerated OTP: " + otp.getCode());
        System.out.println("OTP is valid for 60 seconds.");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<String> inputTask = () -> {
            System.out.print("Enter OTP: ");
            return scanner.nextLine();
        };

        Callable<String> timerTask = () -> {
            Thread.sleep(60000);
            return "EXPIRED";
        };

        String result;
        try {
            result = executor.invokeAny(
                    java.util.Arrays.asList(inputTask, timerTask)
            );
        } catch (Exception e) {
            result = "EXPIRED";
        }

        if ("EXPIRED".equals(result)) {
            System.out.println("\nOTP Expired.");
        } else {
            boolean valid = service.verifyOTP(otp, result);
            if (valid) {
                System.out.println("______________________________");
                System.out.println("| OTP Verified Successfully! |");
                System.out.println("------------------------------");
            } else {
                System.out.println("Invalid OTP.");
            }
        }

        executor.shutdownNow();
        scanner.close();
    }
}
