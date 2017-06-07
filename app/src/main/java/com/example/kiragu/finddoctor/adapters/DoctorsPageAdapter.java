package com.example.kiragu.finddoctor.adapters;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kiragu.finddoctor.models.Doctor;
import com.example.kiragu.finddoctor.ui.DoctorsDetailFragment;

import java.util.ArrayList;

/**
 * Created by kiragu on 6/5/17.
 */

public class DoctorsPageAdapter extends FragmentPagerAdapter {
    private ArrayList<Doctor> mDoctors;

    public DoctorsPageAdapter(FragmentManager fm, ArrayList<Doctor> doctors) {
        super(fm);
        mDoctors = doctors;
    }
    @Override
    public Fragment getItem(int position) {
        return DoctorsDetailFragment.newInstance(mDoctors.get(position));
    }
    @Override
    public int getCount() {
        return mDoctors.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDoctors.get(position).getName();
    }
}