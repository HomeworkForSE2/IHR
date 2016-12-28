package code;

import java.io.IOException;
import java.rmi.RemoteException;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import service.HotelBrowseService;
import service.OrderByUserService;
import serviceImpl.HotelBrowseServiceImpl;
import serviceImpl.OrderByUserServiceImpl;
import vo.OrderVO;

public class orderController {
    @FXML private Text hotelName;
    @FXML private DatePicker staDate;
    @FXML private DatePicker endDate;
    @FXML private ChoiceBox<String> roomType;
    @FXML private ChoiceBox<String> roomNum;
    @FXML private TextField peoNum;
    @FXML private CheckBox hasChildren;
    
    
    private OrderByUserService orderByUserService;
    private HotelBrowseService hotelBrowseService;
    public void init(String name){
        hotelName.setText(name);
    }

    @FXML private void order() throws IOException{
    	orderByUserService=new OrderByUserServiceImpl();
    	orderByUserService.initUser(MainUI.userID);
    	hotelBrowseService=new HotelBrowseServiceImpl();
    	
        String startTime = staDate.getValue().toString();
        String endTime = endDate.getValue().toString();
        String type = roomType.getSelectionModel().getSelectedItem();
        int num = Integer.parseInt(roomNum.getSelectionModel().getSelectedItem());
        int pNum = Integer.parseInt(peoNum.getText());
        Boolean hasChild = hasChildren.isSelected();

        int rType=0;
        if(type.equals("单人间")){
        	rType=1;
        }else if(type.equals("双人间")){
        	rType=2;
        }else if(type.equals("三人间")){
        	rType=3;
        }
        //参数！！！！！！！！！！！！！！！！！！
        
        //默认预订时间为起始的12点，到结束的12点
        OrderVO order=new OrderVO(0, MainUI.userID, hotelBrowseService.searchHotel(hotelName.getText()).getHotelID(), 0, 0, startTime.substring(0, 4)+startTime.substring(5, 7)+startTime.substring(8, 10)+"12", endTime.substring(0, 4)+endTime.substring(5, 7)+endTime.substring(8, 10)+"12", null, rType, num, pNum, hasChild);
       
//    
        boolean result=orderByUserService.createOrder(order);
        
        if(result){
        	System.out.println(true);
        }else{
        	//小弹窗
        	System.out.println(false);
        	
        }
        
        
    }

}
