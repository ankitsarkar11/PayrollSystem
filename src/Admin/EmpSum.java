package Admin;


import Common.CloseLogic;
import Common.DBHub;
import Common.Welcome;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Created by Deadpool on 4/10/2016.
 */
public class EmpSum {
    public static void display(int EID){
        Label heading = new Label("Employee Summary");
        Label lid = new Label(Integer.toString(EID));
        Label lidF = new Label("Identification Code:");
        Label lname = new Label(DBHub.singleselect(EID,"NAME"));
        Label lnameF = new Label("Name:");
        Label sheading = new Label("Salary Details");
        Label lbasicF = new Label("Basic:");
        Label lbasic = new Label("\u20B9 "+DBHub.singleselect(EID,"BASIC"));
        Label latotalF = new Label("Total Allowances:");
        float atotal = Float.parseFloat(DBHub.singleselect(EID,"da")) +
                Float.parseFloat(DBHub.singleselect(EID,"hra")) +
                Float.parseFloat(DBHub.singleselect(EID,"aa")) +
                Float.parseFloat(DBHub.singleselect(EID,"ta")) +
                Float.parseFloat(DBHub.singleselect(EID,"bonus")) +
                Float.parseFloat(DBHub.singleselect(EID,"ma")) +
                Float.parseFloat(DBHub.singleselect(EID,"sa"));
        Label latotal = new Label("\u20B9 "+Float.toString(atotal));
        Label ldtotalF = new Label("Total Deductions:");
        float dtotal = Float.parseFloat(DBHub.singleselect(EID,"md")) +
                Float.parseFloat(DBHub.singleselect(EID,"cd"));
        Label ldtotal = new Label("\u20B9 "+Float.toString(dtotal));
        Label lgtotalF = new Label("Gross Salary");
        float gtotal = Float.parseFloat(DBHub.singleselect(EID,"BASIC")) + atotal -dtotal;
        Label lgtotal = new Label("\u20B9 "+Float.toString(gtotal));

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

        Scene scene = new Scene(layout,640,480);
        Welcome.common.setScene(scene);
        Welcome.common.show();


    }
}
