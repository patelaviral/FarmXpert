package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class login_Activity2 extends AppCompatActivity {
    EditText nameed1,passed1;
    Button logbtn;
    TextView regtxt;
    ImageButton lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        nameed1 = findViewById(R.id.name1);
        passed1 = findViewById(R.id.pass1);
        regtxt = findViewById(R.id.reg_txt);
        logbtn = findViewById(R.id.lg_btn);
        lang = findViewById(R.id.lang01);
        lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login_Activity2.this,languageActivity.class));
            }
        });
        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = nameed1.getText().toString();
                String pass = passed1.getText().toString();
                database1 dbc = new database1(getApplicationContext(),"Agriculture",null,1);             // yha per database1 call hua ha
                if(!user.equals("")||!pass.equals("")){
                    if(dbc.login(user,pass) == 1){
                        Toast.makeText(login_Activity2.this, "Thanks for Login", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",user);                                                                // to save our data with key and value.
                        editor.apply();
                        startActivity(new Intent(login_Activity2.this,HomeActivity.class));
                    }
                    else{
                        Toast.makeText(login_Activity2.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(login_Activity2.this, "Please enter password & username", Toast.LENGTH_SHORT).show();
                }
            }
        });
        regtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login_Activity2.this,reg_Activity.class));
            }
        });
    }
}