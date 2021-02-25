package com.practicals.onetimelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtInfo;
    Button btnLogout;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isLoggedin();
        pref = getSharedPreferences("Login",MODE_PRIVATE);
        txtInfo = findViewById(R.id.txtInfo);
        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });
        txtInfo.setText(txtInfo.getText() +" " + pref.getString("Username",""));
    }

    private void Logout() {
        if(pref == null)
            pref = getSharedPreferences("Login",MODE_PRIVATE);

        editor = pref.edit();
        editor.putString("Username",null);
        editor.commit();

        startActivity(new Intent(MainActivity.this,login.class));
    }

    public void isLoggedin(){

        if(pref == null)
            pref = getSharedPreferences("Login",MODE_PRIVATE);

        if(!pref.contains("Username")){
            startActivity(new Intent(MainActivity.this,login.class));
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isLoggedin();
    }
}
