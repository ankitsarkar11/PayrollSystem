package Common;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * Created by Deadpool on 4/12/2016.
 */
public class DBConnect {

    public static void display(){
        Label heading = new Label("Database Details");
        Label sub = new Label("We couldn't Connect to any Database. Please Provide the Required Details for Database Connection");
        Label lhost = new Label("Host");
        Label lport = new Label("Port");
        Label ldb = new Label("Database");
        Label ldbuser = new Label("Username");
        Label ldbpass = new Label("Password");
        Label lnotice = new Label("*These Credentials will Only be Valid for this Session");
        Button back = new Button("Back");
        Button submit = new Button("Submit");
        Button exit = new Button("Exit");

        TextField thost = new TextField();
        TextField tport = new TextField();
        TextField tdb = new TextField();
        TextField tdbuser = new TextField();
        PasswordField tdbpass = new PasswordField();

        back.setOnAction(e -> {
            Welcome.back();
        });

        exit.setOnAction(e -> {
            CloseLogic.onclose();
        });

        submit.setOnAction(e -> {
            if(thost.getText().length() == 0 || tport.getText().length() == 0 || tdb.getText().length() == 0 || tdbuser.getText().length() == 0 || tdbpass.getText().length() == 0){
                AlertDialog.display("ERROR","All Fields are Mandatory !!");
            }
            else {
                Welcome.host = thost.getText();
                Welcome.port = tport.getText();
                Welcome.db = tdb.getText();
                Welcome.dbuser = tdbuser.getText();
                Welcome.dbpass = tdbpass.getText();
                AlertDialog.display("Done","Database Details Submitted !!");
                Welcome.back();
            }
        });

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);

        layout.add(lhost,0,0);
        layout.add(thost,1,0);
        layout.add(lport,0,1);
        layout.add(tport,1,1);
        layout.add(ldb,0,2);
        layout.add(tdb,1,2);
        layout.add(ldbuser,0,3);
        layout.add(tdbuser,1,3);
        layout.add(ldbpass,0,4);
        layout.add(tdbpass,1,4);
        layout.add(back,0,5);
        layout.add(submit,1,5);
        layout.add(exit,0,6);

        GridPane alayout = new GridPane();
        alayout.setAlignment(Pos.CENTER);
        alayout.setHgap(10);
        alayout.setVgap(10);

        alayout.add(heading,0,0);
        alayout.add(sub,0,1);

        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(alayout);
        mainLayout.setCenter(layout);
        mainLayout.setBottom(lnotice);

        Scene scene = new Scene(mainLayout,Welcome.gw,Welcome.gh);

        Welcome.common.setScene(scene);

    }
}
