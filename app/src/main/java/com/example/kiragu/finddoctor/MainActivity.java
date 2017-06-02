package com.example.kiragu.finddoctor;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.headerTextView) TextView mTextView;
    @Bind(R.id.findDoctorButton)
    Button mFindDoctorButton;
    @Bind(R.id.location)
    EditText mLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//Font
        Typeface amita = Typeface.createFromAsset(getAssets(), "fonts/Amita-Regular.ttf");
        mTextView.setTypeface(amita);

//Onclick listener to take user to the DoctorsListActivity
        mFindDoctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == mFindDoctorButton) {
//Passing location to the DoctorsListActivity
                    String location = mLocation.getText().toString();
                    Intent intent = new Intent(MainActivity.this, DoctorsListActivity.class);
                    intent.putExtra("location", location);
                    startActivity(intent);
                }
            }
        });

    }
}
