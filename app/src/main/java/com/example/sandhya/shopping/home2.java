package com.example.sandhya.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sandhya.shopping.internship.nahelper;

public class home2 extends AppCompatActivity {
EditText user,pass;
Button fp,login,reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        login=findViewById(R.id.login);
        reg = findViewById(R.id.reg);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nahelper nh=new nahelper(home2.this);
                if(nh.login(user.getText().toString(),pass.getText().toString()))  {
                    Intent i=new Intent(home2.this,home3.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(home2.this, "Wrong user", Toast.LENGTH_SHORT).show();
                }
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(home2.this,register.class);
                startActivity(i);
            }
        });
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(home2.this,fop.class);
                startActivity(i2);
            }
        });
    }
}
