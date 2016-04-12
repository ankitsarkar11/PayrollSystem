package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Deadpool on 4/12/2016.
 */
public class DBMsgInsert {
    public static void mgInsert(String msg, String sub, int eid, int rid){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + Welcome.host + ":" + Welcome.port + "/" + Welcome.db + "?" + "user=" + Welcome.dbuser + "&password=" + Welcome.dbpass);
            int SR = srgen();
            if(rid == 0){
                PreparedStatement nst = conn.prepareStatement("SELECT *  from employee WHERE AP=1");
                ResultSet rs = nst.executeQuery();
                while(rs.next())
                {
                    PreparedStatement pst = conn.prepareStatement("INSERT INTO message (SR,EID,EID2,CHK,WROTE,SUB) "+ "values (?,?,?,0,?,?)");
                    pst.setInt(1, SR);
                    pst.setInt(2, eid);
                    pst.setInt(3, rs.getInt("EID"));
                    pst.setString(4, msg);
                    pst.setString(5, sub);
                    pst.executeUpdate();
                    SR = srgen();
                }
            }
            else{
                PreparedStatement pst = conn.prepareStatement("INSERT INTO message (SR,EID,EID2,CHK,WROTE,SUB) "+ "values (?,?,?,0,?,?)");
                pst.setInt(1, SR);
                pst.setInt(2, eid);
                pst.setInt(3, rid);
                pst.setString(4, msg);
                pst.setString(5, sub);
                pst.executeUpdate();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private static int srgen(){
        int SR = 0;
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + Welcome.host + ":" + Welcome.port + "/" + Welcome.db + "?" + "user=" + Welcome.dbuser + "&password=" + Welcome.dbpass);
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM MESSAGE");
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                SR++;
                if(SR != rst.getInt("SR")){
                    SR--;
                    break;
                }
            }
            SR++;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return SR;
    }
}
