package code;

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
import service.HotelInfoService;
import service.HotelManageService;
import service.MemberService;
import service.UserInfoService;
import service.UserManageService;
import serviceImpl.HotelInfoServiceImpl;
import serviceImpl.HotelManageServiceImpl;
import serviceImpl.MemberServiceImpl;
import serviceImpl.UserInfoServiceImpl;
import serviceImpl.UserManageServiceImpl;
import vo.HotelInfoVO;
import vo.UserInfoVO;

import java.io.IOException;
import java.time.LocalDate;

public class adminController {
    @FXML private GridPane root;
    @FXML private VBox small;
    @FXML private HBox swap;
    private VBox slideBar;
    
    private HotelManageService hotelManageService;
    private UserManageService userManageService;
    private MemberService memberService;
    private UserInfoService userInfoService;
    private HotelInfoService hotelInfoService;
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
        Text hotelManage = new Text("酒店操作");
        Text erManage = new Text("用户操作");
        Button logOut = new Button("退出登录");

        hotelManage.setOnMouseClicked(event -> toManageHotel());
        erManage.setOnMouseClicked(event -> toManageEr());
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
        slideBar.getChildren().addAll(backBox,head,welcome,name,hotelManage,erManage,logOut);

        root.getChildren().remove(small);
        root.add(slideBar,0,0,1,2);
    }

    private void toManageHotel(){
        swap.getChildren().remove(0);

        GridPane table = new GridPane();
        table.setAlignment(Pos.CENTER);

        table.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
        table.setMaxHeight(600);
        table.setPrefWidth(600);

        VBox zeroZero = new VBox();
        Label nameLabel = new Label("酒店名称：");
        zeroZero.setPrefSize(200,80);
        zeroZero.setAlignment(Pos.CENTER);
        zeroZero.getChildren().add(nameLabel);
        table.add(zeroZero,0,0);

        VBox zeroOne = new VBox();
        TextField nameField = new TextField();
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
        TextField addressField = new TextField();
        oneOne.getChildren().add(addressField);
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
        TextField circleField = new TextField();
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
        TextField starField = new TextField();
        threeOne.getChildren().add(starField);
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
        TextArea serviceField = new TextArea();
        serviceField.setWrapText(true);
        serviceField.setStyle("-fx-line-spacing:0.5em;");
        fourOne.getChildren().add(serviceField);
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
        TextArea introField = new TextArea();
        introField.setWrapText(true);
        introField.setStyle("-fx-line-spacing: 0.5em;");
        ScrollPane sp = new ScrollPane(introField);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setPadding(new Insets(0,5,0,0));
        fiveOne.getChildren().add(sp);
        fiveOne.setPrefSize(400,120);
        fiveOne.setPadding(new Insets(20,15,20,20));
        fiveOne.setAlignment(Pos.CENTER_LEFT);
        fiveOne.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(fiveOne,1,5,2,1);

        VBox  sixZero = new VBox();
        Label  workerLabel = new Label("工作人员：");
        sixZero.getChildren().addAll(workerLabel);
        sixZero.setAlignment(Pos.CENTER);
        sixZero.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(sixZero,0,6);

        HBox sixOne = new HBox();
        TextField workerNameField = new TextField();
        workerNameField.setPromptText("userName");
        TextField keyField = new TextField();
        keyField.setPromptText("Password");
        sixOne.getChildren().addAll(workerNameField,keyField);
        sixOne.setPrefSize(180,80);
        sixOne.setAlignment(Pos.CENTER);
        sixOne.setSpacing(20);
        table.add(sixOne,1,6,2,1);

        VBox sevenOne = new VBox();
        Text change  = new Text("添加");
        sevenOne.getChildren().add(change);
        sevenOne.setPrefSize(200,80);
        sevenOne.setAlignment(Pos.CENTER);
        sevenOne.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
        table.add(sevenOne,1,7);
        hotelManageService=new HotelManageServiceImpl();
        sevenOne.setOnMouseClicked(event -> {
            String hotelName = nameField.getText();
            String workerName  = workerNameField.getText();
            String password = keyField.getText();
            String address = addressField.getText();
            String circle = circleField.getText();
            String stars = starField.getText();
            String service = serviceField.getText();
            String introduce = introField.getText();
            HotelInfoVO hotel=new HotelInfoVO(0, hotelName, address, circle, Integer.parseInt(stars), introduce, service, 0);
            UserInfoVO user=new UserInfoVO(0, workerName, password, "0", 0);
            try {
				hotelManageService.addHotel(hotel);
				hotelManageService.addHotelworker(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            //传参!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            toManageHotel();
        });

        DropShadow ds = new DropShadow();
        ds.setColor(Color.color(0,0,0,0.5));
        ds.setOffsetX(4);
        ds.setOffsetY(4);
        table.setEffect(ds);

        swap.getChildren().add(table);
    }

    private void toManageEr(){
        swap.getChildren().remove(0);

        GridPane table = new GridPane();
        table.setAlignment(Pos.CENTER);
        swap.getChildren().addAll(table);

        TextField searchField = new TextField();
        table.add(searchField,0,0);

        Button searchBtn = new Button("搜索");
        table.add(searchBtn,1,0);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        table.add(hBox,0,1);
        hBox.getChildren().addAll(new HBox());

        Button addBtn = new Button("add");
        table.add(addBtn,1,1);

        userManageService=new UserManageServiceImpl();
        addBtn.setOnMouseClicked(event -> {
            HBox container = new HBox();
            container.setAlignment(Pos.CENTER);
            container.setPrefSize(400,300);
            container.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
            DropShadow ds = new DropShadow();
            ds.setColor(Color.color(0,0,0,0.5));
            ds.setOffsetX(4);
            ds.setOffsetY(4);
            container.setEffect(ds);
            hBox.getChildren().remove(0);
            hBox.getChildren().add(container);

            GridPane infoBoard = new GridPane();
            infoBoard.setVgap(20);
            infoBoard.setHgap(10);
            infoBoard.setAlignment(Pos.CENTER);
            container.getChildren().addAll(infoBoard);

            Label nameLabel = new Label("姓名：");
            Label passwordLabel = new Label("密码：");
            TextField nameField = new TextField();
            TextField passwordField = new TextField();
            Button ok = new Button("add");

            infoBoard.add(nameLabel,0,0);
            infoBoard.add(passwordLabel,0,1);
            infoBoard.add(nameField,1,0);
            infoBoard.add(passwordField,1,1);
            infoBoard.add(ok,1,2);

            ok.setOnMouseClicked(event1 -> {
                String name = nameField.getText();
                String password = passwordField.getText();

                //传参!!!!!!!!!!!!!!!!!!!!1
                //添加营销人员
                UserInfoVO websiteWorker=new UserInfoVO(0,name,password,"0",0);
                try {
					boolean result=userManageService.addWebsiteWorker(websiteWorker);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                toManageEr();
            });
        });


        memberService=new MemberServiceImpl();
        userInfoService=new UserInfoServiceImpl();
        hotelInfoService=new HotelInfoServiceImpl();
        searchBtn.setOnMouseClicked(event -> {
            String searchValue = searchField.getText();
            //搜索值
            UserInfoVO user = null;
            try {
				user=userManageService.showUserInfo(searchValue);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            if(user==null){
            	System.out.println("!");
            	return;
            }

            String type = user.getUserType();
            //搜索到的人员类型

            if(type.equals("用户")){
            	
                String name = user.getUserName();
                String birthday=null;
				try {
					birthday = memberService.getMember(user.getUserID()).getBirthday();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                String enterprise=null;
				try {
					enterprise = memberService.getMember(user.getUserID()).getEnterpriseName();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                String credit = user.getCredit()+"CP";
                String phone = user.getPhoneNumber();

                String typeInfo;
                String type2;
                if(birthday == null){
                    type2 = "企业用户";
                    typeInfo = enterprise;
                }else{
                    type2 = "普通用户";
                    typeInfo = birthday;
                }

                GridPane userBoard = new GridPane();
                userBoard.setAlignment(Pos.CENTER);
                userBoard.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
                userBoard.setMaxHeight(400);
                userBoard.setPrefWidth(720);
                hBox.getChildren().remove(0);
                hBox.getChildren().addAll(userBoard);

                VBox zeroZero = new VBox();
                Label nameLabel = new Label("姓名：");
                zeroZero.setPrefSize(120,100);
                zeroZero.setAlignment(Pos.CENTER);
                zeroZero.getChildren().add(nameLabel);
                userBoard.add(zeroZero,0,0,1,1);

                VBox zeroOne = new VBox();
                Text nameField = new Text();
                nameField.setText(name);
                zeroOne.getChildren().add(nameField);
                zeroOne.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                zeroOne.setPrefSize(240,100);
                zeroOne.setAlignment(Pos.CENTER);
                userBoard.add(zeroOne,1,0,2,1);

                VBox zeroThree = new VBox();
                Label typeLabel = new Label("账户类型：");
                zeroThree.getChildren().add(typeLabel);
                zeroThree.setPrefSize(120,100);
                zeroThree.setAlignment(Pos.CENTER);
                zeroThree.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                userBoard.add(zeroThree,3,0,1,1);

                VBox zeroFour = new VBox();
                Text typeField = new Text();
                typeField.setText(type2);
                zeroFour.getChildren().add(typeField);
                zeroFour.setPrefSize(240,100);
                zeroFour.setAlignment(Pos.CENTER);
                userBoard.add(zeroFour,4,0,2,1);

                VBox oneZero = new VBox();
                Label typeInfoLabel = new Label();
                if(type2.equals("企业用户")){
                    typeInfoLabel.setText("我的企业：");
                }else{
                    typeInfoLabel.setText("我的生日：");
                }
                oneZero.getChildren().add(typeInfoLabel);
                oneZero.setPrefSize(120,100);
                oneZero.setAlignment(Pos.CENTER);
                oneZero.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                userBoard.add(oneZero,0,1,1,1);

                VBox oneOne = new VBox();
                Text typeInfoField = new Text();
                typeInfoField.setText(typeInfo);
                oneOne.getChildren().add(typeInfoField);
                oneOne.setPrefSize(600,100);
                oneOne.setAlignment(Pos.CENTER);
                oneOne.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                userBoard.add(oneOne,1,1,5,1);

                VBox twoZero = new VBox();
                Label creditLabel = new Label("信用值：");
                twoZero.getChildren().add(creditLabel);
                twoZero.setPrefSize(120,100);
                twoZero.setAlignment(Pos.CENTER);
                twoZero.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                userBoard.add(twoZero,0,2,1,1);

                VBox twoOne = new VBox();
                Text creditField = new Text();
                creditField.setText(credit);
                twoOne.getChildren().add(creditField);
                twoOne.setPrefSize(240,100);
                twoOne.setAlignment(Pos.CENTER);
                twoOne.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                userBoard.add(twoOne,1,2,2,1);

                VBox twoThree = new VBox();
                Label phoneLabel = new Label("联系方式：");
                twoThree.getChildren().addAll(phoneLabel);
                twoThree.setPrefSize(120,100);
                twoThree.setAlignment(Pos.CENTER);
                userBoard.add(twoThree,3,2,1,1);

                VBox twoFour = new VBox();
                Text phoneField = new Text();
                phoneField.setText(phone);
                twoFour.getChildren().add(phoneField);
                twoFour.setPrefSize(240,100);
                twoFour.setAlignment(Pos.CENTER);
                twoFour.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                userBoard.add(twoFour,4,2,2,1);

                VBox threeZero = new VBox();
                Text creditRecord = new Text("确认");
                threeZero.getChildren().add(creditRecord);
                threeZero.setPrefSize(240,100);
                threeZero.setAlignment(Pos.CENTER);
                userBoard.add(threeZero,0,3,2,1);

                VBox threeTwo = new VBox();
                Text hotelRecord  = new Text("修改");
                threeTwo.getChildren().add(hotelRecord);
                threeTwo.setPrefSize(240,100);
                threeTwo.setAlignment(Pos.CENTER);
                threeTwo.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                userBoard.add(threeTwo,2,3,2,1);

                VBox threeFour = new VBox();
                Text orderInfo = new Text("取消");
                threeFour.getChildren().add(orderInfo);
                threeFour.setPrefSize(240,100);
                threeFour.setAlignment(Pos.CENTER);
                userBoard.add(threeFour,4,3,2,1);
                threeFour.setOnMouseClicked(event3 -> toManageEr());

                threeTwo.setOnMouseClicked(event2 -> {
                    oneOne.getChildren().remove(0);
                    twoFour.getChildren().remove(0);

                    TextField enterpriseNameField = new TextField();
                    DatePicker birthdayField = new DatePicker();

                    if(type2.equals("企业用户")){
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
                    	UserInfoVO user2=null;
                    	try {
							user2=userManageService.showUserInfo(name);
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
                        String newBirthday = null;
                        String newEnterprise = null;
                        String newPhone;

                        if(type2.equals("企业用户")){
                            newEnterprise = enterpriseNameField.getText();
                        }else{
                            newBirthday = birthdayField.getValue().toString();
                        }
                        newPhone = newPhoneField.getText();
                        //在此更新数据
                        UserInfoVO newUser=new UserInfoVO(user2.getUserID(),user2.getUserName(),user2.getPassword(),newPhone,user2.getCredit());
              
                        try {
							userInfoService.modifyUserInfo(newUser);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        
                        int userID=user2.getUserID();
        				try {
        					memberService.memberUpdate(userID, newBirthday, newEnterprise);
        				} catch (Exception e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}

                        //更新数据之后
                        toManageEr();
                    });
                });
            }else if(type.equals("酒店工作人员")){
                hBox.getChildren().remove(0);

                //传参！！！！！！！！！！！！！！
                String name = user.getUserName();
                String password = user.getPassword();
                String hotel=null;
				try {
					hotel = hotelInfoService.findHotel(user.getUserID()).getHotelName();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

                GridPane hotelWorkerBoard = new GridPane();
                hotelWorkerBoard.setAlignment(Pos.CENTER);
                hotelWorkerBoard.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
                hotelWorkerBoard.setPrefHeight(300);
                hotelWorkerBoard.setPrefWidth(300);
                hBox.getChildren().add(hotelWorkerBoard);

                HBox nameBox = new HBox();
                nameBox.setPrefSize(100,100);
                nameBox.setAlignment(Pos.CENTER);
                nameBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                hotelWorkerBoard.add(nameBox,0,0);
                Label nameLabel = new Label("姓名：");
                nameBox.getChildren().addAll(nameLabel);

                HBox nameTextBox = new HBox();
                nameTextBox.setAlignment(Pos.CENTER);
                nameTextBox.setPrefSize(200,100);
                nameTextBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                hotelWorkerBoard.add(nameTextBox,1,0);
                Text nameText = new Text(name);
                nameTextBox.getChildren().addAll(nameText);

                HBox keyBox = new HBox();
                keyBox.setPrefSize(100,100);
                keyBox.setAlignment(Pos.CENTER);
                keyBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                hotelWorkerBoard.add(keyBox,0,1);
                Label keyLabel = new Label("密码：");
                keyBox.getChildren().addAll(keyLabel);

                HBox keyTextBox = new HBox();
                keyTextBox.setAlignment(Pos.CENTER);
                keyTextBox.setPrefSize(200,100);
                keyTextBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                hotelWorkerBoard.add(keyTextBox,1,1);
                Text keyText = new Text(password);
                keyTextBox.getChildren().addAll(keyText);

                HBox hNameBox = new HBox();
                hNameBox.setPrefSize(100,100);
                hNameBox.setAlignment(Pos.CENTER);
                hNameBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                hotelWorkerBoard.add(hNameBox,0,2);
                Label hNameLabel = new Label("隶属酒店：");
                hNameBox.getChildren().addAll(hNameLabel);

                HBox hotelTextBox = new HBox();
                hotelTextBox.setAlignment(Pos.CENTER);
                hotelTextBox.setPrefSize(200,100);
                hotelTextBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                hotelWorkerBoard.add(hotelTextBox,1,2);
                Text hotelText = new Text(hotel);
                hotelTextBox.getChildren().addAll(hotelText);

                HBox btnBox = new HBox();
                btnBox.setAlignment(Pos.CENTER);
                btnBox.setPrefSize(200,50);
                btnBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                hotelWorkerBoard.add(btnBox,1,3);
                Button changeBtn = new Button("修改");
                btnBox.getChildren().addAll(changeBtn);

                Button cancel = new Button("取消");
                hotelWorkerBoard.add(cancel,0,3);

                cancel.setOnMouseClicked(event1 -> toManageEr());

                changeBtn.setOnMouseClicked(event1 -> {
                	UserInfoVO user3=null;
                	try {
						user3=userManageService.showUserInfo(name);
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
                	String hotel2=null;
                	try {
						hotel2=hotelInfoService.findHotel(user3.getUserID()).getHotelName();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    TextField nameField = new TextField();
                    nameField.setText(name);
                    nameTextBox.getChildren().remove(0);
                    nameTextBox.getChildren().addAll(nameField);

                    TextField keyField = new TextField();
                    keyField.setText(password);
                    keyTextBox.getChildren().remove(0);
                    keyTextBox.getChildren().addAll(keyField);

                    TextField hotelField = new TextField();
                    hotelField.setText(hotel2);
                    hotelTextBox.getChildren().remove(0);
                    hotelTextBox.getChildren().addAll(hotelField);

                    Button submitBtn = new Button("确认");
                    btnBox.getChildren().remove(0);
                    btnBox.getChildren().addAll(submitBtn);
                    submitBtn.setOnMouseClicked(event2 -> {
                        String newName = nameField.getText();
                        String newPassword = keyField.getText();
                        String newHotel = hotelField.getText();
                        //修改后的值传递回去
                        
                        UserInfoVO user4=null;
                    	try {
    						user4=userManageService.showUserInfo(name);
    					} catch (Exception e2) {
    						// TODO Auto-generated catch block
    						e2.printStackTrace();
    					}
                        try {
							userInfoService.modifyUserInfo(new UserInfoVO(user4.getUserID(), user4.getUserName(), newPassword, user4.getPhoneNumber(), 0));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        toManageEr();
                    });
                });
            }else{
                hBox.getChildren().remove(0);

                //传参！！！！！！！！！！！！！！
                String name = user.getUserName();
                String password = user.getPassword();

                GridPane hotelWorkerBoard = new GridPane();
                hotelWorkerBoard.setAlignment(Pos.CENTER);
                hotelWorkerBoard.setStyle("-fx-background-color: #595959;-fx-border-radius: 20px;-fx-background-radius: 20px;");
                hotelWorkerBoard.setPrefHeight(300);
                hotelWorkerBoard.setPrefWidth(300);
                hBox.getChildren().add(hotelWorkerBoard);

                HBox nameBox = new HBox();
                nameBox.setPrefSize(100,100);
                nameBox.setAlignment(Pos.CENTER);
                nameBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                hotelWorkerBoard.add(nameBox,0,0);
                Label nameLabel = new Label("姓名：");
                nameBox.getChildren().addAll(nameLabel);

                HBox nameTextBox = new HBox();
                nameTextBox.setAlignment(Pos.CENTER);
                nameTextBox.setPrefSize(200,100);
                nameTextBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                hotelWorkerBoard.add(nameTextBox,1,0);
                Text nameText = new Text(name);
                nameTextBox.getChildren().addAll(nameText);

                HBox keyBox = new HBox();
                keyBox.setPrefSize(100,100);
                keyBox.setAlignment(Pos.CENTER);
                keyBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                hotelWorkerBoard.add(keyBox,0,1);
                Label keyLabel = new Label("密码：");
                keyBox.getChildren().addAll(keyLabel);

                HBox keyTextBox = new HBox();
                keyTextBox.setAlignment(Pos.CENTER);
                keyTextBox.setPrefSize(200,100);
                keyTextBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                hotelWorkerBoard.add(keyTextBox,1,1);
                Text keyText = new Text(password);
                keyTextBox.getChildren().addAll(keyText);

                HBox btnBox = new HBox();
                btnBox.setAlignment(Pos.CENTER);
                btnBox.setPrefSize(200,50);
                btnBox.setStyle("-fx-border-width: 1px;-fx-border-color: #6a7070;-fx-border-style: solid;");
                hotelWorkerBoard.add(btnBox,1,3);
                Button changeBtn = new Button("修改");
                btnBox.getChildren().addAll(changeBtn);

                Button cancel = new Button("取消");
                hotelWorkerBoard.add(cancel,0,3);

                cancel.setOnMouseClicked(event1 -> toManageEr());

                changeBtn.setOnMouseClicked(event1 -> {

                    TextField nameField = new TextField();
                    nameField.setText(name);
                    nameTextBox.getChildren().remove(0);
                    nameTextBox.getChildren().addAll(nameField);

                    TextField keyField = new TextField();
                    keyField.setText(password);
                    keyTextBox.getChildren().remove(0);
                    keyTextBox.getChildren().addAll(keyField);

                    Button submitBtn = new Button("确认");
                    btnBox.getChildren().remove(0);
                    btnBox.getChildren().addAll(submitBtn);
                    submitBtn.setOnMouseClicked(event2 -> {
                        String newName = nameField.getText();
                        String newPassword = keyField.getText();
                        //修改后的值传递回去
                        UserInfoVO user4=null;
                    	try {
    						user4=userManageService.showUserInfo(name);
    					} catch (Exception e2) {
    						// TODO Auto-generated catch block
    						e2.printStackTrace();
    					}
                        try {
							userInfoService.modifyUserInfo(new UserInfoVO(user4.getUserID(), user4.getUserName(), newPassword, user4.getPhoneNumber(), 0));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        toManageEr();
                    });
                });
            }
        });
    }

}
