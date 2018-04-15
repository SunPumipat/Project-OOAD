
public class Device {

    private String account;
    private int row = 6;
    private double levelWater = 8;
    public static String[][] deviceDB = {
            //Name  , Temperature , Humidity , Soil Moisture , update time
            {"Samsung", "30", "5", "8", "Friday", "D00"},
            {"Iphone", "26", "6", "9", "Friday", "D01"},
            {" ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " "}
    };

    private static String[][] statHour = {
            {"Friday", "18.00"},
            {"Friday", "19.00"},
            {"Friday", "20.00"},
            {" ", " "},
            {" ", " "},
            {" ", " "},
    };

    private static double[][] statDB = {
            {30, 32, 0, 2, 3, 0, 5, 7, 0},
            {28, 34, 0, 3, 8, 0, 6, 8, 0},
            {27, 30, 0, 4, 5, 0, 5, 8, 0},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    Device(String account) {
        this.account = account;
    }

    public void addDevice(String name) {
        for (int i = 0; i < row; i++) {
            if (deviceDB[i][0].equals(name)) {
                System.out.println("The name of the device is taken");
                break;
            }
            if (deviceDB[i][0].equals(" ")) {
                deviceDB[i][0] = name;
                System.out.println("New device has been added to the system");
                break;
            }
        }
    }

    public void historyStat(String date, String time) {
        int index = -1;
        calculateAverage();
        if (time.equals("no")) {
            for (int i = 0; i < row; i++) {
                if (statHour[i][0].equals(date)) {
                    index = i;
                    System.out.println("\nlast Update: " + statHour[i][0] + " " + statHour[i][1]
                            + "\nLowest Temperature : " + statDB[i][0]
                            + "\nHighest Temperature: " + statDB[i][1]
                            + "\nAverage Temperature: " + statDB[i][2]
                            + "\nLowest Humidity: " + statDB[i][3]
                            + "\nHighest Humidity: " + statDB[i][4]
                            + "\nAverage Humidity: " + statDB[i][5]
                            + "\nLowest Soil Moisture: " + statDB[i][6]
                            + "\nHighest Soil Moisture: " + statDB[i][7]
                            + "\nAverage  Soil Moisture: " + statDB[i][8]);
                    System.out.print("\n");
                }
            }
        } else {
            for (int i = 0; i < row; i++) {
                if (statHour[i][0].equals(date) && statHour[i][1].equals(time)) {
                    index = i;
                    System.out.println("\nlast Update: " + statHour[i][0] + " " + statHour[i][1]
                            + "\nLowest Temperature : " + statDB[i][0]
                            + "\nHighest Temperature: " + statDB[i][1]
                            + "\nAverage Temperature: " + statDB[i][2]
                            + "\nLowest Humidity: " + statDB[i][3]
                            + "\nHighest Humidity: " + statDB[i][4]
                            + "\nAverage Humidity: " + statDB[i][5]
                            + "\nLowest Soil Moisture: " + statDB[i][6]
                            + "\nHighest Soil Moisture: " + statDB[i][7]
                            + "\nAverage  Soil Moisture: " + statDB[i][8]);
                    System.out.print("\n");
                }
            }
        }

        if (index == -1) {
            System.out.println("No data");
        }

    }

    public void viewMonitor(int select){
        switch (select) {
            case 1: listofDeviceMonitor();
                break;
            case 2: listofStatMonitor();
                break;
        }
    }

    private void listofStatMonitor() {
        int index = lastUpdate();
        calculateAverage();

        if (!(index == -1)) {
            System.out.println("\nLowest Temperature : " + statDB[index][0]
                    + "\nHighest Temperature: " + statDB[index][1]
                    + "\nAverage Temperature: " + statDB[index][2]
                    + "\nLowest Humidity: " + statDB[index][3]
                    + "\nHighest Humidity: " + statDB[index][4]
                    + "\nAverage Humidity: " + statDB[index][5]
                    + "\nLowest Soil Moisture: " + statDB[index][6]
                    + "\nHighest Soil Moisture: " + statDB[index][7]
                    + "\nAverage  Soil Moisture: " + statDB[index][8]
                    + "\nlast Update: " + statHour[index][0] + " " + statHour[index][1]);
            System.out.print("\n");
        } else {
            System.out.println("No data");
        }
    }

    private void listofDeviceMonitor() {
        for (int i = 0; i < row; i++) {
            if (deviceDB[i][0].equals(" ")) {
                System.out.println("[" + i + "] No Data");
            } else {
                System.out.println("[" + i + "] Device Name: " + deviceDB[i][0] + " Temperature: " + deviceDB[i][1] + "C Humidity: "
                        + deviceDB[i][2] + " g/cm3 Soil Moisture: " + deviceDB[i][3] + " g/cm3 last Update: " + deviceDB[i][4]);
            }
        }
    }

    public boolean checkFormat(String name) {
        String splitText[] = name.split("");
        for (int i = 0; i < splitText.length; i++) {
            if (!(splitText[i].equals("+") && splitText[i].equals("-") && splitText[i].equals("*") && splitText[i].equals("/"))) {
                System.out.println("");
                return true;
            }
        }
        return false;

    }

    private void calculateAverage() {
        for (int i = 0; i < row; i++) {
            if (!(statDB[i][0] == -1)) {
                statDB[i][2] = (statDB[i][0] + statDB[i][1]) / 2;
                statDB[i][5] = (statDB[i][3] + statDB[i][4]) / 2;
                statDB[i][8] = (statDB[i][6] + statDB[i][7]) / 2;
            }
        }
    }

    private int lastUpdate() {
        int index = -1;
        double temp = 0.0;
        for (int i = 0; i < row; i++) {
            if (!statHour[i][0].equals(" ")) {
                if (Double.parseDouble(statHour[i][1]) > temp) {
                    index = i;
                    temp = Double.parseDouble(statHour[i][1]);
                }
            }

        }
        return index;
    }

    public void runMoistureSetting(){
        calculateAverage();
        double temp = 0.0;
        int index = -1;
        for (int i = 0; i < row; i++) {
            if (!statHour[i][1].equals(" ")) {
                if (Double.parseDouble(statHour[i][1]) > temp) {
                    temp = Double.parseDouble(statHour[i][1]);
                    index = i;
                }
            }
        }

        if (statDB[index][8] < levelWater) {
            System.out.println("\n|---Turn On the Soil Moisture System---|");
        } else {
            System.out.println("\n|---Turn Off the Soil Moisture System---|");
        }
    }

    public void recordMoisture(double level) {
        this.levelWater = level;
        double temp = 0.0;
        int index = -1;
        calculateAverage();
        for (int i = 0; i < row; i++) {
            if (!statHour[i][1].equals(" ")) {
                if (Double.parseDouble(statHour[i][1]) > temp) {
                    temp = Double.parseDouble(statHour[i][1]);
                    index = i;
                }
            }
        }

        if (statDB[index][8] < level) {
            System.out.println("\n|---Turn On the Soil Moisture System---|");
        } else {
            System.out.println("\n|---Turn Off the Soil Moisture System---|");
        }
    }
}
