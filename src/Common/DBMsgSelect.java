package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Ankit Sarkar on 4/17/2016.
 */
public class DBMsgSelect {
    public int eid, eid2,chk;
    public String sub, msg;
    DBMsgSelect(int sr){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + Welcome.host + ":" + Welcome.port + "/" + Welcome.db + "?" + "user=" + Welcome.dbuser + "&password=" + Welcome.dbpass);
            PreparedStatement pst = conn.prepareStatement("Select * from message where SR=?");
            pst.setInt(1,sr);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                msg = rs.getString("WROTE");
                eid = rs.getInt("EID");
                eid2 = rs.getInt("EID2");
                chk = rs.getInt("CHK");
                sub = rs.getString("SUB");
            }
        }
        catch(Exception e) {
            AlertDialog.display("ERROR","Non Compatible Values Detected !");
        }
    }
}
