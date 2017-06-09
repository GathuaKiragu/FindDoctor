package com.example.kiragu.finddoctor.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kiragu.finddoctor.Constants;
import com.example.kiragu.finddoctor.R;

/**
 * A simple {@link Fragment} subclass.
 */
import com.example.kiragu.finddoctor.models.Doctor;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import org.parceler.Parcels;
import butterknife.Bind;
import butterknife.ButterKnife;

    public class DoctorsDetailFragment extends Fragment implements View.OnClickListener{
        @Bind(R.id.doctorImageView)
        ImageView mDoctorImageView;
        @Bind(R.id.doctorsNameTextView)
        TextView mDoctorsNameTextView;
        @Bind(R.id.websiteTextView)
        TextView mWebsiteTextView;
        @Bind(R.id.phoneTextView)
        TextView mPhoneTextView;
        @Bind(R.id.addressTextView) TextView mAddressTextView;
        @Bind(R.id.saveDoctorsButton)
        Button mSaveDoctorsButton;
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
            mAddressTextView.setText(mDoctor.getAddress());

            mWebsiteTextView.setOnClickListener(this);
            mAddressTextView.setOnClickListener(this);
            mSaveDoctorsButton.setOnClickListener(this);

            return view;
        }
//Onclick listener
        @Override
        public void onClick(View v) {
            if (v == mWebsiteTextView) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(mDoctor.getWebsite()));
                startActivity(webIntent);
            }
            if (v == mAddressTextView) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:" + mDoctor.getLatitude()
                                + "," + mDoctor.getLongitude()
                                + "?q=(" + mDoctor.getName() + ")"));
                startActivity(mapIntent);
            }
            if (v == mSaveDoctorsButton) {
                DatabaseReference doctorRef = FirebaseDatabase
                        .getInstance()
                        .getReference(Constants.FIREBASE_CHILD_DOCTORS);
                doctorRef.push().setValue(mDoctor);
                Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
            }
        }
    }