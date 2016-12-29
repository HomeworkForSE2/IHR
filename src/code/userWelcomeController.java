package code;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import service.CreditService;
import service.HotelBrowseService;
import service.HotelInfoService;
import service.MemberService;
import service.OrderByUserService;
import service.UserInfoService;
import serviceImpl.CreditServiceImpl;
import serviceImpl.HotelBrowseServiceImpl;
import serviceImpl.HotelInfoServiceImpl;
import serviceImpl.MemberServiceImpl;
import serviceImpl.OrderByUserServiceImpl;
import serviceImpl.UserInfoServiceImpl;
import vo.CreditChangeVO;
import vo.HotelInfoVO;
import vo.MemberVO;
import vo.OrderVO;
import vo.RoomConditionVO;
import vo.SortHotelListByScore;
import vo.SortHotelListByStarNum;
import vo.UserInfoVO;

import java.io.IOException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class userWelcomeController {
    @FXML private GridPane root;
    @FXML private VBox small;
    @FXML private HBox searchBar;
    @FXML private HBox advanceTag;
    @FXML private TextField searchArea;
    @FXML private GridPane container;
    @FXML private HBox swap;
    @FXML private HBox searchIcon;
    @FXML private ChoiceBox<String> sortBar;
    @FXML private HBox searchResult;
    @FXML private ChoiceBox<String> rankBar;
    private VBox slideBar;
    private GridPane advancedSearchBar;
    private List<OrderVO> list;
    private static boolean isTrue=true;
    
    private HotelBrowseService hotelBrowseService;
    private UserInfoService userInfoService;
    private MemberService memberService;
    private CreditService creditService;
    private OrderByUserService orderByUserService;
    private HotelInfoService hotelInfoService;
    
     @FXML private void toggleAdvancedSearch(){

        advancedSearchBar = new GridPane();
        advancedSearchBar.setAlignment(Pos.TOP_CENTER);

        Label address = new Label("地址*：");
        Label circle = new Label("商圈*：");
        Label grade = new Label("星级：");
        Label marks = new Label("评分：");
        Label roomNum = new Label("房间数量：");
        Label roomType = new Label("房间类型：");
        Label price = new Label("最高价格：");

        TextField addressField = new TextField();
        TextField circleField = new TextField();
        TextField gradeField = new TextField();
        TextField marksField = new TextField();
        TextField roomNumField = new TextField();
        TextField roomTypeField = new TextField();
        TextField roomHighPriceField = new TextField();

        Text unit = new Text("￥");

        Button search = new Button("搜索");
        Button cancel = new Button("取消");

        advancedSearchBar.add(address,0,0);
        advancedSearchBar.add(addressField,1,0,3,1);
        advancedSearchBar.add(circle,4,0);
        advancedSearchBar.add(circleField,5,0,3,1);

        advancedSearchBar.add(grade,0,1);
        advancedSearchBar.add(gradeField,1,1,3,1);
        advancedSearchBar.add(marks,4,1);
        advancedSearchBar.add(marksField,5,1,3,1);

        advancedSearchBar.add(roomType,0,2);
        advancedSearchBar.add(roomTypeField,1,2,3,1);
        advancedSearchBar.add(roomNum,4,2);
        advancedSearchBar.add(roomNumField,5,2,3,1);
        advancedSearchBar.add(price,0,3);
        advancedSearchBar.add(roomHighPriceField,1,3,3,1);
        advancedSearchBar.add(unit,4,3);

        advancedSearchBar.add(search,0,4);
        advancedSearchBar.add(cancel,1,4);

        container.getChildren().removeAll(searchBar,advanceTag);
        container.add(advancedSearchBar,0,1);

        hotelBrowseService=new HotelBrowseServiceImpl();
        
        search.setOnAction(event -> {
            String ad = addressField.getText();
            String ci = circleField.getText();
            String rN = roomNumField.getText();
            String rT = roomTypeField.getText();           
            String hP = roomHighPriceField.getText();
            String gd = gradeField.getText();
            String mk = marksField.getText();
            //房间类型、最高价格、数量
            //2种排序方式，星级、评分
            
            //这里指这三个一定要全填，看作一个整体和星级、评分相独立
            RoomConditionVO roomCondition=null;
            if(rT.equals("")||hP.equals("")||rN.equals("")){
            	///////////////////////////
            	if(rT.equals("")&&hP.equals("")&&rN.equals("")){
            		
            	}else{
//            		小弹窗 
            	}
            }else{
            	roomCondition=new RoomConditionVO(Integer.parseInt(rT),Integer.parseInt(hP),Integer.parseInt(rN));
            	
            }
           
            int starNum;
            if(!gd.equals("")){
            	starNum=Integer.parseInt(gd);
            }else{
            	starNum=0;
            }
            
            int judgeScore;
            if(!mk.equals("")){
            	judgeScore=Integer.parseInt(mk);
            }else{
            	judgeScore=0;
            }
            try {
				List<HotelInfoVO> hotelList=hotelBrowseService.viewHotelList(ad, ci, roomCondition, starNum, judgeScore);
				search(hotelList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            //传参，高级搜索数据，你需要返回的一个List，作为search（）的参数，这里我现在空着，你来补一下
            //！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        });

        cancel.setOnAction(event -> {
            container.getChildren().remove(advancedSearchBar);
            container.add(searchBar,0,1);
            container.add(advanceTag,0,2);
        });
    }

    @FXML private void normalSearch() throws IOException{
        String result = searchArea.getText();
        //！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        // 传参：搜索数据;
        //要求跟上一个一样
        hotelBrowseService=new HotelBrowseServiceImpl();
        HotelInfoVO hotel=hotelBrowseService.searchHotel(result);
        List<HotelInfoVO> hotelList=new ArrayList<>();
        if(hotel==null){

        }else{
        	hotelList.add(hotel);
        }
        System.out.println(hotelList.size());
        search(hotelList);
    }
    
    ObservableList<String> rankList = FXCollections.observableArrayList("排序查看","评分升序","评分降序","星级升序","星级降序");    
    private void search(List<HotelInfoVO> list) throws IOException{
        searchIcon.setVisible(false);
        sortBar.setVisible(false);
        rankBar.setVisible(true);
        searchResult.getChildren().remove(0);
        
        orderByUserService=new OrderByUserServiceImpl();    
		orderByUserService.initUser(MainUI.userID);	

        rankBar.setItems(rankList);
        rankBar.setValue("排序查看");
        

        VBox board = new VBox();
        board.setPadding(new Insets(20,30,20,20));
        board.setAlignment(Pos.TOP_CENTER);
        board.setSpacing(20);
        board.setStyle("-fx-background-color: rgba(0,0,0,0)");

        //酒店信息,长度
        int lengthOfList = list.size();
        if(lengthOfList==0){
            Text none = new Text("对不起，没有符合条件的酒店，请重试！");
            searchResult.getChildren().add(none);
            return;
        }

        for(int i=0;i<lengthOfList;i++){
            //List 应该有这些参数？？？？
            //传参，加上四种状态是否预订，是否入住过，是否撤销过，是否异常过
        	
        	HotelInfoVO hotel=list.get(i);
            String name = hotel.getHotelName();
            String address = hotel.getLocation();
            String circle = hotel.getBD();
            
            int hotelID=hotel.getHotelID();

            int starsNum = hotel.getStarNum();
            int marks = hotel.getScore();
            boolean isLived = orderByUserService.hasUserFinishedOrderInThisHotel(hotelID);
            boolean isCanceled = orderByUserService.hasUserCanceledOrderInThisHotel(hotelID);
            boolean isUnmoral = orderByUserService.hasUserUnusualOrderInThisHotel(hotelID);
            boolean isOrdering = true;
            
            GridPane singleRecord = new GridPane();
            singleRecord.setAlignment(Pos.CENTER);

            VBox nameBox = new VBox();
            nameBox.setPrefSize(300,100);
            nameBox.setAlignment(Pos.CENTER);
            nameBox.setSpacing(5);
            Text nameText = new Text(name);
            Text starsText = new Text();
            String stars = "";
            for(int j=0;j<starsNum;j++){
                stars = stars+" * ";
            }
            starsText.setText(stars);
            starsText.setFill(Color.YELLOW);
            Text marksText = new Text(Integer.toString(marks)+" 分");
            HBox stateBox = new HBox();
            stateBox.setAlignment(Pos.CENTER);
            stateBox.setSpacing(5);
            if(isOrdering){
            	Text text = new Text("当前预订中");
                text.setFont(Font.font(10));
                text.setFill(Color.WHITE);
                HBox bg = new HBox();
                bg.setPrefSize(40,14);
                bg.setAlignment(Pos.CENTER);
                bg.setStyle("-fx-background-color: rgb(0,176,80);-fx-background-radius: 10px;-fx-border-radius: 10px;");
                bg.getChildren().add(text);
                stateBox.getChildren().add(bg);
            }
            if(isLived){
                Text text = new Text("入住过");
                text.setFont(Font.font(11));
                text.setFill(Color.WHITE);
                HBox bg = new HBox();
                bg.setPrefSize(40,14);
                bg.setAlignment(Pos.CENTER);
                bg.setStyle("-fx-background-color: rgb(46,117,182);-fx-background-radius: 10px;-fx-border-radius: 10px;");
                bg.getChildren().add(text);
                stateBox.getChildren().add(bg);
            }
            if(isCanceled){
                Text text = new Text("撤销过");
                text.setFont(Font.font(11));
                text.setFill(Color.WHITE);
                HBox bg = new HBox();
                bg.setPrefSize(40,14);
                bg.setAlignment(Pos.CENTER);
                bg.setStyle("-fx-background-color: rgb(255,192,0);-fx-background-radius: 10px;-fx-border-radius: 10px;");
                bg.getChildren().add(text);
                stateBox.getChildren().add(bg);
            }
            if(isUnmoral){
                Text text = new Text("异常过");
                text.setFont(Font.font(11));
                text.setFill(Color.WHITE);
                HBox bg = new HBox();
                bg.setPrefSize(40,14);
                bg.setAlignment(Pos.CENTER);
                bg.setStyle("-fx-background-color: rgb(180,0,0);-fx-background-radius: 10px;-fx-border-radius: 10px;");
                bg.getChildren().add(text);
                stateBox.getChildren().add(bg);
            }
           
            nameBox.getChildren().addAll(nameText,starsText,marksText,stateBox);
            singleRecord.add(nameBox,0,0,1,2);

            VBox addressBox = new VBox();
            addressBox.setPrefSize(300,100);
            addressBox.setAlignment(Pos.CENTER);
            Text addressText = new Text(address);
            Text circleText = new Text(circle);
            addressBox.setSpacing(5);
            addressBox.setStyle("-fx-background-color: rgba(255,255,255,0.1)");
            addressBox.getChildren().addAll(addressText,circleText);
            singleRecord.add(addressBox,1,0,1,2);

            HBox order = new HBox();
            order.setPrefSize(200,50);
            order.setAlignment(Pos.CENTER);
            order.setStyle("-fx-background-color: rgba(255,255,255,0);-fx-background-radius: 20px;-fx-border-radius: 20px;");
            Text orderText = new Text("预订");
            order.getChildren().add(orderText);
            singleRecord.add(order,3,0);

            HBox look = new HBox();
            look.setPrefSize(200,50);
            look.setAlignment(Pos.CENTER);
            look.setStyle("-fx-background-color: rgba(255,255,255,0);-fx-background-radius: 20px;-fx-border-radius: 20px;");
            Text lookText = new Text("查看");
            look.getChildren().add(lookText);
            singleRecord.add(look,3,1);

            singleRecord.setPadding(new Insets(0,0,0,0));
            singleRecord.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
            DropShadow ds = new DropShadow();
            ds.setColor(Color.color(0,0,0,0.5));
            ds.setOffsetX(2);
            ds.setOffsetY(2);
            singleRecord.setEffect(ds);
            singleRecord.setPrefSize(800,100);

            board.getChildren().add(singleRecord);
        }
        ScrollPane sp = new ScrollPane();
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setContent(board);
        sp.setStyle("-fx-background-color: rgba(0,0,0,0);-fx-border-style: none;");
        sp.setMaxHeight(400);

        searchResult.getChildren().add(sp);
        
        rankBar.setOnAction(event -> {
            String rank = rankBar.getSelectionModel().getSelectedItem();
            if(!(rank.equals("排序"))){
                //返回分类查看的值，修改你传过来的list
                //我先写的，共有四种排序方法："评分升序","评分降序","星级升序","星级降序"
                //值在rank里面
            	if(rank.equals("评分升序")){
            		SortHotelListByScore s=new SortHotelListByScore();
            		Collections.sort(list, s); 
            	}else if(rank.equals("评分降序")){
            		SortHotelListByScore s=new SortHotelListByScore();
            		Collections.sort(list, s); 
            		Collections.reverse(list);
            	}else if(rank.equals("星级升序")){
            		SortHotelListByStarNum s=new SortHotelListByStarNum();
            		Collections.sort(list, s); 
            	}else if(rank.equals("星级降序")){
            		SortHotelListByStarNum s=new SortHotelListByStarNum();
            		Collections.sort(list, s); 
            		Collections.reverse(list);
            	}
            }
            try {
				search(list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            rankBar.setValue(rank);
        });
    }

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
        Text userInfo = new Text("个人信息");
        Text creditRecord = new Text("信用记录");
        Text hotelRecord = new Text("酒店记录");
        Text orderInfo = new Text("订单详情");

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

        userInfo.setOnMouseClicked(event -> {
            try {
				toUserInfo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
		
		creditRecord.setOnMouseClicked(event -> {
	        try {
	           	toCreditRecord();
	        } catch (Exception e) {
				// TODO Auto-generated catch block
	        	   e.printStackTrace();
			}
	     });
			
		//toHotelRecord()
        hotelRecord.setOnMouseClicked(event ->  {
	        try {
	        	toHotelRecord();
	        } catch (Exception e) {
				// TODO Auto-generated catch block
	        	   e.printStackTrace();
			}
	     });
        orderInfo.setOnMouseClicked(event ->  {
	        try {
	        	toOrderInfo();
	        } catch (Exception e) {
				// TODO Auto-generated catch block
	        	   e.printStackTrace();
			}
	     });
    }

    private void toUserInfo() throws IOException{
        swap.getChildren().remove(0);
        sortBar.setVisible(false);
        rankBar.setVisible(false);
        searchIcon.setVisible(true);

        GridPane table = new GridPane();
        table.setAlignment(Pos.CENTER);

        table.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
        table.setMaxHeight(400);
        table.setPrefWidth(720);

        userInfoService=new UserInfoServiceImpl(); 
        memberService=new MemberServiceImpl();
        UserInfoVO user=userInfoService.showUserInfo(MainUI.userID);
        MemberVO member=memberService.getMember(MainUI.userID);
        //数据传输
        //！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        //有改动：取消判断是生日还是企业名称的判断，都算作typeInfo，这样就省去了判断的麻烦，反正你存数据的时候也没判断会员类型啊！但是如果是生日的话，格式还是要按照
        //YYYY-MM-DD
        //注意，下面还有修改后得到的值
        String name = user.getUserName();
        String phone = user.getPhoneNumber();
        String credit = String.valueOf(user.getCredit())+"cp";
        
        String birthday = member.getBirthday() ;
        String enterprise = member.getEnterpriseName();
        
        

        String typeInfo;
        String type;
        if(birthday == null){
            type = "企业用户";
            typeInfo = enterprise;
        }else{
            type = "普通用户";
            typeInfo = birthday;
        }

        VBox zeroZero = new VBox();
        Label nameLabel = new Label("姓名：");
        zeroZero.setPrefSize(120,100);
        zeroZero.setAlignment(Pos.CENTER);
        zeroZero.getChildren().add(nameLabel);
        table.add(zeroZero,0,0,1,1);

        VBox zeroOne = new VBox();
        Text nameField = new Text();
        nameField.setText(name);
        zeroOne.getChildren().add(nameField);
        zeroOne.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        zeroOne.setPrefSize(240,100);
        zeroOne.setAlignment(Pos.CENTER);
        table.add(zeroOne,1,0,2,1);

        VBox zeroThree = new VBox();
        Label typeLabel = new Label("账户类型：");
        zeroThree.getChildren().add(typeLabel);
        zeroThree.setPrefSize(120,100);
        zeroThree.setAlignment(Pos.CENTER);
        zeroThree.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(zeroThree,3,0,1,1);

        VBox zeroFour = new VBox();
        Text typeField = new Text();
        typeField.setText(type);
        zeroFour.getChildren().add(typeField);
        zeroFour.setPrefSize(240,100);
        zeroFour.setAlignment(Pos.CENTER);
        table.add(zeroFour,4,0,2,1);

        VBox oneZero = new VBox();
        Label typeInfoLabel = new Label();
        if(type.equals("企业用户")){
            typeInfoLabel.setText("我的企业：");
        }else{
            typeInfoLabel.setText("我的生日：");
        }
        oneZero.getChildren().add(typeInfoLabel);
        oneZero.setPrefSize(120,100);
        oneZero.setAlignment(Pos.CENTER);
        oneZero.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(oneZero,0,1,1,1);

        VBox oneOne = new VBox();
        Text typeInfoField = new Text();
        typeInfoField.setText(typeInfo);
        oneOne.getChildren().add(typeInfoField);
        oneOne.setPrefSize(600,100);
        oneOne.setAlignment(Pos.CENTER);
        oneOne.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(oneOne,1,1,5,1);

        VBox twoZero = new VBox();
        Label creditLabel = new Label("信用值：");
        twoZero.getChildren().add(creditLabel);
        twoZero.setPrefSize(120,100);
        twoZero.setAlignment(Pos.CENTER);
        twoZero.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(twoZero,0,2,1,1);

        VBox twoOne = new VBox();
        Text creditField = new Text();
        creditField.setText(credit);
        twoOne.getChildren().add(creditField);
        twoOne.setPrefSize(240,100);
        twoOne.setAlignment(Pos.CENTER);
        twoOne.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(twoOne,1,2,2,1);

        VBox twoThree = new VBox();
        Label phoneLabel = new Label("联系方式：");
        twoThree.getChildren().addAll(phoneLabel);
        twoThree.setPrefSize(120,100);
        twoThree.setAlignment(Pos.CENTER);
        table.add(twoThree,3,2,1,1);

        VBox twoFour = new VBox();
        Text phoneField = new Text();
        phoneField.setText(phone);
        twoFour.getChildren().add(phoneField);
        twoFour.setPrefSize(240,100);
        twoFour.setAlignment(Pos.CENTER);
        twoFour.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(twoFour,4,2,2,1);

        VBox threeZero = new VBox();
        Text creditRecord = new Text("确认");
        threeZero.getChildren().add(creditRecord);
        threeZero.setPrefSize(240,100);
        threeZero.setAlignment(Pos.CENTER);
        table.add(threeZero,0,3,2,1);

        VBox threeTwo = new VBox();
        Text hotelRecord  = new Text("修改");
        threeTwo.getChildren().add(hotelRecord);
        threeTwo.setPrefSize(240,100);
        threeTwo.setAlignment(Pos.CENTER);
        threeTwo.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(threeTwo,2,3,2,1);
        threeTwo.setOnMouseClicked(event -> {
            oneOne.getChildren().remove(0);
            twoFour.getChildren().remove(0);

            TextField enterpriseNameField = new TextField();
            DatePicker birthdayField = new DatePicker();

            if(type.equals("企业用户")){
                enterpriseNameField.setText(typeInfo);
                oneOne.getChildren().add(enterpriseNameField);
            }else {
                birthdayField.setValue(LocalDate.parse(typeInfo));
                oneOne.getChildren().add(birthdayField);
            }

            TextField newPhoneField = new TextField();

            newPhoneField.setText(phone);
            twoFour.getChildren().add(newPhoneField);

            threeZero.setOnMouseClicked(event1 -> {
                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                //修改后更新的值，用来更新一下你的txt数据
                String newBirthday = null;
                String newEnterprise = null;
                String newPhone;

                if(type.equals("企业用户")){
                    newEnterprise = enterpriseNameField.getText();
                }else{
                    newBirthday = birthdayField.getValue().toString();
                    newBirthday=newBirthday.substring(0, 4)+newBirthday.substring(5, 7)+newBirthday.substring(8);
                }
                newPhone = newPhoneField.getText();
                //在此更新数据
                
                UserInfoVO newUser=new UserInfoVO(user.getUserID(),user.getUserName(),user.getPassword(),newPhone,user.getCredit());
                
                boolean result1;
                boolean result2;
				try {
					result1=userInfoService.modifyUserInfo(newUser);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int userID=user.getUserID();
				try {
					result2=memberService.memberUpdate(userID, newBirthday, newEnterprise);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
                //更新数据之后
                try {
					toUserInfo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            });
        });

        VBox threeFour = new VBox();
        Text orderInfo = new Text("取消");
        threeFour.getChildren().add(orderInfo);
        threeFour.setPrefSize(240,100);
        threeFour.setAlignment(Pos.CENTER);
        table.add(threeFour,4,3,2,1);
        
			threeFour.setOnMouseClicked(event -> {
	            try {
					toUserInfo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        });

        DropShadow ds = new DropShadow();
        ds.setColor(Color.color(0,0,0,0.5));
        ds.setOffsetX(4);
        ds.setOffsetY(4);
        table.setEffect(ds);

        swap.getChildren().add(table);
    }
    
    private void toCreditRecord(){
        swap.getChildren().remove(0);
        sortBar.setVisible(false);
        rankBar.setVisible(false);
        searchIcon.setVisible(true);

        VBox board = new VBox();
        board.setPadding(new Insets(20,30,20,20));
        board.setAlignment(Pos.TOP_CENTER);
        board.setSpacing(20);
        board.setStyle("-fx-background-color: rgba(0,0,0,0)");
        
        creditService=new CreditServiceImpl();
        List<CreditChangeVO> list = null;
		try {
			list = creditService.showCreditRecord(MainUI.userID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int lengthOfList = list.size();

        if(lengthOfList==0){
            Text none = new Text("对不起，您还没有过信用交易呢!");
            swap.getChildren().add(none);
            return;
        }

        for(int i=0;i<lengthOfList;i++){
            //传参
        	CreditChangeVO credit=list.get(i);
            String data = credit.getTime();
            String opr = credit.getAction();
            String orderID = String.valueOf(credit.getOrderID());
            int oriCredit = credit.getStartCredit();
            int nowCredit = credit.getEndCredit();

            String benefit = Integer.toString(nowCredit-oriCredit)+"CP";

            GridPane singleRecord = new GridPane();
            singleRecord.setAlignment(Pos.CENTER);

            HBox idBox = new HBox();
            idBox.setPrefSize(200,100);
            idBox.setAlignment(Pos.CENTER);
            Text idText = new Text(orderID);
            idBox.getChildren().add(idText);
            singleRecord.add(idBox,0,0);

            HBox recordBox = new HBox();
            recordBox.setPrefSize(200,100);
            recordBox.setAlignment(Pos.CENTER);
            Text recordText = new Text();
            if(benefit.substring(0,1).equals("-")){
                recordText.setText(benefit);
                recordText.setFill(Color.RED);
            }else{
                recordText.setText("+"+benefit);
                recordText.setFill(Color.color(0,0.8,0.25));
            }
            Text oriText = new Text(Integer.toString(oriCredit)+"CP");
            Text nowText = new Text("->"+Integer.toString(nowCredit)+"CP");
            recordBox.getChildren().addAll(oriText,recordText,nowText);
            recordBox.setSpacing(5);
            recordBox.setStyle("-fx-background-color: rgba(0,0,0,0.1)");
            singleRecord.add(recordBox,1,0);

            HBox dataBox = new HBox();
            dataBox.setPrefSize(200,100);
            dataBox.setAlignment(Pos.CENTER);
            Text dataText = new Text(data);
            dataBox.getChildren().add(dataText);
            singleRecord.add(dataBox,2,0);

            HBox oprBox = new HBox();
            oprBox.setPrefSize(100,100);
            oprBox.setAlignment(Pos.CENTER);
            Text oprText = new Text(opr);
            oprBox.getChildren().add(oprText);
            oprBox.setStyle("-fx-background-color: rgba(255,255,255,0.1)");
            singleRecord.add(oprBox,3,0);

            singleRecord.setPadding(new Insets(0,0,0,0));
            singleRecord.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
            DropShadow ds = new DropShadow();
            ds.setColor(Color.color(0,0,0,0.5));
            ds.setOffsetX(2);
            ds.setOffsetY(2);
            singleRecord.setEffect(ds);
            singleRecord.setPrefSize(700,100);

            board.getChildren().add(singleRecord);
        }

        ScrollPane sp = new ScrollPane();
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setContent(board);
        sp.setStyle("-fx-background-color: rgba(0,0,0,0);-fx-border-style: none;");
        sp.setMaxHeight(600);

        swap.getChildren().add(sp);
    }
    
    private void toHotelRecord() throws IOException{
        swap.getChildren().remove(0);
        sortBar.setVisible(false);
        rankBar.setVisible(false);
        searchIcon.setVisible(true);

        VBox board = new VBox();
        board.setPadding(new Insets(20,30,20,20));
        board.setAlignment(Pos.TOP_CENTER);
        board.setSpacing(20);
        board.setStyle("-fx-background-color: rgba(0,0,0,0)");

        //酒店信息,长度
        hotelBrowseService=new HotelBrowseServiceImpl();
        orderByUserService=new OrderByUserServiceImpl();    
		orderByUserService.initUser(MainUI.userID);	
        List<HotelInfoVO> list=hotelBrowseService.showReservedHotel(MainUI.userID);
        int lengthOfList = list.size();

        if(lengthOfList==0){
            Text none = new Text("对不起，您还没有预定过酒店呢!");
            swap.getChildren().add(none);
            return;
        }

        for(int i=0;i<lengthOfList;i++){
            //传参，加上三种状态
        	HotelInfoVO hotel=list.get(i);
            String name = hotel.getHotelName();
            String address = hotel.getLocation();
            String circle = hotel.getBD();
            
            //////////////是否完成过2、撤销过4、异常过3
            boolean isLived = orderByUserService.hasUserFinishedOrderInThisHotel(hotel.getHotelID());
            boolean isCanceled = orderByUserService.hasUserCanceledOrderInThisHotel(hotel.getHotelID());
            boolean isUnmoral = orderByUserService.hasUserUnusualOrderInThisHotel(hotel.getHotelID());
            boolean isOrdering = orderByUserService.isUserOrderingInThisHotel(hotel.getHotelID());

            GridPane singleRecord = new GridPane();
            singleRecord.setAlignment(Pos.CENTER);

            VBox nameBox = new VBox();
            nameBox.setPrefSize(300,100);
            nameBox.setAlignment(Pos.CENTER);
            nameBox.setSpacing(5);
            Text nameText = new Text(name);
            HBox stateBox = new HBox();
            stateBox.setAlignment(Pos.CENTER);
            stateBox.setSpacing(5);
            if(isOrdering){
            	Text text = new Text("当前预订中");
                text.setFont(Font.font(10));
                text.setFill(Color.WHITE);
                HBox bg = new HBox();
                bg.setPrefSize(40,14);
                bg.setAlignment(Pos.CENTER);
                bg.setStyle("-fx-background-color: rgb(0，176，80);-fx-background-radius: 10px;-fx-border-radius: 10px;");
                bg.getChildren().add(text);
                stateBox.getChildren().add(bg);
            }
            if(isLived){
                Text text = new Text("入住过");
                text.setFont(Font.font(10));
                text.setFill(Color.WHITE);
                HBox bg = new HBox();
                bg.setPrefSize(40,14);
                bg.setAlignment(Pos.CENTER);
                bg.setStyle("-fx-background-color: rgb(46,117,182);-fx-background-radius: 10px;-fx-border-radius: 10px;");
                bg.getChildren().add(text);
                stateBox.getChildren().add(bg);
            }
            if(isCanceled){
                Text text = new Text("撤销过");
                text.setFont(Font.font(10));
                text.setFill(Color.WHITE);
                HBox bg = new HBox();
                bg.setPrefSize(40,14);
                bg.setAlignment(Pos.CENTER);
                bg.setStyle("-fx-background-color: rgb(255,192,0);-fx-background-radius: 10px;-fx-border-radius: 10px;");
                bg.getChildren().add(text);
                stateBox.getChildren().add(bg);
            }
            if(isUnmoral){
                Text text = new Text("异常过");
                text.setFont(Font.font(10));
                text.setFill(Color.WHITE);
                HBox bg = new HBox();
                bg.setPrefSize(40,14);
                bg.setAlignment(Pos.CENTER);
                bg.setStyle("-fx-background-color: rgb(180,0,0);-fx-background-radius: 10px;-fx-border-radius: 10px;");
                bg.getChildren().add(text);
                stateBox.getChildren().add(bg);
            }
            nameBox.getChildren().add(nameText);
            nameBox.getChildren().add(stateBox);
            singleRecord.add(nameBox,0,0,1,2);

            VBox addressBox = new VBox();
            addressBox.setPrefSize(200,100);
            addressBox.setAlignment(Pos.CENTER);
            Text addressText = new Text(address);
            Text circleText = new Text(circle);
            addressBox.setStyle("-fx-background-color: rgba(0,0,0,0.1)");
            addressBox.setSpacing(5);
            addressBox.getChildren().addAll(addressText,circleText);
            singleRecord.add(addressBox,1,0,1,2);

            HBox order = new HBox();
            order.setPrefSize(200,50);
            order.setAlignment(Pos.CENTER);
            order.setStyle("-fx-background-color: rgba(255,255,255,0);-fx-background-radius: 20px;-fx-border-radius: 20px;");
            Text orderText = new Text("预订");
            order.getChildren().add(orderText);
            singleRecord.add(order,2,0);

            HBox look = new HBox();
            look.setPrefSize(200,50);
            look.setAlignment(Pos.CENTER);
            look.setStyle("-fx-background-color: rgba(255,255,255,0);-fx-background-radius: 20px;-fx-border-radius: 20px;");
            Text lookText = new Text("查看");
            look.getChildren().add(lookText);
            singleRecord.add(look,2,1);

            singleRecord.setPadding(new Insets(0,0,0,0));
            singleRecord.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
            DropShadow ds = new DropShadow();
            ds.setColor(Color.color(0,0,0,0.5));
            ds.setOffsetX(2);
            ds.setOffsetY(2);
            singleRecord.setEffect(ds);
            singleRecord.setPrefSize(700,100);

            board.getChildren().add(singleRecord);
        }
        ScrollPane sp = new ScrollPane();
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setContent(board);
        sp.setStyle("-fx-background-color: rgba(0,0,0,0);-fx-border-style: none;");
        sp.setMaxHeight(600);

        swap.getChildren().add(sp);
    }
    ObservableList<String> sortList = FXCollections.observableArrayList("分类查看","正常","异常","已执行","撤销");
    private void toOrderInfo() throws IOException{
        swap.getChildren().remove(0);
        sortBar.setVisible(true);
        rankBar.setVisible(false);
        searchIcon.setVisible(true);

        
        sortBar.setItems(sortList);
        	sortBar.setValue("分类查看");
       
        /////////
        orderByUserService=new OrderByUserServiceImpl();    
		orderByUserService.initUser(MainUI.userID);	
		hotelInfoService=new HotelInfoServiceImpl();
		if(isTrue){
			list=orderByUserService.getAllUserOrder();
		}
		
        

        VBox board = new VBox();
        board.setPadding(new Insets(20,30,20,20));
        board.setAlignment(Pos.TOP_CENTER);
        board.setSpacing(20);
        board.setStyle("-fx-background-color: rgba(0,0,0,0)");

        //订单长度
        int lengthOfList = list.size();

        if(lengthOfList==0){
            Text none = new Text("对不起，您还没有预定过就酒店呢!");
            swap.getChildren().add(none);
            return;
        }

        for(int i=0;i<lengthOfList;i++){
            //传参
        	OrderVO order=list.get(i);
            String orderState = order.getState();//我觉得只有四种状态：正常、异常、已执行、已撤销
            String orderID = String.valueOf(order.getOrderId());
            String hotelName = hotelInfoService.findHotel(order.getHotelId()).getHotelName();
            String value = order.getPrice()+"$";
            String startDate = order.getStartTime();//三个都要按照格式YYYY-MM-DD
            String actDate = order.getFinishTime();
            String endDate = order.getEndTime();
            String roomType = order.getRoomType();
            
            int roomNum = order.getRoomNum();
            int peopleNum = order.getPeopleNum();
            boolean hasChildren = order.isHasChildren();


            GridPane singleRecord = new GridPane();
            singleRecord.setAlignment(Pos.CENTER);

            HBox orderIDBox = new HBox();
            Text orderIDText = new Text(orderID);
            orderIDBox.setAlignment(Pos.CENTER);
            orderIDBox.setPrefSize(400,100);
            orderIDBox.getChildren().add(orderIDText);
            singleRecord.add(orderIDBox,0,0,4,1);

            HBox orderStateBox = new HBox();
            Text orderStateText = new Text(orderState);
            switch (orderState) {
                case "正常":
                    orderStateText.setFill(Color.color(0, 0.8, 0.25));
                    break;
                case "异常":
                    orderStateText.setFill(Color.RED);
                    break;
                case "已撤销":
                    orderStateText.setFill(Color.color(0.5, 0.5, 0.5));
                    break;
                default:
                    orderStateText.setFill(Color.color(0.18, 0.46, 0.71));
                    break;
            }
            orderStateBox.setAlignment(Pos.CENTER);
            orderStateBox.setPrefSize(200,100);
            orderStateBox.getChildren().add(orderStateText);
            singleRecord.add(orderStateBox,4,0,2,1);

            HBox hotelNameBox = new HBox();
            Text hotelNameText = new Text(hotelName);
            hotelNameBox.setAlignment(Pos.CENTER);
            hotelNameBox.setPrefSize(600,100);
            hotelNameBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
            hotelNameBox.getChildren().addAll(hotelNameText);
            singleRecord.add(hotelNameBox,0,1,6,1);

            HBox roomTypeBox = new HBox();
            Text roomTypeText = new Text(roomType+" × "+Integer.toBinaryString(roomNum));
            roomTypeBox.setAlignment(Pos.CENTER);
            roomTypeBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
            roomTypeBox.setPrefSize(200,100);
            roomTypeBox.getChildren().add(roomTypeText);
            singleRecord.add(roomTypeBox,0,2,2,1);

            HBox valueBox = new HBox();
            Text valueText = new Text(value);
            valueBox.setAlignment(Pos.CENTER);
            valueBox.setPrefSize(100,100);
            valueBox.getChildren().add(valueText);
            singleRecord.add(valueBox,2,2);

            HBox peopleBox = new HBox();
            Text peopleText = new Text();
            if(!hasChildren){
                peopleText.setText(Integer.toString(peopleNum)+"人，无儿童");
            }else{
                peopleText.setText(Integer.toString(peopleNum)+"人，有儿童");
            }
            peopleBox.setAlignment(Pos.CENTER);
            peopleBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
            peopleBox.setPrefSize(300,100);
            peopleBox.getChildren().add(peopleText);
            singleRecord.add(peopleBox,3,2,3,1);

            HBox startDateBox = new HBox();
            Text startDateText = new Text(startDate+"预约");
            startDateBox.setAlignment(Pos.CENTER);
            startDateBox.setPrefSize(200,100);
            startDateBox.getChildren().add(startDateText);
            singleRecord.add(startDateBox,0,3,2,1);

            HBox actDateBox = new HBox();
            Text actDateText = new Text(actDate+"入住");
            actDateBox.setAlignment(Pos.CENTER);
            actDateBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
            actDateBox.setPrefSize(200,100);
            actDateBox.getChildren().add(actDateText);
            singleRecord.add(actDateBox,2,3,2,1);

            HBox endDateBox = new HBox();
            Text endDateText = new Text(endDate+"离开");
            endDateBox.setAlignment(Pos.CENTER);
            endDateBox.setPrefSize(200,100);
            endDateBox.getChildren().add(endDateText);
            singleRecord.add(endDateBox,4,3,2,1);

            singleRecord.setPadding(new Insets(0,0,0,0));
            singleRecord.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
            DropShadow ds = new DropShadow();
            ds.setColor(Color.color(0,0,0,0.5));
            ds.setOffsetX(4);
            ds.setOffsetY(4);
            singleRecord.setEffect(ds);
            singleRecord.setPrefSize(600,400);

            if(orderState.equals("正常")){
                startDateBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                endDateBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                HBox cancel = new HBox();
                Text cancelText = new Text("撤销订单");
                cancel.setAlignment(Pos.CENTER);
                cancel.setPrefSize(200,50);
                cancel.getChildren().add(cancelText);
                singleRecord.add(cancel,2,4,2,1);
                singleRecord.setPrefSize(600,450);

                cancel.setOnMouseClicked(event -> {
                    //撤销订单操作
                    //修改你的数据的订单状态
                    //返回值，我觉得是你传过来的List里面的第i个
                    //i值可返回
                	//!!!!!!!!!!!!!!!!!!!!!!!
                	try {
						orderByUserService.cancelOrder(Integer.parseInt(orderID));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    try {
						toOrderInfo();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                });
            }

            board.getChildren().add(singleRecord);
        }
        ScrollPane sp = new ScrollPane();
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setContent(board);
        sp.setStyle("-fx-background-color: rgba(0,0,0,0);-fx-border-style: none;");
        sp.setMaxHeight(600);

        swap.getChildren().add(sp);
        
        sortBar.setOnAction(event -> {
            String sort = sortBar.getSelectionModel().getSelectedItem();
//        	if(sort==null){return;}
            if(!(sort.equals("分类查看"))){
                //返回分类查看的值，修改你传过来的list
                //我先写的，共有四种类型：正常，异常，已执行，已撤销
                //值在sort里面    
            	
            	isTrue=false;
            	if(sort.equals("正常")){
            		try {
						list=orderByUserService.getUserNotExecuteOrder();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

            	}else if(sort.equals("异常")){
            		try {
						list=orderByUserService.getUserUnusualOrder();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            	}else if(sort.equals("已执行")){
            		try {
						list=orderByUserService.getUserExecuteOrder();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            	}else if(sort.equals("撤销")){
            		try {
						list=orderByUserService.getUserCancelOrder();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            	}
            }else{
            	isTrue=true;
            }
            try {
				toOrderInfo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            sortBar.setValue(sort);
        });
    }

    @FXML private void toSearch(){
        swap.getChildren().remove(0);
        sortBar.setVisible(false);
        searchIcon.setVisible(true);
        swap.getChildren().add(container);
    }

    

}
