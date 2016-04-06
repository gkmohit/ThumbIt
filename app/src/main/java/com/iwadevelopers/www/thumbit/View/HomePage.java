package com.iwadevelopers.www.thumbit.View;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.iwadevelopers.www.thumbit.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomePage extends AppCompatActivity {

    @Bind(R.id.thumbText)
    TextView mThumbText;

    @Bind(R.id.tagLineText)
    TextView mTagLineText;

    @Bind(R.id.firstTo100Text)
    TextView mFirstTo100Text;

    @Bind(R.id.againstTimeText)
    TextView mAgainstTimeText;

    @Bind(R.id.helpText)
    TextView mHelpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);


        Typeface fontAwesome = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf"); //Fontawrsome
        Typeface dotBold = Typeface.createFromAsset(getAssets(), "dotBold.TTF"); //Dot Bold
        Typeface dotMatrix = Typeface.createFromAsset(getAssets(), "dotMatrix.TTF"); //Dot Matrix

        mFirstTo100Text.setTypeface(dotBold);
        mAgainstTimeText.setTypeface(dotBold);
        mHelpText.setTypeface(dotBold);
        mThumbText.setTypeface(dotBold);
        mTagLineText.setTypeface(dotBold);

        mFirstTo100Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomePage.this, MainActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                HomePage.this.startActivity(myIntent);
            }
        });
    }
}
