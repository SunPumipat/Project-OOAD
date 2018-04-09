import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FarmSystem farmSystem = new FarmSystem();
        String username, password, role;

        while (true) {
            System.out.print("Username: ");
            username = input.next();
            System.out.print("Password: ");
            password = input.next();
            System.out.print("Role [1]Admin [2]Farmer [3]Farm Owner: ");
            role = input.next();

            if (farmSystem.loginSystem(username, password, role)) {
                farmSystem.menuFarm();
            }
        }


    }
}
