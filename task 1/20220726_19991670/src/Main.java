import java.util.Scanner;
import java.io.*;
public class Main{
    public static void main(String[] args){

        // Initializing arrays to represent cashier queues
        String[] cashier1 = {"X", "X"};
        String[] cashier2 = {"X", "X", "X"};
        String[] cashier3 = {"X", "X", "X", "X", "X"};

        int BurgerStock = 50;// Initializing burger stock
        String Option="";// Variable to store user's chosen option

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
            System.out.println("999 or EXT: Exit the Program.");
            System.out.println();

            if (BurgerStock <= 10) {
                System.out.println("Only 10 or less burgers left.");
            }

            // Create a new instance of the Scanner class to read user input
            Scanner OU = new Scanner(System.in);
            System.out.print("Enter the Option: ");
            Option=OU.next();
            if(Option.equals("999")||Option.equals("EXT")){
                System.out.println("Progamm End...");
                break;
            }
            System.out.println();
            //calling methods
            switch(Option){
                case "100":
                case "VFQ":
                    mymethod100(cashier1,cashier2,cashier3);
                    break;

                case "101":
                case "VEQ":
                    mymethod101(cashier1,cashier2,cashier3);
                    break;

                case "102":
                case "ACQ":
                    mymethod102(cashier1,cashier2,cashier3);
                    break;

                case "103":
                case "RCQ":
                    mymethod103(cashier1,cashier2,cashier3);
                    break;

                case "104":
                case "PCQ":
                    BurgerStock=mymethod104(cashier1,cashier2,cashier3,BurgerStock);
                    break;

                case "105":
                case "VCS":
                    mymethod105(cashier1,cashier2,cashier3);
                    break;

                case "106":
                case "SPD":
                    mymethod106(cashier1,cashier2,cashier3,BurgerStock);
                    break;

                case "107":
                case "LPD":
                    BurgerStock = mymethod107(cashier1,cashier2,cashier3,BurgerStock);
                    break;

                case "108":
                case "STK":
                    mymethod108(BurgerStock);
                    break;

                case "109":
                case "AFS":
                    BurgerStock=mymethod109(BurgerStock);
                    break;

                default:
                    System.out.println("Invaild Input");
                    break;

            }
        }

    }
    public static void mymethod100(String[] cashier1,String[] cashier2,String[] cashier3){
        // Initialize new arrays to store modified values.
        String[] cashierONE = new String[2];
        String[] cashierTWO = new String[3];
        String[] cashierTHREE = new String[5];

        // Copy values from cashier1 to cashierONE
        for(int i=0;i<cashierONE.length;i++){
            cashierONE[i] = cashier1[i];
        }
        // Copy values from cashier2 to cashierTWO
        for(int i=0;i<cashierTWO.length;i++){
            cashierTWO[i] = cashier2[i];
        }
        // Copy values from cashier3 to cashierTHREE
        for(int i=0;i<cashierTHREE.length;i++){
            cashierTHREE[i] = cashier3[i];
        }
        // Replace non-"X" elements in cashierONE with "O"
        for(int i=0;i<cashierONE.length;i++) {
            if(!cashierONE[i].equals("X")) {
                cashierONE[i] = "O";
            }
        }
        // Replace non-"X" elements in cashierTWO with "O"
        for(int i=0;i<cashierTWO.length;i++) {
            if(!cashierTWO[i].equals("X")) {
                cashierTWO[i] = "O";
            }
        }
        // Replace non-"X" elements in cashierTHREE with "O"
        for(int i=0;i<cashierTHREE.length;i++) {
            if(!cashierTHREE[i].equals("X")) {
                cashierTHREE[i] = "O";
            }
        }
        System.out.print("*****************\n*    Cashiers   *\n*****************");
        System.out.println();
        System.out.println("  "+cashierONE[0]+" "+cashierTWO[0]+" "+cashierTHREE[0]+" ");
        System.out.println("  "+cashierONE[1]+" "+cashierTWO[1]+" "+cashierTHREE[1]+" ");
        System.out.println("    "+cashierTWO[2]+" "+cashierTHREE[2]+" ");
        System.out.println("      "+cashierTHREE[3]+" ");
        System.out.println("      "+cashierTHREE[4]+" ");
        System.out.println();
        System.out.println("X-Not Occupied. O-Occupied.");
        System.out.println();
    }
    public static void mymethod101(String[] cashier1,String[] cashier2, String[] cashier3){
        // Check if Cashier1 is occupied or not
        for(String emc1:cashier1){
            if(emc1.equals("X")){
                System.out.println("Cashier 1 not Occupied.");
                break;
            }
        }
        // Check if Cashier2 is occupied or not
        for(String emc2:cashier2){
            if(emc2.equals("X")){
                System.out.println("Cashier 2 not Occupied.");
                break;
            }
        }
        // Check if Cashier3 is occupied or not
        for(String emc3:cashier3){
            if(emc3.equals("X")){
                System.out.println("Cashier 3 not Occupied.");
                break;
            }
        }
    }
    public static void mymethod102(String[] cashier1,String[] cashier2, String[] cashier3){
        Scanner OU = new Scanner(System.in);

        // User to enter customer name
        System.out.print("Enter the customer name: ");
        String name = OU.nextLine();

        // User to enter cashier number
        System.out.print("Enter the cashier number: ");
        int cnum=OU.nextInt();
        if(cnum==1){
            int j=0;

            // Iterate over cashier1 array to find an available slot
            for(int i=0; i<cashier1.length;i++){
                if(cashier1[i].equals("X")){

                    // Assign customer name to the available slot
                    cashier1[i]=name;
                    System.out.println("Customer add to queue.");
                    j=1;
                    break;
                }
            }
            if(j==0){
                System.out.println("The queue is full.Try to another queue.");
            }
        }
        else if(cnum==2){
            int j=0;

            // Iterate over cashier2 array to find an available slot
            for(int i=0; i<cashier2.length;i++){
                if(cashier2[i].equals("X")){

                    // Assign customer name to the available slot
                    cashier2[i]=name;
                    System.out.println("Customer add to queue");
                    j=1;
                    break;
                }
            }
            if(j==0){
                System.out.println("The queue is full.Try to another queue.");
            }
        }
        else if(cnum==3){
            int j=0;

            // Iterate over cashier3 array to find an available slot
            for(int i=0; i<cashier3.length;i++){
                if(cashier3[i].equals("X")){

                    // Assign customer name to the available slot
                    cashier3[i]=name;
                    System.out.println("Customer add to queue");
                    j=1;
                    break;
                }
            }
            if(j==0){
                System.out.println("The queue is full.Try to another queue.");
            }
        }
        else{
            System.out.println("Invaild input.");
        }
    }
    public static void mymethod103(String[] cashier1,String[] cashier2, String[] cashier3){
        Scanner OU= new Scanner(System.in);

        // User to enter the cashier number
        System.out.print("Enter the cashier number: ");
        int cnum=OU.nextInt();

        // User to enter the cashier slot
        System.out.print("Enter the Cashier slot: ");
        int cslot=OU.nextInt();
        if(cnum==1){
            if(cslot>=1 && cslot<=2){
                if(cashier1[cslot-1].equals("X")) {
                    System.out.println("No customer to remove");
                    return;
                }
                // Mark the customer as removed in the cashier1 array
                cashier1[cslot-1]="X";
                System.out.println("Customer Removed.");

                // Shift the remaining customers forward in the array
                for(int i = cslot-1; i<(cashier1.length-1); i++) {
                    String temp = cashier1[i];
                    cashier1[i] = cashier1[i+1];
                    cashier1[i+1] = temp;
                }
            }
        }
        else if(cnum==2){
            if(cslot>=1 && cslot<=3){
                if(cashier2[cslot-1].equals("X")) {
                    System.out.println("No customer to remove");
                    return;
                }
                // Mark the customer as removed in the cashier2 array
                cashier2[cslot-1]="X";
                System.out.println("Customer Removed.");

                // Shift the remaining customers forward in the array
                for(int i = cslot-1; i<(cashier2.length-1); i++) {
                    String temp = cashier2[i];
                    cashier2[i] = cashier2[i+1];
                    cashier2[i+1] = temp;
                }
            }
        }
        else if(cnum==3){
            if(cslot>=1 && cslot<=5){
                if(cashier3[cslot-1].equals("X")) {
                    System.out.println("No customer to remove");
                    return;
                }
                // Mark the customer as removed in the cashier3 array
                cashier3[cslot-1]="X";
                System.out.println("Customer Removed.");

                // Shift the remaining customers forward in the array
                for(int i = cslot-1; i<(cashier3.length-1); i++) {
                    String temp = cashier3[i];
                    cashier3[i] = cashier3[i+1];
                    cashier3[i+1] = temp;
                }
            }
        }
    }
    public static int mymethod104(String[] cashier1,String[] cashier2, String[] cashier3,int BurgerStock){
        if(BurgerStock==0) {
            System.out.println("Out of burgers!");
            return BurgerStock;
        }
        Scanner OU= new Scanner(System.in);
        System.out.print("Enter the cashier number: ");
        int cnum=OU.nextInt();

        // Check if the chosen cashier number is 1
        if(cnum==1){
            if(!cashier1[0].equals("X")) {
                cashier1[0] = "X";// Mark the first element of cashier1 as "X" to indicate customer served
                System.out.println("Customer Served.");

                // Loop that not execute
                for (int i = 0; i < cashier1.length-1; i++) {
                    String temp = cashier1[i];
                    cashier1[i] = cashier1[i + 1];
                    cashier1[i + 1] = temp;
                }
                BurgerStock -= 5;// Subtract 5 from BurgerStock
                return BurgerStock;// Return the updated BurgerStock
            } else {
                System.out.println("No customers to serve.");
                return BurgerStock;
            }
        }
        // Check if the chosen cashier number is 2
        else if(cnum==2){
            if(!cashier2[0].equals("X")) {
                cashier2[0] = "X";// Mark the first element of cashier1 as "X" to indicate customer served
                System.out.println("Customer Served.");

                // Loop that not execute
                for (int i = 0; i < cashier2.length-1; i++) {
                    if(cashier2[i].equals("X")){
                        String temp = cashier2[i+1];
                        cashier2[i+1] = cashier2[i];
                        cashier2[i] = temp;
                    }
                }
                BurgerStock -= 5;// Subtract 5 from BurgerStock
                return BurgerStock;// Return the updated BurgerStock
            } else{
                System.out.println("No customers to serve");
                return BurgerStock;
            }
        }
        // Check if the chosen cashier number is 3
        else if(cnum==3){
            if(!cashier3[0].equals("X")) {
                cashier3[0] = "X";// Mark the first element of cashier1 as "X" to indicate customer served
                System.out.println("Customer Served.");

                // Loop that not execute
                for (int i = 0; i < cashier3.length-1; i++) {
                    String temp = cashier3[i];
                    cashier3[i] = cashier3[i + 1];
                    cashier3[i + 1] = temp;
                }
                BurgerStock -= 5;// Subtract 5 from BurgerStock
                return BurgerStock;// Return the updated BurgerStock
            }else{
                System.out.println("No customers to serve");
                return 0;
            }
        }
        // If none of the above conditions match, print an error message and return the original BurgerStock
        else{
            System.out.println("Invaild Input.");
            return BurgerStock;
        }
    }
    public static void mymethod108(int BurgerStock){
        System.out.println("Remaining Burgers are "+BurgerStock);
    }
    public static int mymethod109(int BurgerStock){
        Scanner OU=new Scanner(System.in);

        // The user to enter the number of burgers they want to add
        System.out.println("Enter the how many Burgers want to add: ");

        // Read an integer value entered by the user and store it in New burger Stock(Neburst)
        int NeburSt=OU.nextInt();

        // Add the value of NeburSt to the current BurgerStock and update NeburSt
        NeburSt=BurgerStock+NeburSt;

        // Print the updated value of NeburSt as the new burger stock
        System.out.println("New Burger Stock "+NeburSt);

        // Return the updated value of NeburSt
        return NeburSt;
    }


    public static void mymethod106(String[] cashier1,String[] cashier2, String[] cashier3, int burgers)
    {
        try{
            // Create a FileWriter object named mywriter to write to the file "filename.txt"
            FileWriter mywriter=new FileWriter("filename.txt");

            // Write the elements of cashier1 array to the file, separated by commas
            for(String element:cashier1) {
                mywriter.write(element+",");
            }
            // Write a newline character to separate the arrays
            mywriter.write("\n");

            // Write the elements of cashier2 array to the file, separated by commas
            for(String element:cashier2) {
                mywriter.write(element+",");
            }
            // Write a newline character to separate the arrays
            mywriter.write("\n");

            // Write the elements of cashier3 array to the file, separated by commas
            for(String element:cashier3) {
                mywriter.write(element+",");
            }
            // Write a newline character and the value of burgers to the file
            mywriter.write("\n"+burgers);

            // Close the FileWriter to release resources
            mywriter.close();

            System.out.println("Successfully wrote to the file.");
        }
        catch(IOException e)
        {
            // If an IOException occurs, print an error message
            System.out.println("An error Occurred.");
        }
    }
    public static int mymethod107(String[] cashier1,String[] cashier2, String[] cashier3, int burgerS) {
        try {
            // Create a File object for the file "filename.txt"
            File file = new File("filename.txt");

            // Create a Scanner object to read the contents of the file
            Scanner file_reader = new Scanner(file);

            // Read the first line of the file into text1
            String text1 = file_reader.nextLine();

            // Read the first line of the file into text2
            String text2 = file_reader.nextLine();

            // Read the first line of the file into text3
            String text3 = file_reader.nextLine();

            // Read the fourth line of the file into LBurgers
            String LBurgers = file_reader.nextLine();

            // Parse the value of LBurgers into an integer
            int burgers = Integer.parseInt(LBurgers);
            // Split text1 using commas as the delimiter and store the resulting values in array1
            String[] array1 = text1.split(",",0);
            // Split text1 using commas as the delimiter and store the resulting values in array2
            String[] array2 = text2.split(",",0);
            // Split text1 using commas as the delimiter and store the resulting values in array3
            String[] array3 = text3.split(",",0);

            // Iterate over the elements of cashier1 array
            for(int i=0;i<cashier1.length;i++){
                // Assign the value at the corresponding index of array1 to cashier1
                cashier1[i] = array1[i];
            }
            // Iterate over the elements of cashier2 array
            for(int i=0;i<cashier2.length;i++){
                // Assign the value at the corresponding index of array1 to cashier2
                cashier2[i] = array2[i];
            }
            // Iterate over the elements of cashier3 array
            for(int i=0;i<cashier3.length;i++){
                // Assign the value at the corresponding index of array1 to cashier3
                cashier3[i] = array3[i];
            }
            // Close the file_reader
            file_reader.close();
            System.out.println("Successfully read from the file.");

            // Return the value of burgers
            return burgers;
        } catch (Exception e) {
            // If an IOException occurs while reading the file, print an error message
            System.out.println("Error while reading a file.");
            // Print the stack trace of the exception
            e.printStackTrace();
        }
        // If an exception occurred, return the original value of burgerS
        return burgerS;
    }
    public static void mymethod105(String[] cashier1,String[] cashier2, String[] cashier3){
        String[] NamesAl = new String[10];// Create a new array to store the names
        int n=0;// Initialize a variable to keep track of the index in NamesAl

        // Copy elements from cashier1 to NamesAl
        for(String element:cashier1) {
            NamesAl[n] = element;
            n++;
        }
        // Copy elements from cashier2 to NamesAl
        for(String element:cashier2) {
            NamesAl[n] = element;
            n++;
        }
        // Copy elements from cashier3 to NamesAl
        for(String element:cashier3) {
            NamesAl[n] = element;
            n++;
        }

        // Perform a bubble sort on NamesAl array
        for (int i = 0; i < NamesAl.length - 1; i++) {
            for (int j = 0; j < NamesAl.length - i - 1; j++) {
                // Compare adjacent strings using compareStrings method
                if (compareStrings(NamesAl[j], NamesAl[j + 1]) > 0) {
                    // Swap elements if they are out of order
                    String temp = NamesAl[j];
                    NamesAl[j] = NamesAl[j + 1];
                    NamesAl[j + 1] = temp;
                }
            }
        }
        // Print the sorted names from NamesAl array
        for(String element:NamesAl) {
            if(!element.equals("X")){
                System.out.print(element+",");
            }
        }
        System.out.println("\n");// Print a new line after all the names have been printed
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