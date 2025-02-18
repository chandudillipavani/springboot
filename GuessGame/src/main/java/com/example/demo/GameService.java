package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.Scanner;

@Service
public class GameService {
    
    @Autowired
    private GameScoreRepository gameScoreRepository;

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.println("Guess a number between 1 and 100:");

        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                guessedCorrectly = true;
            }
        }

        // Save score to the database
        GameScore score = new GameScore(playerName, attempts);
        gameScoreRepository.save(score);
        System.out.println("Score saved to the database.");
        scanner.close();
    }
}

