package code;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainUI extends Application {

	static int userID;
    private static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
        stage = primaryStage;
        stage.setTitle("意 居");
        stage.setScene(new Scene(root, 1280, 720));

//        stage.initStyle(StageStyle.UNDECORATED);

        stage.show();
    }

    static void toLogin() throws Exception {
        Stage loginStage = new Stage();
        Parent root = FXMLLoader.load(indexController.class.getResource("login.fxml"));
        Scene scene = new Scene(root, 450,600);

        loginStage.setScene(scene);
        loginStage.show();
        loginController.getLoginStage(loginStage);
    }

    static  void toSignUp() throws Exception {
        Stage signUpStage = new Stage();
        Parent root = FXMLLoader.load(indexController.class.getResource("signUp.fxml"));
        Scene scene = new Scene(root, 450,600);

        signUpStage.setScene(scene);
        signUpStage.show();
        signUpController.getSignUpStage(signUpStage);
    }
    static void toUserWelcome() throws IOException {
        Parent root = FXMLLoader.load(indexController.class.getResource("userWelcome.fxml"));

        Scene scene = new Scene(root,1280,720);
        stage.setScene(scene);
        stage.show();
    }

    static void toIndex() throws IOException{
        Parent root = FXMLLoader.load(indexController.class.getResource("index.fxml"));

        Scene scene = new Scene(root,1280,720);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
