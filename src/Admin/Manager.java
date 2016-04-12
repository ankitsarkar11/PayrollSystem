package Admin;

import Common.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


/**
 * Created by Ankit Sarkar on 4/9/2016.
 */
public class Manager {
    static TextField tsearch = new TextField();
    public static void display(int EID, Scene login){
        Label heading = new Label("Administrator Panel");
        Label lsearch = new Label("Employee ID to Search");
        Button bsearch = new Button("Search");
        Button logout = new Button("Logout");
        Button pending = new Button("Pending Applications");
        Button exit = new Button("Exit");
        Button msg = new Button("Send Message");
        Button msga = new Button("Message to All Admins");

        exit.setOnAction(e -> {
            CloseLogic.onclose();
        });

        logout.setOnAction(e -> {
            Welcome.back();
        });

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.add(heading,0,0);
        layout.add(lsearch,0,1);
        layout.add(tsearch,1,1);
        layout.add(bsearch,0,2);
        layout.add(msg,0,3);
        layout.add(msga,1,3);
        layout.add(logout,0,4);
        layout.add(exit,1,4);

        Scene scene = new Scene(layout,720,480);

        msg.setOnAction(e ->{
            SendMessage.display(EID,1,scene);
        });

        msga.setOnAction(e ->{
            SendMessage.display(EID,0,scene);
        });

        bsearch.setOnAction(e ->{
            if(tsearch.getText().length() == 0){
                AlertDialog.display("Empty Field", "The Field Can't be Empty");
            }
            else{
                DBHub data = new DBHub();
                data.empSelect(Integer.parseInt(tsearch.getText()));
                if(data.eid != 0){
                    EmpSum.display(Integer.parseInt(tsearch.getText()),scene);
                }
                else{
                    AlertDialog.display("Not Found","Employee Not Found !");
                }
            }
        });

        pending.setOnAction(e ->{
            Pending.display(scene);
        });

        Welcome.common.setScene(scene);
        Welcome.common.show();

    }
}
