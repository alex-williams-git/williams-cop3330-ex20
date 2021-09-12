/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Alexander Williams
 */

package org.example;
import java.util.Scanner;
import java.lang.Math;

public class App 
{
    public static void main( String[] args )
    {
        Scanner doubleScan = new Scanner(System.in);
        Scanner stringScan = new Scanner(System.in);
        int flag = 0;
        double total_tax = 0;
        double tax = 0;

        System.out.print("What is the order amount? ");
        double amount = doubleScan.nextDouble();

        System.out.print("What state do you life in? ");
        String state = stringScan.nextLine();

        if(state.equals("Wisconsin") || state.equals("wisconsin"))
        {
            System.out.print("What county do you live in? ");
            String county = stringScan.nextLine();
            flag = 1;

            if(county.equals("Eau Claire") || county.equals("eau claire"))
            {
                tax = amount * .05;
                double county_tax = amount * 0.005;
                total_tax = Math.round((tax + county_tax) * 100.0) / 100.0;
            }
            else if(county.equals("Dunn") || county.equals("dunn"))
            {
                tax = amount * .05;
                double county_tax = amount * 0.004;
                total_tax = Math.round((tax + county_tax) * 100.0) / 100.0;
            }
            else
            {
                tax = Math.round((amount *.05) * 100.0) / 100.0;
                flag = 3;
            }
        }

        if(state.equals("Illinois"))
        {
            tax = Math.round((amount * 0.08) * 100.0) / 100.0;
            flag = 2;
        }

        if(flag == 1)
        {
            double grand_total = total_tax + amount;
            System.out.println("The tax is $" + total_tax);
            System.out.println("The total is $" + grand_total);
        }
        else if(flag == 2)
        {
            double grand_total = tax + amount;
            System.out.println("The tax is $" + String.format("%.2f",tax));
            System.out.println("The total is $" + String.format("%.2f", grand_total));
        }
        else if(flag == 3)
        {
            double grand_total = tax + amount;
            System.out.println("The tax is $" + String.format("%.2f",tax));
            System.out.println("The total is $" + String.format("%.2f", grand_total));
        }
        else
        {
            System.out.println("There is no tax.");
            System.out.println("The total is $" + String.format("%.2f", amount));
        }
    }
}
