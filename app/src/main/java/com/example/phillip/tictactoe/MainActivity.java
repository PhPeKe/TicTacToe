package com.example.phillip.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;


import java.io.Serializable;

import static com.example.phillip.tictactoe.GameState.PLAYER_ONE;
import static com.example.phillip.tictactoe.GameState.PLAYER_TWO;
import static com.example.phillip.tictactoe.Tile.CROSS;

public class MainActivity extends AppCompatActivity {

    Game game;
    public boolean playerOneTurn = true;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        game = new Game();
    }
    public void tileClicked (final View view) {
        int id = view.getId();
        int row = 0;
        int col = 0;
        Button button = null;

        switch(id) {
            case 2131165220:
                button = button1;
                row = 0;
                col = 0;
                break;

            case 2131165229:
                button = button9;
                row = 0;
                col = 1;
                break;

            case 2131165228:
                button = button8;
                row = 0;
                col = 2;
                break;

            case 2131165227:
                button = button7;
                row = 1;
                col = 0;
                break;

            case 2131165226:
                button = button6;
                row = 1;
                col = 1;
                break;

            case 2131165225:
                button = button5;
                row = 1;
                col = 2;
                break;

            case 2131165224:
                button = button4;
                row = 2;
                col = 0;
                break;

            case 2131165223:
                button = button3;
                row = 2;
                col = 1;
                break;

            case 2131165222:
                button = button2;
                row = 2;
                col = 2;
                break;
        }


        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Invalid move!");
        alertDialog.setMessage("You cannot click the same field twice!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Got it",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog win1 = new AlertDialog.Builder(MainActivity.this).create();
        win1.setTitle("Player One Won!");
        win1.setMessage("Congratulations!");
        win1.setButton(AlertDialog.BUTTON_NEUTRAL, "Thanks!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        resetClicked(view);
                    }
                });
        AlertDialog win2 = new AlertDialog.Builder(MainActivity.this).create();
        win2.setTitle("Player Two Won!");
        win2.setMessage("Congratulations!");
        win2.setButton(AlertDialog.BUTTON_NEUTRAL, "Thanks!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        resetClicked(view);
                    }
                });
        AlertDialog pat = new AlertDialog.Builder(MainActivity.this).create();
        pat.setTitle("Its a Draw!");
        pat.setMessage("Nobody wins...");
        pat.setButton(AlertDialog.BUTTON_NEUTRAL, "Try again!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        resetClicked(view);
                    }
                });

        Tile tile = game.draw(row,col);
        playerOneTurn = game.playerOneTurn;
        switch(tile) {
            case CROSS:
                button.setText("X");
                break;
            case CIRCLE:
                button.setText("O");
                break;
            case INVALID:
                alertDialog.show();
                break;
        }
        GameState g = game.getWin(row, col);

        switch(g){

            case PLAYER_ONE:
                win1.show();
                break;
            case PLAYER_TWO:
                win2.show();
                break;
            case DRAW:
                pat.show();
                break;
        }
    }
    public void resetClicked(View view) {

        AlertDialog newgame = new AlertDialog.Builder(MainActivity.this).create();
        newgame.setMessage("New Game");
        newgame.setButton(AlertDialog.BUTTON_NEUTRAL, "Play!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        game = new Game();

        newgame.show();

        button1.setText("BUTTON");
        button2.setText("BUTTON");
        button3.setText("BUTTON");
        button4.setText("BUTTON");
        button5.setText("BUTTON");
        button6.setText("BUTTON");
        button7.setText("BUTTON");
        button8.setText("BUTTON");
        button9.setText("BUTTON");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean("turn", playerOneTurn);
        outState.putSerializable("game", game);
        outState.putString("button", button1.getText().toString());
        outState.putString("button2", button2.getText().toString());
        outState.putString("button3", button3.getText().toString());
        outState.putString("button4", button4.getText().toString());
        outState.putString("button5", button5.getText().toString());
        outState.putString("button6", button6.getText().toString());
        outState.putString("button7", button7.getText().toString());
        outState.putString("button8", button8.getText().toString());
        outState.putString("button9", button9.getText().toString());

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        game.playerOneTurn = savedInstanceState.getBoolean("turn");

        game = (Game) savedInstanceState.getSerializable("game");
        button1.setText(savedInstanceState.getString("button"));
        button2.setText(savedInstanceState.getString("button2"));
        button3.setText(savedInstanceState.getString("button3"));
        button4.setText(savedInstanceState.getString("button4"));
        button5.setText(savedInstanceState.getString("button5"));
        button6.setText(savedInstanceState.getString("button6"));
        button7.setText(savedInstanceState.getString("button7"));
        button8.setText(savedInstanceState.getString("button8"));
        button9.setText(savedInstanceState.getString("button9"));

    }
}
