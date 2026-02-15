import java.util.*;
import java.security.SecureRandom;
class Homepage{
void  Homepage(){
        System.out.println("=============================");
        System.out.println("| 1) Randomly Generated OTP |");
        System.out.println("| 2) Secure OTP             |");
        System.out.println("| 3) Exit                   |");
        System.out.println("=============================");
        System.out.print("Enter Your Choice :");
    }
}
public class Main {
    static void main(String[] args) {
        Random random = new Random();
        SecureRandom secureRandom = new SecureRandom();
        Homepage homepage = new Homepage();
        Scanner input = new Scanner(System.in);
        System.out.println("***********Wel-Come To OTP App*********");
        while (true) {
            homepage.Homepage();
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    int OTP = random.nextInt(10000);
                    System.out.println("The Generated OTP:" + OTP);
                    break;
                case 2:
                    int otp = secureRandom.nextInt(10000);
                    System.out.println("The Generated OTP:" + otp);
                    break;
                case 3:
                    System.out.println("Thank You For Using OTP generating App");
                    System.exit(0);
            }
        }

    }
}