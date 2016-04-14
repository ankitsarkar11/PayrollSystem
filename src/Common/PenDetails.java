package Common;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Created by Ankit Sarkar on 4/14/2016.
 */
public class PenDetails{
    public static void display(int eid, String name, String dept, Scene sback){
        Label heading = new Label("Pending Application Details");
        Label leid = new Label("Assigned Employee ID");
        Label lname = new Label("Name");
        Label ldept = new Label("Department");

        TextField teid = new TextField(Integer.toString(eid));
        TextField tname = new TextField(name);
        TextField tdept = new TextField(dept);
        teid.setEditable(false);
        tname.setEditable(false);
        tdept.setEditable(false);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        Button logout = new Button("Log Out");
        Button approve = new Button("Approve");
        Button delete = new Button("Delete");

        back.setOnAction(e -> {
            Welcome.common.setScene(sback);
        });

        GridPane gData  = new GridPane();
        gData.setAlignment(Pos.CENTER);
        gData.setVgap(10);
        gData.setHgap(10);
        gData.add(leid,0,0);
        gData.add(teid,1,0);
        gData.add(lname,0,1);
        gData.add(tname,1,1);
        gData.add(ldept,0,2);
        gData.add(tdept,1,2);

        GridPane bData = new GridPane();
        bData.setAlignment(Pos.CENTER);
        bData.setVgap(10);
        bData.setHgap(100);
        bData.add(back,0,0);
        bData.add(logout,1,0);
        bData.add(exit,2,0);

        GridPane Action = new GridPane();
        Action.setAlignment(Pos.CENTER);
        Action.setVgap(10);
        Action.setHgap(100);
        Action.add(approve,0,0);
        Action.add(delete,1,0);

        VBox main = new VBox(10);
        main.setAlignment(Pos.CENTER);
        main.getChildren().addAll(heading,gData,Action,bData);

        Scene scene = new Scene(main,Welcome.gw,Welcome.gh);
        Welcome.common.setScene(scene);
    }
}
