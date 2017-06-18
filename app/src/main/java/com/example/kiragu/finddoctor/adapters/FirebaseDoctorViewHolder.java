package com.example.kiragu.finddoctor.adapters;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiragu.finddoctor.Constants;
import com.example.kiragu.finddoctor.R;
import com.example.kiragu.finddoctor.models.Doctor;
import com.example.kiragu.finddoctor.ui.DoctorsDetailActivity;
import com.example.kiragu.finddoctor.util.ItemTouchHelperViewHolder;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by kiragu on 6/9/17.
 */

public class FirebaseDoctorViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;
    View mView;
    Context mContext;
    public ImageView mRestaurantImageView;

    public FirebaseDoctorViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
//        itemView.setOnClickListener(this);
    }

    public void bindDoctor(Doctor doctor) {
        ImageView doctorsImageView = (ImageView) mView.findViewById(R.id.doctorImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.doctorsNameTextView);
        TextView specialty= (TextView) mView.findViewById(R.id.specialtyTextView);

        Picasso.with(mContext)
                .load(doctor.getImage())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(doctorsImageView);

        nameTextView.setText(doctor.getName());
    }

//    @Override
//    public void onClick(View view) {
//        final ArrayList<Doctor> doctors = new ArrayList<>();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_DOCTORS);
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    doctors.add(snapshot.getValue(Doctor.class));
//                }
//
//                int itemPosition = getLayoutPosition();
//
//                Intent intent = new Intent(mContext, DoctorsDetailActivity.class);
//                intent.putExtra("position", itemPosition + "");
//                intent.putExtra("doctors", Parcels.wrap(doctors));
//                mContext.startActivity(intent);
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//    }

@Override
public void onItemSelected(){
    AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
            R.animator.drag_scale_on);
    set.setTarget(itemView);
    set.start();
}
    public  void onItemClear(){
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
                R.animator.drag_scale_off);
        set.setTarget(itemView);
        set.start();
    }
}
