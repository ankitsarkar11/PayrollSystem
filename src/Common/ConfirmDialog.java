package Common;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Ankit Sarkar on 4/9/2016.
 */
public class ConfirmDialog {
    static boolean ans;
    public static boolean display(String title, String msg){
        Stage face = new Stage();
        face.setTitle(title);
        face.initModality(Modality.APPLICATION_MODAL);
        Label label = new Label(msg);
        Button yes = new Button("Yes");
        Button no = new Button("No");

        yes.setOnAction(e -> {
            ans = true;
            face.close();
        });

        no.setOnAction(e -> {
            ans = false;
            face.close();
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label,yes,no);

        Scene scene = new Scene(layout,200,100);

        face.setScene(scene);
        face.showAndWait();

        return ans;
    }
}
