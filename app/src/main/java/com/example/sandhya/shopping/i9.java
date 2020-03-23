package com.example.sandhya.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class i9 extends AppCompatActivity {
    Button cart1,pay1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i9);
        cart1=findViewById(R.id.cart);
        pay1=findViewById(R.id.pay);
        cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(i9.this,cart.class);
                startActivity(i);
            }
        });
        pay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(i9.this,pay.class);
                startActivity(i1);
            }
        });
    }
}
