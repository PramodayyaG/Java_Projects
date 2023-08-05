package org.HangmanGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameService {
    //private String path = "input.txt";
    public void start() throws FileNotFoundException {
        Scanner inputScanner = new Scanner(System.in);
        String randomWords = getRandomWord();
        //chararray one for random word and other one for user
        char[] randomWordArray = randomWords.toCharArray();
        char[] guessingArray = new char[randomWords.length()];

//        System.out.println(guessingArray);
        Arrays.fill(guessingArray, '_');

        int nunberOfChances = randomWords.length();

        System.out.println("Starting the game...!");
        System.out.print("The length of the word and the number of chances are same : "+nunberOfChances+"\n");
        System.out.println(new String(guessingArray));

        while (true){
            System.out.println("----------------------------------------------------------------------------");
            System.out.print("Please type in a letter: ");
            char letter = inputScanner.nextLine().toLowerCase().charAt(0);

            boolean isGuessingCorrect = false;
            for (int i = 0; i < randomWords.length(); i++) {
                if(letter == randomWordArray[i]){
                    guessingArray[i]=letter;

                    isGuessingCorrect=true;
                }
            }
            if(isGuessingCorrect){
                System.out.println("You guessed it correct, go for next letter");
                if (isGameFinshed(guessingArray)){
                    break;
                }
            }
            else {
                nunberOfChances--;
                if (nunberOfChances==0) {
                    System.out.println("Sorry you ran out of chances");
                    System.out.println("The word is: "+randomWords);
                    break;
                }
                System.out.println("Letter is not matching... Please Try again!");
                System.out.println("Number of chances are remaining: "+nunberOfChances);
            }
            System.out.println("The word: "+new String(guessingArray));
        }
    }

    private boolean isGameFinshed(char[] guessingArray) {
        for (int i = 0; i < guessingArray.length; i++) {
            if (guessingArray[i] == '_') {
                return false;
            }
        }
        System.out.println("Congratulations you won...!");
        System.out.println("The word: "+new String(guessingArray));
        return true;
    }

    private String getRandomWord() throws FileNotFoundException {
        List<String> words = getTheWords();
        Random randomNumber = new Random();
        int randomIndex = randomNumber.nextInt(words.size());

        return words.get(randomIndex);
    }
    private List<String> getTheWords() throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        File wordsFile = new File("input.txt");
        Scanner wordsScanner = new Scanner(wordsFile);
        while (wordsScanner.hasNextLine()){
            words.add(wordsScanner.nextLine());
        }
        return words;
    }

}
