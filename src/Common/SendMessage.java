package Common;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * Created by Deadpool on 4/12/2016.
 */
public class SendMessage {
    public static void display(int EID, int mode, Scene sback){
        Label heading = new Label("Message Form");
        Label rid = new Label("Recipient's ID");
        Label sub = new Label("Subject");
        Label message = new Label("Message");
        Button back = new Button("Back");
        Button send = new Button("Send");
        Button exit = new Button("Exit");
        Button logout = new Button("Log Out");

        TextField trid = new TextField();
        TextField tsub = new TextField();
        TextArea msg = new TextArea();

        if(mode == 0){
            rid.setVisible(false);
            trid.setVisible(false);
        }

        send.setOnAction(e ->{
            if(mode == 0){
                if(msg.getText().length() == 0 || sub.getText().length() == 0)
                    AlertDialog.display("ERROR","No Field Can be Empty !!");
                else
                    DBMsgInsert.mgInsert(msg.getText(),sub.getText(),EID,0);
            }
            else if(msg.getText().length() == 0 || sub.getText().length() == 0 || trid.getText().length() == 0)
                AlertDialog.display("ERROR","No Field Can be Empty !!");
            else
                DBMsgInsert.mgInsert(msg.getText(),tsub.getText(),EID,Integer.parseInt(trid.getText()));
        });

        back.setOnAction(e -> {
            Welcome.common.setScene(sback);
        });

        exit.setOnAction(e -> {
            CloseLogic.onclose();
        });

        logout.setOnAction(e -> {
            CloseLogic.onclose(1);
        });

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);

        layout.setHgap(10);
        layout.setVgap(10);

        if(mode == 0){
            layout.add(heading,0,0);
            layout.add(sub,0,1);
            layout.add(tsub,1,1);
            layout.add(message,0,2);
        }
        else{
            layout.add(heading,0,0);
            layout.add(rid,0,1);
            layout.add(trid,1,1);
            layout.add(sub,0,2);
            layout.add(tsub,1,2);
            layout.add(message,0,3);
        }

        GridPane buttons = new GridPane();
        buttons.setAlignment(Pos.CENTER);

        buttons.setHgap(10);
        buttons.setVgap(10);

        buttons.add(back,0,0);
        buttons.add(send,1,0);
        buttons.add(logout,2,0);
        buttons.add(exit,3,0);

        BorderPane blayout = new BorderPane();
        blayout.setTop(layout);
        blayout.setCenter(msg);
        blayout.setBottom(buttons);

        Scene scene = new Scene(blayout,Welcome.gw,Welcome.gh);
        Welcome.common.setScene(scene);
    }
}
