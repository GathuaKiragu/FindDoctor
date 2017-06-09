package com.example.kiragu.finddoctor.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiragu.finddoctor.R;

/**
 * A simple {@link Fragment} subclass.
 */
import com.example.kiragu.finddoctor.models.Doctor;
import com.squareup.picasso.Picasso;
import org.parceler.Parcels;
import butterknife.Bind;
import butterknife.ButterKnife;

    public class DoctorsDetailFragment extends Fragment {
        @Bind(R.id.doctorImageView)
        ImageView mDoctorImageView;
        @Bind(R.id.doctorsNameTextView)
        TextView mDoctorsNameTextView;
        @Bind(R.id.websiteTextView)
        TextView mWebsiteTextView;
        @Bind(R.id.phoneTextView)
        TextView mPhoneTextView;
        @Bind(R.id.specialtyTextView) TextView mSpecialty;

        private Doctor mDoctor;

        public static DoctorsDetailFragment newInstance(Doctor doctor) {
            DoctorsDetailFragment doctorsDetailFragment = new DoctorsDetailFragment();
            Bundle args = new Bundle();
            args.putParcelable("doctor", Parcels.wrap(doctor));
            doctorsDetailFragment.setArguments(args);
            return doctorsDetailFragment;
        }
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mDoctor = Parcels.unwrap(getArguments().getParcelable("doctor"));
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_doctors_detail, container, false);
            ButterKnife.bind(this, view);
            Picasso.with(view.getContext()).load(mDoctor.getImage()).into(mDoctorImageView);
            mDoctorsNameTextView.setText(mDoctor.getName());
            mWebsiteTextView.setText(mDoctor.getWebsite());
            mPhoneTextView.setText(android.text.TextUtils.join(", ", mDoctor.getPhone()));
            mSpecialty.setText(android.text.TextUtils.join(", ", mDoctor.getSpecialty()));
            return view;
        }
    }