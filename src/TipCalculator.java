import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initializes the variables
        double costs = 0.0;
        double total = 0.0;
        String foodItem = "";
        List<String> list = new ArrayList<String>();  //I learned about arrays from here:https://stackoverflow.com/questions/2843366/how-to-add-new-elements-to-an-array
        int numPeople;
        int tip;
        double aIT;
        double perPerson;
        double costPPBT;
        double tenPercent;
        double twentyPercent;

        //Asks how many people and how much was the cost of an item.
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are in your group? ");
        numPeople = scan.nextInt();
        System.out.print("What are the costs for items you ordered? If you are done, type -1: ");
        costs = scan.nextDouble();

        //Asks what item they have ordered and the cost of it. It loops until the user types -1.
        while (costs != -1) {
            scan.nextLine();
            System.out.print("Enter the Item: ");
            foodItem = scan.nextLine();
            list.add(foodItem);
            total += costs;
            System.out.print("What are the costs for items you ordered? If you are done, type -1: ");
            costs = scan.nextDouble();
        }

        //Asks for the tip percentage and calculates the total tip, total bill with tip, per person cost before and after tip, and how much a person has to tip
        tenPercent = total * (10/100.0);
        tenPercent = Math.round((tenPercent) * 100)/100.0;
        twentyPercent = total * (20/100.0);
        twentyPercent = Math.round((twentyPercent) * 100)/100.0;
        System.out.println("How much do you want to tip?");
        System.out.println("A 10 percent tip would cost " + tenPercent + "$ and a 20 percent tip would be " + twentyPercent + "$");
        System.out.print("What is the tip percentage? (0-100): ");
        tip = scan.nextInt();
        aIT = total * (tip/100.0);
        aIT = Math.round((aIT) * 100)/100.0;
        perPerson = aIT/numPeople;
        perPerson = Math.round((perPerson) * 100)/100.0;
        costPPBT = total/numPeople;
        costPPBT =  (int)((costPPBT) * 100)/100.0;

        //This just prints out all the information.
        System.out.println("---------------------------------------------------------------");
        System.out.println("Total bill before tip: " + Math.round(total * 100)/100.0 + "$");
        System.out.println("Total percentage: " + tip);
        System.out.println("Total tip: " + Math.round(aIT * 100)/100.0 + "$");
        System.out.println("Total bill with tip: " + (Math.round((aIT + total) * 100)/100.0) + "$");
        System.out.println("Per person cost before tip: " + costPPBT + "$");
        System.out.println("Each person has to tip " + (perPerson) + "$.");
        System.out.println("Total cost per person: " + (Math.round((perPerson + costPPBT) * 100)/100.0) + "$");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Items ordered: "); //Learned how to output elements from here:https://www.educative.io/answers/how-to-print-arraylist-elements-in-java
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
