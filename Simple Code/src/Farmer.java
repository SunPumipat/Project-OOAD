import java.util.Scanner;

public class Farmer extends AppUser {

    private int row = 6;
    private Device device = null;
    private Product product = null;
    private Disease disease = null;

    Farmer(String name) {
        super(name);
    }

    public void MonitorPage() {
        Scanner input = new Scanner(System.in);
        device = new Device(getAccount());
        System.out.print("[1]View Device Monitor\n[2]View Statistic Monitor\n[3]View History Statistic\n[0]Back to Menu\n:");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                device.viewMonitor(1);
                break;
            case 2:
                device.viewMonitor(2);
                break;
            case 3:
                viewHistory();
                break;
        }
    }

    public void ProductStockPage() {
        Scanner input = new Scanner(System.in);
        product = new Product(getAccount());
        System.out.print("[1]Add Production\n" +
                "[2]Update Production\n" +
                "[3]Delete Production\n" +
                "[4]View Production\n" +
                "[0]Back to Menu\n:");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                addProduct();
                break;
            case 2:
                updateProduct();
                break;
            case 3:
                deleteQuantity();
                break;
            case 4:
                viewQuantity();
                break;
        }
    }

    public void DiseasePage() {
        Scanner input = new Scanner(System.in);
        disease = new Disease(getAccount());
        System.out.print("[1]Add Disease\n" +
                "[2]Update Disease\n" +
                "[3]Delete Disease\n" +
                "[4]View Disease\n" +
                "[0]Back to Menu\n:");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                addDisease();
                break;
            case 2:
                updateDisease();
                break;
            case 3:
                deleteDisease();
                break;
            case 4:
                viewDisease();
                break;
        }
    }

    private void viewHistory() {
        Scanner input = new Scanner(System.in);
        String date, time;
        System.out.print("\n[1]Search by Date\n[2]Search by Date and Time\n: ");
        int select = input.nextInt();
        switch (select) {
            case 1:
                System.out.print("Date: ");
                date = input.next();
                device.historyStat(date, "no");
                break;
            case 2:
                System.out.print("Date: ");
                date = input.next();
                System.out.print("Time: ");
                time = input.next();
                device.historyStat(date, time);
                break;
            default:
                System.out.println("Please select the statistic date");
        }
    }

    private void addProduct() {
        Scanner input = new Scanner(System.in);
        String name, quantity;
        int index = -1;
        for (int i = 0; i < row; i++) {
            if (!Product.productDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Product.productDB[i][0] + " Quantity: " + Product.productDB[i][2]);
            }
        }

        System.out.print("\nName Product: ");
        name = input.next();
        System.out.print("Quantity of Product: ");
        quantity = input.next();

        for (int i = 0; i < row; i++) {
            if (Product.productDB[i][0].equals(name)) {
                index = i;
                if (Integer.parseInt(quantity) > 0 && Integer.parseInt(quantity) < 10 && confirm()) {
                    product.addQuantity(name, quantity);
                    System.out.println("Production record has been added into the system");
                    device.runMoistureSetting();
                    break;
                } else {
                    System.out.println("incorrect format");
                }
            }
        }
        if (index == -1) {
            System.out.println("Does't has Product");
        }
    }

    private void updateProduct() {
        Scanner input = new Scanner(System.in);
        String name, quantity;
        int index = -1;
        System.out.print("\n");

        for (int i = 0; i < row; i++) {
            if (!Product.productDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Product.productDB[i][0] + " Quantity: " + Product.productDB[i][2]);
            }
        }

        System.out.print("Update Product: ");
        name = input.next();
        System.out.print("Quantity: ");
        quantity = input.next();

        for (int i = 0; i < row; i++) {
            if (Product.productDB[i][0].equals(name)) {
                index = i;
                if (Integer.parseInt(quantity) > 0 && Integer.parseInt(quantity) < 10 && confirm()) {
                    product.updateQuantity(name, quantity);
                    System.out.println("Production record has been edited");

                    break;
                } else {
                    System.out.println("incorrect format");
                }
            }
        }
        if (index == -1) {
            System.out.println("Does't has Product");
        }
    }

    private void deleteQuantity() {
        Scanner input = new Scanner(System.in);
        String name, quantity;
        int index = -1;
        System.out.print("\n");
        for (int i = 0; i < row; i++) {
            if (!Product.productDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Product.productDB[i][0] + " Quantity: " + Product.productDB[i][2]);
            }
        }
        System.out.print("Delete Product: ");
        name = input.next();
        System.out.print("Quantity: ");
        quantity = input.next();
        for (int i = 0; i < row; i++) {
            if (Product.productDB[i][0].equals(name) && confirm()) {
                index = i;
                product.deleteQuantity(name, quantity);
                System.out.println("Production record has been removed from the system");
                break;
            }
        }
        if (index == -1) {
            System.out.println("Does't has Product");
        }

    }

    private void viewQuantity() {
        for (int i = 0; i < row; i++) {
            if (!Product.productDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Product.productDB[i][0] + " Quantity: " + Product.productDB[i][2]);
            }
        }
    }

    private void addDisease() {
        Scanner input = new Scanner(System.in);
        String name, diseaseName;
        int index = -1;
        for (int i = 0; i < row; i++) {
            if (!Disease.diseaseDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Disease.diseaseDB[i][0] + " Disease Name: " + Disease.diseaseDB[i][1]);
            }
        }

        System.out.print("\nName Product: ");
        name = input.next();
        System.out.print("\nName Disease: ");
        diseaseName = input.next();

        for (int i = 0; i < row; i++) {
            if (Disease.diseaseDB[i][0].equals(name)) {
                index = i;
                if (disease.checkFormat(diseaseName)) {
                    System.out.print("[1]Confirm to Add Disease\n[2]Cancel\n: ");
                    int check = input.nextInt();
                    switch (check) {
                        case 1:
                            disease.addDisease(name, diseaseName);
                            System.out.println("Disease has been added into the system");
                            break;
                    }
                    break;
                } else {
                    System.out.println("incorrect format");
                }
            }
        }
        if (index == -1) {
            System.out.println("Does't has Product");
        }
    }

    private void updateDisease() {
        Scanner input = new Scanner(System.in);
        String name, diseaseName;
        int index = -1;
        for (int i = 0; i < row; i++) {
            if (!Disease.diseaseDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Disease.diseaseDB[i][0] + " Disease Name: " + Disease.diseaseDB[i][1]);
            }
        }

        System.out.print("\nName Product: ");
        name = input.next();
        System.out.print("\nName Disease: ");
        diseaseName = input.next();

        for (int i = 0; i < row; i++) {
            if (Disease.diseaseDB[i][0].equals(name)) {
                index = i;
                if (disease.checkFormat(diseaseName) && confirm()) {
                    disease.updateDisease(name, diseaseName);
                    System.out.println("Disease record has been edited");
                    break;
                } else {
                    System.out.println("incorrect format");
                }
            }
        }
        if (index == -1) {
            System.out.println("Does't has Product");
        }
    }

    private void deleteDisease() {
        Scanner input = new Scanner(System.in);
        String name;
        int index = -1;
        System.out.print("\n");
        for (int i = 0; i < row; i++) {
            if (!Disease.diseaseDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Disease.diseaseDB[i][0] + " Disease Name: " + Disease.diseaseDB[i][1]);
            }
        }

        System.out.print("Delete Disease Product: ");
        name = input.next();

        for (int i = 0; i < row; i++) {
            if (Disease.diseaseDB[i][0].equals(name) && confirm()) {
                index = i;
                disease.deleteDisease(name);
                System.out.println("Disease record has been removed from the system");
                break;
            }
        }
        if (index == -1) {
            System.out.println("Does't has Product");
        }


    }

    private void viewDisease() {
        for (int i = 0; i < row; i++) {
            if (!Disease.diseaseDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Disease.diseaseDB[i][0] + " Disease Name: " + Disease.diseaseDB[i][1]);
            }
        }

    }

}
