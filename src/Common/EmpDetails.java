package Common;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.FloatMap;
import javafx.scene.layout.GridPane;

/**
 * Created by Ankit Sarkar on 4/10/2016.
 */
public class EmpDetails {
    public static void display(int EID, Scene scene, int ap){
        try {
            DBHub data = new DBHub();
            data.empSelect(EID);

            TextField tname = new TextField(data.name);
            TextField tid = new TextField(Integer.toString(data.eid));
            TextField tbasic = new TextField(Float.toString(data.bonus));
            TextField tda = new TextField(Float.toString(data.da));
            TextField thra = new TextField(Float.toString(data.hra));
            TextField tbonus = new TextField(Float.toString(data.bonus));
            TextField tma = new TextField(Float.toString(data.ma));
            TextField tta = new TextField(Float.toString(data.ta));
            TextField tsa = new TextField(Float.toString(data.sa));
            TextField taa = new TextField(Float.toString(data.ta));
            TextField tmd = new TextField(Float.toString(data.md));
            TextField tcd = new TextField(Float.toString(data.cd));
            TextField tdept = new TextField(data.dept);

            Label heading = new Label("Employee Details");
            Label lname = new Label("Name");
            Label ldept = new Label("Department");
            Label lid = new Label("Employee ID");
            Label allheading = new Label("All Allowances");
            Label gen = new Label("General");
            Label lbasic = new Label("Basic");
            Label lda = new Label("Dearness Allowance");
            Label lhra = new Label("House Rent Allowance");
            Label lbonus = new Label("Bonus");
            Label lma = new Label("Medical Allowance");
            Label lta = new Label("Travelling Allowance");
            Label lsa = new Label("Shifting Allowance");
            Label laa = new Label("Accident Allowance");
            Label dedheading = new Label("All Deductions");
            Label lmd = new Label("Mess Deduction");
            Label lcd = new Label("Cleanliness Deduction");
            Button back = new Button("Back");
            Button save = new Button("Save Changes");
            Button exit = new Button("Exit");
            Button print = new Button("Print");
            CheckBox admin = new CheckBox("Admin Rights");

            exit.setOnAction(e -> {
                CloseLogic.onclose();
            });

            back.setOnAction(e -> {
                Welcome.common.setScene(scene);
            });

            if (data.ap == 1) {
                admin.setSelected(true);
            }

            tid.setEditable(false);
            if (ap != 1) {
                tname.setEditable(false);
                tdept.setEditable(false);
                tbasic.setEditable(false);
                tda.setEditable(false);
                thra.setEditable(false);
                tbonus.setEditable(false);
                tma.setEditable(false);
                tta.setEditable(false);
                tsa.setEditable(false);
                taa.setEditable(false);
                tmd.setEditable(false);
                tcd.setEditable(false);
                save.setVisible(false);
                admin.setVisible(false);
            }

            GridPane layout = new GridPane();
            layout.setAlignment(Pos.CENTER);
            layout.setHgap(10);
            layout.setVgap(10);

            layout.add(heading, 0, 0);
            layout.add(lname, 0, 1);
            layout.add(tname, 1, 1);
            layout.add(lid, 0, 2);
            layout.add(tid, 1, 2);
            layout.add(ldept, 0, 3);
            layout.add(tdept, 1, 3);
            layout.add(gen, 0, 4);
            layout.add(lbasic, 0, 5);
            layout.add(tbasic, 1, 5);
            layout.add(allheading, 0, 6);
            layout.add(lda, 0, 7);
            layout.add(tda, 1, 7);
            layout.add(lhra, 0, 8);
            layout.add(thra, 1, 8);
            layout.add(lbonus, 0, 9);
            layout.add(tbonus, 1, 9);
            layout.add(lma, 0, 10);
            layout.add(tma, 1, 10);
            layout.add(lta, 0, 11);
            layout.add(tta, 1, 11);
            layout.add(lsa, 0, 12);
            layout.add(tsa, 1, 12);
            layout.add(laa, 0, 13);
            layout.add(taa, 1, 13);
            layout.add(dedheading, 0, 14);
            layout.add(lmd, 0, 15);
            layout.add(tmd, 1, 15);
            layout.add(lcd, 0, 16);
            layout.add(tcd, 1, 16);
            layout.add(admin, 0, 17);
            layout.add(back, 0, 18);
            layout.add(save, 1, 18);
            layout.add(exit, 0, 19);
            layout.add(print, 1, 19);

            print.setOnAction(e -> {
                PrintJob.print(layout);
            });

            save.setOnAction(e -> {
                DBEmpUpdate insert = new DBEmpUpdate();
                insert.eid = Integer.parseInt(tid.getText());
                insert.name = tname.getText();
                insert.aa = Float.parseFloat(taa.getText());
                insert.basic = Float.parseFloat(tbasic.getText());
                insert.bonus = Float.parseFloat(tbonus.getText());
                insert.cd = Float.parseFloat(tcd.getText());
                insert.da = Float.parseFloat(tda.getText());
                insert.dept = tdept.getText();
                insert.hra = Float.parseFloat(thra.getText());
                insert.ma = Float.parseFloat(tma.getText());
                insert.md = Float.parseFloat(tmd.getText());
                insert.sa = Float.parseFloat(tsa.getText());
                insert.ta = Float.parseFloat(tta.getText());
                if (admin.isSelected()) {
                    insert.ap = 1;
                }
                insert.empUpdate(data.eid);
                AlertDialog.display("Success", "Database Updated Successfully !!");
            });

            Scene current = new Scene(layout, 640, 700);

            Welcome.common.setScene(current);
        }
        catch(Exception e){
            AlertDialog.display("ERROR","Non Compatible Values Detected !");
        }
    }
}
