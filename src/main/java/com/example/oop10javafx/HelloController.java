package com.example.oop10javafx;

import com.example.oop10javafx.integral.MainCalculator;
import com.example.oop10javafx.integral.MyPair;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Pair;


public class HelloController {
    @FXML
    private Label calculatedIntervalValue;
    @FXML
    private Label calculatedTimeValue;
    @FXML
    private TextField intervalsCount;
    @FXML
    private TextField threadsCount;

    @FXML
    public void clickAction() {
        MainCalculator mainCalculator = new MainCalculator();

        MyPair response = mainCalculator.calculateAll(Integer.parseInt(intervalsCount.getText()), Integer.parseInt(threadsCount.getText()));

        calculatedIntervalValue.setText(String.valueOf(response.result()));
        calculatedTimeValue.setText(String.valueOf(response.time()));
    }
}