package com.solovev.calculatorfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.function.BiFunction;

public class MainController {
    @FXML
    public TextField textFieldInput1;
    @FXML
    public TextField textFieldOperation;
    @FXML
    public TextField textFieldInput2;
    @FXML
    public TextField textFieldResult;
    @FXML
    public Label labelWarningText;
    private final String boundaries = String.format("%s from: %s to %s", Double.class.getSimpleName(), Double.MIN_VALUE, Double.MAX_VALUE);
    @FXML
    public void initialize(){
        String boundaries = String.format("%s from: %s to %s", Double.class.getSimpleName(), Double.MIN_VALUE, Double.MAX_VALUE);
        labelWarningText.setText(labelWarningText.getText() + boundaries);
    }

    /**
     * Method performs given operation to the inputs, writes result to result, and operation sign to OperationFiled
     *
     * @param function     function to perform
     * @param functionSign sign of the function
     */
    private void operation(BiFunction<Double, Double, Double> function, String functionSign) {
        try {
            Double input1 = Double.parseDouble(textFieldInput1.getText());
            Double input2 = Double.parseDouble(textFieldInput2.getText());
            textFieldResult.setText(function.apply(input1, input2).toString());
            textFieldOperation.setText(functionSign);
        } catch (NumberFormatException e){
            Alert formatAlert = new Alert(Alert.AlertType.ERROR);
            formatAlert.setHeaderText("Wrong format");
            formatAlert.setContentText("Supports only numbers " + boundaries);
            formatAlert.show();
        }
    }

    @FXML
    public void buttonPlus(ActionEvent actionEvent) {
        operation(Double::sum, "+");
    }

    @FXML
    public void buttonMinus(ActionEvent actionEvent) {
        operation((i, k) -> i - k, "-");
    }

    @FXML
    public void buttonMultiply(ActionEvent actionEvent) {
        operation((i, k) -> i * k, "x");
    }

    @FXML
    public void buttonDivide(ActionEvent actionEvent) {
        operation((i, k) -> i / k, "/");
    }

}
