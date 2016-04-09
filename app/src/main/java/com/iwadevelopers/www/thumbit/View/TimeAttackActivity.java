package com.iwadevelopers.www.thumbit.View;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.iwadevelopers.www.thumbit.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TimeAttackActivity extends AppCompatActivity {

    public static String TAG = TimeAttackActivity.class.getSimpleName();

    @Bind(R.id.countdownProgressBar)
    ProgressBar mCountdownProgressBar;

    @Bind(R.id.playerTwo)
    RelativeLayout mPlayerTwo;

    @Bind(R.id.playerOne)
    RelativeLayout mPlayerOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_attack);
        ButterKnife.bind(this);
        CountDownTimer mCountDownTimer;
        final int[] i = {0};

        mCountdownProgressBar.setProgress(i[0]);
        mCountDownTimer=new CountDownTimer(60000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress"+ i[0] + millisUntilFinished);
                i[0]++;
                mCountdownProgressBar.setProgress(i[0]);

            }

            @Override
            public void onFinish() {
                //Do what you want
                i[0]++;
                mCountdownProgressBar.setProgress(i[0]);
            }
        };
        mCountDownTimer.start();
    }
}
