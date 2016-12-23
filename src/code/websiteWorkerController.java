package code;


import javafx.animation.FadeTransition;
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
import javafx.scene.text.Text;
import javafx.util.Duration;
import service.CreditService;
import service.HotelInfoService;
import service.OrderByWebService;
import service.StrategyService;
import service.UserInfoService;
import service.UserManageService;
import serviceImpl.CreditServiceImpl;
import serviceImpl.HotelInfoServiceImpl;
import serviceImpl.OrderByWebServiceImpl;
import serviceImpl.StrategyServiceImpl;
import serviceImpl.UserInfoServiceImpl;
import serviceImpl.UserManageServiceImpl;
import vo.OrderVO;
import vo.StrategyVO;
import vo.VipVO;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

public class websiteWorkerController {
    @FXML
    private GridPane root;
    @FXML private VBox small;
    @FXML private HBox swap;
    @FXML private ChoiceBox<String> sortBar;
    private VBox slideBar;
    
    private List<OrderVO> list;
    private static boolean isTrue=true;
    private OrderByWebService orderByWebService;
    private HotelInfoService hotelInfoService;
    private UserInfoService userInfoService;
    private CreditService creditService;
    private StrategyService strategyService;
    private UserManageService userManageService;
    
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
        Text orderOpr = new Text("订单操作");
        Text creditOpr = new Text("信用操作");
        Text strategy = new Text("营销策略 ");
        Button logOut = new Button("退出登录");

       
		orderOpr.setOnMouseClicked(event -> {
			try {
				toOrderOpr();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		);

        creditOpr.setOnMouseClicked(event ->  {
        	try {
				toCreditOpr();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
        );
        strategy.setOnMouseClicked(event -> toStrategy());
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
        slideBar.getChildren().addAll(backBox,head,welcome,name,orderOpr,creditOpr,strategy,logOut);

        root.getChildren().remove(small);
        root.add(slideBar,0,0,1,2);
    }

    private ObservableList<String> sortList = FXCollections.observableArrayList("分类查看","正常","异常","已执行","撤销");
    private void toOrderOpr() throws IOException{
        swap.getChildren().remove(0);
        sortBar.setVisible(true);


        VBox board = new VBox();
        board.setPadding(new Insets(20,30,20,20));
        board.setAlignment(Pos.TOP_CENTER);
        board.setSpacing(20);
        board.setStyle("-fx-background-color: rgba(0,0,0,0)");
        
        orderByWebService=new OrderByWebServiceImpl();
        hotelInfoService=new HotelInfoServiceImpl();
        userInfoService=new UserInfoServiceImpl();
        if(isTrue){
        	list=orderByWebService.getAllWebOrder();
        }
        //订单长度
        int lengthOfList = list.size();

        if(lengthOfList==0){
            Text none = new Text("您的网站还没有订单呢，多多努力啊!");
            swap.getChildren().add(none);
            return;
        }

        for(int i=0;i<lengthOfList;i++){
            //传参
        	OrderVO order=list.get(i);
            String orderState = order.getState();//我觉得只有四种状态：正常、异常、已执行、已撤销
            String orderID = String.valueOf(order.getOrderId());
            String hotelName = hotelInfoService.findHotel(order.getHotelId()).getHotelName();
            String userName  = userInfoService.showUserInfo(order.getUserId()).getUserName();//用户名
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
                    orderStateText.setFill(Color.color(0, 0.8, 0.24));
                    break;
                case "异常":
                    orderStateText.setFill(Color.RED);
                    break;
                case "已撤销":
                    orderStateText.setFill(Color.color(0.5, 0.5, 0.5));
                    break;
                default:
                    orderStateText.setFill(Color.color(0.18, 0.46, 0.70));
                    break;
            }
            orderStateBox.setAlignment(Pos.CENTER);
            orderStateBox.setPrefSize(200,100);
            orderStateBox.getChildren().add(orderStateText);
            singleRecord.add(orderStateBox,4,0,2,1);
            
            HBox enterpriseNameBox = new HBox();
            Text enterpriseNameText = new Text(hotelName);
            enterpriseNameBox.setAlignment(Pos.CENTER);
            enterpriseNameBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
            enterpriseNameBox.setPrefSize(200,100);
            enterpriseNameBox.getChildren().add(enterpriseNameText);
            singleRecord.add(enterpriseNameBox,0,1,3,1);
            
            HBox userNameBox = new HBox();
            Text userNameText = new Text(userName);
            userNameBox.setAlignment(Pos.CENTER);
            userNameBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
            userNameBox.setPrefSize(200,100);
            userNameBox.getChildren().add(userNameText);
            singleRecord.add(userNameBox,3,1,3,1);
            
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
            valueBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
            valueBox.setPrefSize(100,100);
            valueBox.getChildren().add(valueText);
            singleRecord.add(valueBox,2,2);

            HBox peopleBox = new HBox();
            Text peopleText = new Text();
            if(hasChildren){
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

           if(orderState.equals("异常")){
                startDateBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                endDateBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");

                HBox cancel = new HBox();
                Text cancelText = new Text("撤销");
                cancel.setAlignment(Pos.CENTER);
                cancel.setPrefSize(100,50);
                cancel.getChildren().add(cancelText);
                singleRecord.add(cancel,3,4);
                singleRecord.setPrefSize(600, 450);

               HBox creditBox = new HBox();
               creditBox.setAlignment(Pos.CENTER);
               creditBox.setPrefSize(100,50);
               Text text1 = new Text("返回");
               ChoiceBox<String> cb = new ChoiceBox<>();
               cb.setItems(FXCollections.observableArrayList("额度","一半","全部"));
               cb.setValue("额度");
               cb.getStylesheets().add("/stylesheets/choiceBoxArrow.css");
               Text text2 = new Text("信用值");
               creditBox.getChildren().addAll(text1,cb,text2);
               singleRecord.add(creditBox,2,3);

                singleRecord.setPrefSize(600,350);

                cancel.setOnMouseClicked(event -> {
                	String s = cb.getSelectionModel().getSelectedItem();
                    //修改你的数据的订单状态
                    //返回值，我觉得是你传过来的List里面的第i个
                    //i值可返回
                	int dec=1;
                	if(s.equals("一半")){
                		
                	}else if(s.equals("全部")){
                		dec=0;
                	}
                	
                	try {
						orderByWebService.cancelUnusualOrder(order.getOrderId(), dec);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    try {
						toOrderOpr();
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
        sp.setMaxHeight(600);

        swap.getChildren().add(sp);

        sortBar.setItems(sortList);
        sortBar.setValue("分类查看");
        sortBar.setOnAction(event -> {
            String sort = sortBar.getSelectionModel().getSelectedItem();
            if(!(sort.equals("分类查看"))){
                //返回分类查看的值，修改你传过来的list
                //我先写的，共有四种类型：正常，异常，已执行，已撤销
                //值在sort里面
            	isTrue=false;
            	if(sort.equals("正常")){
            		try {
						list=orderByWebService.getWebNotExecuteOrder();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

            	}else if(sort.equals("异常")){
            		try {
						list=orderByWebService.getWebUnusualOrder();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            	}else if(sort.equals("已执行")){
            		try {
						list=orderByWebService.getWebExecuteOrder();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            	}else if(sort.equals("撤销")){
            		try {
						list=orderByWebService.getWebCancelOrder();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            	}
            }else{
            	isTrue=true;
            }
            
            try {
				toOrderOpr();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            sortBar.setValue(sort);
        });
    }

    private void toCreditOpr() throws IOException{
        swap.getChildren().remove(0);
        sortBar.setVisible(false);

        GridPane board = new GridPane();
        board.setAlignment(Pos.CENTER);
        swap.getChildren().add(board);

        VBox creditGradeContainer = new VBox();
        creditGradeContainer.setAlignment(Pos.CENTER);
        creditGradeContainer.setPadding(new Insets(10,10,10,10));
        creditGradeContainer.setPrefSize(400,600);
        board.add(creditGradeContainer,0,0);
        
        HBox creditGradeBox = new HBox();
        creditGradeBox.setAlignment(Pos.CENTER);
        creditGradeBox.setPrefSize(380,580);
        creditGradeBox.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
        DropShadow ds = new DropShadow();
        ds.setColor(Color.color(0,0,0,0.5));
        ds.setOffsetX(4);
        ds.setOffsetY(4);
        creditGradeBox.setEffect(ds);
        creditGradeContainer.getChildren().addAll(creditGradeBox);

        GridPane creditGradeBoard = new GridPane();
        creditGradeBoard.setAlignment(Pos.CENTER);
        creditGradeBoard.setVgap(20);
        creditGradeBox.getChildren().addAll(creditGradeBoard);

        VBox showBoard = new VBox();
        showBoard.setAlignment(Pos.CENTER);
        showBoard.setPadding(new Insets(10,15,10,10));
        showBoard.setSpacing(20);

        HBox addBox = new HBox();
        addBox.setAlignment(Pos.CENTER);
        addBox.setPrefSize(300,50);
        addBox.setSpacing(10);

        TextField vipGradeField = new TextField();
        vipGradeField.setPromptText("vip等级");
        vipGradeField.setPrefWidth(50);
        TextField vipBorderField = new TextField();
        vipBorderField.setPromptText("输入该等级下限信用值");
        Button addBtn = new Button("add");
        addBox.getChildren().addAll(vipGradeField,vipBorderField,addBtn);
        
        creditService=new CreditServiceImpl();
        strategyService=new StrategyServiceImpl();

        addBtn.setOnMouseClicked(event -> {
            String vip = vipGradeField.getText();
            String border = vipBorderField.getText();
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            //返回值：
            try {
				boolean result=strategyService.setVipGrade(Integer.parseInt(vip), Integer.parseInt(border));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            try {
				toCreditOpr();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });

        creditGradeBoard.add(addBox,0,1);

        ScrollPane sp = new ScrollPane();
        sp.setPrefSize(300,300);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setContent(showBoard);
        creditGradeBoard.add(sp,0,0);
        //
        //传参::::!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        List<VipVO> vipList=strategyService.viewWebVipList();
        int  lengthOfList = vipList.size();
        for(int i=0;i<lengthOfList;i++){
        	VipVO v=vipList.get(i);
            String vip = "vip"+v.getVipGrade();
            int lowBorder = v.getVipGradeCredit();

            HBox singleBoard = new HBox();
            singleBoard.setAlignment(Pos.CENTER);
            singleBoard.setSpacing(30);
            Label vipLabel = new Label(vip);
            Text borderText = new Text(Integer.toString(lowBorder));
            singleBoard.getChildren().addAll(vipLabel,borderText);

            showBoard.getChildren().addAll(singleBoard);
        }

        VBox chargeCreditContainer = new VBox();
        chargeCreditContainer.setAlignment(Pos.CENTER);
        chargeCreditContainer.setPadding(new Insets(10,10,10,10));
        chargeCreditContainer.setPrefSize(400,600);
        board.add(chargeCreditContainer,1,0);

        HBox chargeCreditBox = new HBox();
        chargeCreditBox.setAlignment(Pos.CENTER);
        chargeCreditBox.setPrefSize(380,580);
        chargeCreditBox.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
        DropShadow ds1 = new DropShadow();
        ds1.setColor(Color.color(0,0,0,0.5));
        ds1.setOffsetX(4);
        ds1.setOffsetY(4);
        chargeCreditBox.setEffect(ds1);
        chargeCreditContainer.getChildren().addAll(chargeCreditBox);

        GridPane chargeCreditBoard = new GridPane();
        chargeCreditBoard.setVgap(20);
        chargeCreditBoard.setHgap(10);
        chargeCreditBoard.setAlignment(Pos.CENTER);
        chargeCreditBox.getChildren().addAll(chargeCreditBoard);

        Label userNameLabel = new Label("用户名：");
        TextField userNameField = new TextField();
        Label creditValueLabel = new Label("信用值：");
        TextField creditValueField = new TextField();
        Button chargeBtn = new Button("充值");
        chargeCreditBoard.add(userNameLabel,0,0);
        chargeCreditBoard.add(userNameField,1,0);
        chargeCreditBoard.add(creditValueLabel,0,1);
        chargeCreditBoard.add(creditValueField,1,1);
        chargeCreditBoard.add(chargeBtn,1,2);
        
        userManageService=new UserManageServiceImpl();

        chargeBtn.setOnMouseClicked(event -> {
            String userName = userNameField.getText();
            String creditValue = creditValueField.getText();
            try {
				creditService.addRechargeCredit(userManageService.showUserInfo(userName).getUserID(), Integer.parseInt(creditValue), 0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            //传参
            try {
				toCreditOpr();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });

    }

    private void toStrategy(){
        swap.getChildren().remove(0);
        sortBar.setVisible(false);

        GridPane strategyBoard = new GridPane();
        strategyBoard.setAlignment(Pos.CENTER);
        strategyBoard.setPrefSize(800,600);
        swap.getChildren().add(strategyBoard);


        HBox container1 = new HBox();
        container1.setPrefSize(400,600);
        container1.setPadding(new Insets(10,10,10,10));

        HBox dateStrategyBoard = new HBox();
        dateStrategyBoard.setAlignment(Pos.CENTER);
        dateStrategyBoard.setPrefSize(380,580);
        Text dateStrategyText = new Text("新增特殊日期促销活动");
        dateStrategyBoard.getChildren().add(dateStrategyText);

        dateStrategyBoard.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
        DropShadow ds = new DropShadow();
        ds.setColor(Color.color(0,0,0,0.5));
        ds.setOffsetX(4);
        ds.setOffsetY(4);
        dateStrategyBoard.setEffect(ds);
        container1.getChildren().add(dateStrategyBoard);
        strategyBoard.add(container1,0,0);


        HBox container2 = new HBox();
        container2.setPrefSize(400,600);
        container2.setPadding(new Insets(10,10,10,10));

        HBox vipStrategyBoard = new HBox();
        vipStrategyBoard.setAlignment(Pos.CENTER);
        vipStrategyBoard.setPrefSize(380,580);
        Text vipStrategyText = new Text("新增VIP促销活动");
        vipStrategyBoard.getChildren().add(vipStrategyText);

        vipStrategyBoard.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
        DropShadow ds1 = new DropShadow();
        ds1.setColor(Color.color(0,0,0,0.5));
        ds1.setOffsetX(4);
        ds1.setOffsetY(4);
        vipStrategyBoard.setEffect(ds1);
        container2.getChildren().add(vipStrategyBoard);
        strategyBoard.add(container2,1,0);

        strategyService=new StrategyServiceImpl();
        dateStrategyBoard.setOnMouseClicked(event -> {
            if(!dateStrategyBoard.getChildren().contains(dateStrategyText)){return;}

            GridPane dateStrategyInfoBoard = new GridPane();

            Label nameLabel = new Label("活动名称：");
            Label oriLabel = new Label("开始日期：");
            Label endLabel = new Label("结束日期：");
            Label discountLabel = new Label("折扣率：");

            TextField nameField = new TextField();
            DatePicker oriField = new DatePicker();
            DatePicker endField = new DatePicker();
            TextField discountField = new TextField();
            Button confirm = new Button("确定");
            Button cancel = new Button("取消");

            dateStrategyInfoBoard.add(nameLabel,0,0);
            dateStrategyInfoBoard.add(oriLabel,0,1);
            dateStrategyInfoBoard.add(endLabel,0,2);
            dateStrategyInfoBoard.add(discountLabel,0,3);
            dateStrategyInfoBoard.add(nameField,1,0);
            dateStrategyInfoBoard.add(oriField,1,1);
            dateStrategyInfoBoard.add(endField,1,2);
            dateStrategyInfoBoard.add(discountField,1,3);
            dateStrategyInfoBoard.add(confirm,0,4);
            dateStrategyInfoBoard.add(cancel,1,4);

            dateStrategyInfoBoard.setAlignment(Pos.CENTER_LEFT);
            dateStrategyInfoBoard.setVgap(20);
            dateStrategyInfoBoard.setHgap(10);
            dateStrategyBoard.getChildren().add(dateStrategyInfoBoard);

            dateStrategyBoard.getChildren().removeAll(dateStrategyText);

            confirm.setOnMouseClicked(event1 -> {
                String name = nameField.getText();
                String oriDate = oriField.getValue().toString();
                String endDate = endField.getValue().toString();
                String discount = discountField.getText();
                
                try {
					boolean result=strategyService.setSpecialTimeByWeb(new StrategyVO(0, name, Double.parseDouble(discount), oriDate.substring(0, 4)+oriDate.substring(5,7)+oriDate.substring(8,10),endDate.substring(0, 4)+endDate.substring(5,7)+endDate.substring(8,10)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                //返回给你参数
                Text sucText = new Text("succeeded!!");
                HBox sucBox = new HBox();
                sucBox.setAlignment(Pos.CENTER);
                sucBox.getChildren().add(sucText);
                sucBox.setStyle("-fx-background-color: rgba(255,255,255,0.4);");
                dateStrategyInfoBoard.add(sucBox,0,1,2,2);

                FadeTransition fFt1 = new FadeTransition(Duration.millis(1000),sucBox);
                fFt1.setFromValue(0);fFt1.setToValue(1);
                fFt1.play();
                FadeTransition fFt2 = new FadeTransition(Duration.millis(1000),sucBox);
                fFt2.setByValue(-1);
                fFt2.setDelay(Duration.millis(3000));
                fFt2.play();

                if(sucBox.getOpacity()==0){dateStrategyInfoBoard.getChildren().remove(sucBox);}
            });

            cancel.setOnMouseClicked(event1 -> {

                dateStrategyBoard.getChildren().add(dateStrategyText);

                dateStrategyBoard.getChildren().remove(dateStrategyInfoBoard);
            });
        });

        vipStrategyBoard.setOnMouseClicked(event -> {
            if(!vipStrategyBoard.getChildren().contains(vipStrategyText)){return;}

            GridPane vipStrategyInfoBoard = new GridPane();

            Label nameLabel = new Label("活动名称：");
            Label oriLabel = new Label("开始日期：");
            Label endLabel = new Label("结束日期：");
            Label discountLabel = new Label("折扣率：");
            Label circleLabel = new Label("商圈：");
            Label vipLabel = new Label("vip等级：");

            TextField nameField = new TextField();
            DatePicker oriField = new DatePicker();
            DatePicker endField = new DatePicker();
            TextField discountField = new TextField();
            TextField circleField = new TextField();
            TextField vipField = new TextField();
            Button confirm = new Button("确定");
            Button cancel = new Button("取消");

            vipStrategyInfoBoard.add(nameLabel,0,0);
            vipStrategyInfoBoard.add(oriLabel,0,1);
            vipStrategyInfoBoard.add(endLabel,0,2);
            vipStrategyInfoBoard.add(discountLabel,0,3);
            vipStrategyInfoBoard.add(vipLabel,0,4);
            vipStrategyInfoBoard.add(nameField,1,0);
            vipStrategyInfoBoard.add(oriField,1,1);
            vipStrategyInfoBoard.add(endField,1,2);
            vipStrategyInfoBoard.add(discountField,1,3);
            vipStrategyInfoBoard.add(vipField,1,4);
            vipStrategyInfoBoard.add(circleLabel,0,5);
            vipStrategyInfoBoard.add(circleField,1,5);
            vipStrategyInfoBoard.add(confirm,0,6);
            vipStrategyInfoBoard.add(cancel,1,6);

            vipStrategyInfoBoard.setAlignment(Pos.CENTER_LEFT);
            vipStrategyInfoBoard.setVgap(20);
            vipStrategyInfoBoard.setHgap(10);
            vipStrategyBoard.getChildren().add(vipStrategyInfoBoard);
            vipStrategyBoard.getChildren().removeAll(vipStrategyText);

            confirm.setOnMouseClicked(event1 -> {
                String name = nameField.getText();
                String oriDate = oriField.getValue().toString();
                String endDate = endField.getValue().toString();
                String discount = discountField.getText();
                String circle = circleField.getText();
                String vip = vipField.getText();

                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                //返回给你参数
               
                try {
					boolean result=strategyService.setForVip(new StrategyVO(0, name, Double.parseDouble(discount), oriDate.substring(0, 4)+oriDate.substring(5,7)+oriDate.substring(8,10),endDate.substring(0, 4)+endDate.substring(5,7)+endDate.substring(8,10)),circle, Integer.parseInt(vip));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                Text sucText = new Text("succeeded!!");
                HBox sucBox = new HBox();
                sucBox.setAlignment(Pos.CENTER);
                sucBox.getChildren().add(sucText);
                sucBox.setStyle("-fx-background-color: rgba(255,255,255,0.5);");
                vipStrategyInfoBoard.add(sucBox,0,2,2,2);

                FadeTransition fFt1 = new FadeTransition(Duration.millis(1000),sucBox);
                fFt1.setFromValue(0);fFt1.setToValue(1);
                fFt1.play();
                FadeTransition fFt2 = new FadeTransition(Duration.millis(1000),sucBox);
                fFt2.setByValue(-1);
                fFt2.setDelay(Duration.millis(3000));
                fFt2.play();

                if(sucBox.getOpacity()==0){vipStrategyInfoBoard.getChildren().remove(sucBox);}
            });

            cancel.setOnMouseClicked(event1 -> {

                vipStrategyBoard.getChildren().add(vipStrategyText);

                vipStrategyBoard.getChildren().remove(vipStrategyInfoBoard);
            });
        });
    }

}
