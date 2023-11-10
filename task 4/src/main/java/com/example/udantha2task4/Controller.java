package com.example.udantha2task4;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

import java.util.Collections;
import java.util.List;
import java.util.Queue;

import static com.example.udantha2task4.FoodQueue.getOccupiedCount;

public class Controller {

    Controller controller;
    Main main;


    @FXML
    private TextField customerAddCashierNumber,customerAddFirstname,customerAddLastname,
            customerAddBurgers,burgerQuantity,cashierNumber,removePosition,
            removeServedCashierNumber,searchCustomer;
    @FXML
    private Button customerAddButton;
    @FXML
    private Label cashier1cus1,cashier1cus2,cashier2cus1,cashier2cus2,
            cashier2cus3,cashier3cus1,cashier3cus2,cashier3cus3,cashier3cus4,
            cashier3cus5,burgerStockText,burgerStock,customersCount,income;

    @FXML
    private TableView<ObservableList<String>> tableView;
    @FXML
    private TableColumn<ObservableList<String>, String> tableFirstName;
    @FXML
    private TableColumn<ObservableList<String>, String> tableLastName;
    @FXML
    private TableColumn<ObservableList<String>, String> tableBurgers;

    @FXML
    void clearTable() {
        ObservableList<ObservableList<String>> data = tableView.getItems();
        data.clear();
    }

    @FXML
    void initialize() {

        main = new Main();
        updateUI();

    }

    @FXML
    private void customerAddButton() {

        controller = new Controller();
        main = new Main();

        if(customerAddFirstname.getText().isEmpty() || customerAddLastname.getText().isEmpty() || customerAddBurgers.getText().isEmpty()){
            controller.message("Please fill the all fields!", "error");
        }else if(!customerAddBurgers.getText().matches("-?\\d+")){
            controller.message("Please try again!", "error");
        } else if(main.getBurgers() < Integer.parseInt(customerAddBurgers.getText())){
            controller.message("Not so much burgers.!", "info");
        } else{

                if(main.getCashier1().size() >= 2 && main.getCashier2().size() >= 3 && main.getCashier3().size() >= 5){
                    main.mymethod102(  customerAddFirstname.getText(),  customerAddLastname.getText(), Integer.parseInt(customerAddBurgers.getText()) );
                    burgerStock.setText(String.valueOf(main.getBurgers()));
                    customerAddCashierNumber.setText("");
                    customerAddFirstname.setText("");
                    customerAddLastname.setText("");
                    customerAddBurgers.setText("");
                    controller.message("All queues are full. Added to the waiting list!", "info");
                }else{
                    main.mymethod102( customerAddFirstname.getText(),  customerAddLastname.getText(), Integer.parseInt(customerAddBurgers.getText()) );
                    burgerStock.setText(String.valueOf(main.getBurgers()));
                    customerAddCashierNumber.setText("");
                    customerAddFirstname.setText("");
                    customerAddLastname.setText("");
                    customerAddBurgers.setText("");
                    controller.message("Customer added to queue!", "success");
                }

        }

        updateUI();

    }

    @FXML
    private void addBurgers(){
        controller = new Controller();
        main = new Main();

        if(burgerQuantity.getText().equals("")){
            controller.message("Please fill the all fields!", "error");
        }else if(!burgerQuantity.getText().matches("-?\\d+")){
            controller.message("Please try again!", "error");
        }else{
            main.addBurgers(Integer.parseInt(burgerQuantity.getText()));
            updateUI();
            controller.message(burgerQuantity.getText() + " burgers added to the stock.!", "success");
            burgerQuantity.setText("");
        }

    }

