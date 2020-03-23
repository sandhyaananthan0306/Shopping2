package com.example.sandhya.shopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sandhya.shopping.internship.nahelper;

public class register extends AppCompatActivity {
    EditText rsname,rsage,rspass,rsemail,rsphone,rcpass;
    Spinner rsbranch;
    RadioGroup rsgender;
    RadioButton rb;
    Button rsregister;
    boolean pcp=false;
    boolean mf=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        rsname=findViewById(R.id.rsname);
        rsage=findViewById(R.id.rsage);
        rsgender=findViewById(R.id.rsgender);
        rspass=findViewById(R.id.rspass);
        rsemail=findViewById(R.id.rsemail);
        rsphone=findViewById(R.id.rsphone);
        rsbranch=findViewById(R.id.rsbranch);
        rsregister=findViewById(R.id.rsregister);
        rcpass=findViewById(R.id.rcpass);

        rsgender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb=findViewById(i);
                mf=true;
            }
        });
        rcpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(rcpass.getText().toString().equals(rspass.getText().toString()))
                {
                    pcp=true;
                }
                else
                {
                    pcp=false;
                    rcpass.setError("same undali");
                }
            }
        });
        rsregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(rb!=null&&pcp&&mf&&!TextUtils.isEmpty(rsname.getText().toString()) &&!TextUtils.isEmpty(rsage.getText().toString())&&!TextUtils.isEmpty(rspass.getText().toString())
                        &&!TextUtils.isEmpty(rsemail.getText().toString()) &&!TextUtils.isEmpty(rsphone.getText().toString())
                        &&!TextUtils.isEmpty(rcpass.getText().toString()))
                {


                    if (rb != null) {
                        String sgender = rb.getText().toString();
                    } else {
                        Toast.makeText(register.this, "You are trans", Toast.LENGTH_SHORT).show();
                    }
                    String sbranch = rsbranch.getSelectedItem().toString();
                    if (pcp == true) {
                        nahelper nh=new nahelper(register.this);
                        String sname=rsname.getText().toString();
                        String spass=rspass.getText().toString();
                        int sage=Integer.parseInt(rsage.getText().toString());
                        String semail=rsemail.getText().toString();
                        String sphone=rsphone.getText().toString();
                        String sgender=null;
                        nh.register(sname, sage, sgender, spass, semail, sphone, sbranch);
                        nh.close();
                    } else {
                        Toast.makeText(register.this, "Both Passwords should be same", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(register.this,"No feilds should be empty",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
