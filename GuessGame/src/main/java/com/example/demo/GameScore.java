package com.example.demo;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "GameScores")
public class GameScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String playerName;
    private int attempts;
    private LocalDateTime playDate = LocalDateTime.now();

    // Constructors
    public GameScore() {}

    public GameScore(String playerName, int attempts) {
        this.playerName = playerName;
        this.attempts = attempts;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public int getAttempts() { return attempts; }
    public void setAttempts(int attempts) { this.attempts = attempts; }

    public LocalDateTime getPlayDate() { return playDate; }
    public void setPlayDate(LocalDateTime playDate) { this.playDate = playDate; }
}
