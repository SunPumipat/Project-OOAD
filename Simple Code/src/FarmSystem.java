import java.util.Scanner;

public class FarmSystem {
    private String account;
    private String role;
    private boolean isRun = false;

    public boolean loginSystem(String usr, String psw, String role) {

        boolean isVerify = AppUser.verifyUser(usr, psw, role);
        if (isVerify) {
            this.account = usr;
            this.role = role;
            setRun(true);
        }
        return isVerify;
    }

    public void logoutSystem() {
        setRun(false);
    }

    public boolean registerSystem(String usr, String psw) {
        boolean addNew = AppUser.addUser(usr, psw);
        return addNew;
    }

    public void menuFarm() {
        while (isRun()) {
            if (role.equals("1")) {
                adminMenu();
            } else if (role.equals("2")) {

            } else if (role.equals("3")) {

            }
        }
    }

    private void adminMenu() {
        Admin admin = new Admin(account);
        Scanner input = new Scanner(System.in);
        int choose;
        System.out.println("\n|--------HELLO Admin: "+account +" --------|");
        System.out.print("[0]Logout: ");
        choose = input.nextInt();

        switch (choose){
            case 0: logoutSystem();
                break;
        }
    }

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

}
