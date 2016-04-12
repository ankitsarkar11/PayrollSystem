package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by Deadpool on 4/12/2016.
 */
public class DBEmpUpdate {
    public String name;
    public String dept;
    public int eid;
    public float basic;
    public float da;
    public float hra;
    public float aa;
    public float ta;
    public float bonus;
    public float ma;
    public float sa;
    public int ap;
    public float md;
    public float cd;

    public void empUpdate(int EID){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pay_admin?" + "user=pay_admin&password=qwerty12345");
            PreparedStatement pst = conn.prepareStatement("Update  employee Set EID=?,NAME=?,DEPT=?,BASIC=?,DA=?,HRA=?,AA=?,TA=?,BONUS=?,MA=?,SA=?,AP=?,MD=?,CD=? Where EID=?");
            pst.setInt(1,eid);
            pst.setString(2,name);
            pst.setString(3,dept);
            pst.setFloat(4,basic);
            pst.setFloat(5,da);
            pst.setFloat(6,hra);
            pst.setFloat(7,aa);
            pst.setFloat(8,ta);
            pst.setFloat(9,bonus);
            pst.setFloat(10,ma);
            pst.setFloat(11,sa);
            pst.setInt(12,ap);
            pst.setFloat(13,md);
            pst.setFloat(14,cd);
            pst.setFloat(15,EID);

            pst.executeUpdate();
        }
        catch(Exception e) {
            AlertDialog.display("ERROR","Non Compatible Values Detected !");
        }
    }
}