    @FXML
    private void removeCustomer(){

        controller = new Controller();
        main = new Main();


        if(cashierNumber.getText().equals("") || removePosition.getText().equals("")){
            controller.message("Please fill the all fields!", "error");
        }else if(!cashierNumber.getText().matches("-?\\d+") || !removePosition.getText().matches("-?\\d+")){
            controller.message("Please try again!", "error");
        } else{

            if(cashierNumber.getText().equals("1")){
                if(Integer.parseInt(removePosition.getText()) <= main.getCashier1().size()){
                    main.removeCustomer(Integer.parseInt(cashierNumber.getText()), Integer.parseInt(removePosition.getText()));
                    controller.message( "removed from Cashier 0"+ cashierNumber.getText() + " at position 0"+removePosition.getText(), "success");
                    cashierNumber.setText("");
                    removePosition.setText("");

                }else{
                    controller .message("Please try again!", "error");
                }
            }else if(cashierNumber.getText().equals("2")){
                if(Integer.parseInt(removePosition.getText()) <= main.getCashier2().size()){
                    main.removeCustomer(Integer.parseInt(cashierNumber.getText()), Integer.parseInt(removePosition.getText()));
                    controller.message( "removed from Cashier 0"+ cashierNumber.getText() + " at position 0"+removePosition.getText(), "success");
                    cashierNumber.setText("");
                    removePosition.setText("");

                }else{
                    controller.message("Please try again!", "error");
                }
            }else if(cashierNumber.getText().equals("3")){
                if(Integer.parseInt(removePosition.getText()) <= main.getCashier3().size()){
                    main.removeCustomer(Integer.parseInt(cashierNumber.getText()), Integer.parseInt(removePosition.getText()));
                    controller.message( "removed from Cashier 0"+ cashierNumber.getText() + " at position 0"+removePosition.getText(), "success");
                    cashierNumber.setText("");
                    removePosition.setText("");
                }else{
                    controller.message("Please try again!", "error");
                }
            }
            updateUI();

        }
    }

    @FXML
    private void removeServedCustomer(){
        main = new Main();
        controller = new Controller();

        if(removeServedCashierNumber.getText().equals("")){
            controller.message("Please fill the fields!", "error");
        }else {

            if(Integer.parseInt(burgerStock.getText()) <= 0){
                controller.message("Out of burgers!", "info");
            }else {


                int index = 0;
                if (index >= 0 && index > main.waiting().size()) {

                    int outputServed = main.removeServedCustomer(removeServedCashierNumber.getText());
                    removeServedCashierNumber.setText("");
                    if (outputServed == 1) {

                        controller.message("Order served!", "info");
                    } else if (outputServed == 2){
                        controller.message("Out of burgers!", "info");
                    }else {
                        controller.message("No customers to serve.", "info");
                    }

                } else {
                    int outputServed = main.removeServedCustomer(removeServedCashierNumber.getText());
                    removeServedCashierNumber.setText("");
                    if (outputServed == 1) {

                        controller.message("Order served and added new customer!", "info");
                    }else if (outputServed == 2){
                        controller.message("Out of burgers!", "info");
                    } else {
                        controller.message("No customers to serve.", "info");
                    }

                }
            }
        }
        updateUI();
    }




    public void updateUI(){
        main = new Main();

        income.setText(String.valueOf(main.income()));

        clearTable();
//        table data set

        tableFirstName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(0)));
        tableLastName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(1)));
        tableBurgers.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(2)));

        List<Customer> allCustomers  = main.getCustomer();

        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

        for (Customer customer : allCustomers) {
            if (customer != null) {
                ObservableList<String> rowData = FXCollections.observableArrayList(
                        customer.getFirstName(),
                        customer.getLastName(),
                        String.valueOf(customer.getBurgers())
                );
                data.add(rowData);
            }
        }

        tableView.setItems(data);

