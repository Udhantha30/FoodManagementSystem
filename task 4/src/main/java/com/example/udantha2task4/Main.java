package com.example.udantha2task4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gui.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 840, 524);
        stage.setTitle("Foodies Fave Food Center");
        stage.setScene(scene);
        stage.setOnCloseRequest(e -> System.exit(0));
        stage.setResizable(false);
        stage.show();
    }

    public static void launchApp() {
        launch();
    }

    public void stop() throws Exception {
        super.stop();
        System.exit(0);
    }
    static FoodQueue foodQueue;

    public static void main(String[] args) {
        foodQueue = new FoodQueue();
        Boolean frameOpen = false;
        String Option="";// Variable to store user's chosen option


        Scanner OU = new Scanner(System.in);

        while(true){
            System.out.println();
            System.out.println("Welcome to Foodies Fave Food center");
            System.out.println();
            System.out.println("Options are below:");
            System.out.println();
            // Displaying available options to the user
            System.out.println("100 or VFQ: View all Queues.");
            System.out.println("101 or VEQ: View all Empty Queues.");
            System.out.println("102 or ACQ: Add customer to a Queue.");
            System.out.println("103 or RCQ: Remove a customer from a Queue.");
            System.out.println("104 or PCQ: Remove a served customer.");
            System.out.println("105 or VCS: View Customers Sorted in alphabetical order.");
            System.out.println("106 or SPD: Store Program Data into file.");
            System.out.println("107 or LPD: Load Program Data from file.");
            System.out.println("108 or STK: View Remaining burgers Stock.");
            System.out.println("109 or AFS: Add burgers to Stock.");
            System.out.println("110 or IFQ: View Income of each queue.");
            System.out.println("112 or GUI: Launch the GUI.");
            System.out.println("999 or EXT: Exit the Program.");
            System.out.println();

            if (foodQueue.burgersStock() <= 10) {
                System.out.println("Only 10 or less burgers left.");
            }

            // Create a new instance of the Scanner class to read user input

            System.out.print("Enter the Option: ");
            Option = OU.nextLine();
            if(Option.equals("999")||Option.equals("EXT")){
                System.out.println("Program End...");
                break;
            }
            System.out.println();
            //calling methods
            switch(Option){
                case "100":
                case "VFQ":
                    foodQueue.mymethod100();
                    break;

                case "101":
                case "VEQ":
                    foodQueue.  mymethod101();
                    break;

                case "102":
                case "ACQ":

                    System.out.print("Enter customer first name: ");
                    String customerFirstName = OU.nextLine();
                    System.out.print("Enter customer last name: ");
                    String customerLastName = OU.nextLine();
                    System.out.print("Enter number of burgers: ");
                    String burgers = OU.nextLine();

                    Customer customer = new Customer(customerFirstName, customerLastName, Integer.parseInt(burgers));
                    foodQueue.mymethod102(customer);

                    break;

                case "103":
                case "RCQ":
                    // User to enter the cashier number
                    System.out.print("Enter the cashier number: ");
                    String cnum=OU.nextLine();

                    // User to enter the cashier slot
                    System.out.print("Enter the Cashier slot: ");
                    String cslot=OU.nextLine();
                    foodQueue.mymethod103(Integer.parseInt(cnum),Integer.parseInt(cslot));
                    break;

                case "104":
                case "PCQ":
                    System.out.print("Enter the cashier number: ");
                    String cnum1 = OU.nextLine();
                    foodQueue.mymethod104(Integer.parseInt(cnum1));
                    break;

                case "105":
                case "VCS":
                    foodQueue.mymethod105();
                    break;

                case "106":
                case "SPD":
                    foodQueue.mymethod106();
                    break;

                case "107":
                case "LPD":
                    foodQueue.mymethod107();
                    break;

                case "108":
                case "STK":
                    int burgersReturn = foodQueue.mymethod108();
                    System.out.println("Remaining Burgers are "+burgersReturn);
                    break;

                case "109":
                case "AFS":
                    // The user to enter the number of burgers they want to add
                    System.out.println("Enter the how many Burgers want to add: ");

                    // Read an integer value entered by the user and store it in New burger Stock(Neburst)
                    String NeburSt=OU.nextLine();
                    foodQueue.mymethod109(Integer.parseInt(NeburSt));
                    break;
                case "110":
                case "IFQ":
                    double income1 = foodQueue.income1();
                    double income2 = foodQueue.income2();
                    double income3 = foodQueue.income3();

                    System.out.println("Income of queue 1 : " + income1);
                    System.out.println("Income of queue 2 : " + income2);
                    System.out.println("Income of queue 3 : " + income3);

                    break;
                case "112":
                case "GUI":

                    if(frameOpen == false){

                        Thread fxThread = new Thread(Main::launchApp);
                        fxThread.start();

                        frameOpen = true;

                    }
                    break;
                default:
                    System.out.println("Invaild Input");
                    break;

            }
        }

    }

    public List<Customer> getCustomer(){
        return foodQueue.getCustomer();
    }

    public int getBurgers(){
        return foodQueue.getStock();
    }

    public List<Customer> getCashier1() {
        return foodQueue.getCashier1();
    }

    public List<Customer> getCashier2() {
        return foodQueue.getCashier2();
    }

    public List<Customer> getCashier3() {
        return foodQueue.getCashier3();
    }

    public void mymethod102(String customerFirstName, String customerLastName,int burgers){
        Customer customer = new Customer(customerFirstName,customerLastName, burgers);
        foodQueue.mymethod102(customer);
    }

    public void addBurgers(int quantity){
        foodQueue.mymethod109(quantity);
    }

    public String nextQueue(){

        String shortestQueue = foodQueue.getShortestQueueUI();

        return shortestQueue;
    }

    public void removeCustomer(int cashierNum, int position){
        foodQueue.mymethod103(cashierNum, position);
    }

    public int removeServedCustomer(String cnum){

        int returnServed = foodQueue.mymethod104(Integer.parseInt(cnum));

        return returnServed;
    }

    public List<Customer> waiting(){
        return foodQueue.waiting();
    }

    public void saveFile(){
        foodQueue.mymethod106();
    }

    public List<Customer> loadFile(){
        return foodQueue.mymethod107();
    }

    public double income(){

        return foodQueue.income();
    }

    public List<Customer> alphabetical(){
        List<Customer> allCustomers = foodQueue.mymethod105();
        return allCustomers;
    }
}