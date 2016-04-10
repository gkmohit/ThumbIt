package com.iwadevelopers.www.thumbit.View;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iwadevelopers.www.thumbit.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.playerOne)
    RelativeLayout mPlayerOne;

    @Bind(R.id.playerTwo)
    RelativeLayout mPlayerTwo;

    @Bind(R.id.playerOneScoreText)
    TextView mPlayerOneScoreText;

    @Bind(R.id.playerTwoScoreText)
    TextView mPlayerTwoScoreText;

    @Bind(R.id.hyfenText)
    TextView mHyfenText;

    @Bind(R.id.playerOneWinnerText)
    TextView mPlayerOneWinnerText;

    @Bind(R.id.playerTwoWinnerText)
    TextView mPlayerTwoWinnerText;

    @Bind(R.id.playerOneFinalScoreText)
    TextView mPlayerOneFinalScore;


    @Bind(R.id.playerTwoFinalScoreText)
    TextView mPlayerTwoFinalScore;


    public final int WINNER_SCORE = 10;
    public static boolean isDone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //The available font types
        Typeface fontAwesome = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf"); //Fontawrsome
        Typeface dotBold = Typeface.createFromAsset(getAssets(), "dotBold.TTF"); //Dot Bold
        Typeface dotMatrix = Typeface.createFromAsset(getAssets(), "dotMatrix.TTF"); //Dot Matrix

        //Setting font types
        mPlayerOneScoreText.setTypeface(dotBold);
        mPlayerTwoScoreText.setTypeface(dotBold);
        mHyfenText.setTypeface(dotBold);
        mPlayerOneWinnerText.setTypeface(dotBold);
        mPlayerTwoWinnerText.setTypeface(dotBold);
        mPlayerOneFinalScore.setTypeface(dotBold);
        mPlayerTwoFinalScore.setTypeface(dotBold);

        //Setting text and visibility
        mPlayerOneScoreText.setText("0");
        mPlayerTwoScoreText.setText("0");


        final int[] playerOneScore = {0};
        final int[] playerTwoScore = {0};


        new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {
                long timeInSeconds = millisUntilFinished / 1000;
                mPlayerOneWinnerText.setText( "" +  timeInSeconds);
                mPlayerTwoWinnerText.setText( "" +  timeInSeconds);
            }

            public void onFinish() {
                mPlayerOneWinnerText.setText(R.string.start_tapping_text);
                mPlayerTwoWinnerText.setText(R.string.start_tapping_text);
                setClickable(mPlayerOne, true);
                setClickable(mPlayerTwo, true);

                //Player one
                mPlayerOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playerOneScore[0] = Integer.parseInt(mPlayerOneScoreText.getText().toString().trim());
                        playerOneScore[0] = playerOneScore[0] + 1;
                        mPlayerOneScoreText.setText(playerOneScore[0] + "");
                        if(playerOneScore[0] < WINNER_SCORE){
                            mPlayerOneWinnerText.setVisibility(View.INVISIBLE);
                            mPlayerTwoWinnerText.setVisibility(View.INVISIBLE);
                            Log.d(TAG, "player one clicked " + playerOneScore[0]);
                        } else if(playerOneScore[0] > WINNER_SCORE){
                            Log.d(TAG, "PLAYER ONE WINS");

                            //Setting texts
                            mPlayerOneWinnerText.setText(R.string.winner);
                            mPlayerTwoWinnerText.setText(R.string.you_lost);
                            mPlayerOneFinalScore.setText(playerOneScore[0] + "");
                            mPlayerTwoFinalScore.setText(playerTwoScore[0] + "");
                            setScoreAndWInner();
                            //Setting clickable
                            setClickable(mPlayerOne, false);
                            setClickable(mPlayerTwo, false);
                            isDone = true;
                        }

                    }
                });

                //Player two
                mPlayerTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playerTwoScore[0] = Integer.parseInt(mPlayerTwoScoreText.getText().toString().trim());
                        playerTwoScore[0] = playerTwoScore[0] + 1;
                        mPlayerTwoScoreText.setText(playerTwoScore[0] + "");
                        if(playerTwoScore[0] < WINNER_SCORE) {
                            mPlayerOneWinnerText.setVisibility(View.INVISIBLE);
                            mPlayerTwoWinnerText.setVisibility(View.INVISIBLE);
                            Log.d(TAG, "player two clicked " + playerTwoScore[0]);
                        } else{
                            Log.d(TAG, "PLAYER TWO WINS");
                            //Setting texts
                            mPlayerTwoWinnerText.setText(R.string.winner);
                            mPlayerOneWinnerText.setText(R.string.you_lost);
                            mPlayerOneFinalScore.setText(playerOneScore[0] + "");
                            mPlayerTwoFinalScore.setText(playerTwoScore[0] + "");
                            setScoreAndWInner();
                            //Setting clickable
                            setClickable(mPlayerOne, false);
                            setClickable(mPlayerTwo, false);
                            isDone = true;

                        }
                    }
                });
                    mPlayerOneScoreText.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = getIntent();
                            finish();
                            startActivity(myIntent);
                        }
                    });

                    mPlayerTwoScoreText.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent myIntent = new Intent(MainActivity.this, HomePage.class);
                            finish();
                            startActivity(myIntent);
                        }
                    });
            }
        }.start();


    }

    public void setScoreAndWInner() {
        mPlayerOneScoreText.setText(getResources().getString(R.string.play_again));
        mPlayerTwoScoreText.setText(getResources().getString(R.string.return_home));
//        mPlayerOneScoreText.setTextSize(getResources().getDimension(R.dimen.play_again_text_size));
//        mPlayerTwoScoreText.setTextSize(getResources().getDimension(R.dimen.play_again_text_size));

        //Setting Visibility
        mPlayerOneWinnerText.setVisibility(View.VISIBLE);
        mPlayerTwoWinnerText.setVisibility(View.VISIBLE);
        mPlayerOneFinalScore.setVisibility(View.VISIBLE);
        mPlayerTwoFinalScore.setVisibility(View.VISIBLE);
    }

    public void setClickable(RelativeLayout inLayout, Boolean inValue){
        inLayout.setClickable(inValue);
    }

//    public ;

}

