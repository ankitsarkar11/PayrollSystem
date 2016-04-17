package Common;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;

/**
 * Created by Ankit Sarkar on 4/17/2016.
 */
public class MessageList {
    static Scene scene;
    public static void display(int EID2, Scene sback){

        Label heading = new Label("Messages");

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

        TableView<MsgDecs> msgTable = new TableView();
        msgTable.setEditable(false);

        TableColumn<MsgDecs,Integer> msgSR= new TableColumn<>("No.");
        TableColumn<MsgDecs,Integer> msgEid = new TableColumn<>("Employee ID");
        TableColumn<MsgDecs,String> msgName = new TableColumn<>("Name");
        TableColumn<MsgDecs,String> msgSub = new TableColumn<>("Subject");
        TableColumn<MsgDecs,Button> msgAction = new TableColumn<>("View Action");

        msgSR.setCellValueFactory(new PropertyValueFactory<>("sr"));
        msgEid.setCellValueFactory(new PropertyValueFactory<>("eid"));
        msgName.setCellValueFactory(new PropertyValueFactory<>("name"));
        msgSub.setCellValueFactory(new PropertyValueFactory<>("sub"));
        msgAction.setCellValueFactory(new PropertyValueFactory<>("action"));

        msgTable.setItems(getMsg(EID2));
        msgTable.getColumns().addAll(msgSR,msgEid,msgName,msgSub,msgAction);

        HBox bBox = new HBox(10);
        bBox.setAlignment(Pos.CENTER);
        bBox.getChildren().addAll(back,logout,exit);

        VBox main = new VBox(10);
        main.setAlignment(Pos.CENTER);
        main.getChildren().addAll(heading,msgTable,bBox);

        scene = new Scene(main,Welcome.gw,Welcome.gh);
        Welcome.common.setScene(scene);
    }

    public static ObservableList<MsgDecs> getMsg(int EID2){
        ObservableList<MsgDecs> msgdet = FXCollections.observableArrayList();
        ResultSet rs = DBMsgList.msgSelectAll(EID2);
        int msgsr = 0;
        try{
            while(rs.next()){
                msgsr++;
                int eid = rs.getInt("EID2");
                DBHub data = new DBHub();
                data.empSelect(eid);
                String name = data.name;
                String sub = rs.getString("SUB");
                Button action = new Button("View");
                int SR = rs.getInt("SR");
                action.setOnAction(e -> {
                    CheckMessage.display(SR,scene);
                });
                msgdet.add(new MsgDecs(msgsr,eid,name,sub,action));
            }
            rs.close();
        }
        catch (SQLException e){
            e.printStackTrace();;
        }
        return msgdet;
    }
}
