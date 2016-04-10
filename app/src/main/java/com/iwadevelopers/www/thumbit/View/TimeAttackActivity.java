package com.iwadevelopers.www.thumbit.View;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iwadevelopers.www.thumbit.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TimeAttackActivity extends AppCompatActivity {

    public static String TAG = TimeAttackActivity.class.getSimpleName();

    @Bind(R.id.timerText)
    TextView mTimerText;

    @Bind(R.id.playerTwo)
    RelativeLayout mPlayerTwo;

    @Bind(R.id.playerOne)
    RelativeLayout mPlayerOne;

    @Bind(R.id.playAgainText)
    TextView mPlayAgainText;

    @Bind(R.id.returnHomeText)
    TextView mReturnHomeText;

    @Bind(R.id.playerOneScore)
    TextView mPlayerOneScore;

    @Bind(R.id.playerTwoScore)
    TextView mPlayerTwoScore;

    @Bind(R.id.playerOneFinalScore)
    TextView mPlayerOneFinalScore;

    @Bind(R.id.playerTwoFinalScore)
    TextView mPlayerTwoFinalScore;

    @Bind(R.id.countdownBar)
    RelativeLayout mCountdownBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_attack);
        ButterKnife.bind(this);

        final int[] playerOneScore = {0};
        final int[] playerTwoScore = {0};

        //The available font types
        Typeface fontAwesome = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf"); //Fontawrsome
        Typeface dotBold = Typeface.createFromAsset(getAssets(), "dotBold.TTF"); //Dot Bold
        Typeface dotMatrix = Typeface.createFromAsset(getAssets(), "dotMatrix.TTF"); //Dot Matrix

        mTimerText.setTypeface(dotBold);
        mPlayAgainText.setTypeface(dotBold);
        mReturnHomeText.setTypeface(dotBold);
        mPlayerOneScore.setTypeface(dotBold);
        mPlayerTwoScore.setTypeface(dotBold);
        mPlayerOneFinalScore.setTypeface(dotBold);
        mPlayerTwoFinalScore.setTypeface(dotBold);

        mTimerText.setVisibility(View.INVISIBLE);
        new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long timeInSeconds = millisUntilFinished / 1000;
                mPlayerOne.setClickable(false);
                mPlayerTwo.setClickable(false);
                mPlayerOneScore.setText("" + timeInSeconds);
                mPlayerTwoScore.setText("" + timeInSeconds);
            }

            @Override
            public void onFinish() {
                mTimerText.setText(getResources().getString(R.string.go));
                mPlayerOneScore.setText(getResources().getString(R.string.start_tapping_text));
                mPlayerTwoScore.setText(getResources().getString(R.string.start_tapping_text));
                mPlayerOne.setClickable(true);
                mPlayerTwo.setClickable(true);
                mTimerText.setVisibility(View.VISIBLE);


                new CountDownTimer(21000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        long timeInSeconds = millisUntilFinished / 1000;
                        mTimerText.setText(timeInSeconds + "");
                        if (timeInSeconds <= 14) {
                            mCountdownBar.setBackgroundColor(getResources().getColor(R.color.progress_bar_color_midway));
                        }
                        if (timeInSeconds <= 7) {
                            mCountdownBar.setBackgroundColor(getResources().getColor(R.color.progress_bar_color_ending));
                        }

                        mPlayerOne.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                playerOneScore[0] = playerOneScore[0] + 1;
                                mPlayerOneScore.setText(playerOneScore[0] + "");

                            }
                        });
                        mPlayerTwo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                playerTwoScore[0] = playerTwoScore[0] + 1;
                                mPlayerTwoScore.setText(playerTwoScore[0] + "");
                            }
                        });
                    }

                    @Override
                    public void onFinish() {

                        //Removing clickables
                        mPlayerOne.setClickable(false);
                        mPlayerTwo.setClickable(false);
                        //Setting scores
                        mPlayerOneScore.setText(playerOneScore[0] + "");
                        mPlayerTwoScore.setText(playerTwoScore + "");
                        mTimerText.setVisibility(View.INVISIBLE);

                        //Checking for winner
                        if (playerOneScore[0] > playerTwoScore[0]) {
                            mPlayerOneScore.setText(getResources().getString(R.string.winner));
                            mPlayerTwoScore.setText(getResources().getString(R.string.you_lost));
                        } else {
                            mPlayerTwoScore.setText(getResources().getString(R.string.winner));
                            mPlayerOneScore.setText(getResources().getString(R.string.you_lost));
                        }

                        mReturnHomeText.setVisibility(View.VISIBLE);
                        mPlayAgainText.setVisibility(View.VISIBLE);
                        mPlayerOneScore.setVisibility(View.VISIBLE);
                        mPlayerTwoScore.setVisibility(View.VISIBLE);

                        mReturnHomeText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent myIntent = new Intent(TimeAttackActivity.this, HomePage.class);
                                finish();
                                startActivity(myIntent);
                            }
                        });

                        mPlayAgainText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent myIntent = getIntent();
                                finish();
                                startActivity(myIntent);
                            }
                        });
                    }

                }.start();
            }
        }.start();
    }
}
