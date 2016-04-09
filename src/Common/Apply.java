package Common;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Ankit Sarkar on 4/9/2016.
 */
public class Apply {


    public static Scene display(Scene login){
        Label uname = new Label("Name");
        Label upass = new Label("Password");
        Label udept = new Label("Department");
        Label heading = new Label("Application Form");

        PasswordField pass = new PasswordField();
        TextField name = new TextField();
        TextField dept = new TextField();

        Button submit = new Button("Submit");
        submit.setOnAction(e -> System.out.println(name.getText()+pass.getText()+dept.getText()));

        Button back = new Button("Back");
        back.setOnAction(e ->{
            Welcome.common.setTitle("Login Page");
            Welcome.common.setScene(login);
        });
        Button exit = new Button("Exit");
        exit.setOnAction(e -> {
            Welcome.common.close();
        });
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.add(heading,0,0);
        layout.add(uname,0,1);
        layout.add(name,1,1);
        layout.add(upass,0,2);
        layout.add(pass,1,2);
        layout.add(udept,0,3);
        layout.add(dept,1,3);
        layout.add(submit,0,4);
        layout.add(back,0,5);
        layout.add(exit,1,5);
        Scene scene = new Scene(layout,640,480);

        return scene;
    }
}
