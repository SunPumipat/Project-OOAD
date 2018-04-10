import java.util.Scanner;

public class FarmSystem {
    private String account;
    private String role;
    private Admin admin = null;
    private Farmer farmer = null;
    private FarmOwner farmOwner = null;
    private boolean isRun = false;

    public boolean loginSystem(String usr, String psw, String role) {

        boolean isVerify = AppUser.verifyUser(usr, psw, role);
        if (isVerify) {
            this.account = usr;
            this.role = role;
            setRun(true);
            if (role.equals(1)) {
                admin = new Admin(account);
            } else if (role.equals(2)) {
                farmer = new Farmer(account);
            } else if (role.equals(3)) {
                farmOwner = new FarmOwner(account);
            }
        }
        return isVerify;
    }

    public void logoutSystem(){
        setRun(false);
    }

    public boolean registerSystem(String usr , String psw){
        boolean addNew = AppUser.addUser(usr, psw);
        return addNew;
    }

    public void menuFarm() {
        Scanner input = new Scanner(System.in);
        int choose;
        while (isRun()) {
            System.out.println("\n|--------Hello World in FARM--------|");
            System.out.print("[0]Logout: ");
            choose = input.nextInt();
            switch (choose){
                case 0: logoutSystem();
                    break;
            }
        }
    }

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

}
