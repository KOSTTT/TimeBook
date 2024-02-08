package com.example.timebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.timebook.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private ActivityMainBinding binding;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private int chapter;
    private List<User> listTemp;
    private ImageView avatar;
    private TextView tvName;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        avatar = findViewById(R.id.avatar);
        tvName = findViewById(R.id.tvName);
        toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        getIntentProfile();
    }

    private void setOnClickItem(){

    }
    private void getIntentProfile(){
        Intent i = getIntent();
    if(i != null){
        Picasso.get().load(i.getStringExtra(Constants.USER_IMAGE)).into(avatar);
        tvName.setText(i.getStringExtra(Constants.USER_NAME));
    }
    }
    public void onClickEditProf(View view){
        Intent intent = new Intent(ProfileActivity.this,EditProfile.class);
        startActivity(intent);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}
