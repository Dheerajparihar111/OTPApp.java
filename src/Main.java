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
                    System.out.println("1)Randomly Generated 4-Digit OTP");
                    System.out.println("2)Randomly Generated 6-Digit OTP");
                    System.out.println("3)Randomly Generated 8-Digit OTP");
                    System.out.print("Enter your choice :");
                     choice =input.nextInt();
                     switch (choice){
                         case 1:
                              int OTP4 = random.nextInt(10000);
                              System.out.println("The Generated OTP:" + OTP4);
                              break;
                         case 2:
                            int OTP6 = random.nextInt(1000000);
                             System.out.println("The Generated OTP:" + OTP6);
                             break;
                         case 3:
                             int OTP8 = random.nextInt(100000000);
                             System.out.println("The Generated OTP:" + OTP8);
                             break;

                     }break;

                case 2:
                    System.out.println("1)Randomly Generated 4-Digit OTP");
                    System.out.println("2)Randomly Generated 6-Digit OTP");
                    System.out.println("3)Randomly Generated 8-Digit OTP");
                    System.out.print("Enter your Choice: ");
                     choice =input.nextInt();
                     switch (choice){
                         case  1:
                             int otp4 = secureRandom.nextInt(10000);
                             System.out.println("The Generated OTP:" + otp4);
                             break;
                         case 2:
                             int otp6 = secureRandom.nextInt(1000000);
                             System.out.println("The Generated OTP:" + otp6);
                             break;
                         case 3:
                             int otp8 = secureRandom.nextInt(100000000);
                             System.out.println("The Generated OTP:" + otp8);
                             break;
                     }break;

                case 3:
                    System.out.println("Thank You For Using OTP generating App");
                    System.exit(0);

            }
        }

    }
}