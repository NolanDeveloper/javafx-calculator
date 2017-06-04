package com.nolan.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class MainController extends GridPane implements Initializable {
    @FXML private Button btnClean;
    @FXML private Button btnDivide;
    @FXML private Button btnMultiply;
    @FXML private Button btnSubtract;
    @FXML private Button btnAdd;
    @FXML private Button btnEquals;
    @FXML private Button btnZero;
    @FXML private Button btnOne;
    @FXML private Button btnTwo;
    @FXML private Button btnThree;
    @FXML private Button btnFour;
    @FXML private Button btnFive;
    @FXML private Button btnSix;
    @FXML private Button btnSeven;
    @FXML private Button btnEight;
    @FXML private Button btnNine;
    @FXML private Button btnDot;
    @FXML private Label lblMain;
    @FXML private Label lblHelper;
    
    private Arithmetic arithmetic = new Arithmetic();
    
    public MainController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblMain.textProperty().bind(arithmetic.mainText);
        lblHelper.textProperty().bind(arithmetic.helperText);
    }
    
    @FXML
    private void onKeyPressed(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        if (keyCode.isDigitKey()) {
            int digit = Integer.parseInt(event.getText());
            arithmetic.clickNumber(digit);
        } else {
            String pressedKey = event.getText();
            if ("+".equals(pressedKey)) {
                arithmetic.clickOperation(Arithmetic.Operation.ADD);
            } else if ("-".equals(pressedKey)) {
                arithmetic.clickOperation(Arithmetic.Operation.SUB);
            } else if ("*".equals(pressedKey)) {
                arithmetic.clickOperation(Arithmetic.Operation.MUL);
            } else if ("/".equals(pressedKey)) {
                arithmetic.clickOperation(Arithmetic.Operation.DIV);
            } else if ("=".equals(pressedKey) || KeyCode.ENTER == keyCode) {
                arithmetic.clickEquals();
            } else if (KeyCode.BACK_SPACE == keyCode) {
                arithmetic.removeLast();
            }
        }
    }
    
    @FXML
    private void onClean() {
        arithmetic.clean();
    }
    
    @FXML
    private void onNumber(Event event) {
        Button button = (Button) event.getSource();
        int digit = Integer.parseInt(button.getText());
        arithmetic.clickNumber(digit);
    }
    
    @FXML
    private void onDot() {
        arithmetic.clickDot();
    }
    
    @FXML
    private void onOperation(Event event) {
        Object source = event.getSource();
        Arithmetic.Operation operation;
        if (btnAdd == source) {
            operation = Arithmetic.Operation.ADD;
        } else if (btnSubtract == source) {
            operation = Arithmetic.Operation.SUB;
        } else if (btnMultiply == source) {
            operation = Arithmetic.Operation.MUL;
        } else if (btnDivide == source) {
            operation = Arithmetic.Operation.DIV;
        } else {
            throw new RuntimeException("Unknown operation");
        }
        arithmetic.clickOperation(operation);
    }
    
    @FXML
    private void onEquals() {
        arithmetic.clickEquals();
    }
}
