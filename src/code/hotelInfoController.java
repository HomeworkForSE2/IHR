package code;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class hotelInfoController {

    @FXML private Text hotelName;
    @FXML private Text address;
    @FXML private Text circle;
    @FXML private HBox star;
    @FXML private Text mark;
    @FXML private Text service;
    @FXML private Text intro;
    @FXML private Button ok;

    public void init(String[] hotelInfo){
        hotelName.setText(hotelInfo[0]);
        address.setText(hotelInfo[1]);
        circle.setText(hotelInfo[2]);
        int starNum = Integer.parseInt(hotelInfo[3]);
        for (int i=0;i<starNum;i++){
            ImageView stars = new ImageView();
            stars.setImage(new Image("../pic/star.png"));
            star.getChildren().addAll(stars);
        }
        mark.setText(hotelInfo[4]);
        service.setText(hotelInfo[5]);
        intro.setText(hotelInfo[6]);
    }

    @FXML private void ok() throws IOException {
        MainUI.toOrder(hotelName.getText());
    }
}
