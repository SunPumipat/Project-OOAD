import java.util.Scanner;

public class FarmOwner extends AppUser {

    private Device device = null;
    private Product product = null;
    private Disease disease = null;
    private int row = 6;

    FarmOwner(String name) {
        super(name);
    }


    public void MonitorPage() {
        Scanner input = new Scanner(System.in);
        device = new Device(getAccount());
        System.out.print("[1]View Device Monitor\n[2]View Statistic Monitor\n[3]View History Statistic\n[0]Back to Menu\n:");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                viewMonitor(1);
                break;
            case 2:
                viewMonitor(2);
                break;
            case 3:
                viewHistory();
                break;
        }
    }

    public void ControlPage() {
        Scanner input = new Scanner(System.in);
        device = new Device(getAccount());
        System.out.print("[1]Add Device\n" +
                "[2]Update Device\n" +
                "[3]Delete Device\n" +
                "[4]View All Devices\n" +
                "[5]Set Moisture Level\n" +
                "[0]Back to Menu\n:");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                addDevice();
                break;
            case 2:
                updateDevice();
                break;
            case 3:
                deleteDevice();
                break;
            case 4:
                viewDevice();
                break;
            case 5:
                setMoisture();
                break;
        }
    }

    public void PredictionPage() {
        Scanner input = new Scanner(System.in);
        product = new Product(getAccount());
        System.out.print("[1]View Predict Product\n" +
                "[2]Add Product\n" +
                "[3]Update Product\n" +
                "[4]Remove Product\n" +
                "[5]View Product\n" +
                "[0]Back to Menu\n:");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                predictProduct();
                break;
            case 2:
                addProduction();
                break;
            case 3:
                updateProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                viewProduct();
        }
    }

    public void ProductStockPage() {
        Scanner input = new Scanner(System.in);
        product = new Product(getAccount());
        System.out.print("[]View Production\n" +
                "[0]Back to Menu\n:");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                viewQuantity();
                break;

        }
    }

    public void DiseasePage() {
        Scanner input = new Scanner(System.in);
        disease = new Disease(getAccount());
        System.out.print( "[1]View Disease\n" +
                "[0]Back to Menu\n:");
        int choose = input.nextInt();
        switch (choose) {
              case 1:
                viewDisease();
                break;
        }
    }

    private void viewMonitor(int select){
        switch (select){
            case 1:
                device.listofDeviceMonitor();
                break;
            case 2:
                device.listofStatMonitor();
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

    private void addDevice() {
        Scanner input = new Scanner(System.in);
        String name;
        for (int i = 0; i < row; i++) {
            if (!Device.deviceDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Device Name: " + Device.deviceDB[i][0]);
            }

        }

        System.out.print("\nName new device: ");
        name = input.next();

        if (device.checkFormat(name)) {
            System.out.print("[1]Confirm to Add Device\n[2]Cancel\n: ");
            int check = input.nextInt();
            switch (check) {
                case 1:
                    device.addDevice(name);
                    break;
                case 2:
                    break;
            }

        } else {
            System.out.println("incorrect format");
        }
    }

    private void updateDevice() {
        Scanner input = new Scanner(System.in);
        String name, oldDevice;
        boolean hasThatName = true;
        System.out.print("\n");
        for (int i = 0; i < row; i++) {
            System.out.println("[" + i + "] Device Name: " + Device.deviceDB[i][0]);
        }

        System.out.print("Update Device: ");
        oldDevice = input.next();


        System.out.print("New Name Device: ");
        name = input.next();

        for (int i = 0; i < row; i++) {
            if (Device.deviceDB[i][0].equals(name)) {
                System.out.println("The name of the device is taken");
                hasThatName = false;
            }
        }

        if (device.checkFormat(name) && hasThatName) {
            for (int i = 0; i < row; i++) {
                if (Device.deviceDB[i][0].equals(oldDevice)) {
                    System.out.print("[1]Confirm to Update Device\n[2]Cancel\n: ");
                    int check = input.nextInt();
                    switch (check) {
                        case 1:
                            Device.deviceDB[i][0] = name;
                            System.out.println("Device has been updated");
                            break;
                    }

                } else {
                    System.out.println("Does't has Device");
                }
            }
        } else {
            System.out.println("incorrect format");
        }
    }

    private void deleteDevice() {
        Scanner input = new Scanner(System.in);
        String device;
        int index = -1;
        boolean hasThatDevice = false;
        System.out.println("\n");
        for (int i = 0; i < row; i++) {
            System.out.println("[" + i + "] Device Name: " + Device.deviceDB[i][0]);
        }

        System.out.print("Delete Device: ");
        device = input.next();
        for (int i = 0; i < row; i++) {
            if (Device.deviceDB[i][0].equals(device)) {
                index = i;
                hasThatDevice = true;
            }
        }

        if (hasThatDevice) {
            System.out.print("[1]Confirm to Delete Device\n[2]Cancel\n: ");
            int check = input.nextInt();
            switch (check) {
                case 1:
                    int column = 6;
                    for (int i = 0; i < column; i++) {
                        Device.deviceDB[index][i] = " ";
                    }
                    System.out.println("Device has been removed");
                    break;
            }
        } else {
            System.out.println("Does't has Device");
        }

    }

    private void viewDevice() {
        for (int i = 0; i < row; i++) {
            if (!Device.deviceDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Device ID: " + Device.deviceDB[i][5] + " Device Name: " + Device.deviceDB[i][0]);
            }

        }
    }

    private void setMoisture() {
        Scanner input = new Scanner(System.in);
        System.out.print("Soil Moisture: ");
        double soilLevel = input.nextDouble();

        if (soilLevel > 0 && soilLevel < 10) {
            System.out.print("[1]Confirm input Soil Moisture Level\n[2]Cancel\n: ");
            int check = input.nextInt();
            switch (check) {
                case 1:
                    device.recordMoisture(soilLevel);
                    break;
            }
        } else {
            System.out.println("incorrect format");
        }
    }

    private void predictProduct() {

    }

    private void addProduction() {
        Scanner input = new Scanner(System.in);
        String name, unit;
        System.out.print("\n");
        for (int i = 0; i < row; i++) {
            if (!Product.productDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Product.productDB[i][0]);
            }
        }

        System.out.print("\nName Product: ");
        name = input.next();
        System.out.print("Unit of Product: ");
        unit = input.next();

        for (int i = 0; i < row; i++) {
            if (Product.productDB[i][0].equals(name)) {
                System.out.println("This product is already in the system");
                break;
            }

            if (Product.productDB[i][0].equals(" ")) {
                if (product.checkFormat(name)) {
                    System.out.print("[1]Confirm to Add Product\n[2]Cancel\n: ");
                    int check = input.nextInt();
                    switch (check) {
                        case 1:
                            product.addProduct(name, unit);
                            System.out.println("Product has been added to the system");
                            break;
                    }
                    break;
                } else {
                    System.out.println("incorrect format");
                }
            }
        }
    }

    private void updateProduct() {
        Scanner input = new Scanner(System.in);
        String name, unit, oldProduct;
        int index = -1;
        System.out.print("\n");
        for (int i = 0; i < row; i++) {
            if (!Product.productDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Product.productDB[i][0]);
            }
        }

        System.out.print("Update Product: ");
        oldProduct = input.next();
        System.out.print("\nNew Name Product: ");
        name = input.next();
        System.out.print("Unit of Product: ");
        unit = input.next();
        for (int i = 0; i < row; i++) {
            if (Product.productDB[i][0].equals(name)) {
                System.out.println("This product is already in the system");
                break;
            }
            if (Product.productDB[i][0].equals(oldProduct)) {
                index = i;
            }
            if (!(index == -1) && product.checkFormat(name)) {
                System.out.print("[1]Confirm to Update Product\n[2]Cancel\n: ");
                int check = input.nextInt();
                switch (check) {
                    case 1:
                        product.updateProduct(name, unit, oldProduct);
                        System.out.println("Product has been edited");
                        break;
                }
                break;
            } else {
                System.out.println("incorrect format");
            }

        }

        if (index == -1) {
            System.out.println("Does't has Product");
        }
    }

    private void deleteProduct() {
        Scanner input = new Scanner(System.in);
        String name;
        int index = -1;
        System.out.print("\n");
        for (int i = 0; i < row; i++) {
            if (!Product.productDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Product.productDB[i][0]);
            }
        }

        System.out.print("Delete Product: ");
        name = input.next();

        for (int i = 0; i < row; i++) {
            if (Product.productDB[i][0].equals(name)) {
                index = i;
                System.out.print("[1]Confirm to Delete Product\n[2]Cancel\n: ");
                int check = input.nextInt();
                switch (check) {
                    case 1:
                        int column = 3;
                        for (int j = 0; i < column; i++) {
                            Product.productDB[index][j] = " ";
                        }
                        System.out.println("Product has been removed from the system");
                        break;
                }
            }
        }

        if (index == -1) {
            System.out.println("Does't has Product");
        }
    }

    private void viewProduct() {
        for (int i = 0; i < row; i++) {
            if (!Product.productDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Product.productDB[i][0] + " Unit: " + Product.productDB[i][1]);
            }
        }
    }

    private void viewQuantity() {
        for (int i = 0; i < row; i++) {
            if (!Product.productDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Product.productDB[i][0] + " Quantity: " + Product.productDB[i][2]);
            }
        }
    }

    private void viewDisease(){
        for (int i = 0; i < row; i++) {
            if (!Disease.diseaseDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] Product Name: " + Disease.diseaseDB[i][0] + " Disease Name: " + Disease.diseaseDB[i][1]);
            }
        }
    }

}
