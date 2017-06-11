package com.example.kiragu.finddoctor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.kiragu.finddoctor.adapters.DoctorsListAdapter;
import com.example.kiragu.finddoctor.models.Doctor;
import com.example.kiragu.finddoctor.services.BetterDoctorService;
import com.example.kiragu.finddoctor.ui.DoctorsDetailActivity;

import org.parceler.Parcels;

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
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorslist);
        ButterKnife.bind(this);
//Receive passed location
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        getDoctors(location);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);


        if (mRecentAddress != null) {
            getDoctors(mRecentAddress);
        }

    }
//inflating the search menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                addToSharedPreferences(query);
                getDoctors(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
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
    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
    }
}