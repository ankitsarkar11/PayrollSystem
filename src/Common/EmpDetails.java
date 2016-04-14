package Common;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

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
            Button logout = new Button("Log Out");

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

            logout.setOnAction(e ->{
                CloseLogic.onclose(1);
            });

            if(data.ap == 1) {
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

            layout.add(heading, 2, 0);
            layout.add(lname, 0, 1);
            layout.add(tname, 1, 1);
            layout.add(lid, 3, 1);
            layout.add(tid, 4, 1);
            layout.add(ldept, 0, 2);
            layout.add(tdept, 1, 2);
            layout.add(gen, 2, 3);
            layout.add(lbasic, 0, 4);
            layout.add(tbasic, 1, 4);
            layout.add(allheading, 2, 5);
            layout.add(lda, 0, 6);
            layout.add(tda, 1, 6);
            layout.add(lhra, 3, 6);
            layout.add(thra, 4, 6);
            layout.add(lbonus, 0, 7);
            layout.add(tbonus, 1, 7);
            layout.add(lma, 3, 7);
            layout.add(tma, 4, 7);
            layout.add(lta, 0, 8);
            layout.add(tta, 1, 8);
            layout.add(lsa, 3, 8);
            layout.add(tsa, 4, 8);
            layout.add(laa, 0, 9);
            layout.add(taa, 1, 9);
            layout.add(dedheading, 2, 10);
            layout.add(lmd, 0, 11);
            layout.add(tmd, 1, 11);
            layout.add(lcd, 3, 11);
            layout.add(tcd, 4, 11);

            GridPane buttonGrid = new GridPane();
            buttonGrid.setAlignment(Pos.CENTER);
            buttonGrid.setVgap(10);
            buttonGrid.setHgap(100);

            if(ap == 1) {
                buttonGrid.add(back, 0, 0);
                buttonGrid.add(logout, 1, 0);
                buttonGrid.add(save, 2, 0);
                buttonGrid.add(print, 3, 0);
                buttonGrid.add(exit, 4, 0);
            }
            else{
                buttonGrid.add(back, 0, 0);
                buttonGrid.add(logout, 1, 0);
                buttonGrid.add(print, 2, 0);
                buttonGrid.add(exit, 3, 0);
            }

            VBox vlayout = new VBox(10);
            vlayout.setAlignment(Pos.CENTER);
            vlayout.getChildren().addAll(layout,admin,buttonGrid);

            print.setOnAction(e -> {
                print.setVisible(false);
                save.setVisible(false);
                admin.setVisible(false);
                back.setVisible(false);
                exit.setVisible(false);
                logout.setVisible(false);
                PrintJob.print(layout);
                back.setVisible(true);
                exit.setVisible(true);
                print.setVisible(true);
                logout.setVisible(true);
                if(ap == 1){
                    save.setVisible(true);
                    admin.setVisible(true);
                }
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

            Scene current = new Scene(vlayout,Welcome.gw,Welcome.gh);

            Welcome.common.setScene(current);
        }
        catch(Exception e){
            AlertDialog.display("ERROR","Non Compatible Values Detected !");
        }
    }
}
