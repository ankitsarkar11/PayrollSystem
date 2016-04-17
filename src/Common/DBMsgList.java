package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Ankit Sarkar on 4/17/2016.
 */
public class DBMsgList {
    public String name,dept,pass;
    public int eid;
    static ResultSet rs = null;

    public static ResultSet msgSelectAll(int EID2) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + Welcome.host + ":" + Welcome.port + "/" + Welcome.db + "?" + "user=" + Welcome.dbuser + "&password=" + Welcome.dbpass);
            PreparedStatement pst = conn.prepareStatement("Select * from message where EID2=?");
            pst.setInt(1,EID2);
            rs = pst.executeQuery();
            return rs;
        }
        catch(Exception e) {
            AlertDialog.display("ERROR","Non Compatible Values Detected !");
        }
        return rs;
    }
}
