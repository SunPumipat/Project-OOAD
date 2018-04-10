public abstract class AppUser {

    private String account;

    AppUser(String name) {
        this.account = name;
    }

    private static String localDB[][] = {
            {"Sun", "1234", "1"},
            {"Dan", "1234", "2"},
            {"Kim", "1234", "3"},
            {" ", " ", " "},
            {" ", " ", " "}
    };

    public static boolean addUser(String usr, String psw) {
        String tempDB[][] = localDB;
        int y = 5;
        for (int i = 0; i < y; i++) {
            if (tempDB[i][0].equals(" ")) {
                tempDB[i][0] = usr;
                tempDB[i][1] = psw;
                tempDB[i][2] = "2";
                return true;
            }
        }
        return false;
    }

    public static boolean verifyUser(String usr, String psw, String role) {
        String tempDB[][] = localDB;
        int y = 5;
        for (int i = 0; i < y; i++) {
            if (tempDB[i][0].equals(usr) && tempDB[i][1].equals(psw) && tempDB[i][2].equals(role)) {
                return true;
            }
        }
        System.out.println("Username or password is incorrect\n");
        return false;
    }


}
