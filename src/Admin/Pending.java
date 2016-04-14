package Admin;

import Common.DBPenSelect;
import Common.PenDetails;
import Common.PenList;
import Common.Welcome;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Deadpool on 4/12/2016.
 */
public class Pending {
    static Scene scene;
    public static void display(Scene back){
        Label heading = new Label("Pending Requests");

        TableView<PenList> penTable = new TableView();
        penTable.setEditable(false);

        TableColumn<PenList,String> penName = new TableColumn<>("Name");
        TableColumn<PenList,Integer> penId = new TableColumn<>("Employee ID");
        TableColumn<PenList,String> penDept = new TableColumn<>("Department");
        TableColumn<PenList,Button> penAction = new TableColumn<>("Action");

        penName.setMinWidth(165);
        penAction.setMinWidth(165);
        penId.setMinWidth(190);
        penDept.setMinWidth(190);

        penName.setCellValueFactory(new PropertyValueFactory<>("name"));
        penId.setCellValueFactory(new PropertyValueFactory<>("eid"));
        penDept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        penAction.setCellValueFactory(new PropertyValueFactory<>("action"));

        penTable.setItems(getPen());
        penTable.getColumns().addAll(penId,penName,penDept,penAction);


        GridPane tLayout = new GridPane();
        tLayout.setAlignment(Pos.CENTER);
        tLayout.setHgap(10);
        tLayout.setVgap(10);
        tLayout.add(heading,0,0);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(tLayout,penTable);

        scene = new Scene(layout,Welcome.gw,Welcome.gh);
        Welcome.common.setScene(scene);

    }

    public static ObservableList<PenList> getPen(){
        ObservableList<PenList> emps = FXCollections.observableArrayList();
        ResultSet data = DBPenSelect.penSelectAll();
        try{
            while(data.next()){
                int eid = data.getInt("EID");
                String name = data.getString("name");
                String dept = data.getString("dept");
                Button a = new Button("View Details");
                a.setOnAction(e -> {
                    PenDetails.display(eid,name,dept,scene);
                });
                emps.add(new PenList(name,eid,dept,a));
            }
            data.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return emps;
    }
}
