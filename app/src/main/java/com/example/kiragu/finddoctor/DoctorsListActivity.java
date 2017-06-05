package com.example.kiragu.finddoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.kiragu.finddoctor.adapters.DoctorsListAdapter;
import com.example.kiragu.finddoctor.models.Doctor;
import com.example.kiragu.finddoctor.services.BetterDoctorService;
import java.io.IOException;
import java.util.ArrayList;
import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DoctorsListActivity extends AppCompatActivity {
    public static final String TAG = DoctorsListActivity.class.getSimpleName();
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private DoctorsListAdapter mAdapter;
    public ArrayList<Doctor> mDoctors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorslist);
        ButterKnife.bind(this);
//Receive passed location
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
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
                            mAdapter = new DoctorsListAdapter(getApplicationContext(), mDoctors);
                            mRecyclerView.setAdapter(mAdapter);
                            RecyclerView.LayoutManager layoutManager =
                                    new LinearLayoutManager(DoctorsListActivity.this);
                            mRecyclerView.setLayoutManager(layoutManager);
                            mRecyclerView.setHasFixedSize(true);
                        }
                });
            }
        });
    }
}