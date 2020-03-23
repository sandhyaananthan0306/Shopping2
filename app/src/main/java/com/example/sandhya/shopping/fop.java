package com.example.sandhya.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sandhya.shopping.internship.nahelper;

public class fop extends AppCompatActivity {
EditText php;
Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fop);
        php=findViewById(R.id.php);
        check=findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nahelper na=new nahelper(fop.this);
                if(na.check(php.getText().toString())){
                    Intent i=new Intent(fop.this,fop2.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(fop.this, "Phone Number Not Registered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
