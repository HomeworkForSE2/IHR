package code;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class orderController {
    @FXML private Text hotelName;
    @FXML private DatePicker staDate;
    @FXML private DatePicker endDate;
    @FXML private ChoiceBox<String> roomType;
    @FXML private ChoiceBox<String> roomNum;
    @FXML private TextField peoNum;
    @FXML private CheckBox hasChildren;

    public void init(String name){
        hotelName.setText(name);
    }

    @FXML private void order(){
        String startDate = staDate.getValue().toString();
        String enDate = endDate.getValue().toString();
        String romType = roomType.getSelectionModel().getSelectedItem();
        int romNum = Integer.parseInt(roomNum.getSelectionModel().getSelectedItem());
        int peopleNum = Integer.parseInt(peoNum.getText());
        Boolean hasChild = hasChildren.isSelected();

        //参数！！！！！！！！！！！！！！！！！！
    }

}
