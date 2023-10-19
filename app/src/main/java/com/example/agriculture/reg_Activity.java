package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class reg_Activity extends AppCompatActivity {

    EditText phonenumber,username1,password,conpass;
    Button reg_btn;
    TextView log_sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        phonenumber = findViewById(R.id.ph_num1);
        username1 = findViewById(R.id.reg_name);
        password = findViewById(R.id.pass2);
        conpass = findViewById(R.id.con_pass2);
        reg_btn = findViewById(R.id.reg_btn);
        log_sc = findViewById(R.id.log_txt);

        log_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(reg_Activity.this,login_Activity2.class));
            }
        });

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = phonenumber.getText().toString();
                String username = username1.getText().toString();
                String pass = password.getText().toString();
                String con = conpass.getText().toString();
                database1 dbc = new database1(getApplicationContext(),"Agriculture",null,1);                  // database class create
                if(!num.equals("") || !username.equals("") || !pass.equals("") || !con.equals("")){
                    if(!pass.equals(con)){
                        Toast.makeText(reg_Activity.this, "Password & Confirm Password not Match", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(invalid(pass)){
                            dbc.register(username,pass);
                            Toast.makeText(reg_Activity.this, "New Account Formed", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(reg_Activity.this,login_Activity2.class));
                        }
                        else{
                            Toast.makeText(reg_Activity.this, "Password must contain at least 8 Character & having Digit, Alphabet & Symbol", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else{
                    Toast.makeText(reg_Activity.this, "Please fill all section", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public static boolean invalid(String password){
        int f1 = 0,f2 = 0,f3 = 0;
        if(password.length()<8){
            return false;
        }else{
            for(int i = 0;i<password.length();i++){
                if(Character.isLetter(password.charAt(i))){
                    f1 = 1;
                }
                if(Character.isDigit(password.charAt(i))){
                    f2 = 1;
                }
                char c = password.charAt(i);
                if(c>=33&&c<=46 || c == 64){
                    f3 = 1;
                }
            }
            if(f1 == 1 && f2 == 1 && f3 == 1){
                return true;
            }
            else{
                return false;
            }
        }
    }
}