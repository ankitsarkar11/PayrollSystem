package Employee;

import Common.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Created by Ankit Sarkar on 4/9/2016.
 */
public class Manager {
    public static void display(int EID){
        DBHub data = new DBHub();
        data.empSelect(EID);
        Label heading = new Label("Welcome " + data.name);
        Button details  = new Button("View Details");
        Button msg = new Button("Send Message");
        Button msga = new Button("Message to Admin");
        Button logout = new Button("Log Out");
        Button chkmsg = new Button("Check Messages");

        logout.setOnAction(e -> {
            CloseLogic.onclose(1);
        });

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);

        layout.add(heading,0,0);
        layout.add(details,0,1);
        layout.add(msg,0,2);
        layout.add(msga,1,2);
        layout.add(chkmsg,2,2);
        layout.add(logout,0,3);

        Scene scene = new Scene(layout,Welcome.gw,Welcome.gh);

        chkmsg.setOnAction(e -> {
            MessageList.display(EID,scene);
        });

        msg.setOnAction(e ->{
            SendMessage.display(EID,1,scene);
        });

        msga.setOnAction(e ->{
            SendMessage.display(EID,0,scene);
        });

        details.setOnAction(e -> EmpDetails.display(EID,scene,2));
        logout.setOnAction(e -> {
            CloseLogic.onclose(1);
        });
        Welcome.common.setScene(scene);
    }
}
