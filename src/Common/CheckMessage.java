package Common;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by Ankit Sarkar on 4/17/2016.
 */
public class CheckMessage {
    public static void display(int sr, Scene sback){
        Label heading = new Label("Message Details");
        Label lsd = new Label("Sender");
        Label lsub = new Label("Subject");
        Label lmsg = new Label("Message");

        TextField tsd = new TextField();
        TextField tsub = new TextField();
        TextArea tmsg = new TextArea();

        tsd.setEditable(false);
        tsub.setEditable(false);
        tmsg.setEditable(false);

        Button back = new Button("Back");
        Button logout = new Button("Log Out");
        Button exit = new Button("Exit");

        logout.setOnAction(e -> {
            CloseLogic.onclose(1);
        });

        exit.setOnAction(e -> {
            CloseLogic.onclose();
        });

        back.setOnAction(e -> {
            Welcome.common.setScene(sback);
        });

        DBMsgSelect mdata = new DBMsgSelect(sr);
        tsd.setText(Integer.toString(mdata.eid));
        tsub.setText(mdata.sub);
        tmsg.setText(mdata.msg);

        GridPane glayout = new GridPane();
        glayout.setAlignment(Pos.CENTER);
        glayout.setHgap(10);
        glayout.setVgap(10);
        glayout.add(lsd,0,0);
        glayout.add(tsd,1,0);
        glayout.add(lsub,0,1);
        glayout.add(tsub,1,1);
        glayout.add(lmsg,0,2);

        HBox bBox = new HBox(10);
        bBox.setAlignment(Pos.CENTER);
        bBox.getChildren().addAll(back,logout,exit);

        VBox main = new VBox(10);
        main.setAlignment(Pos.CENTER);
        main.getChildren().addAll(heading,glayout,tmsg,bBox);

        Scene scene = new Scene(main,Welcome.gw,Welcome.gh);
        Welcome.common.setScene(scene);
    }
}
