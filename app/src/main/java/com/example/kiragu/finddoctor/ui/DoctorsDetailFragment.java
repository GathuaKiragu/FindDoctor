package com.example.kiragu.finddoctor.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kiragu.finddoctor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorsDetailFragment extends Fragment {


    public DoctorsDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctors_detail, container, false);
    }

}
