import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FarmSystem farmSystem = new FarmSystem();
        String username, password, role;
        int check;

        while (true) {
            System.out.print("\n[1]Login [2]Register: ");
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

            }else if(check == 2){
                System.out.print("\nUsername: ");
                username = input.next();
                System.out.print("Password: ");
                password = input.next();
                if (farmSystem.registerSystem(username,password)){
                    System.out.println("|----Success Register!! Wait for administrator to approve----|");
                }else {
                    System.out.println("|----Success Fail!!----|");
                }
            }

        }

    }
}
