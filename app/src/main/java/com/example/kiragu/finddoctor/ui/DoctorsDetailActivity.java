package com.example.kiragu.finddoctor.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kiragu.finddoctor.R;
import com.example.kiragu.finddoctor.adapters.DoctorsPageAdapter;
import com.example.kiragu.finddoctor.models.Doctor;
import org.parceler.Parcels;
import java.util.ArrayList;
import butterknife.Bind;
import butterknife.ButterKnife;

public class DoctorsDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager)
    ViewPager mViewPager;
    private DoctorsPageAdapter adapterViewPager;
    ArrayList<Doctor> mDoctors = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_detail);
            ButterKnife.bind(this);

            mDoctors = Parcels.unwrap(getIntent().getParcelableExtra("doctors"));
            int startingPosition = getIntent().getIntExtra("position", 0);
            adapterViewPager = new DoctorsPageAdapter(getSupportFragmentManager(), mDoctors);
            mViewPager.setAdapter(adapterViewPager);
            mViewPager.setCurrentItem(startingPosition);
        }
}
