package com.example.phillip.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();
    }
    public void tileClicked (View view) {
        int id = view.getId();
        int row = 0;
        int col = 0;
        Button button = null;

        System.out.println(id);
        switch(id) {
            case 2131165220:
                button = findViewById(R.id.button);
                row = 0;
                col = 0;
                break;

            case 2131165229:
                button = findViewById(R.id.button9);
                row = 0;
                col = 1;
                break;

            case 2131165228:
                button = findViewById(R.id.button8);
                row = 0;
                col = 2;
                break;

            case 2131165227:
                button = findViewById(R.id.button7);
                row = 1;
                col = 0;
                break;

            case 2131165226:
                button = findViewById(R.id.button6);
                row = 1;
                col = 1;
                break;

            case 2131165225:
                button = findViewById(R.id.button5);
                row = 1;
                col = 2;
                break;

            case 2131165224:
                button = findViewById(R.id.button4);
                row = 2;
                col = 0;
                break;

            case 2131165223:
                button = findViewById(R.id.button3);
                row = 2;
                col = 1;
                break;

            case 2131165222:
                button = findViewById(R.id.button2);
                row = 2;
                col = 2;
                break;
        }


        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Invalid move!");
        alertDialog.setMessage("You cant click the same field twice!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


        Tile tile = game.draw(row,col);
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
    }
    public void resetClicked(View view) {

        AlertDialog alertDialog2 = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog2.setTitle("New Game");
        alertDialog2.setMessage("Game is reset!");
        alertDialog2.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        game = new Game();

        alertDialog2.show();

        Button button = findViewById(R.id.button);
        button.setText("BUTTON");
        button = findViewById(R.id.button2);
        button.setText("BUTTON");
        button = findViewById(R.id.button3);
        button.setText("BUTTON");
        button = findViewById(R.id.button4);
        button.setText("BUTTON");
        button = findViewById(R.id.button5);
        button.setText("BUTTON");
        button = findViewById(R.id.button6);
        button.setText("BUTTON");
        button = findViewById(R.id.button7);
        button.setText("BUTTON");
        button = findViewById(R.id.button8);
        button.setText("BUTTON");
        button = findViewById(R.id.button9);
        button.setText("BUTTON");

    }
}
