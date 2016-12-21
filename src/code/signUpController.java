package code;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import service.MemberService;
import serviceImpl.MemberServiceImpl;
import vo.UserInfoVO;

import java.io.IOException;
import java.time.LocalDate;

public class signUpController {
    private static Stage stage;
    @FXML TextField userNameArea;
    @FXML PasswordField passwordArea;
    @FXML ToggleButton normalArea;
    @FXML ToggleButton enterpriseArea;
    @FXML TextField connectionArea;
    @FXML GridPane root;
    @FXML TextField enterpriseName;
    @FXML DatePicker birthday;
    private MemberService memberService;
    
    static void getSignUpStage(Stage signUpStage){
        stage = signUpStage;
    }
    @FXML private void normalClick(){
        normalArea.setSelected(true);
        enterpriseArea.setSelected(false);

        enterpriseName.setVisible(false);
        birthday.setVisible(true);
        birthday.setValue(LocalDate.now());
    }
    @FXML private void enterpriseClick(){
        normalArea.setSelected(false);
        enterpriseArea.setSelected(true);

        enterpriseName.setVisible(true);
        birthday.setVisible(false);
    }

    @FXML private void signUp() throws IOException {
        String userName = userNameArea.getText();
        String password = passwordArea.getText();
        String phoneNumber = connectionArea.getText();

        //注册信息
        String enterName=null;
        String bir=null;
        
        if(enterpriseArea.isSelected()){
        	enterName = enterpriseName.getText();
        }else{    
        	LocalDate date = birthday.getValue();
   

        	String year=String.valueOf(date.getYear());      
        	String month=String.valueOf(date.getMonthValue());
        	if(date.getMonthValue()<10){
        		month="0"+month;
        	}       
        	String day=String.valueOf(date.getDayOfMonth());
        	if(date.getDayOfMonth()<10){
        		day="0"+day;
        	}
        	bir=year+""+month+""+day; 
        	}

        	memberService=new MemberServiceImpl(); 
        	UserInfoVO user=new UserInfoVO(0, userName, password, phoneNumber, 0);    
        	int result=memberService.initialize(user,bir,enterName);
        
        	if(result>0){
        		MainUI.toUserWelcome();
        		MainUI.userID=result;
        		stage.close();
        	}else{
        		//未完成
        		System.out.println("注册失败！");
        	}
    }

    @FXML private void cancel(){
        stage.close();
    }
}
