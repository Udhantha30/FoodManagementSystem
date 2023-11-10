package com.example.udanthui;

import com.example.udanthui.FoodQueue;

import java.util.Scanner;

public class Main{


    public static void main(String[] args){

        String Option="";// Variable to store user's chosen option

        FoodQueue foodQueue = new FoodQueue();
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
            System.out.println("999 or EXT: Exit the Program.");
            System.out.println();

            if (foodQueue.burgersStock() <= 10) {
                System.out.println("Only 10 or less burgers left.");
            }

            // Create a new instance of the Scanner class to read user input

            System.out.print("Enter the Option: ");
            Option = OU.nextLine();
            if(Option.equals("999")||Option.equals("EXT")){
                System.out.println("Progamm End...");
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
                    foodQueue.mymethod101();
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
                default:
                    System.out.println("Invaild Input");
                    break;

            }
        }

    }



}