package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Deadpool on 4/12/2016.
 */
public class DBPenSelect {
    public String name,dept,pass;
    public int eid;
    ResultSet rs = null;

    public ResultSet penSelectAll() {
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pay_admin?" + "user=pay_admin&password=qwerty12345");
            PreparedStatement pst = conn.prepareStatement("Select * from pending");
            rs = pst.executeQuery();
            return rs;
        }
        catch(Exception e) {
            AlertDialog.display("ERROR","Non Compatible Values Detected !");
        }
        return rs;
    }
}
