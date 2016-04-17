package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Ankit Sarkar on 4/12/2016.
 */
public class DBPenInsert {
    String name,pass,dept;
    public int penInsert(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + Welcome.host + ":" + Welcome.port + "/" + Welcome.db + "?" + "user=" + Welcome.dbuser + "&password=" + Welcome.dbpass);
            PreparedStatement rst = conn.prepareStatement("Select * from employee");
            PreparedStatement pst = conn.prepareStatement("Select * from pending");
            int EID=0;
            int REID=0;
            int flagr = 0;
            int flagp = 0;
            while(true){
                EID++;
                flagr = 0;
                flagp = 0;
                ResultSet rs = rst.executeQuery();
                ResultSet ps = pst.executeQuery();
                while(rs.next()){
                    if(rs.getInt("EID") == EID){
                        flagr = 1;
                    }
                }
                while(ps.next()){
                    if(ps.getInt("EID") == EID){
                        flagp = 1;
                    }
                }
                if(flagr == 0 && flagp == 0){
                    REID = EID;
                    break;
                }
            }
            PreparedStatement mst = conn.prepareStatement("Insert into pending (EID,NAME,PASS,DEPT) Values (?,?,?,?)");
            mst.setInt(1, REID);
            mst.setString(2, name);
            mst.setString(3, pass);
            mst.setString(4, dept);
            mst.executeUpdate();
            return REID;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
