package com.example.kiragu.finddoctor.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiragu.finddoctor.R;
import com.example.kiragu.finddoctor.models.Doctor;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kiragu on 6/3/17.
 */

public class DoctorsListAdapter extends RecyclerView.Adapter<DoctorsListAdapter.DoctorsViewHolder> {
    private ArrayList<Doctor> mDoctors = new ArrayList<>();
    private Context mContext;

    public DoctorsListAdapter(Context context, ArrayList<Doctor> doctors) {
        mContext = context;
        mDoctors = doctors;
    }

    @Override
    public DoctorsListAdapter.DoctorsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctors_list_item, parent, false);
        DoctorsViewHolder viewHolder = new DoctorsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DoctorsListAdapter.DoctorsViewHolder holder, int position) {
        holder.bindDoctor(mDoctors.get(position));
    }

    @Override
    public int getItemCount() {
        return mDoctors.size();
    }

    public class DoctorsViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.doctorImageView)
        ImageView mRestaurantImageView;
        @Bind(R.id.doctorsNameTextView)
        TextView mDoctorsNameTextView;
        @Bind(R.id.doctorsTitleTextView)
        TextView mDoctorsTitleTextView;
        @Bind(R.id.genderTextView)
        TextView mGenderTextView;
        @Bind(R.id.addressTextView)
        TextView mAddressTextView;
        @Bind(R.id.phoneTextView)
        TextView mPhoneTextView;
        @Bind(R.id.doctorsBio)
        TextView mDoctorsBio;
        @Bind(R.id.availabilityTextView)
        TextView mAvailabilityTextView;
        @Bind(R.id.ratingTextView)
        TextView mRatingTextView;
        private Context mContext;

        public DoctorsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindDoctor(Doctor doctor) {
            mDoctorsNameTextView.setText(doctor.getName());
            mDoctorsTitleTextView.setText(doctor.getTitle());
            mGenderTextView.setText(doctor.getGender());
            mAddressTextView.setText(doctor.getName());
            mDoctorsBio.setText(doctor.getBio());
            mAvailabilityTextView.setText(doctor.getmAvailability());
            mPhoneTextView.setText(doctor.getPhone().get(0));
            mRatingTextView.setText("Rating: " + doctor.getRating());
        }

    }
}

