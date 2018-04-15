import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FarmSystem farmSystem = new FarmSystem();
        String username, password, role;
        int check;

        while (true) {
            System.out.print("\n[1]Login \n[2]Register\n: ");
            check = input.nextInt();

            if (check == 1) {
                System.out.print("\nUsername: ");
                username = input.next();
                System.out.print("Password: ");
                password = input.next();
                System.out.print("Role [1]Admin [2]Farmer [3]Farm Owner: ");
                role = input.next();

                if (farmSystem.loginSystem(username, password, role)) {
                    farmSystem.menuFarm();
                }

            } else if (check == 2) {
                System.out.print("\nUsername: ");
                username = input.next();
                System.out.print("Password: ");
                password = input.next();
                System.out.print("Name: ");
                String name = input.next();
                System.out.print("Surname: ");
                String sname = input.next();
                System.out.print("Email: ");
                String mail = input.next();
                System.out.print("Phone Number: ");
                String phone = input.next();
                System.out.print("Birthday (dd/mm/yyyy): ");
                String birth = input.next();

                if (farmSystem.registerSystem(username, password, name, sname,mail, phone, birth)) {
                    System.out.println("|----Success Register!! Wait for administrator to approve----|");
                } else {
                    System.out.println("|----Register Fail!!----|");
                }
            }

        }

    }
}
