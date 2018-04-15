public class Product {

    private int row = 6;
    private String account;
    public static String[][] productDB = {
            //Name Unit Quantity
            {"Potato", "6", "10"},
            {"Tomato", "3", "20"},
            {"Carrot", "1", "30"},
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
    };

    Product(String account) {
        this.account = account;
    }

    public void addProduct(String name, String unit) {
        for (int i = 0; i < row; i++) {
            if (productDB[i][0].equals(" ")) {
                Disease.diseaseDB[i][0] = name;
                productDB[i][0] = name;
                productDB[i][1] = unit;
                break;
            }
        }
    }

    public void addQuantity(String name, String quantity) {
        for (int i = 0; i < row; i++) {
            if (productDB[i][0].equals(name)) {
                productDB[i][2] = String.valueOf(Integer.parseInt(quantity) + Integer.parseInt(productDB[i][2]));

                break;
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

    public void updateProduct(String name, String unit, String old) {
        for (int i = 0; i < row; i++) {
            if (productDB[i][0].equals(old)) {
                productDB[i][0] = name;
                productDB[i][1] = unit;
                break;
            }
        }
    }

    public void updateQuantity(String name, String quantity) {
        for (int i = 0; i < row; i++) {
            if (productDB[i][0].equals(name)) {
                productDB[i][2] = quantity;
                break;
            }
        }
    }

    public void deleteQuantity(String name ,String quantity){
        for (int i = 0; i < row; i++) {
            if (productDB[i][0].equals(name)) {
                productDB[i][2] = String.valueOf(Integer.parseInt(productDB[i][2]) - Integer.parseInt(quantity));
                break;
            }
        }
    }

}
