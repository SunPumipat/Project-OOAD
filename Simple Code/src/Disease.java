public class Disease implements Operation{
    private String account;
    private int row = 6;
    public static String[][] diseaseDB = {
            {"Potato", "Lom Ba Mhoo"},
            {"Tomato", "Cancer"},
            {"Carrot", " "},
            {" ", " "},
            {" ", " "},
            {" ", " "}
    };

    Disease(String account) {
        this.account = account;
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

    public void addDisease(String name,String diseaseName) {
        for(int i= 0 ; i < row ; i++){
            if(diseaseDB[i][0].equals(name)){
                diseaseDB[i][1] = diseaseName;
            }
        }
    }

    public void updateDisease(String name,String diseaseName){
        for(int i= 0 ; i < row ; i++){
            if(diseaseDB[i][0].equals(name)){
                diseaseDB[i][1] = diseaseName;
            }
        }
    }

    public void deleteDisease(String name){
        for(int i= 0 ; i < row ; i++){
            if(diseaseDB[i][0].equals(name)){
                diseaseDB[i][1] = " ";
            }
        }
    }
}
