package com.example.kiragu.finddoctor.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiragu.finddoctor.R;
import com.example.kiragu.finddoctor.models.Doctor;
import com.example.kiragu.finddoctor.ui.DoctorsDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

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
        // Inflate the custom layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctors_list_item, parent, false);
        // Return a new holder instance
        DoctorsViewHolder viewHolder = new DoctorsViewHolder(view);
        return viewHolder;
    }
    // Populating data into the item through holder
    @Override
    public void onBindViewHolder(DoctorsListAdapter.DoctorsViewHolder holder, int position) {
        // Get the data model based on position
        holder.bindDoctor(mDoctors.get(position));
    }
    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mDoctors.size();
    }

    // Set item views based on views and data model
    public class DoctorsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.doctorImageView)
        ImageView mDoctorImageView;
        @Bind(R.id.doctorsNameTextView)
        TextView mDoctorsNameTextView;
//        @Bind(R.id.doctorsTitleTextView)
//        TextView mDoctorsTitleTextView;
//        @Bind(R.id.genderTextView)
//        TextView mGenderTextView;
//        @Bind(R.id.addressTextView)
//        TextView mAddressTextView;
//        @Bind(R.id.phoneTextView)
//        TextView mPhoneTextView;
        @Bind(R.id.doctorsBio)
        TextView mDoctorsBio;
//        @Bind(R.id.languageTextView) TextView mLanguageTextView;
//        @Bind(R.id.specialtyTextView) TextView mSpecialty;
        private Context mContext;

        public DoctorsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, DoctorsDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("doctors", Parcels.wrap(mDoctors));
            mContext.startActivity(intent);
        }
//receiving data from the model and setting it to our view
        public void bindDoctor(Doctor doctor) {
            Picasso.with(mContext).load(doctor.getImage()).into(mDoctorImageView);
            mDoctorsNameTextView.setText(doctor.getName());
//            mDoctorsTitleTextView.setText(doctor.getTitle());
//            mGenderTextView.setText(doctor.getGender());
//            mAddressTextView.setText(doctor.getName());
            mDoctorsBio.setText(doctor.getBio());
//            mPhoneTextView.setText(doctor.getPhone().get(0));
//            mSpecialty.setText(doctor.getSpecialty().get(0));
//            mLanguageTextView.setText(doctor.getLanguages().get(0));

        }
    }
}

