package com.example.kiragu.finddoctor;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.headerTextView) TextView mTextView;
    @Bind(R.id.findDoctorButton)
    Button mFindDoctorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//Font
        Typeface amita = Typeface.createFromAsset(getAssets(), "fonts/Amita-Regular.ttf");
        mTextView.setTypeface(amita);

//Onclick listener to take user to the DoctorsActivity
        mFindDoctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DoctorsActivity.class);
                startActivity(intent);
            }
        });

    }
}
