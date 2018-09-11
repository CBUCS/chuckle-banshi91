package com.chuckle.activities;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class is used for rolling the dices and
 * getting two different results and re-roll it
 * to get perfect scores
 */
public class MainActivity
{
    private static String newLine = System.getProperty("line.separator");//This will retrieve line separator

    //main method
    public static void main(String[] args)
    {
         Scanner scanner;//keyboard input
        String input = "N";

         ArrayList<Integer> arrayListSums = new ArrayList<>();//arraylist of sums

        while (!input.equalsIgnoreCase("Y")) {
            System.out.println("Are you ready to roll the dice?"
                    + newLine + "Enter Y - YES and N - NO");

            scanner = new Scanner(System.in);
            input = scanner.next();

            if (input.equalsIgnoreCase("Y")) {
                DiceActivity dice1 = new DiceActivity();
                DiceActivity dice2 = new DiceActivity();

                int dice1Value = dice1.getDiceNumber();
                int dice2Value = dice2.getDiceNumber();

                checkForSum(dice1Value, dice2Value, arrayListSums);
                rollAgain(dice1, dice2, dice1Value, dice2Value, arrayListSums);

            }
            else {
                if (input.equalsIgnoreCase("N")) {
                    break;
                }
                    System.out.println("Please enter Y or N.");
                    input = "N";
            }
        }
    }


    //this will check sum and ask again to roll or not
    private static void checkForSum(int dice1Value, int dice2Value, ArrayList<Integer> arrayListSums)
    {
        System.out.println("Dice 1 Value :" + dice1Value
                + newLine + "Dice 2 Value :" + dice2Value);

        int dicesSum = dice1Value + dice2Value;
        sumOfDiceNumbers(dicesSum,arrayListSums);


        if (arrayListSums.size()>1)
            {
                StringBuilder result = new StringBuilder();
                for ( int p : arrayListSums )
                {
                    result.append(p).append( ", " );
                }
                String withoutLastComma = result.substring( 0, result.length( ) - ", ".length( ) );
                System.out.println("Your Scores are : " + withoutLastComma);
            }else {
                System.out.println("Your Score is : " + arrayListSums.get(0));
            }

        if (dicesSum  == 11)
        {
            System.out.println("Wohooo, you're lucky. You've got perfect score!!");
            System.exit(0);
        }else
        {
            System.out.println("Are you ready to roll the dices again? Enter :"
                    + newLine + "A - Dice 1"
                    + newLine + "B - Dice 2"
                    + newLine + "C = Both Dice"
                    + newLine + "D - Quit");
        }
    }


    //rolling dice again to get 11 score
    private static void rollAgain(DiceActivity dice1, DiceActivity dice2,
                                  int dice1Value, int dice2Value, ArrayList<Integer> arrayListSums)
    {
        String input = "Z";

        while (!input.equalsIgnoreCase("D")) {
            Scanner scanner = new Scanner(System.in);
            input = scanner.next().toUpperCase();

            switch (input)
            {
                case "A":
                    dice1Value = dice1.getDiceNumber();

                    checkForSum(dice1Value, dice2Value, arrayListSums);

                    break;
                case "B":
                    dice2Value =  dice2.getDiceNumber();

                    checkForSum(dice1Value, dice2Value, arrayListSums);

                    break;
                case "C":
                    dice1Value =dice1.getDiceNumber();
                    dice2Value =  dice2.getDiceNumber();

                    checkForSum(dice1Value, dice2Value, arrayListSums);

                    break;
                case "D":
                    break;
                default:
                    System.out.println("Please enter valid input.");
                    break;
            }
        }
    }


    //sum of dice numbers
    //check whether list does not enter duplicate values
    private static void sumOfDiceNumbers(int dicesSum, ArrayList<Integer> arrayListSums)
    {
        if (!arrayListSums.isEmpty() && !arrayListSums.contains(dicesSum)) {
            arrayListSums.add(dicesSum);
        }else{
            arrayListSums.add(dicesSum);
        }
    }
}
