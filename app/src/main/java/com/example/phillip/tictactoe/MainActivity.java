package com.example.phillip.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

        Tile tile = game.draw(row,col);
        switch(tile) {
            case CROSS:
                button.setText("X");
                break;
            case CIRCLE:
                button.setText("O");
                break;
            case INVALID:
                break;
        }
    }
}
