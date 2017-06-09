package com.example.kiragu.finddoctor.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kiragu.finddoctor.Constants;
import com.example.kiragu.finddoctor.R;
import com.example.kiragu.finddoctor.adapters.FirebaseDoctorViewHolder;
import com.example.kiragu.finddoctor.models.Doctor;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedDoctorsActivity extends AppCompatActivity {
     private DatabaseReference mDoctorsReference;
        private FirebaseRecyclerAdapter mFirebaseAdapter;

        @Bind(R.id.recyclerView)
        RecyclerView mRecyclerView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_doctorslist);
            ButterKnife.bind(this);

            mDoctorsReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_DOCTORS);
            setUpFirebaseAdapter();
        }

        private void setUpFirebaseAdapter() {
            mFirebaseAdapter = new FirebaseRecyclerAdapter<Doctor, FirebaseDoctorViewHolder>
                    (Doctor.class, R.layout.doctors_list_item, FirebaseDoctorViewHolder.class,
                            mDoctorsReference) {

                @Override
                protected void populateViewHolder(FirebaseDoctorViewHolder viewHolder,
                                                  Doctor model, int position) {
                    viewHolder.bindDoctor(model);
                }
            };
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(mFirebaseAdapter);
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            mFirebaseAdapter.cleanup();
        }
    }