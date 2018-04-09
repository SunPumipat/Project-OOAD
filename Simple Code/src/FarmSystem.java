public class FarmSystem {
    private String account;
    private String role;

    public boolean loginSystem(String usr, String psw, String role) {

        boolean isVerify = AppUser.verifyUser(usr, psw, role);
        if (isVerify) {
            this.account = usr;
            this.role = role;
        }
        return isVerify;
    }

    public void menuFarm() {
        System.out.println("|----Hello World in FARM----|");
        if (role.equals(1)) {

        }


    }
}
