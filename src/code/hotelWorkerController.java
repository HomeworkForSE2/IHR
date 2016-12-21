package code;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.io.IOException;

public class hotelWorkerController {
    @FXML private GridPane root;
    @FXML private VBox small;
    @FXML private HBox swap;
    @FXML private ChoiceBox<String> sortBar;
    private VBox slideBar;

    @FXML private void openSlideBar(){
        slideBar = new VBox();

        HBox backBox = new HBox();
        backBox.setAlignment(Pos.TOP_RIGHT);

        Image image = new Image("pic/back.png");
        ImageView back = new ImageView(image);
        backBox.setOnMouseClicked(event -> {
            root.getChildren().remove(slideBar);
            root.add(small,0,0,1,2);
        });

        backBox.getChildren().add(back);

        VBox head = new VBox();
        head.setPrefSize(300,300);
        head.setAlignment(Pos.TOP_CENTER);

        Text welcome = new Text("欢迎您");
        Text name = new Text();
        Text userInfo = new Text("酒店信息");
        Text creditRecord = new Text("客房信息");
        Text hotelRecord = new Text("订单处理");
        Text orderInfo = new Text("营销策略");

        Button logOut = new Button("退出登录");

        logOut.setOnAction(event -> {
            try {
                MainUI.toIndex();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        slideBar.setPrefSize(300,720);
        slideBar.setMinHeight(720);
        slideBar.setMinWidth(300);
        slideBar.setAlignment(Pos.TOP_CENTER);
        slideBar.getChildren().addAll(backBox,head,welcome,name,userInfo,creditRecord,hotelRecord,orderInfo,logOut);

        root.getChildren().remove(small);
        root.add(slideBar,0,0,1,2);
    }
}
