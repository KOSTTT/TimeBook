package com.example.timebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class LogoActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);
        StartMainActivity();
    }
    private void StartMainActivity(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(LogoActivity.this,SignActivity.class);
                startActivity(intent);
            }
        }).start();
    }
    protected void OnDestroy(){
        super.onDestroy();
        finish();
    }
}