//        queue validation

        if(main.nextQueue() != "0"){
            customerAddCashierNumber.setText(main.nextQueue());
        }else{
            customerAddCashierNumber.setText("All queues are full.");
        }

        System.out.println(main.nextQueue());

        burgerStock.setText(String.valueOf(main.getBurgers()));

        if(main.getBurgers() <= 10){
            burgerStock.setTextFill(Color.web("red"));
            burgerStockText.setTextFill(Color.web("red"));
        }else{
            burgerStock.setTextFill(Color.web("#0047FF"));
            burgerStockText.setTextFill(Color.web("#0047FF"));
        }

        customersCount.setText(String.valueOf(main.getCashier1().size() + main.getCashier2().size() + main.getCashier3().size()));

        if (main.getCashier1().size() >= 1) {
            cashier1cus1.setText("O");
        }else{
            cashier1cus1.setText("X");
        }
        if (main.getCashier1().size() >= 2) {
            cashier1cus2.setText("O");
        }else{
            cashier1cus2.setText("X");
        }
        if (main.getCashier2().size() >= 1) {
            cashier2cus1.setText("O");
        }else{
            cashier2cus1.setText("X");
        }
        if (main.getCashier2().size() >= 2) {
            cashier2cus2.setText("O");
        }else{
            cashier2cus2.setText("X");
        }
        if (main.getCashier2().size() >= 3) {
            cashier2cus3.setText("O");
        }else{
            cashier2cus3.setText("X");
        }
        if (main.getCashier3().size() >= 1) {
            cashier3cus1.setText("O");
        }else{
            cashier3cus1.setText("X");
        }
        if (main.getCashier3().size() >= 2) {
            cashier3cus2.setText("O");
        }else{
            cashier3cus2.setText("X");
        }
        if (main.getCashier3().size() >= 3) {
            cashier3cus3.setText("O");
        }else{
            cashier3cus3.setText("X");
        }
        if (main.getCashier3().size() >= 4) {
            cashier3cus4.setText("O");
        }else{
            cashier3cus4.setText("X");
        }
        if (main.getCashier3().size() >= 5) {
            cashier3cus5.setText("O");
        }else{
            cashier3cus5.setText("X");
        }
    }

    @FXML
    private void saveFile(){
        main = new Main();
        controller = new Controller();
        main.saveFile();
        controller.message("Saved successfully!", "info");
    }

    @FXML
    private void loadFile(){
        main = new Main();
        List<Customer> allCustomers = main.loadFile();

        updateUI();

    }

    @FXML
    private void alphabetical(){
        main = new Main();
        List<Customer> allCustomers = main.alphabetical();

        clearTable();

        tableFirstName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(0)));
        tableLastName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(1)));
        tableBurgers.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(2)));

        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

        for (Customer customer : allCustomers) {
            if (customer != null) {
                ObservableList<String> rowData = FXCollections.observableArrayList(
                        customer.getFirstName(),
                        customer.getLastName(),
                        String.valueOf(customer.getBurgers())
                );
                data.add(rowData);
            }
        }

        tableView.setItems(data);
    }

    @FXML
    private void searchCustomer(){
        List<Customer> allCustomers = main.getCustomer();
        String customerName = searchCustomer.getText();

        clearTable();

        tableFirstName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(0)));
        tableLastName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(1)));
        tableBurgers.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(2)));

        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

        for (Customer customer : allCustomers) {
            if (customer != null) {

                    ObservableList<String> rowData = FXCollections.observableArrayList(
                            customer.getFirstName(),
                            customer.getLastName(),
                            String.valueOf(customer.getBurgers())
                    );
                if(customer.getFirstName().toLowerCase().equals(customerName.toLowerCase())) {
                    data.add(rowData);
                }
            }
        }

        tableView.setItems(data);
    }

    @FXML
    private void waitingCustomer(){
        List<Customer> waiting = main.waiting();
        controller = new Controller();

        if (waiting.isEmpty()) {
            controller.message("There are no waiting list customers!", "info");
        }else {

            clearTable();

            tableFirstName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(0)));
            tableLastName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(1)));
            tableBurgers.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(2)));

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            for (Customer customer : waiting) {
                if (customer != null) {
                    ObservableList<String> rowData = FXCollections.observableArrayList(
                            customer.getFirstName(),
                            customer.getLastName(),
                            String.valueOf(customer.getBurgers())
                    );
                    data.add(rowData);
                }
            }

            tableView.setItems(data);
        }
    }

    private void message(String message, String type){

        if(type.equals("error")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }else if(type.equals("info")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }else if(type.equals("success")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successful");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }
    }

}