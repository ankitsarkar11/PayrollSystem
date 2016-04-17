package Common;

import javafx.scene.control.Button;

/**
 * Created by Ankit Sarkar on 4/17/2016.
 */
public class MsgDecs {
    private int eid, sr;
    private String name, sub;
    private Button action;

    public int getSr() {
        return sr;
    }

    public void setSr(int sr) {
        this.sr = sr;
    }

    MsgDecs(int sr, int eid, String name, String sub, Button action){
        this.eid = eid;
        this.name = name;
        this.sub = sub;
        this.action = action;
        this.sr = sr;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public Button getAction() {
        return action;
    }

    public void setAction(Button action) {
        this.action = action;
    }
}
