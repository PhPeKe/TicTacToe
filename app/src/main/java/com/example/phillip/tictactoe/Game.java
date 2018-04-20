package com.example.phillip.tictactoe;


import android.support.annotation.BoolRes;

import java.io.Serializable;

import static com.example.phillip.tictactoe.Tile.BLANK;
import static com.example.phillip.tictactoe.Tile.CIRCLE;
import static com.example.phillip.tictactoe.Tile.CROSS;

public class Game implements Serializable{
    final private int BOARD_SIZE = 3;
    private Tile[][] board;
    private int score;

    public Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    public int movesPlayed = 0;
    private Boolean gameOver;

    public Game() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = BLANK;

        playerOneTurn = true;
        gameOver = false;
    }
    public Tile draw(int row, int column) {
        if (board[row][column] == BLANK) {
            if (playerOneTurn) {
                playerOneTurn = !playerOneTurn;
                movesPlayed += 1;
                board[row][column] = CROSS;
                return Tile.CROSS;
            }else {
                playerOneTurn = !playerOneTurn;
                movesPlayed += 1;
                board[row][column] = CIRCLE;
                return Tile.CIRCLE;
            }
        }else {
            return Tile.INVALID;
        }
    }
    // Check board for a winning tile-combination
    public GameState getWin(int row, int col) {
        score = 0;
        for (int i = 0; i<BOARD_SIZE; i++) {
            if (board[row][i] == CROSS) {
                score += 1;
                if (score == 3)
                    return GameState.PLAYER_ONE;
            }
        }
        score = 0;
        for (int i = 0; i<BOARD_SIZE; i++) {
            if (board[i][col] == CROSS) {
                score += 1;
                if (score == 3)
                    return GameState.PLAYER_ONE;
            }
        }
        score = 0;
        for (int i = 0; i<BOARD_SIZE; i++) {
            if (board[row][i] == CIRCLE) {
                score += 1;
                if (score == 3)
                    return GameState.PLAYER_TWO;
            }
        }
        score = 0;
        for (int i = 0; i<BOARD_SIZE; i++) {
            if(board[i][col] == CIRCLE) {
                score += 1;
                if (score == 3)
                    return GameState.PLAYER_TWO;
            }
        }
        score = 0;
        if((board[0][0] == CROSS && board[1][1] == CROSS && board[2][2] == CROSS) || (board[2][0] == CROSS && board[1][1] == CROSS && board[0][2] == CROSS))
            return GameState.PLAYER_ONE;

        if((board[0][0] == CIRCLE && board[1][1] == CIRCLE && board[2][2] == CIRCLE) || (board[2][0] == CIRCLE && board[1][1] == CIRCLE && board[0][2] == CIRCLE))
            return GameState.PLAYER_TWO;

        if(movesPlayed == 9)
            return GameState.DRAW;

        return GameState.IN_PROGRESS;
    }
}
