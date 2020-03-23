package com.example.sandhya.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginad extends AppCompatActivity {
EditText user,pass;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginad);
        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getText().toString().equals("admin")&&pass.getText().toString().equals("admin")) {
                    Intent i=new Intent(loginad.this,home3.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(loginad.this, "You are not the admin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
