package Common;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

/**
 * Created by Ankit Sarkar on 4/9/2016.
 */
public class Welcome extends Application{
    public static Stage common;
    static Scene login;
    Button sign_in, apply;
    static TextField usert;
    static PasswordField passt;
    static String host = "******";
    static String port = "3306";
    static String db = "*******";
    static String dbuser = "*******";
    static String dbpass = "**********";
    public static int gw = 720;
    public static int gh = 480;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        common = primaryStage;
        common.setOnCloseRequest(e -> {
            e.consume();
            CloseLogic.onclose();
        });
        Label heading = new Label();
        heading.setText("Payroll Management System");
        Label username = new Label("Username");
        Label password = new Label("Password");
        sign_in = new Button("Sign In");
        apply = new Button("Apply");
        usert = new TextField();
        passt = new PasswordField();

        Button exit = new Button("Exit");
        exit.setOnAction(e -> {
            CloseLogic.onclose();
        });

        sign_in.setOnAction(e -> {
            if(usert.getText().length() == 0 || passt.getText().length() == 0){
                AlertDialog.display("Empty Field Error", "All Fields are Required");
            }
            else if(!CheckNum.checkInt(usert.getText())){
                AlertDialog.display("Employee ID Field Error", "Only Numbers Allowed in Employee ID Field");
            }
            else{
                int access = validate(usert.getText(), passt.getText());
                if(access == 1){
                    Admin.Manager.display(Integer.parseInt(usert.getText()));
                }else if(access == 2){
                    Employee.Manager.display(Integer.parseInt(usert.getText()));
                }else if(access == 3){
                    DBConnect.display();
                }else{
                    AlertDialog.display("Wrong Credentials", "Please Check Your Credentials");
                }
            }
        });

        apply.setOnAction(e ->{
            Apply.display(login);
        });


        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(25,25,25,25));

        layout.add(username,0,1);
        layout.add(usert,1,1);
        layout.add(heading,0,0);
        layout.add(password,0,2);
        layout.add(passt,1,2);
        layout.add(sign_in,0,3);
        layout.add(apply,1,3);
        layout.add(exit,0,4);

        login = new Scene(layout,gw,gh);
        login.getStylesheets().add("global.css");
        heading.setId("fancytext");
        common.setTitle("Login Page");
        common.setScene(login);
        common.show();
    }

    private int validate(String EID,String PASS){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db + "?" + "user=" + dbuser + "&password=" + dbpass);
            PreparedStatement pst = conn.prepareStatement("Select * from employee where EID=? and PASS=?");
            pst.setString(1, EID);
            pst.setString(2, PASS);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                if(rs.getInt("AP") == 1){
                    return 1;
                }
                else
                    return 2;
            }
            else
                return 0;
        }
        catch(SQLException e){
            e.printStackTrace();
            return 3;
        }
    }
    public static void back(){
        usert.setText("");
        passt.setText("");
        common.setScene(login);
        common.show();
    }
}
