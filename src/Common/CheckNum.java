package Common;

/**
 * Created by Ankit Sarkar on 4/14/2016.
 */
public class CheckNum {
    public static boolean checkInt(String checkStr){
        int checker;
        try{
            checker = Integer.parseInt(checkStr);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
