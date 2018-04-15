import java.util.Scanner;

public abstract class AppUser{

    private String account;

    protected static String registerDB[][] = {
            {"Job", "1234", "2", "Kunlapat", "Panyadee", "job@gmail.com", "04-4-4-4 ", "1/1/2540"},
            {"New", "1234", "2", "Kattareeya", "Suwannapoom", "new@gmail.com", "05-5-5-5", "2/1/2540"},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "}
    };
    protected static String localDB[][] = {
            {"Sun", "1234", "1", "Pumipat", "Tippayawong", "sun@gmail.com", "01-1-1-1", "21/11/2540"},
            {"Dan", "1234", "2", "Nattapat", "Tamtrakool", "dan@gmail.com", "02-2-2-2", "11/4/2540"},
            {"Kim", "1234", "3", "Nattapong", "Thanakunkan", "kim@gmail.com", "03-3-3-3", "23/2/2541"},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "}
    };

    AppUser(String name) {
        this.account = name;
    }

    protected void changePasswordPage() {
        Scanner input = new Scanner(System.in);
        int row = 7, index = -1;
        System.out.print("Old Password: ");
        String old = input.next();

        for (int i = 0; i < row; i++) {
            if (localDB[i][0].equals(account) && localDB[i][1].equals(old)) {
                index = i;
                System.out.print("New Password: ");
                String temp1 = input.next();
                System.out.print("New Password Confirm: ");
                String temp2 = input.next();

                if (checkNewPassword(temp1, temp2)) {
                    System.out.print("\n[1]Confirm to Change\n[2]Cancel\n: ");
                    int check = input.nextInt();
                    switch (check) {
                        case 1:
                            localDB[i][1] = temp1;
                            System.out.println("Change password successful");
                            break;
                    }
                }
            }
        }

        if (index == -1) {
            System.out.println("Incorrect password");
        }

    }

    public boolean confirm() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n[1]Confirm to Do\n[2]Cancel\n: ");
        int check = input.nextInt();
        switch (check) {
            case 1:
                return true;
        }
        return false;
    }

    private boolean checkNewPassword(String text1, String text2) {
        String splitText[] = text1.split("");
        for (int i = 0; i < splitText.length; i++) {
            if (!(splitText[i].equals("+") && splitText[i].equals("-") && splitText[i].equals("*") && splitText[i].equals("/"))) {
                System.out.println("");
                if ((text1.equals(text2))) {
                    return true;
                } else {
                    System.out.println("New password doesn’t match");
                    return false;
                }
            } else {
                System.out.println("Incorrect Format");
                return false;
            }
        }
        return false;
    }

    public static boolean addUser(String usr, String psw, String name, String sname, String mail, String phone, String birth) {
        int row = 7;
        for (int i = 0; i < row; i++) {
            if (registerDB[i][0].equals(" ")) {
                registerDB[i][0] = usr;
                registerDB[i][1] = psw;
                registerDB[i][2] = "2";
                registerDB[i][3] = name;
                registerDB[i][4] = sname;
                registerDB[i][5] = mail;
                registerDB[i][6] = phone;
                registerDB[i][7] = birth;
                return true;
            }
        }
        return false;
    }

    public static boolean verifyUser(String usr, String psw, String role) {
        String tempDB[][] = localDB;
        int row = 7;
        boolean inLocalDB = false;
        for (int i = 0; i < row; i++) {
            if (tempDB[i][0].equals(usr) && tempDB[i][1].equals(psw) && tempDB[i][2].equals(role)) {
                inLocalDB = true;
            }
        }

        boolean inregisterDB = false;
        tempDB = registerDB;
        for (int i = 0; i < row; i++) {
            if (tempDB[i][0].equals(usr) && tempDB[i][1].equals(psw) && tempDB[i][2].equals(role)) {
                inregisterDB = true;
            }
        }

        if (inLocalDB) {
            return true;
        } else if (inregisterDB) {
            System.out.println("Your account has not been approved by administrator");
            return false;
        }

        System.out.println("Username or password is incorrect\n");
        return false;
    }

    public String getAccount() {
        return account;
    }

}
