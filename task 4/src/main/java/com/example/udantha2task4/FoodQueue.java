package com.example.udantha2task4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoodQueue {

    private static int burgersStock = 50;
    private static double burgerPrice = 650;
    private static int burgersCount1 = 0;
    private static int burgersCount2 = 0;
    private static int burgersCount3 = 0;
    private static Customer[] cashierONE = new Customer[2];
    private static Customer[] cashierTWO = new Customer[3];
    private static Customer[] cashierTHREE = new Customer[5];

    private static List<Customer> waiting = new ArrayList<>();

    private static String filePath = "customer.txt";

    public static int burgersStock(){
        return burgersStock;
    }

    public int getStock(){
        return burgersStock;
    }

    public List<Customer> waiting(){

        return waiting;

    }

    public int getBurgerStock(){
        return burgersStock;
    }

    public List<Customer> getCustomer() {

        List<Customer> allCustomers = new ArrayList<>();

        // Add customers from QueueOne
        for (Customer customer : cashierONE) {
            if (customer != null) {
                allCustomers.add(customer);
            }
        }

        // Add customers from QueueTwo
        for (Customer customer : cashierTWO) {
            if (customer != null) {
                allCustomers.add(customer);
            }
        }

        // Add customers from QueueThree
        for (Customer customer : cashierTHREE) {
            if (customer != null) {
                allCustomers.add(customer);
            }
        }

        return allCustomers;

    }


    public List<Customer> getCashier1() {
        List<Customer> allCustomers = new ArrayList<>();
        for (Customer customer : cashierONE) {
            if (customer != null) {
                allCustomers.add(customer);
            }
        }
        return allCustomers;
    }

    public List<Customer> getCashier2() {
        List<Customer> allCustomers = new ArrayList<>();
        for (Customer customer : cashierTWO) {
            if (customer != null) {
                allCustomers.add(customer);
            }
        }
        return allCustomers;
    }

    public List<Customer>  getCashier3() {
        List<Customer> allCustomers = new ArrayList<>();
        for (Customer customer : cashierTHREE) {
            if (customer != null) {
                allCustomers.add(customer);
            }
        }
        return allCustomers;
    }

    public static void mymethod100(){


        System.out.println("\t*****************");
        System.out.println("\t*\tCashiers\t*");
        System.out.println("\t*****************");

        for (int i = 0; i < 5; i++) {
            if (cashierONE.length > i) {
                if (cashierONE[i] == null) {
                    System.out.print("\t\t" + "X");
                } else {
                    System.out.print("\t\t" + "O");
                }

            } else {
                System.out.print("\t\t");
            }
            if (cashierTWO.length > i) {
                if (cashierTWO[i] == null) {
                    System.out.print("\t" + "X");
                } else {
                    System.out.print("\t" + "O");
                }

            } else {
                System.out.print("\t");
            }
            if (cashierTHREE.length > i) {
                if (cashierTHREE[i] == null) {
                    System.out.print("\t" + "X");
                } else {
                    System.out.print("\t" + "O");
                }

            } else {
                System.out.print("\t");
            }
            System.out.println("  ");
        }
        System.out.println("X - Not Occupied O - Occupied");
        System.out.println();
    }
    public static void mymethod101(){
        // Check if Cashier1 is occupied or not
        for(Customer customer : cashierONE){
            if(customer == null){
                System.out.println("Cashier 1 not Occupied.");
                break;
            }
        }
        // Check if Cashier2 is occupied or not
        for(Customer customer : cashierTWO){
            if(customer == null){
                System.out.println("Cashier 2 not Occupied.");
                break;
            }
        }
        // Check if Cashier3 is occupied or not
        for(Customer customer : cashierTHREE){
            if(customer == null){
                System.out.println("Cashier 3 not Occupied.");
                break;
            }
        }
    }

    public static void mymethod102(Customer customer){

        String arrayIndex = getShortestQueueUI();

        if (customer.getBurgers() - 1 < burgersStock) {

            if(arrayIndex == "1"){

                for (int i = 0; i < cashierONE.length; i++) {
                    if (cashierONE[i] == null) {
                        cashierONE[i] = customer;
                        break;
                    }
                }
                System.out.println("Customer added to queue.");

            }else if(arrayIndex == "2"){

                for (int i = 0; i < cashierTWO.length; i++) {

                    if (cashierTWO[i] == null) {
                        cashierTWO[i] = customer;
                        break;
                    }
                }

                System.out.println("Customer added to queue.");

            }else if(arrayIndex == "3"){

                for (int i = 0; i < cashierTHREE.length; i++) {
                    if (cashierTHREE[i] == null) {
                        cashierTHREE[i] = customer;
                        break;
                    }
                }
                System.out.println("Customer added to queue.");

            }else if(arrayIndex == "0"){
                waiting.add(customer);
                System.out.println("All queues are full. Added to the waiting list");
            }

        } else {
            System.out.println("Not enough burgers in stock.");
        }

    }

//    public static Customer[] getShortestQueue() {
//        int cashierOneOccupiedCount = getOccupiedCount(cashierONE);
//        int cashierTwoOccupiedCount = getOccupiedCount(cashierTWO);
//        int cashierThreeOccupiedCount = getOccupiedCount(cashierTHREE);
//
//        if (cashierOneOccupiedCount <= cashierTwoOccupiedCount && cashierOneOccupiedCount <= cashierThreeOccupiedCount && cashierONE[cashierONE.length - 1] == null) {
//            return cashierONE;
//        } else if (cashierTwoOccupiedCount <= cashierOneOccupiedCount && cashierTwoOccupiedCount <= cashierThreeOccupiedCount && cashierTWO[cashierTWO.length - 1] == null) {
//            return cashierTWO;
//        } else if (cashierTHREE[cashierTHREE.length - 1] == null ) {
//            return cashierTHREE;
//        }
//        return null;
//    }

    public static String getShortestQueueUI() {
        int cashierOneOccupiedCount = getOccupiedCount(cashierONE);
        int cashierTwoOccupiedCount = getOccupiedCount(cashierTWO);
        int cashierThreeOccupiedCount = getOccupiedCount(cashierTHREE);

        if (cashierOneOccupiedCount <= cashierTwoOccupiedCount && cashierOneOccupiedCount <= cashierThreeOccupiedCount && cashierONE[cashierONE.length - 1] == null) {
            return "1";
        } else if (cashierTwoOccupiedCount <= cashierOneOccupiedCount && cashierTwoOccupiedCount <= cashierThreeOccupiedCount && cashierTWO[cashierTWO.length - 1] == null) {
            return "2";
        } else if (cashierTHREE[cashierTHREE.length - 1] == null ) {
            return "3";
        }
        return "0";
    }
    public static int getOccupiedCount(Customer[] array) {
        int count = 0;
        for (Customer customer : array) {
            if (customer != null) {
                count++;
            }
        }
        return count;
    }
    public static void mymethod103(int cnum,int cslot){

        if(cnum==1){
            if(cashierONE[cslot - 1] != null){

                System.out.println("Customer Removed.");
                for (int i = (0); i < cashierONE.length; i++) {
                    if ((i + 1) == cashierONE.length)
                        return;

                    cashierONE[i] = cashierONE[i + 1];
                    cashierONE[i + 1] = null;
                    mymethod100();

                }

            }else{
                System.out.println("No customer to remove");
            }
        }else if(cnum==2){
            if(cashierTWO[cslot - 1] != null){
                System.out.println("Customer Removed.");
                for (int i = (0); i < cashierTWO.length; i++) {
                    if ((i + 1) == cashierTWO.length)
                        return;

                    cashierTWO[i] = cashierTWO[i + 1];
                    cashierTWO[i + 1] = null;
                    mymethod100();

                }

            }else{
                System.out.println("No customer to remove");
            }
        }else if(cnum==3){
            if(cashierTHREE[cslot - 1] != null){
                System.out.println("Customer Removed.");
                for (int i = (0); i < cashierTHREE.length; i++) {
                    if ((i + 1) == cashierTHREE.length)
                        return;

                    cashierTHREE[i] = cashierTHREE[i + 1];
                    cashierTHREE[i + 1] = null;
                    mymethod100();

                }

            }else{
                System.out.println("No customer to remove");
            }
        }

    }
    public static int mymethod104(int cnum) {
        if (burgersStock == 0) {
            System.out.println("Out of burgers!");
            return 0;
        }else{

        Customer customer = null;

        if (waiting.size() > 0) {
            customer = waiting.get(0);
        }

        int customerServed = 0;


        // Check if the chosen cashier number is 1
        if (cnum == 1) {
            if (cashierONE[0] != null) {
                if(cashierONE[0].getBurgers() > burgersStock){
                    customerServed = 2;

                }else {
                    System.out.println("Customer Served.");
                    burgersStock -= cashierONE[0].getBurgers();
                    burgersCount1 += cashierONE[0].getBurgers();
                    for (int i = 0; i < cashierONE.length - 1; i++) {

                        cashierONE[i] = cashierONE[i + 1];
                        cashierONE[i + 1] = null;

                        if (waiting.size() > 0) {
                            mymethod102(customer);
                            waiting.remove(0);
                        }

                        customerServed = 1;
                    }
                }
            } else {
                System.out.println("No customers to serve.");
            }
        }
        // Check if the chosen cashier number is 2
        else if (cnum == 2) {
            if (cashierTWO[0] != null) {
                if(cashierTWO[0].getBurgers() > burgersStock){
                    customerServed = 2;

                }else {
                    System.out.println("Customer Served.");
                    burgersStock -= cashierTWO[0].getBurgers();
                    burgersCount2 += cashierTWO[0].getBurgers();

                    for (int i = 0; i < cashierTWO.length - 1; i++) {

                        cashierTWO[i] = cashierTWO[i + 1];
                        cashierTWO[i + 1] = null;

                        if (waiting.size() > 0) {
                            mymethod102(customer);
                            waiting.remove(0);
                        }

                        customerServed = 1;
                    }
                }
            } else {
                System.out.println("No customers to serve.");
            }
        }
        // Check if the chosen cashier number is 3
        else if (cnum == 3) {
            if (cashierTHREE[0] != null) {
                if(cashierTHREE[0].getBurgers() > burgersStock){
                    customerServed = 2;

                }else {
                    System.out.println("Customer Served.");
                    burgersStock -= cashierTHREE[0].getBurgers();
                    burgersCount3 += cashierTHREE[0].getBurgers();
                    for (int i = 0; i < cashierTHREE.length - 1; i++) {

                        cashierTHREE[i] = cashierTHREE[i + 1];
                        cashierTHREE[i + 1] = null;

                        if (waiting.size() > 0) {
                            mymethod102(customer);
                            waiting.remove(0);
                        }

                        customerServed = 1;
                    }
                }
            } else {
                System.out.println("No customers to serve.");
            }
        }
        // If none of the above conditions match, print an error message
        else {
            System.out.println("Invalid Input.");
        }

//        if(burgersStock < 10){
//            System.out.println();
//        }
        return customerServed;
        }
    }
    public static int mymethod108(){

        return burgersStock;
    }
    public static void mymethod109(int NeburSt){

        // Add the value of NeburSt to the current BurgerStock and update NeburSt
        burgersStock += NeburSt;

        // Print the updated value of NeburSt as the new burger stock
        System.out.println("New Burger Stock " + burgersStock);

    }
    public static void mymethod106(){

        List<Customer> allCustomers = new ArrayList<>();

        for (Customer customer : cashierONE) {
            if (customer != null) {
                allCustomers.add(customer);
            }
        }

        // Add customers from QueueTwo to the list
        for (Customer customer : cashierTWO) {
            if (customer != null) {
                allCustomers.add(customer);
            }
        }

        // Add customers from QueueThree to the list
        for (Customer customer : cashierTHREE) {
            if (customer != null) {
                allCustomers.add(customer);
            }
        }

        try {

            File file = new File(filePath);

            if (file.exists()) {
                file.delete();
            }

            FileWriter myWriter = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);

            for (Customer customer : allCustomers) {
                String customerData = customer.getFirstName() + "," + customer.getLastName() + "," + customer.getBurgers();
                bufferedWriter.write(customerData);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            myWriter.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

    }
    public static List<Customer> mymethod107() {

        List<Customer> allCustomers = new ArrayList<>();


        String thisLine = null;
        String[] words = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((thisLine = br.readLine()) != null) {
                words = thisLine.split(",");
                String firstName = words[0];
                String lastName = words[1];
                int numOfBurgers = Integer.parseInt(words[2]);

                Customer customer = new Customer(firstName, lastName, numOfBurgers);
                allCustomers.add(customer);

                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("No of burgers: " + numOfBurgers);
                System.out.println();

                Customer customer1 = new Customer(firstName, lastName, numOfBurgers);
                mymethod102(customer1);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allCustomers;

    }
    public static List<Customer> mymethod105(){

        List<Customer> allCustomers = new ArrayList<>();

        for (Customer customer : cashierONE) {
            if (customer != null) {
                allCustomers.add(customer);
            }
        }

        // Add customers from QueueTwo to the list
        for (Customer customer : cashierTWO) {
            if (customer != null) {
                allCustomers.add(customer);
            }
        }

        // Add customers from QueueThree to the list
        for (Customer customer : cashierTHREE) {
            if (customer != null) {
                allCustomers.add(customer);
            }
        }

        Collections.sort(allCustomers, (c1, c2) -> c1.getFirstName().compareToIgnoreCase(c2.getFirstName()));


        for (Customer name : allCustomers) {

            System.out.println("First Name: " + name.getFirstName());
            System.out.println("Last Name: " + name.getLastName());
            System.out.println("No of burgers: " + name.getBurgers());
            System.out.println();
        }

        System.out.println("\n");// Print a new line after all the names have been printed
        return allCustomers;
    }

    public double income(){
        double income = (burgersCount1 + burgersCount2 + burgersCount3) * burgerPrice;
        return income;
    }
    public double income1(){
        double income = burgersCount1 * burgerPrice;
        return income;
    }

    public double income2(){
        double income = burgersCount2 * burgerPrice;
        return income;
    }

    public double income3(){
        double income = burgersCount3 * burgerPrice;
        return income;
    }

    public static int compareStrings(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                return c1 - c2;// Return the difference between the Unicode values of the characters
            }
        }
        return s1.length() - s2.length();// Return the difference in string lengths if all characters are the same
    }
}