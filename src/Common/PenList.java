package Common;

import javafx.scene.control.Button;

/**
 * Created by Ankit Sarkar on 4/14/2016.
 */
public class PenList{
    private String name,dept;
    private int eid;
    Button action = new Button("View Details");

    public Button getAction() {
        return action;
    }

    public void setAction(Button action) {
        this.action = action;
    }

    public PenList(String name, int eid, String dept, Button action){
        this.name = name;
        this.eid = eid;
        this.dept = dept;
        this.action = action;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }
}
