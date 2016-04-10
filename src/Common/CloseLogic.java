package Common;

/**
 * Created by Ankit Sarkar on 4/10/2016.
 */
public class CloseLogic {
    public static void onclose(){
        if(ConfirmDialog.display("Confirmation","Are You Sure ?")){
            Welcome.common.close();
        }
    }
}
