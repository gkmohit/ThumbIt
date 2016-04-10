package com.iwadevelopers.www.thumbit.View;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.iwadevelopers.www.thumbit.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HelpActivity extends AppCompatActivity {

    @Bind(R.id.helpTextView)
    TextView mHelpTextView;

    @Bind(R.id.homeButton)
    Button mHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ButterKnife.bind(this);

        //The available font types
        Typeface fontAwesome = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf"); //Fontawrsome
        Typeface dotBold = Typeface.createFromAsset(getAssets(), "dotBold.TTF"); //Dot Bold
        Typeface dotMatrix = Typeface.createFromAsset(getAssets(), "dotMatrix.TTF"); //Dot Matrix

        mHelpTextView.setTypeface(dotBold);
        mHomeButton.setTypeface(dotBold);

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HelpActivity.this, HomePage.class);
                finish();
                startActivity(myIntent);
            }
        });

        mHelpTextView.setMovementMethod(new ScrollingMovementMethod());

    }
}
