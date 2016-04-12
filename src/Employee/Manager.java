package Employee;

import Common.DBHub;
import Common.EmpDetails;
import Common.Welcome;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Created by Ankit Sarkar on 4/9/2016.
 */
public class Manager {
    public static void display(int EID, Scene login){
        DBHub data = new DBHub();
        data.empSelect(EID);
        Label heading = new Label("Welcome " + data.name);
        Button details  = new Button("View Details");

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);

        layout.add(heading,0,0);
        layout.add(details,0,1);

        Scene scene = new Scene(layout,640,480);
        details.setOnAction(e -> EmpDetails.display(EID,scene,2));

        Welcome.common.setScene(scene);
    }
}
