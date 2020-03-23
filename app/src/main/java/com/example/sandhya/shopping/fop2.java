package com.example.sandhya.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fop2 extends AppCompatActivity {
EditText pass,copass;
Button btlp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fop2);
        pass=findViewById(R.id.pass);
        copass=findViewById(R.id.copass);
        btlp=findViewById(R.id.btlp);
        btlp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pass.getText().toString()==copass.getText().toString()) {
                    Intent i=new Intent(fop2.this,home2.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(fop2.this, "Password and CO-Password do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
