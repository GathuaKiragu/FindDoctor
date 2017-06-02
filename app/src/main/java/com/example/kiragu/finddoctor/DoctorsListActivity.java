package com.example.kiragu.finddoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DoctorsListActivity extends AppCompatActivity {
    @Bind(R.id.doctorLocation)
    TextView mDoctorLocation;

    @Bind(R.id.doctorList)
    ListView mDoctorList;
    public static final String TAG = DoctorsListActivity.class.getSimpleName();
    public ArrayList<Doctor> mDoctors = new ArrayList<>();

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
            public void onResponse(Call call, Response response) {
                mDoctors = betterDoctorService.processResults(response);

                DoctorsListActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        String[] restaurantNames = new String[mDoctors.size()];
                        for (int i = 0; i < restaurantNames.length; i++) {
                            restaurantNames[i] = mDoctors.get(i).getName();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(DoctorsListActivity.this,
                                android.R.layout.simple_list_item_1, restaurantNames);
                        mDoctorList.setAdapter(adapter);

                        for (Doctor doctor : mDoctors) {
                            Log.d(TAG, "Name: " + doctor.getName());
                            Log.d(TAG, "Website: " + doctor.getTitle());
                            Log.d(TAG, "Image url: " + doctor.getImage());
                            Log.d(TAG, "Rating: " + Double.toString(doctor.getRating()));
                            Log.d(TAG, "Phone: " + android.text.TextUtils.join(", ", doctor.getPhone()));
                            Log.d(TAG, "Specialty: " + doctor.getSpecialty().toString());
                        }
                    }

                });
            }
        });
    }
}
