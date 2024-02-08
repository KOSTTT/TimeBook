package com.example.timebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignActivity extends Activity {
    private EditText edEmail, edPassword;
    FirebaseAuth auth;
    ConstraintLayout root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_activity);
        root = findViewById(R.id.root_element);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser cUser = auth.getCurrentUser();
        if(cUser != null){
        }
    }

    private void init (){
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        auth = FirebaseAuth.getInstance();
    }

    public void onClickSign (View view){

        if(!TextUtils.isEmpty(edEmail.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString())) {
            auth.signInWithEmailAndPassword(edEmail.getText().toString(),edPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Авторизация прошла успешно", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(SignActivity.this,ProfileActivity.class);
                                        startActivity(intent);
                            }else {
                                Toast.makeText(getApplicationContext(),"Авторизация не прошла. Повторите попытку заново.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if (edPassword.getText().toString().length() < 5) {
            Toast.makeText(this,"Пароль должен быть не менее 5 символов.", Toast.LENGTH_SHORT).show();
            return;
        }
    }
    public void onClickNewAccount(View view){
        Intent intent = new Intent(SignActivity.this,RegistrActivity.class);
        startActivity(intent);
    }
}
