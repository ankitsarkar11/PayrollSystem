package Admin;

import Common.AlertDialog;
import Common.CloseLogic;
import Common.ConfirmDialog;
import Common.Welcome;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Ankit Sarkar on 4/9/2016.
 */
public class Manager {
    public static void display(int EID, Scene login){
        Label heading = new Label("Administrator Panel");
        Label lsearch = new Label("Employee ID to Search");
        TextField tsearch = new TextField();
        Button bsearch = new Button("Search");
        Button logout = new Button("Logout");
        bsearch.setOnAction(e ->{
            if(tsearch.getText().length() == 0){
                AlertDialog.display("Empty Field", "The Field Can't be Empty");
            }
            else{
                msearch(Integer.parseInt(tsearch.getText()));
            }
        });

        Button exit = new Button("Exit");
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
        layout.add(logout,0,3);
        layout.add(exit,1,3);

        Scene scene = new Scene(layout,640,480);
        Welcome.common.setScene(scene);
        Welcome.common.show();

    }
    private static void msearch(int EID){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pay_admin?" + "user=pay_admin&password=qwerty12345");
            PreparedStatement pst = conn.prepareStatement("Select * from employee");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                if(EID == rs.getInt("EID")){
                    EmpSum.display(EID);
                }
                else{
                    AlertDialog.display("Not Found","Employee Not Found !");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
