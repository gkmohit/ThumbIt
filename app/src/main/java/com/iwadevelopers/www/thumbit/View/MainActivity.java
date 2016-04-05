package com.iwadevelopers.www.thumbit.View;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iwadevelopers.www.thumbit.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.playerOne)
    LinearLayout mPlayerOne;

    @Bind(R.id.playerTwo)
    LinearLayout mPlayerTwo;

    @Bind(R.id.playerOneScoreText)
    TextView mPlayerOneScoreText;

    @Bind(R.id.playerTwoScoreText)
    TextView mPlayerTwoScoreText;

    @Bind(R.id.hyfenText)
    TextView mHyfenText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface fontAwesome = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf"); //Fontawrsome
        Typeface dotBold = Typeface.createFromAsset(getAssets(), "dotBold.TTF"); //Dot Bold
        Typeface dotMatrix = Typeface.createFromAsset(getAssets(), "dotMatrix.TTF"); //Dot Matrix

        mPlayerOneScoreText.setTypeface(dotBold);
        mPlayerTwoScoreText.setTypeface(dotBold);
        mHyfenText.setTypeface(dotBold);

        mPlayerOneScoreText.setText("0");
        mPlayerTwoScoreText.setText("0");

        final int[] playerOneScore = {0};
        final int[] playerTwoScore = {0};

        mPlayerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerOneScore[0] = Integer.parseInt(mPlayerOneScoreText.getText().toString().trim());
                playerOneScore[0] = playerOneScore[0] + 1;
                Log.d(TAG, "player one clicked " + playerOneScore[0]);
                mPlayerOneScoreText.setText(playerOneScore[0] + "");
            }
        });

        mPlayerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerTwoScore[0] = Integer.parseInt(mPlayerTwoScoreText.getText().toString().trim());
                playerTwoScore[0] = playerTwoScore[0] + 1;
                Log.d(TAG, "player two clicked " + playerTwoScore[0]);
                mPlayerTwoScoreText.setText(playerTwoScore[0] + "");
            }
        });
    }
}
