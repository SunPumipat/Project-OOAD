import java.util.Scanner;

public class Admin extends AppUser {

    Admin(String name) {
        super(name);
    }

    public void newFarmerPage() {
        Scanner input = new Scanner(System.in);
        System.out.print("[1]Approve New Account \n[2]Remove Request\n[3]View New Farmer\n[0]Back to Menu\n:");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                approveAccount();
                break;
            case 2:
                removeAccount(0);
                break;
            case 3:
                viewListDB(0);
                break;
        }
    }

    public void ManagementPage() {
        Scanner input = new Scanner(System.in);
        System.out.print("[1]Update Account \n[0]Back to Menu\n:");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                updateAccount();
                break;
        }
    }

    public void FarmerPage() {
        Scanner input = new Scanner(System.in);
        System.out.print("[1]Remove Farmer\n[0]Back to Menu\n:");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                removeAccount(2);
                break;
            case 3:
                viewListDB(2);
                break;
        }
    }

    private void viewListDB(int role){
        Scanner input = new Scanner(System.in);
        int row = 7;
        if(role == 0){
            for (int i = 0; i < row; i++) {
                System.out.println("[" + i + "] Id: " + registerDB[i][0] + " Name: " + registerDB[i][3] + " " + registerDB[i][4] + " Phone: " + registerDB[i][6]);
            }
        }else if(role == 2 ){
            for (int i = 0; i < row; i++) {
                System.out.println("[" + i + "] Id: " + localDB[i][0] + " Name: " + localDB[i][3] + " " + localDB[i][4] + " Phone: " + localDB[i][6]);
            }
        }
    }

    private void updateAccount() {
        Scanner input = new Scanner(System.in);
        String[][] Arrtemp = localDB;
        int check, index = -1;
        boolean isEmail = false, isPhone = false;
        String temp = " ";
        int row = 7;
        System.out.print("\n");
        for (int i = 0; i < row; i++) {
            if (Arrtemp[i][2].equals("2")) {
                System.out.println("[" + i + "] Id: " + Arrtemp[i][0] + " Name: " + Arrtemp[i][3] + " " + Arrtemp[i][4]
                        + " Email: " + Arrtemp[i][5] + " Phone Number: " + Arrtemp[i][6] + " BirthDay: " + Arrtemp[i][7]);
            }

        }

        System.out.print("Update ID: ");
        String id = input.next();

        for (int i = 0; i < row; i++) {
            if (Arrtemp[i][0].equals(id)) {
                index = i;
                System.out.print("Which you want to update? \n[1]Name\n[2]Surname\n[3]Email\n[4]Phone Number\n[5]Birthday\n[0]Back to menu\n:");
                int choose = input.nextInt();
                System.out.print("Update to: ");
                temp = input.next();
                FarmSystem farmSystem = null;
                if (choose == 3) {
                    if (checkFormat(temp, Arrtemp[i][7])) {
                        isEmail = true;
                        isPhone = true;
                    } else {
                        System.out.println("Incorrect format");
                    }
                } else if (choose == 4) {
                    if (checkFormat(Arrtemp[i][5], temp)) {
                        isEmail = true;
                        isPhone = true;
                    } else {
                        System.out.println("Incorrect format");
                    }
                } else {
                    isEmail = true;
                    isPhone = true;
                }

                if (isEmail && isPhone) {
                    System.out.print("\n[1]Confirm to Update\n[2]Cancel\n: ");
                    check = input.nextInt();
                    switch (check) {
                        case 1:
                            localDB[i][choose + 2] = temp;
                            System.out.println("User’s personal information has been edited");
                            break;
                        case 2:
                            break;
                    }
                }
            }
        }

        if (index == -1) {
            System.out.println("Not Found ID");
        }

        if (temp.equals(" ")) {
            System.out.println("Don't have that Farmer ID you want to update\n");
        }
    }

    private void approveAccount() {
        Scanner input = new Scanner(System.in);
        int row = 7;
        for (int i = 0; i < row; i++) {
            System.out.println("[" + i + "] Id: " + registerDB[i][0]);
        }

        System.out.print("Approve Index: ");
        int index = input.nextInt();
        for (int i = 0; i < row; i++) {
            if (localDB[i][0].equals(" ")) {
                int check;
                System.out.print("\n[1]Confirm to Approve\n[2]Cancel\n: ");
                check = input.nextInt();
                switch (check) {
                    case 1:
                        localDB[i][0] = registerDB[index][0];
                        localDB[i][1] = registerDB[index][1];
                        localDB[i][2] = registerDB[index][2];
                        localDB[i][3] = registerDB[index][3];
                        localDB[i][4] = registerDB[index][4];
                        localDB[i][5] = registerDB[index][5];
                        localDB[i][6] = registerDB[index][6];
                        localDB[i][7] = registerDB[index][7];
                        clearIndexDB(index);
                        System.out.println("\nThe new farmer account has been approving from the system");
                        break;
                }
                break;
            }
        }
    }

    private void removeAccount(int role) {
        Scanner input = new Scanner(System.in);
        int row = 7, check, index = -1, column = 8;
        String id;
        boolean hasThisID = false;

        if (role == 0) {
            //Delete Request
            for (int i = 0; i < row; i++) {
                System.out.println("[" + i + "] Id: " + registerDB[i][0]);
            }
            System.out.print("Remove ID (Input ID)\n: ");
            id = input.next();

            for (int i = 0; i < row; i++) {
                if (registerDB[i][0].equals(id) && registerDB[i][2].equals("2")) {
                    index = i;
                    hasThisID = true;
                }
            }


            if (hasThisID) {
                System.out.print("\n[1]Confirm to Approve\n[2]Cancel\n: ");
                check = input.nextInt();
                switch (check) {
                    case 1:
                        for (int i = 0; i < column; i++) {
                            registerDB[index][i] = " ";
                        }
                        System.out.println("The new farmer account has been removed from the system");
                        break;
                    case 0:
                        break;
                }
            } else {
                System.out.println("\nSorry don't have this ID");
            }
        } else if (role == 2) {
            //Delete Farmer
            for (int i = 0; i < row; i++) {
                if (localDB[i][2].equals("2")) {
                    System.out.println("[" + i + "] Id: " + localDB[i][0]);
                }
            }
            System.out.print("Remove ID (Input ID)\n: ");
            id = input.next();

            for (int i = 0; i < row; i++) {
                if (localDB[i][0].equals(id) && localDB[i][2].equals("2")) {
                    index = i;
                    hasThisID = true;
                }
            }

            if (hasThisID) {
                System.out.print("\n[1]Confirm to Approve\n[2]Cancel\n: ");
                check = input.nextInt();
                switch (check) {
                    case 1:
                        for (int i = 0; i < column; i++) {
                            localDB[index][i] = " ";
                        }
                        System.out.println("The farmer account has been removed from the system");
                        break;
                    case 0:
                        break;
                }
            } else {
                System.out.println("\nSorry don't have this ID");
            }
        }

    }

    private void clearIndexDB(int index) {
        int column = 8;
        for (int i = 0; i < column; i++) {
            registerDB[index][i] = " ";
        }
    }

}
