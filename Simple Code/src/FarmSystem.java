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

    public boolean registerSystem(String usr, String psw, String name, String sname, String mail, String phone, String birth) {
        boolean addNew = false;
        Scanner input = new Scanner(System.in);


        if (checkFormat(mail, birth)) {
            int check;
            System.out.print("\n[1]Confirm \n[2]Cancel\n: ");
            check = input.nextInt();
            switch (check) {
                case 1:
                    addNew = AppUser.addUser(usr, psw, name, sname, mail, phone, birth);
                    break;
                case 2:
                    break;
            }

        } else {
            System.out.println("Incorrect Format");
        }

        return addNew;
    }

    public void menuFarm() {
        while (isRun()) {
            if (role.equals("1")) {
                adminMenu();
            } else if (role.equals("2")) {
                farmerMenu();
            } else if (role.equals("3")) {
                ownerMenu();
            }
        }
    }

    private void adminMenu() {
        Admin admin = new Admin(account);
        Scanner input = new Scanner(System.in);
        int choose;
        System.out.println("\n|--------HELLO Admin: " + admin.getAccount() + " --------|");
        System.out.print("[1]New Farmer Page\n[2]Account Management Page \n[3]Farmer Page\n[4]Change Password Page\n[0]Logout\n: ");
        choose = input.nextInt();
        System.out.print("\n");
        switch (choose) {
            case 1:
                admin.newFarmerPage();
                break;
            case 2:
                admin.ManagementPage();
                break;
            case 3:
                admin.FarmerPage();
                break;
            case 4:
                admin.changePasswordPage();
                break;
            case 0:
                logoutSystem();
                break;
        }
    }

    private void farmerMenu(){
        Farmer farmer = new Farmer(account);
        Scanner input = new Scanner(System.in);
        int choose;
        System.out.println("\n|--------HELLO Farmer: " + farmer.getAccount() + " --------|");
        System.out.print("[1]Environmental Monitoring Page\n" +
                "[2]Product Stock Page\n" +
                "[3]Disease Record Page \n" +
                "[4]Change Password Page\n" +
                "[0]Logout\n: ");
        choose = input.nextInt();
        System.out.print("\n");
        switch (choose) {
            case 1:
                farmer.MonitorPage();
                break;
            case 2:
                farmer.ProductStockPage();
                break;
            case 3:
                farmer.DiseasePage();
                break;
            case 4:
                farmer.changePasswordPage();
                break;
            case 0:
                logoutSystem();
                break;
        }
    }

    private void ownerMenu(){
        FarmOwner owner = new FarmOwner(account);
        Scanner input = new Scanner(System.in);
        int choose;
        System.out.println("\n|--------HELLO Owner: " + owner.getAccount() + " --------|");
        System.out.print("[1]Environmental Monitoring Page\n" +
                "[2]Device Control Page\n" +
                "[3]Prediction Page Page\n" +
                "[4]Product Stock Page\n" +
                "[5]Disease Record Page\n" +
                "[6]Change Password Page\n" +
                "[0]Logout\n: ");
        choose = input.nextInt();
        System.out.print("\n");
        switch (choose) {
            case 1:
                owner.MonitorPage();
                break;
            case 2:
                owner.ControlPage();
                break;
            case 3:
                owner.PredictionPage();
                break;
            case 4:
                owner.ProductStockPage();
                break;
            case 5:
                owner.changePasswordPage();
                break;
            case 6:
                owner.DiseasePage();
                break;
            case 0:
                logoutSystem();
                break;
        }
    }

    public boolean checkFormat(String mail, String birth) {
        String checkMail[] = mail.split("");
        boolean isMailCorrect = false;
        for (int i = 0; i < checkMail.length; i++) {
            if (checkMail[i].equals("@")) {
                isMailCorrect = true;
            }
        }

        String checkBirth[] = birth.split("/");
        boolean isBirthCorrect = false;
        if (checkBirth.length == 3) {
            if (Integer.parseInt(checkBirth[0]) < 32 && 0 < Integer.parseInt(checkBirth[0])) {
                if (Integer.parseInt(checkBirth[1]) < 13 && 0 < Integer.parseInt(checkBirth[1])) {
                    if (checkBirth[2].split("").length == 4) {
                        isBirthCorrect = true;
                    }
                }
            }
        } else {
            isBirthCorrect = false;
        }

        return isMailCorrect && isBirthCorrect;
    }

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

}
