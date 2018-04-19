package com.example.phillip.tictactoe;

import static com.example.phillip.tictactoe.Tile.BLANK;
import static com.example.phillip.tictactoe.Tile.CIRCLE;
import static com.example.phillip.tictactoe.Tile.CROSS;

public class Game {
    final private int BOARD_SIZE = 3;
    private Tile[][] board;

    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
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
                board[row][column] = CROSS;
                return Tile.CROSS;
            }else {
                playerOneTurn = !playerOneTurn;
                board[row][column] = CIRCLE;
                return Tile.CIRCLE;
            }
        }else {
            return Tile.INVALID;
        }
    }
}
