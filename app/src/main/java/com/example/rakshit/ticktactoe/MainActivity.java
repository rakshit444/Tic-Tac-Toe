package com.example.rakshit.ticktactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   //0 = x , 1 = zero
    int active_player = 0;

    int turn_counter = 0;

    Boolean game_IsActive = true;

    int[] game_state = {2,2,2,2,2,2,2,2,2};

    int[][] winningPossitions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropIn(View view){
        turn_counter++;
        ImageView IV = (ImageView) view;

        int tappedIs = Integer.parseInt(IV.getTag().toString());
        if(game_state[tappedIs] == 2 && game_IsActive)
        {
        System.out.println(IV.getTag().toString());
        game_state[tappedIs] = active_player;

        if( active_player == 0 ){
            IV.setImageResource(R.drawable.x);
            active_player = 1;
        }
        else
        {
            IV.setImageResource(R.drawable.zero);
            active_player = 0;
        }
        IV.setTranslationY(-1000f);
        IV.animate().translationYBy(1000f).setDuration(300);
        }

        for(int[] winningPossition: winningPossitions) {
            if (game_state[winningPossition[0]] == game_state[winningPossition[1]] && game_state[winningPossition[1]] == game_state[winningPossition[2]]
                    && game_state[winningPossition[0]] != 2 && game_state[winningPossition[1]] != 2 && game_state[winningPossition[2]] != 2) {

                Boolean game_IsActive = false;

                System.out.println("won" + game_state[winningPossition[0]]);

                TextView textview = (TextView) findViewById(R.id.textView);

                if(game_state[winningPossition[0]] == 0){

                    textview.setText("Player 1 has won ");
                }else{

                    textview.setText("Player 2 has won ");

                }
            LinearLayout ll = (LinearLayout) findViewById(R.id.linear_layout);

            ll.setVisibility(View.VISIBLE);}
             if(turn_counter == 9) {

                        TextView textview = (TextView) findViewById(R.id.textView);
                        textview.setText("DRAW ");
                        LinearLayout ll = (LinearLayout) findViewById(R.id.linear_layout);
                        ll.setVisibility(View.VISIBLE);}}}







    public void play_again(View view){

        turn_counter = 0;

        Boolean game_IsActive = true;

        LinearLayout ll = (LinearLayout) findViewById(R.id.linear_layout);

        ll.setVisibility(View.INVISIBLE);

        active_player = 0;

        for(int i = 0; i< game_state.length;i++){
            game_state[i] = 2;
        }
        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid_layout);
        for (int j = 0; j< gridLayout.getChildCount(); j++){

            ((ImageView)gridLayout.getChildAt(j)).setImageResource(android.R.color.transparent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
