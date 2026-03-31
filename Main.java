
import database.FileManage;
import ui.Menu;

public class Main {

    public static void main(String[] args) {

        // All objects here
        Menu myMenu = new Menu();

        // Run the app
        FileManage.fillStudentMap();
        myMenu.run();


        // System.out.println(FileManage.map);
    }
}
