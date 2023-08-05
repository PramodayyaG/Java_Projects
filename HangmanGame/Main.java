package org.HangmanGame;

//read words from a file -- throw an exception when the file is not found
//randomly select a word
//create two char arrays, one for the word another for the guessing
//loop
//--read a character from user
//--check whether the letter is contained by the random word
//----yes: change the guessing char array + print out the guessing was correct
//         also check whether the game is finished or not
//----no:  decrease the number of chances + print out that the guessing was wrong
//         also check whether user has more chances
//end the game based on the scenarios listed above

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        GameService gameService = new GameService();
        gameService.start();
    }
}
