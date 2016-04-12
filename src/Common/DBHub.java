package Common;

import Admin.EmpSum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Ankit Sarkar on 4/10/2016.
 */
public class DBHub {
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

    public void empSelect(int EID){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + Welcome.host + ":" + Welcome.port + "/" + Welcome.db + "?" + "user=" + Welcome.dbuser + "&password=" + Welcome.dbpass);
            PreparedStatement pst = conn.prepareStatement("Select * from employee where EID=?");
            pst.setInt(1,EID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                eid = rs.getInt("EID");
                name = rs.getString("NAME");
                dept = rs.getString("DEPT");
                basic = rs.getFloat("BASIC");
                da = rs.getFloat("DA");
                hra = rs.getFloat("HRA");
                aa = rs.getFloat("AA");
                ta = rs.getFloat("TA");
                bonus = rs.getFloat("BONUS");
                ma = rs.getFloat("MA");
                sa = rs.getFloat("SA");
                ap = rs.getInt("AP");
                md = rs.getFloat("MD");
                cd = rs.getFloat("CD");
            }
            else{
                eid = 0;
            }
        }
        catch(Exception e) {
            AlertDialog.display("ERROR","Non Compatible Values Detected !");
        }
    }


}
