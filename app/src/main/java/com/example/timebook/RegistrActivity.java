package com.example.timebook;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrActivity extends AppCompatActivity {
    private EditText editName, editEmail, editPassword;
    FirebaseDatabase db;
    private DatabaseReference users;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);

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
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.edPassword);
        auth = FirebaseAuth.getInstance();
    }
    public void onClickRegistr (View view){

        if (!TextUtils.isEmpty(editEmail.getText().toString()) && !TextUtils.isEmpty(editPassword.getText().toString())) {
            auth.createUserWithEmailAndPassword(editEmail.getText().toString(),editPassword.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Ваша учетная запись сохранена.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegistrActivity.this,SignActivity.class);
                                intent.putExtra("name",editName.getText().toString());
                                startActivity(intent);
                            }else {
                                Toast.makeText(getApplicationContext(),"Пользователь с такой почтой уже авторизован.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }
        else {
            Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_SHORT).show();

            if (editPassword.getText().toString().length() < 5) {
                Toast.makeText(this, "Пароль должен быть не менее 5 символов.", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
    public void onClickSignIn(View view){
        Intent intent = new Intent(RegistrActivity.this,SignActivity.class);
        startActivity(intent);
    }
}