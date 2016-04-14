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
public class AlertDialog {
    public static void display(String title, String msg){
        Stage face = new Stage();
        face.initModality(Modality.APPLICATION_MODAL);
        face.setTitle(title);
        Label label = new Label(msg);
        Button close = new Button("Go Back");
        close.setOnAction(e -> face.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,close);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 400,100);
        face.setScene(scene);
        face.showAndWait();
    }
}
