package code;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.LoginService;
import serviceImpl.LoginServiceImpl;

import java.io.IOException;

public class loginController {
    private static Stage stage;
    @FXML private TextField userNameArea;
    @FXML private PasswordField passwordArea;
    @FXML private ChoiceBox typeArea;

    private LoginService loginService;
    
    static void getLoginStage(Stage loginStage){
        stage = loginStage;
    }

    @FXML private void login() throws IOException {
        String userName = userNameArea.getText();
        String password = passwordArea.getText();
        String type = typeArea.getSelectionModel().getSelectedItem().toString();
       
        //login数据
        loginService=new LoginServiceImpl();      
        int result=0;
        if(type.equals("网站管理人员")){      	
        	if(loginService.loginAdmin(password)){
        		MainUI.toAdmin();
        		MainUI.userID=0;
        		stage.close();
        	}else{
//        		小弹窗System.out.println("网站管理人员密码错误");
        	}
        }else if(type.equals("网站营销人员")){
        	result=loginService.login(userName, password,3);
        	if(result>0){
        		MainUI.toWebsiteWorker();
        		MainUI.userID=result;
        		stage.close();
        	}else{
//        		小弹窗        		System.out.println("网站营销人员密码错误");
        	}
        }else if(type.equals("酒店管理人员")){
        	result=loginService.login(userName, password,2);
        	if(result>0){
        		MainUI.toHotelWorker();
        		MainUI.userID=result;
        		stage.close();
        	}else{
//        		小弹窗       		System.out.println("酒店管理人员密码错误");
        	}
        }else if(type.equals("客户")){
        	result=loginService.login(userName, password,1);
        	if(result>0){
        		MainUI.toUserWelcome();
        		MainUI.userID=result;
        		stage.close();
        	}else{
//        		小弹窗        		System.out.println("客户密码错误");
        	}
        }else{
//    		小弹窗   		System.out.println("未选择身份");
    	}
        
        
    
    }

    @FXML private void cancel(){
        stage.close();
    }
}
