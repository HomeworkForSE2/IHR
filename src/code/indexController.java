package code;

import javafx.fxml.FXML;

public class indexController {

     @FXML private void toLogin() throws Exception {
         MainUI.toLogin();
    }

    @FXML private void toSignUp() throws Exception {
        MainUI.toSignUp();
    }
}
