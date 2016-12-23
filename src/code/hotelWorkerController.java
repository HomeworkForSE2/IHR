package code;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
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
import service.HotelInfoService;
import service.OrderByHotelService;
import service.RoomService;
import service.StrategyService;
import serviceImpl.HotelInfoServiceImpl;
import serviceImpl.OrderByHotelServiceImpl;
import serviceImpl.RoomServiceImpl;
import serviceImpl.StrategyServiceImpl;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.StrategyVO;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

public class hotelWorkerController {
    @FXML private GridPane root;
    @FXML private VBox small;
    @FXML private HBox swap;
    @FXML private ChoiceBox<String> sortBar;
    private VBox slideBar;

    private HotelInfoService hotelInfoService;
    private RoomService roomService;
    private StrategyService strategyService;
    private OrderByHotelService orderByHotelService;
    private List<OrderVO> list;
    private static boolean isTrue=true;
    
    @FXML private void openSlideBar() {
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
        Text hotelInfo = new Text("酒店信息");
        Text roomInfo = new Text("客房信息");
        Text oprOrder = new Text("订单处理");
        Text strategy = new Text("营销策略 ");
        Button logOut = new Button("退出登录");

      
		hotelInfo.setOnMouseClicked(event -> {
	         try {
	          	  toHotelInfo();
			} catch (Exception e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   });
        roomInfo.setOnMouseClicked(event -> {
            try {
          	  toRoomInfo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      });
        
        oprOrder.setOnMouseClicked(event ->{
            try {
            	toOprOrder();
  			} catch (Exception e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
        });
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
        slideBar.getChildren().addAll(backBox,head,welcome,name,hotelInfo,roomInfo,oprOrder,strategy,logOut);

        root.getChildren().remove(small);
        root.add(slideBar,0,0,1,2);
    }

    private void toHotelInfo() throws IOException{
        swap.getChildren().remove(0);
        sortBar.setVisible(false);

        GridPane table = new GridPane();
        table.setAlignment(Pos.CENTER);

        table.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
        table.setMaxHeight(600);
        table.setPrefWidth(600);
        
        hotelInfoService=new HotelInfoServiceImpl();
        HotelInfoVO hotel=hotelInfoService.findHotel(MainUI.userID);
        //数据传输
        String name = hotel.getHotelName();
        String address = hotel.getLocation();
        String circle = hotel.getBD();
        int stars = hotel.getStarNum();
        String service = hotel.getDevice();
        String intro = hotel.getIntroduction();


        VBox zeroZero = new VBox();
        Label nameLabel = new Label("酒店名称：");
        zeroZero.setPrefSize(200,80);
        zeroZero.setAlignment(Pos.CENTER);
        zeroZero.getChildren().add(nameLabel);
        table.add(zeroZero,0,0);

        VBox zeroOne = new VBox();
        Text nameField = new Text();
        nameField.setText(name);
        zeroOne.getChildren().add(nameField);
        zeroOne.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        zeroOne.setPrefSize(400,80);
        zeroOne.setAlignment(Pos.CENTER);
        table.add(zeroOne,1,0,2,1);

        VBox oneZero = new VBox();
        Label addressLabel = new Label("地址：");
        oneZero.getChildren().add(addressLabel);
        oneZero.setPrefSize(200,80);
        oneZero.setAlignment(Pos.CENTER);
        oneZero.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(oneZero,0,1);

        VBox oneOne = new VBox();
        Text addressText = new Text();
        addressText.setText(address);
        oneOne.getChildren().add(addressText);
        oneOne.setPrefSize(400,80);
        oneOne.setAlignment(Pos.CENTER);
        table.add(oneOne,1,1,2,1);

        VBox twoZero = new VBox();
        Label circleLabel = new Label("商圈：");
        twoZero.getChildren().add(circleLabel);
        twoZero.setPrefSize(200,80);
        twoZero.setAlignment(Pos.CENTER);
        table.add(twoZero,0,2);

        VBox twoOne = new VBox();
        Text circleField = new Text();
        circleField.setText(circle);
        twoOne.getChildren().add(circleField);
        twoOne.setPrefSize(400,80);
        twoOne.setAlignment(Pos.CENTER);
        twoOne.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(twoOne,1,2,2,1);

        VBox threeZero = new VBox();
        Label starsLabel = new Label("星级：");
        threeZero.getChildren().add(starsLabel);
        threeZero.setPrefSize(200,80);
        threeZero.setAlignment(Pos.CENTER);
        threeZero.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(threeZero,0,3);

        VBox threeOne = new VBox();
        HBox starBox = new HBox();
        starBox.setAlignment(Pos.CENTER);
        for(int i=0;i<stars;i++){
            ImageView starView = new ImageView();
            Image star = new Image("/pic/star.png");
            starView.setImage(star);

            starBox.getChildren().add(starView);
        }
        threeOne.getChildren().add(starBox);
        threeOne.setPrefSize(400,80);
        threeOne.setAlignment(Pos.CENTER);
        table.add(threeOne,1,3,2,1);

        VBox fourZero = new VBox();
        Label serviceLabel = new Label("设施服务：");
        fourZero.getChildren().addAll(serviceLabel);
        fourZero.setPrefSize(200,80);
        fourZero.setAlignment(Pos.CENTER);
        table.add(fourZero,0,4);

        VBox fourOne = new VBox();
        Text serviceText = new Text();
        serviceText.setWrappingWidth(350);
        serviceText.setText(service);
        serviceText.setStyle("-fx-line-spacing:0.5em;");
        fourOne.getChildren().add(serviceText);
        fourOne.setPrefSize(400,80);
        fourOne.setPadding(new Insets(20,20,20,20));
        fourOne.setAlignment(Pos.CENTER_LEFT);
        fourOne.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(fourOne,1,4,2,1);

        VBox fiveZero = new VBox();
        Label introLabel = new Label("简介：");
        fiveZero.getChildren().add(introLabel);
        fiveZero.setPrefSize(200,120);
        fiveZero.setAlignment(Pos.CENTER);
        fiveZero.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(fiveZero,0,5);

        VBox fiveOne = new VBox();
        Text introText = new Text();
        introText.setWrappingWidth(350);
        introText.setText(intro);
        introText.setStyle("-fx-line-spacing: 0.5em;");
        ScrollPane sp = new ScrollPane(introText);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setPadding(new Insets(0,5,0,0));
        fiveOne.getChildren().add(sp);
        fiveOne.setPrefSize(400,120);
        fiveOne.setPadding(new Insets(20,15,20,20));
        fiveOne.setAlignment(Pos.CENTER_LEFT);
        fiveOne.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(fiveOne,1,5,2,1);

        VBox sixZero = new VBox();
        Text cancel = new Text("确定");
        sixZero.getChildren().add(cancel);
        sixZero.setPrefSize(200,80);
        sixZero.setAlignment(Pos.CENTER);
        table.add(sixZero,0,6);

        VBox sixOne = new VBox();
        Text change  = new Text("修改");
        sixOne.getChildren().add(change);
        sixOne.setPrefSize(200,80);
        sixOne.setAlignment(Pos.CENTER);
        sixOne.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(sixOne,1,6);
        sixOne.setOnMouseClicked(event -> {
            fiveOne.getChildren().remove(0);
            fourOne.getChildren().remove(0);

            TextArea newIntroArea = new TextArea();
            newIntroArea.setText(intro);
            newIntroArea.setWrapText(true);
            TextArea newServiceArea = new TextArea();
            newServiceArea.setText(service);
            newServiceArea.setWrapText(true);

            fiveOne.getChildren().add(newIntroArea);
            fourOne.getChildren().add(newServiceArea);

            sixZero.setOnMouseClicked(event1 -> {
                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                //修改后更新的值，用来更新一下你的txt数据
            	
                String newIntro = newIntroArea.getText();
                String newService = newServiceArea.getText();
                HotelInfoVO newHotel=new HotelInfoVO(hotel.getHotelID(), hotel.getHotelName(), hotel.getLocation(), hotel.getBD(), hotel.getStarNum(), newIntro, newService,hotel.getScore());
                try {
					hotelInfoService.maintainHotelInfo(newHotel);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                //在此更新数据
                //更新数据之后
                try {
					toHotelInfo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            });
        });

        VBox sixTwo = new VBox();
        Text orderInfo = new Text("取消");
        sixTwo.getChildren().add(orderInfo);
        sixTwo.setPrefSize(200,100);
        sixTwo.setAlignment(Pos.CENTER);
        table.add(sixTwo,2,6);
        sixTwo.setOnMouseClicked(event -> {
	         try {
	          	  toHotelInfo();
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

    private void toRoomInfo() throws IOException{
        swap.getChildren().remove(0);
        sortBar.setVisible(false);

        GridPane roomBoard = new GridPane();
        roomBoard.setAlignment(Pos.CENTER);
        roomBoard.setVgap(5);

        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(20,20,20,20));
        roomBoard.add(container,0,1);

        HBox btnBox = new HBox();
        btnBox.setAlignment(Pos.CENTER);
        Button addBtn = new Button("录入房间");
        btnBox.getChildren().add(addBtn);
        roomBoard.add(btnBox,0,0);

        VBox roomList = new VBox();
        roomList.setSpacing(20);
        roomList.setPadding(new Insets(40,25,20,20));
        roomList.setPrefWidth(600);
        ScrollPane sp = new ScrollPane();
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setContent(roomList);
        sp.setMaxHeight(600);

        container.getChildren().add(sp);
        roomService=new RoomServiceImpl();
        List<RoomVO> list=roomService.getRoomListInThisHotel(MainUI.userID);
        int lenthOfList = list.size();

        for(int i=0;i<lenthOfList;i++){
            //传参：
        	RoomVO room=list.get(i);
            boolean isEmpty =!room.isState() ;
            String roomNo = String.valueOf(i+1);
            String price = String.valueOf(room.getPrice());
            String type = room.getRoomType();

            GridPane roomInfo = new GridPane();
            roomInfo.setAlignment(Pos.CENTER);
            roomInfo.setPrefSize(500,100);

            HBox roomNoBox = new HBox();
            roomNoBox.setPrefSize(100,100);
            roomNoBox.setAlignment(Pos.CENTER);
            roomNoBox.getChildren().add(new Text(roomNo));
            roomInfo.add(roomNoBox,0,0);

            Text state = new Text();
            HBox stateBox = new HBox();
            stateBox.setPrefSize(100,100);
            stateBox.setAlignment(Pos.CENTER);
            stateBox.getChildren().add(state);
            roomInfo.add(stateBox,1,0);

            HBox priceBox = new HBox();
            priceBox.setAlignment(Pos.CENTER);
            priceBox.setPrefSize(100,100);
            priceBox.getChildren().add(new Text(price));
            roomInfo.add(priceBox,2,0);

            HBox typeBox = new HBox();
            typeBox.setAlignment(Pos.CENTER);
            typeBox.setPrefSize(100,100);
            typeBox.getChildren().add(new Text(type));
            roomInfo.add(typeBox,3,0);

            HBox actBtn = new HBox();
            actBtn.setAlignment(Pos.CENTER);
            actBtn.setPrefSize(100,100);
            Text act = new Text();
            actBtn.getChildren().add(act);
            roomInfo.add(actBtn,4,0);

            roomInfo.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
            DropShadow ds = new DropShadow();
            ds.setColor(Color.color(0,0,0,0.5));
            ds.setOffsetX(4);
            ds.setOffsetY(4);
            roomInfo.setEffect(ds);

            if(isEmpty){
                state.setText("空");
                state.setFill(Color.GREEN);
                act.setText("入住");
            }else{
                state.setText("有人");
                state.setFill(Color.YELLOW);
                act.setText("退房");
            }

            roomList.getChildren().add(roomInfo);

            actBtn.setOnMouseClicked(event1 -> {
//            	
                if(act.getText().equals("入住")){
                    //对客房入住操作
                	try {
						roomService.checkInRoom(room.getRoomID());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }else{
                    //对客房退房操作
                	try {
						roomService.checkOutRoom(room.getRoomID());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                try {
					toRoomInfo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            });
        }

        addBtn.setOnMouseClicked(event -> {
            container.getChildren().remove(0);

            HBox addBox = new HBox();
            GridPane addFrame = new GridPane();
            addFrame.setAlignment(Pos.CENTER_LEFT);
            addFrame.setVgap(20);
            addBox.getChildren().add(addFrame);
            addBox.setAlignment(Pos.CENTER);
            addBox.setPrefSize(300,400);
            addBox.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");

            DropShadow ds = new DropShadow();
            ds.setColor(Color.color(0,0,0,0.5));
            ds.setOffsetX(4);
            ds.setOffsetY(4);
            addBox.setEffect(ds);

            container.getChildren().add(addBox);

            Label typeLabel = new Label("房间类型：");
            Label numLabel = new Label("房间数量：");
            Label priceLabel = new Label("房间单价：");

            TextField typeField = new TextField();
            TextField numField = new TextField();
            TextField priceField = new TextField();

            Button submit = new Button("添加");
            Button cancel = new Button("返回");

            addFrame.add(typeLabel,0,0);addFrame.add(typeField,1,0);
            addFrame.add(numLabel,0,1);addFrame.add(numField,1,1);
            addFrame.add(priceLabel,0,2);addFrame.add(priceField,1,2);
            addFrame.add(submit,0,3);addFrame.add(cancel,1,3);

            submit.setOnMouseClicked(event1 -> {
                String type = typeField.getText();
                int num = Integer.parseInt(numField.getText());
                String price = priceField.getText();
                try {
					boolean result=roomService.creatRoom(MainUI.userID, Integer.parseInt(type), num, Double.parseDouble(price));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!传参
                typeField.setText("");
                numField.setText("");
                priceField.setText("");
                try {
					toRoomInfo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            });
            cancel.setOnMouseClicked(event1 -> {
                container.getChildren().remove(0);
                container.getChildren().add(sp);
            });
        });

        swap.getChildren().add(roomBoard);
    }
    
    private ObservableList<String> sortList = FXCollections.observableArrayList("分类查看","正常","异常","已执行","撤销");
    
    private void toOprOrder() throws IOException{
        swap.getChildren().remove(0);
        sortBar.setVisible(true);


        VBox board = new VBox();
        board.setPadding(new Insets(20,30,20,20));
        board.setAlignment(Pos.TOP_CENTER);
        board.setSpacing(20);
        board.setStyle("-fx-background-color: rgba(0,0,0,0)");

        orderByHotelService=new OrderByHotelServiceImpl();
        orderByHotelService.initHotel(MainUI.userID);
        
        if(isTrue){
        	list=orderByHotelService.getAllHotelOrder();
        }
        //订单长度
        int lengthOfList = list.size();

        if(lengthOfList==0){
            Text none = new Text("您的酒店还没有订单呢，多多努力啊!");
            swap.getChildren().add(none);
            return;
        }

        for(int i=0;i<lengthOfList;i++){
            //传参
        	OrderVO order=list.get(i);
            String orderState = order.getState() ;//我觉得只有四种状态：正常、异常、已执行、已撤销
            String orderID = String.valueOf(order.getOrderId());
            String value = order.getPrice()+"$";
            String startDate = order.getStartTime();//三个都要按照格式YYYY-MM-DD
            String actDate = order.getFinishTime();;
            String endDate = order.getEndTime();
            String roomType = order.getRoomType();
            int roomNum = order.getRoomNum();
            int peopleNum = order.getPeopleNum();
            boolean hasChildren = order.isHasChildren();
         
            //自己加个状态
            if(orderState.equals("已执行")&&actDate.equals("尚未完成")){
            	orderState="执行中";        	
            }
            //为了实现完成订单只能点击一次的效果,传过来的参数要加一个:是否已经完成
            //或者加一个状态,比如已完成......
            //!!!!!!!!

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
                    orderStateText.setFill(Color.color(0.18, 0.46, 0.71));
                    break;
            }
            orderStateBox.setAlignment(Pos.CENTER);
            orderStateBox.setPrefSize(200,100);
            orderStateBox.getChildren().add(orderStateText);
            singleRecord.add(orderStateBox,4,0,2,1);

            HBox roomTypeBox = new HBox();
            Text roomTypeText = new Text(roomType+" × "+Integer.toBinaryString(roomNum));
            roomTypeBox.setAlignment(Pos.CENTER);
            roomTypeBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
            roomTypeBox.setPrefSize(200,100);
            roomTypeBox.getChildren().add(roomTypeText);
            singleRecord.add(roomTypeBox,0,1,2,1);

            HBox valueBox = new HBox();
            Text valueText = new Text(value);
            valueBox.setAlignment(Pos.CENTER);
            valueBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
            valueBox.setPrefSize(100,100);
            valueBox.getChildren().add(valueText);
            singleRecord.add(valueBox,2,1);

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
            singleRecord.add(peopleBox,3,1,3,1);

            HBox startDateBox = new HBox();
            Text startDateText = new Text(startDate+"预约");
            startDateBox.setAlignment(Pos.CENTER);
            startDateBox.setPrefSize(200,100);
            startDateBox.getChildren().add(startDateText);
            singleRecord.add(startDateBox,0,2,2,1);

            HBox actDateBox = new HBox();
            Text actDateText = new Text(actDate+"入住");
            actDateBox.setAlignment(Pos.CENTER);
            actDateBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
            actDateBox.setPrefSize(200,100);
            actDateBox.getChildren().add(actDateText);
            singleRecord.add(actDateBox,2,2,2,1);

            HBox endDateBox = new HBox();
            Text endDateText = new Text(endDate+"离开");
            endDateBox.setAlignment(Pos.CENTER);
            endDateBox.setPrefSize(200,100);
            endDateBox.getChildren().add(endDateText);
            singleRecord.add(endDateBox,4,2,2,1);

            singleRecord.setPadding(new Insets(0,0,0,0));
            singleRecord.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
            DropShadow ds = new DropShadow();
            ds.setColor(Color.color(0,0,0,0.5));
            ds.setOffsetX(4);
            ds.setOffsetY(4);
            singleRecord.setEffect(ds);
            singleRecord.setPrefSize(600,300);

            if(orderState.equals("正常")){
                startDateBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                endDateBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                HBox sure = new HBox();
                Text sureText = new Text("执行订单");
                sure.setAlignment(Pos.CENTER);
                sure.setPrefSize(200,50);
                sure.getChildren().add(sureText);
                singleRecord.add(sure,2,3,2,1);
                singleRecord.setPrefSize(600,350);

                sure.setOnMouseClicked(event -> {
                    //修改你的数据的订单状态
                    //返回值，我觉得是你传过来的List里面的第i个
                    //i值可返回
                	try {
						orderByHotelService.executeOrder(order.getOrderId());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

                    try {
						toOprOrder();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                });
            }else if(orderState.equals("已执行")||orderState.equals("执行中")){
                startDateBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                endDateBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");

                if(orderState.equals("执行中")){
                    HBox finish = new HBox();
                    Text finishText = new Text("完成订单");
                    finish.setAlignment(Pos.CENTER);
                    finish.setPrefSize(200,50);
                    finish.getChildren().add(finishText);
                    singleRecord.add(finish,2,3,2,1);
                    singleRecord.setPrefSize(600,350);

                    finish.setOnMouseClicked(event -> {
//                       if(){return;}
                        //修改你的数据的订单状态
                        //返回值，我觉得是你传过来的List里面的第i个
                        //i值可返回
                        //hasfinished置为true
                        
                        try {
							orderByHotelService.finishOrder(order.getOrderId());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

                       
                        try {
							toOprOrder();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    });
                }

            }else if(orderState.equals("异常")){
                startDateBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                endDateBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                HBox delay = new HBox();
                Text delayText = new Text("延迟入住");
                delay.setAlignment(Pos.CENTER);
                delay.setPrefSize(200,50);
                delay.getChildren().add(delayText);
                singleRecord.add(delay,2,3,2,1);
                singleRecord.setPrefSize(600,350);

                delay.setOnMouseClicked(event -> {
                    //修改你的数据的订单状态
                    //返回值，我觉得是你传过来的List里面的第i个
                    //i值可返回
                	try {
						orderByHotelService.setUnusualToExecute(order.getOrderId());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

                    try {
						toOprOrder();
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
 						list=orderByHotelService.getHotelNotExecuteOrder();
 					} catch (Exception e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}

             	}else if(sort.equals("异常")){
             		try {
 						list=orderByHotelService.getHotelUnusualOrder();
 					} catch (Exception e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}
             		
             	}else if(sort.equals("已执行")){
             		try {
 						list=orderByHotelService.getHotelExecuteOrder();
 					} catch (Exception e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}
             		
             	}else if(sort.equals("撤销")){
             		try {
 						list=orderByHotelService.getHotelCancelOrder();
 					} catch (Exception e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}
             		
             	}
             }else{
             	isTrue=true;
             }
            
            try {
				toOprOrder();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            sortBar.setValue(sort);
        });
    }

    private void toStrategy(){
        swap.getChildren().remove(0);
        sortBar.setVisible(false);

        GridPane strategyBoard = new GridPane();
        strategyBoard.setAlignment(Pos.CENTER);
        strategyBoard.setPrefSize(840,640);
        swap.getChildren().add(strategyBoard);


        HBox container1 = new HBox();
        container1.setPrefSize(420,320);
        container1.setPadding(new Insets(10,10,10,10));

        HBox dateStrategyBoard = new HBox();
        dateStrategyBoard.setAlignment(Pos.CENTER);
        dateStrategyBoard.setPrefSize(400,300);
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
        container2.setPrefSize(420,320);
        container2.setPadding(new Insets(10,10,10,10));

        HBox roomNumStrategyBoard = new HBox();
        roomNumStrategyBoard.setAlignment(Pos.CENTER);
        roomNumStrategyBoard.setPrefSize(400,300);
        Text roomNumStrategyText = new Text("新增房间数量促销活动");
        roomNumStrategyBoard.getChildren().add(roomNumStrategyText);

        roomNumStrategyBoard.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
        DropShadow ds1 = new DropShadow();
        ds1.setColor(Color.color(0,0,0,0.5));
        ds1.setOffsetX(4);
        ds1.setOffsetY(4);
        roomNumStrategyBoard.setEffect(ds1);
        container2.getChildren().add(roomNumStrategyBoard);
        strategyBoard.add(container2,1,0);


        HBox container3 = new HBox();
        container3.setPrefSize(420,320);
        container3.setPadding(new Insets(10,10,10,10));

        HBox birthdayStrategyBoard = new HBox();
        birthdayStrategyBoard.setAlignment(Pos.CENTER);
        birthdayStrategyBoard.setPrefSize(400,300);
        Text birthdayStrategyText = new Text("新增会员生日优惠活动");
        birthdayStrategyBoard.getChildren().add(birthdayStrategyText);

        birthdayStrategyBoard.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
        DropShadow ds2 = new DropShadow();
        ds2.setColor(Color.color(0,0,0,0.5));
        ds2.setOffsetX(4);
        ds2.setOffsetY(4);
        birthdayStrategyBoard.setEffect(ds2);
        container3.getChildren().add(birthdayStrategyBoard);
        strategyBoard.add(container3,0,1);


        HBox container4 = new HBox();
        container4.setPrefSize(420,320);
        container4.setPadding(new Insets(10,10,10,10));

        HBox enterpriseStrategyBoard = new HBox();
        enterpriseStrategyBoard.setAlignment(Pos.CENTER);
        enterpriseStrategyBoard.setPrefSize(400,300);
        Text enterpriseStrategyText = new Text("新增会员企业优惠活动");
        enterpriseStrategyBoard.getChildren().add(enterpriseStrategyText);

        enterpriseStrategyBoard.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
        DropShadow ds3 = new DropShadow();
        ds3.setColor(Color.color(0,0,0,0.5));
        ds3.setOffsetX(4);
        ds3.setOffsetY(4);
        enterpriseStrategyBoard.setEffect(ds3);
        container4.getChildren().add(enterpriseStrategyBoard);
        strategyBoard.add(container4,1,1);


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

            ScaleTransition st1 = new ScaleTransition(Duration.millis(500),dateStrategyBoard);
            st1.setByX(0.1);
            st1.setByY(0.1);
            TranslateTransition tt1 = new TranslateTransition(Duration.millis(500),dateStrategyBoard);
            tt1.setByX(20);
            tt1.setByY(15);
            FadeTransition ftO = new FadeTransition(Duration.millis(500),dateStrategyText);
            ftO.setByValue(-1);
            FadeTransition ftI = new FadeTransition(Duration.millis(500),dateStrategyInfoBoard);
            ftI.setFromValue(0);
            ftI.setToValue(1);

            ScaleTransition st2 = new ScaleTransition(Duration.millis(500),roomNumStrategyBoard);
            st2.setByX(-0.1);
            st2.setByY(-0.1);
            TranslateTransition tt2 = new TranslateTransition(Duration.millis(500),roomNumStrategyBoard);
            tt2.setByX(20);
            tt2.setByY(-15);

            ScaleTransition st3 = new ScaleTransition(Duration.millis(500),birthdayStrategyBoard);
            st3.setByX(-0.1);
            st3.setByY(-0.1);
            TranslateTransition tt3 = new TranslateTransition(Duration.millis(500),birthdayStrategyBoard);
            tt3.setByX(-20);
            tt3.setByY(15);

            ScaleTransition st4 = new ScaleTransition(Duration.millis(500),enterpriseStrategyBoard);
            st4.setByX(-0.1);
            st4.setByY(-0.1);
            TranslateTransition tt4 = new TranslateTransition(Duration.millis(500),enterpriseStrategyBoard);
            tt4.setByX(20);
            tt4.setByY(15);

            ParallelTransition pt = new ParallelTransition();
            pt.getChildren().addAll(st1,st2,st3,st4,tt1,tt2,tt3,tt4,ftO,ftI);
            pt.play();

            dateStrategyBoard.getChildren().removeAll(dateStrategyText);
            dateStrategyBoard.resize(500,375);
            roomNumStrategyBoard.resize(320,240);
            birthdayStrategyBoard.resize(320,240);
            enterpriseStrategyBoard.resize(320,240);

            
            strategyService=new StrategyServiceImpl();
            confirm.setOnMouseClicked(event1 -> {
                String name = nameField.getText();
                String oriDate = oriField.getValue().toString();
                String endDate = endField.getValue().toString();
                String discount = discountField.getText();

                StrategyVO strategy=new StrategyVO(MainUI.userID,name,Double.parseDouble(discount),oriDate.substring(0, 4)+oriDate.substring(5,7)+oriDate.substring(8,10),endDate.substring(0, 4)+endDate.substring(5,7)+endDate.substring(8,10)); 
                try {
					strategyService.setSpecialTimeByHotel(strategy);
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

                ScaleTransition cSt1 = new ScaleTransition(Duration.millis(500),dateStrategyBoard);
                cSt1.setByX(-0.1);
                cSt1.setByY(-0.1);
                TranslateTransition cTt1 = new TranslateTransition(Duration.millis(500),dateStrategyBoard);
                cTt1.setByX(-20);
                cTt1.setByY(-15);
                FadeTransition cFtO = new FadeTransition(Duration.millis(500),dateStrategyText);
                cFtO.setFromValue(0);
                cFtO.setToValue(1);
                FadeTransition cFtI = new FadeTransition(Duration.millis(500),dateStrategyInfoBoard);
                cFtI.setByValue(-1);

                ScaleTransition cFt2 = new ScaleTransition(Duration.millis(500),roomNumStrategyBoard);
                cFt2.setByX(0.1);
                cFt2.setByY(0.1);
                TranslateTransition cTt2 = new TranslateTransition(Duration.millis(500),roomNumStrategyBoard);
                cTt2.setByX(-20);
                cTt2.setByY(15);

                ScaleTransition cSt3 = new ScaleTransition(Duration.millis(500),birthdayStrategyBoard);
                cSt3.setByX(0.1);
                cSt3.setByY(0.1);
                TranslateTransition cTt3 = new TranslateTransition(Duration.millis(500),birthdayStrategyBoard);
                cTt3.setByX(20);
                cTt3.setByY(-15);

                ScaleTransition cSt4 = new ScaleTransition(Duration.millis(500),enterpriseStrategyBoard);
                cSt4.setByX(0.1);
                cSt4.setByY(0.1);
                TranslateTransition cTt4 = new TranslateTransition(Duration.millis(500),enterpriseStrategyBoard);
                cTt4.setByX(-20);
                cTt4.setByY(-15);

                ParallelTransition cPt = new ParallelTransition();
                cPt.getChildren().addAll(cSt1,cFt2,cSt3,cSt4,cTt1,cTt2,cTt3,cTt4,cFtO,cFtI);
                cPt.play();

                dateStrategyBoard.getChildren().remove(dateStrategyInfoBoard);
                dateStrategyBoard.resize(400,300);
                roomNumStrategyBoard.resize(400,300);
                birthdayStrategyBoard.resize(400,300);
                enterpriseStrategyBoard.resize(400,300);
            });
        });

        roomNumStrategyBoard.setOnMouseClicked(event -> {
            if(!roomNumStrategyBoard.getChildren().contains(roomNumStrategyText)){return;}

            GridPane roomNumStrategyInfoBoard = new GridPane();

            Label nameLabel = new Label("活动名称：");
            Label oriLabel = new Label("开始日期：");
            Label endLabel = new Label("结束日期：");
            Label discountLabel = new Label("折扣率：");
            Label numLabel = new Label("房间数量：");

            Text nameField = new Text("房间数量优惠");
            DatePicker oriField = new DatePicker();
            DatePicker endField = new DatePicker();
            TextField discountField = new TextField();
            TextField numField = new TextField();
            Button confirm = new Button("确定");
            Button cancel = new Button("取消");

            roomNumStrategyInfoBoard.add(nameLabel,0,0);
            roomNumStrategyInfoBoard.add(oriLabel,0,1);
            roomNumStrategyInfoBoard.add(endLabel,0,2);
            roomNumStrategyInfoBoard.add(discountLabel,0,3);
            roomNumStrategyInfoBoard.add(nameField,1,0);
            roomNumStrategyInfoBoard.add(oriField,1,1);
            roomNumStrategyInfoBoard.add(endField,1,2);
            roomNumStrategyInfoBoard.add(discountField,1,3);
            roomNumStrategyInfoBoard.add(numLabel,0,4);
            roomNumStrategyInfoBoard.add(numField,1,4);
            roomNumStrategyInfoBoard.add(confirm,0,5);
            roomNumStrategyInfoBoard.add(cancel,1,5);

            roomNumStrategyInfoBoard.setAlignment(Pos.CENTER_LEFT);
            roomNumStrategyInfoBoard.setVgap(20);
            roomNumStrategyInfoBoard.setHgap(10);
            roomNumStrategyBoard.getChildren().add(roomNumStrategyInfoBoard);

            ScaleTransition st1 = new ScaleTransition(Duration.millis(500),roomNumStrategyBoard);
            st1.setByX(0.1);
            st1.setByY(0.1);
            TranslateTransition tt1 = new TranslateTransition(Duration.millis(500),roomNumStrategyBoard);
            tt1.setByX(-20);
            tt1.setByY(15);
            FadeTransition ftO = new FadeTransition(Duration.millis(500),roomNumStrategyText);
            ftO.setByValue(-1);
            FadeTransition ftI = new FadeTransition(Duration.millis(500),roomNumStrategyInfoBoard);
            ftI.setFromValue(0);
            ftI.setToValue(1);

            ScaleTransition st2 = new ScaleTransition(Duration.millis(500),dateStrategyBoard);
            st2.setByX(-0.1);
            st2.setByY(-0.1);
            TranslateTransition tt2 = new TranslateTransition(Duration.millis(500),dateStrategyBoard);
            tt2.setByX(-20);
            tt2.setByY(-15);

            ScaleTransition st3 = new ScaleTransition(Duration.millis(500),birthdayStrategyBoard);
            st3.setByX(-0.1);
            st3.setByY(-0.1);
            TranslateTransition tt3 = new TranslateTransition(Duration.millis(500),birthdayStrategyBoard);
            tt3.setByX(-20);
            tt3.setByY(15);

            ScaleTransition st4 = new ScaleTransition(Duration.millis(500),enterpriseStrategyBoard);
            st4.setByX(-0.1);
            st4.setByY(-0.1);
            TranslateTransition tt4 = new TranslateTransition(Duration.millis(500),enterpriseStrategyBoard);
            tt4.setByX(20);
            tt4.setByY(15);

            ParallelTransition pt = new ParallelTransition();
            pt.getChildren().addAll(st1,st2,st3,st4,tt1,tt2,tt3,tt4,ftO,ftI);
            pt.play();

            roomNumStrategyBoard.getChildren().removeAll(roomNumStrategyText);
            roomNumStrategyBoard.resize(500,375);
            dateStrategyBoard.resize(320,240);
            birthdayStrategyBoard.resize(320,240);
            enterpriseStrategyBoard.resize(320,240);

            confirm.setOnMouseClicked(event1 -> {
                String oriDate = oriField.getValue().toString();
                String endDate = endField.getValue().toString();
                String discount = discountField.getText();
                int number = Integer.parseInt(numField.getText());

                
                StrategyVO strategy=new StrategyVO(MainUI.userID,"房间优惠策略",Double.parseDouble(discount),oriDate.substring(0, 4)+oriDate.substring(5,7)+oriDate.substring(8,10),endDate.substring(0, 4)+endDate.substring(5,7)+endDate.substring(8,10));
                try {
					strategyService.setResRoomNumByHotel(strategy, number);
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
                sucBox.setStyle("-fx-background-color: rgba(255,255,255,0.5);");
                roomNumStrategyInfoBoard.add(sucBox,0,2,2,2);

                FadeTransition fFt1 = new FadeTransition(Duration.millis(1000),sucBox);
                fFt1.setFromValue(0);fFt1.setToValue(1);
                fFt1.play();
                FadeTransition fFt2 = new FadeTransition(Duration.millis(1000),sucBox);
                fFt2.setByValue(-1);
                fFt2.setDelay(Duration.millis(3000));
                fFt2.play();

                if(sucBox.getOpacity()==0){roomNumStrategyInfoBoard.getChildren().remove(sucBox);}
            });

            cancel.setOnMouseClicked(event1 -> {

                roomNumStrategyBoard.getChildren().add(roomNumStrategyText);

                ScaleTransition cSt1 = new ScaleTransition(Duration.millis(500),roomNumStrategyBoard);
                cSt1.setByX(-0.1);
                cSt1.setByY(-0.1);
                TranslateTransition cTt1 = new TranslateTransition(Duration.millis(500),roomNumStrategyBoard);
                cTt1.setByX(20);
                cTt1.setByY(-15);
                FadeTransition cFtO = new FadeTransition(Duration.millis(500),roomNumStrategyText);
                cFtO.setFromValue(0);
                cFtO.setToValue(1);
                FadeTransition cFtI = new FadeTransition(Duration.millis(500),roomNumStrategyInfoBoard);
                cFtI.setByValue(-1);

                ScaleTransition cFt2 = new ScaleTransition(Duration.millis(500),dateStrategyBoard);
                cFt2.setByX(0.1);
                cFt2.setByY(0.1);
                TranslateTransition cTt2 = new TranslateTransition(Duration.millis(500),dateStrategyBoard);
                cTt2.setByX(20);
                cTt2.setByY(15);

                ScaleTransition cSt3 = new ScaleTransition(Duration.millis(500),birthdayStrategyBoard);
                cSt3.setByX(0.1);
                cSt3.setByY(0.1);
                TranslateTransition cTt3 = new TranslateTransition(Duration.millis(500),birthdayStrategyBoard);
                cTt3.setByX(20);
                cTt3.setByY(-15);

                ScaleTransition cSt4 = new ScaleTransition(Duration.millis(500),enterpriseStrategyBoard);
                cSt4.setByX(0.1);
                cSt4.setByY(0.1);
                TranslateTransition cTt4 = new TranslateTransition(Duration.millis(500),enterpriseStrategyBoard);
                cTt4.setByX(-20);
                cTt4.setByY(-15);

                ParallelTransition cPt = new ParallelTransition();
                cPt.getChildren().addAll(cSt1,cFt2,cSt3,cSt4,cTt1,cTt2,cTt3,cTt4,cFtO,cFtI);
                cPt.play();

                roomNumStrategyBoard.getChildren().remove(roomNumStrategyInfoBoard);
                roomNumStrategyBoard.resize(400,300);
                dateStrategyBoard.resize(400,300);
                birthdayStrategyBoard.resize(400,300);
                enterpriseStrategyBoard.resize(400,300);
            });
        });

        birthdayStrategyBoard.setOnMouseClicked(event -> {
            if(!birthdayStrategyBoard.getChildren().contains(birthdayStrategyText)){return;}

            GridPane birthdayStrategyInfoBoard = new GridPane();

            Label nameLabel = new Label("活动名称：");
            Label oriLabel = new Label("开始日期：");
            Label endLabel = new Label("结束日期：");
            Label discountLabel = new Label("折扣率：");

            Text nameField = new Text("会员生日优惠");
            DatePicker oriField = new DatePicker();
            DatePicker endField = new DatePicker();
            TextField discountField = new TextField();
            Button confirm = new Button("确定");
            Button cancel = new Button("取消");

            birthdayStrategyInfoBoard.add(nameLabel,0,0);
            birthdayStrategyInfoBoard.add(oriLabel,0,1);
            birthdayStrategyInfoBoard.add(endLabel,0,2);
            birthdayStrategyInfoBoard.add(discountLabel,0,3);
            birthdayStrategyInfoBoard.add(nameField,1,0);
            birthdayStrategyInfoBoard.add(oriField,1,1);
            birthdayStrategyInfoBoard.add(endField,1,2);
            birthdayStrategyInfoBoard.add(discountField,1,3);
            birthdayStrategyInfoBoard.add(confirm,0,4);
            birthdayStrategyInfoBoard.add(cancel,1,4);

            birthdayStrategyInfoBoard.setAlignment(Pos.CENTER_LEFT);
            birthdayStrategyInfoBoard.setVgap(20);
            birthdayStrategyInfoBoard.setHgap(10);
            birthdayStrategyBoard.getChildren().add(birthdayStrategyInfoBoard);

            ScaleTransition st1 = new ScaleTransition(Duration.millis(500),birthdayStrategyBoard);
            st1.setByX(0.1);
            st1.setByY(0.1);
            TranslateTransition tt1 = new TranslateTransition(Duration.millis(500),birthdayStrategyBoard);
            tt1.setByX(20);
            tt1.setByY(-15);
            FadeTransition ftO = new FadeTransition(Duration.millis(500),birthdayStrategyText);
            ftO.setByValue(-1);
            FadeTransition ftI = new FadeTransition(Duration.millis(500),birthdayStrategyInfoBoard);
            ftI.setFromValue(0);
            ftI.setToValue(1);

            ScaleTransition st2 = new ScaleTransition(Duration.millis(500),roomNumStrategyBoard);
            st2.setByX(-0.1);
            st2.setByY(-0.1);
            TranslateTransition tt2 = new TranslateTransition(Duration.millis(500),roomNumStrategyBoard);
            tt2.setByX(20);
            tt2.setByY(-15);

            ScaleTransition st3 = new ScaleTransition(Duration.millis(500),dateStrategyBoard);
            st3.setByX(-0.1);
            st3.setByY(-0.1);
            TranslateTransition tt3 = new TranslateTransition(Duration.millis(500),dateStrategyBoard);
            tt3.setByX(-20);
            tt3.setByY(-15);

            ScaleTransition st4 = new ScaleTransition(Duration.millis(500),enterpriseStrategyBoard);
            st4.setByX(-0.1);
            st4.setByY(-0.1);
            TranslateTransition tt4 = new TranslateTransition(Duration.millis(500),enterpriseStrategyBoard);
            tt4.setByX(20);
            tt4.setByY(15);

            ParallelTransition pt = new ParallelTransition();
            pt.getChildren().addAll(st1,st2,st3,st4,tt1,tt2,tt3,tt4,ftO,ftI);
            pt.play();

            birthdayStrategyBoard.getChildren().removeAll(birthdayStrategyText);
            birthdayStrategyBoard.resize(500,375);
            roomNumStrategyBoard.resize(320,240);
            dateStrategyBoard.resize(320,240);
            enterpriseStrategyBoard.resize(320,240);

            confirm.setOnMouseClicked(event1 -> {
                String oriDate = oriField.getValue().toString();
                String endDate = endField.getValue().toString();
                String discount = discountField.getText();

                StrategyVO strategy=new StrategyVO(MainUI.userID,"生日优惠策略",Double.parseDouble(discount),oriDate.substring(0, 4)+oriDate.substring(5,7)+oriDate.substring(8,10),endDate.substring(0, 4)+endDate.substring(5,7)+endDate.substring(8,10));
                try {
					strategyService.setBirthdayByHotel(strategy);
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
                birthdayStrategyInfoBoard.add(sucBox,0,1,2,2);

                FadeTransition fFt1 = new FadeTransition(Duration.millis(1000),sucBox);
                fFt1.setFromValue(0);fFt1.setToValue(1);
                fFt1.play();
                FadeTransition fFt2 = new FadeTransition(Duration.millis(1000),sucBox);
                fFt2.setByValue(-1);
                fFt2.setDelay(Duration.millis(3000));
                fFt2.play();

                if(sucBox.getOpacity()==0){birthdayStrategyInfoBoard.getChildren().remove(sucBox);}
            });

            cancel.setOnMouseClicked(event1 -> {

                birthdayStrategyBoard.getChildren().add(birthdayStrategyText);

                ScaleTransition cSt1 = new ScaleTransition(Duration.millis(500),birthdayStrategyBoard);
                cSt1.setByX(-0.1);
                cSt1.setByY(-0.1);
                TranslateTransition cTt1 = new TranslateTransition(Duration.millis(500),birthdayStrategyBoard);
                cTt1.setByX(-20);
                cTt1.setByY(15);
                FadeTransition cFtO = new FadeTransition(Duration.millis(500),birthdayStrategyText);
                cFtO.setFromValue(0);
                cFtO.setToValue(1);
                FadeTransition cFtI = new FadeTransition(Duration.millis(500),birthdayStrategyInfoBoard);
                cFtI.setByValue(-1);

                ScaleTransition cFt2 = new ScaleTransition(Duration.millis(500),roomNumStrategyBoard);
                cFt2.setByX(0.1);
                cFt2.setByY(0.1);
                TranslateTransition cTt2 = new TranslateTransition(Duration.millis(500),roomNumStrategyBoard);
                cTt2.setByX(-20);
                cTt2.setByY(15);

                ScaleTransition cSt3 = new ScaleTransition(Duration.millis(500),dateStrategyBoard);
                cSt3.setByX(0.1);
                cSt3.setByY(0.1);
                TranslateTransition cTt3 = new TranslateTransition(Duration.millis(500),dateStrategyBoard);
                cTt3.setByX(20);
                cTt3.setByY(15);

                ScaleTransition cSt4 = new ScaleTransition(Duration.millis(500),enterpriseStrategyBoard);
                cSt4.setByX(0.1);
                cSt4.setByY(0.1);
                TranslateTransition cTt4 = new TranslateTransition(Duration.millis(500),enterpriseStrategyBoard);
                cTt4.setByX(-20);
                cTt4.setByY(-15);

                ParallelTransition cPt = new ParallelTransition();
                cPt.getChildren().addAll(cSt1,cFt2,cSt3,cSt4,cTt1,cTt2,cTt3,cTt4,cFtO,cFtI);
                cPt.play();

                birthdayStrategyBoard.getChildren().remove(birthdayStrategyInfoBoard);
                birthdayStrategyBoard.resize(400,300);
                roomNumStrategyBoard.resize(400,300);
                dateStrategyBoard.resize(400,300);
                enterpriseStrategyBoard.resize(400,300);
            });
        });

        enterpriseStrategyBoard.setOnMouseClicked(event -> {
            if(!enterpriseStrategyBoard.getChildren().contains(enterpriseStrategyText)){return;}

            GridPane enterpriseStrategyInfoBoard = new GridPane();

            Label nameLabel = new Label("活动名称：");
            Label oriLabel = new Label("开始日期：");
            Label endLabel = new Label("结束日期：");
            Label discountLabel = new Label("折扣率：");
            Label enterLabel = new Label("企业名称：");

            Text nameField = new Text("会员企业优惠");
            DatePicker oriField = new DatePicker();
            DatePicker endField = new DatePicker();
            TextField discountField = new TextField();
            TextField enterField = new TextField();
            Button confirm = new Button("确定");
            Button cancel = new Button("取消");

            enterpriseStrategyInfoBoard.add(nameLabel,0,0);
            enterpriseStrategyInfoBoard.add(oriLabel,0,1);
            enterpriseStrategyInfoBoard.add(endLabel,0,2);
            enterpriseStrategyInfoBoard.add(discountLabel,0,3);
            enterpriseStrategyInfoBoard.add(nameField,1,0);
            enterpriseStrategyInfoBoard.add(oriField,1,1);
            enterpriseStrategyInfoBoard.add(endField,1,2);
            enterpriseStrategyInfoBoard.add(discountField,1,3);
            enterpriseStrategyInfoBoard.add(enterLabel,0,4);
            enterpriseStrategyInfoBoard.add(enterField,1,4);
            enterpriseStrategyInfoBoard.add(confirm,0,5);
            enterpriseStrategyInfoBoard.add(cancel,1,5);

            enterpriseStrategyInfoBoard.setAlignment(Pos.CENTER_LEFT);
            enterpriseStrategyInfoBoard.setVgap(20);
            enterpriseStrategyInfoBoard.setHgap(10);
            enterpriseStrategyBoard.getChildren().add(enterpriseStrategyInfoBoard);

            ScaleTransition st1 = new ScaleTransition(Duration.millis(500),enterpriseStrategyBoard);
            st1.setByX(0.1);
            st1.setByY(0.1);
            TranslateTransition tt1 = new TranslateTransition(Duration.millis(500),enterpriseStrategyBoard);
            tt1.setByX(-20);
            tt1.setByY(-15);
            FadeTransition ftO = new FadeTransition(Duration.millis(500),enterpriseStrategyText);
            ftO.setByValue(-1);
            FadeTransition ftI = new FadeTransition(Duration.millis(500),enterpriseStrategyInfoBoard);
            ftI.setFromValue(0);
            ftI.setToValue(1);

            ScaleTransition st2 = new ScaleTransition(Duration.millis(500),dateStrategyBoard);
            st2.setByX(-0.1);
            st2.setByY(-0.1);
            TranslateTransition tt2 = new TranslateTransition(Duration.millis(500),dateStrategyBoard);
            tt2.setByX(-20);
            tt2.setByY(-15);

            ScaleTransition st3 = new ScaleTransition(Duration.millis(500),birthdayStrategyBoard);
            st3.setByX(-0.1);
            st3.setByY(-0.1);
            TranslateTransition tt3 = new TranslateTransition(Duration.millis(500),birthdayStrategyBoard);
            tt3.setByX(-20);
            tt3.setByY(15);

            ScaleTransition st4 = new ScaleTransition(Duration.millis(500),roomNumStrategyBoard);
            st4.setByX(-0.1);
            st4.setByY(-0.1);
            TranslateTransition tt4 = new TranslateTransition(Duration.millis(500),roomNumStrategyBoard);
            tt4.setByX(20);
            tt4.setByY(-15);

            ParallelTransition pt = new ParallelTransition();
            pt.getChildren().addAll(st1,st2,st3,st4,tt1,tt2,tt3,tt4,ftO,ftI);
            pt.play();

            enterpriseStrategyBoard.getChildren().removeAll(enterpriseStrategyText);
            enterpriseStrategyBoard.resize(500,375);
            dateStrategyBoard.resize(320,240);
            birthdayStrategyBoard.resize(320,240);
            roomNumStrategyBoard.resize(320,240);

            confirm.setOnMouseClicked(event1 -> {
                String oriDate = oriField.getValue().toString();
                String endDate = endField.getValue().toString();
                String discount = discountField.getText();
                String enterpriseName = enterField.getText();

                StrategyVO strategy=new StrategyVO(MainUI.userID,"合作企业优惠策略",Double.parseDouble(discount),oriDate.substring(0, 4)+oriDate.substring(5,7)+oriDate.substring(8,10),endDate.substring(0, 4)+endDate.substring(5,7)+endDate.substring(8,10));
                try {
					strategyService.setEnterpriseByHotel(strategy, enterpriseName);
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
                sucBox.setStyle("-fx-background-color: rgba(255,255,255,0.5);");
                enterpriseStrategyInfoBoard.add(sucBox,0,2,2,2);

                FadeTransition fFt1 = new FadeTransition(Duration.millis(1000),sucBox);
                fFt1.setFromValue(0);fFt1.setToValue(1);
                fFt1.play();
                FadeTransition fFt2 = new FadeTransition(Duration.millis(1000),sucBox);
                fFt2.setByValue(-1);
                fFt2.setDelay(Duration.millis(3000));
                fFt2.play();

                if(sucBox.getOpacity()==0){enterpriseStrategyInfoBoard.getChildren().remove(sucBox);}
            });

            cancel.setOnMouseClicked(event1 -> {

                enterpriseStrategyBoard.getChildren().add(enterpriseStrategyText);

                ScaleTransition cSt1 = new ScaleTransition(Duration.millis(500),enterpriseStrategyBoard);
                cSt1.setByX(-0.1);
                cSt1.setByY(-0.1);
                TranslateTransition cTt1 = new TranslateTransition(Duration.millis(500),enterpriseStrategyBoard);
                cTt1.setByX(20);
                cTt1.setByY(15);
                FadeTransition cFtO = new FadeTransition(Duration.millis(500),enterpriseStrategyText);
                cFtO.setFromValue(0);
                cFtO.setToValue(1);
                FadeTransition cFtI = new FadeTransition(Duration.millis(500),enterpriseStrategyInfoBoard);
                cFtI.setByValue(-1);

                ScaleTransition cFt2 = new ScaleTransition(Duration.millis(500),dateStrategyBoard);
                cFt2.setByX(0.1);
                cFt2.setByY(0.1);
                TranslateTransition cTt2 = new TranslateTransition(Duration.millis(500),dateStrategyBoard);
                cTt2.setByX(20);
                cTt2.setByY(15);

                ScaleTransition cSt3 = new ScaleTransition(Duration.millis(500),birthdayStrategyBoard);
                cSt3.setByX(0.1);
                cSt3.setByY(0.1);
                TranslateTransition cTt3 = new TranslateTransition(Duration.millis(500),birthdayStrategyBoard);
                cTt3.setByX(20);
                cTt3.setByY(-15);

                ScaleTransition cSt4 = new ScaleTransition(Duration.millis(500),roomNumStrategyBoard);
                cSt4.setByX(0.1);
                cSt4.setByY(0.1);
                TranslateTransition cTt4 = new TranslateTransition(Duration.millis(500),roomNumStrategyBoard);
                cTt4.setByX(-20);
                cTt4.setByY(15);

                ParallelTransition cPt = new ParallelTransition();
                cPt.getChildren().addAll(cSt1,cFt2,cSt3,cSt4,cTt1,cTt2,cTt3,cTt4,cFtO,cFtI);
                cPt.play();

                enterpriseStrategyBoard.getChildren().remove(enterpriseStrategyInfoBoard);
                enterpriseStrategyBoard.resize(400,300);
                dateStrategyBoard.resize(400,300);
                birthdayStrategyBoard.resize(400,300);
                roomNumStrategyBoard.resize(400,300);
            });
        });

    }
}
