package com.example.kiragu.finddoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DoctorsListActivity extends AppCompatActivity {
    @Bind(R.id.doctorLocation)
    TextView mDoctorLocation;

    public static final String TAG = DoctorsListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorslist);
        ButterKnife.bind(this);
//Receive passed location
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mDoctorLocation.setText("Doctors Around: " + location);
        getDoctors(location);

    }
    private void getDoctors(String location) {
        final BetterDoctorService betterDoctorService = new BetterDoctorService();
        betterDoctorService.findDoctors(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
