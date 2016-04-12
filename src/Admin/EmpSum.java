package Admin;


import Common.CloseLogic;
import Common.DBHub;
import Common.EmpDetails;
import Common.Welcome;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Created by Ankit Sarkar on 4/10/2016.
 */
public class EmpSum {
    public static void display(int EID, Scene sback){
        DBHub data = new DBHub();
        data.empSelect(EID);

        Button back = new Button("Back");
        Button exit = new Button("Exit");
        Button logout = new Button("Log Out");
        Button details = new Button("View Details");
        Label heading = new Label("Employee Summary");
        Label lid = new Label(Integer.toString(EID));
        Label lidF = new Label("Identification Code:");
        Label lname = new Label(data.name);
        Label lnameF = new Label("Name:");
        Label sheading = new Label("Salary Details");
        Label lbasicF = new Label("Basic:");
        Label lbasic = new Label("\u20B9 "+data.basic);
        Label latotalF = new Label("Total Allowances:");
        float atotal = data.da + data.hra + data.aa + data.ta + data.bonus + data.ma + data.sa;
        Label latotal = new Label("\u20B9 "+Float.toString(atotal));
        Label ldtotalF = new Label("Total Deductions:");
        float dtotal = data.md + data.cd;
        Label ldtotal = new Label("\u20B9 "+Float.toString(dtotal));
        Label lgtotalF = new Label("Gross Salary");
        float gtotal = data.basic + atotal -dtotal;
        Label lgtotal = new Label("\u20B9 "+Float.toString(gtotal));
        back.setOnAction(e -> {
            Manager.tsearch.setText("");
            Welcome.common.setScene(sback);
        });

        exit.setOnAction(e -> CloseLogic.onclose());

        logout.setOnAction(e -> CloseLogic.onclose(1));

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.add(heading,0,0);
        layout.add(lnameF,0,1);
        layout.add(lname,1,1);
        layout.add(lidF,0,2);
        layout.add(lid,1,2);
        layout.add(sheading,0,3);
        layout.add(lbasicF,0,4);
        layout.add(lbasic,1,4);
        layout.add(latotalF,0,5);
        layout.add(latotal,1,5);
        layout.add(ldtotalF,0,6);
        layout.add(ldtotal,1,6);
        layout.add(lgtotalF,0,7);
        layout.add(lgtotal,1,7);
        layout.add(back,0,9);
        layout.add(exit,1,9);
        layout.add(logout,0,10);
        layout.add(details,1,10);

        Scene scene = new Scene(layout,Welcome.gw,Welcome.gh);
        details.setOnAction(e ->{
            EmpDetails.display(EID,scene,1);
        });
        Welcome.common.setScene(scene);
        Welcome.common.show();
    }
}
