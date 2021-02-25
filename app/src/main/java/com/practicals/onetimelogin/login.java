package com.practicals.onetimelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    EditText etUname, etPassword;
    Button btnLogin;
    private final String Username = "android";
    private final String Password = "developer@android";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        isLoggedin();
        etUname = findViewById(R.id.etUname);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        pref = getSharedPreferences("Login",MODE_PRIVATE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void Login() {
        String uname = etUname.getText().toString().trim();
        String psw = etPassword.getText().toString().trim();

        if(uname.equals(Username) && psw.equals(Password)){

            if(pref == null)
                pref = getSharedPreferences("Login",MODE_PRIVATE);

            editor = pref.edit();
            editor.putString("Username",uname);
            editor.commit();

            startActivity(new Intent(login.this,MainActivity.class));
        }
    }

    public void isLoggedin(){

        if(pref == null)
            pref = getSharedPreferences("Login",MODE_PRIVATE);

        if(pref.contains("Username")){
            startActivity(new Intent(login.this,MainActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isLoggedin();
    }
}
