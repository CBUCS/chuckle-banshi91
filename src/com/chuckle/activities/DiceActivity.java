package com.chuckle.activities;

import java.util.Random;

/**
 * This class is used to get random numbers of
 * dice from 1 to 6
 */
class DiceActivity
{

    private int diceNumber;

    //this method is used for generating random number
    //limit is 6
    private int getRandomDiceValue()
    {
        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(6) + 1;
        return randomNumber;
    }

    //this method returns random dice number
    int getDiceNumber()
    {
        diceNumber = getRandomDiceValue();
        return  diceNumber;
    }
}
