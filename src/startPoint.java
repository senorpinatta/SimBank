/**
 * Created by benji on 10/18/2016.
 */
public class startPoint {
    // Starting Point for the program makes a new FrontEnd object which will loop endlessly accepting terminal input
    public static void main(String[] args) {
        FrontEnd fEnd= new FrontEnd("AccountsFile.txt", "TSF.txt");
    }
}
