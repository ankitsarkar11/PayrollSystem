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
    public static String singleselect(int EID, String req){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pay_admin?" + "user=pay_admin&password=qwerty12345");
            PreparedStatement pst = conn.prepareStatement("Select * from employee");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                return rs.getString(req);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return "N/A";
        }
        return "N/A";
    }
}
