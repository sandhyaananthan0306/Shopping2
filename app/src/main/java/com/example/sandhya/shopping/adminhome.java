package com.example.sandhya.shopping;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sandhya.shopping.internship.nahelper;
import com.example.sandhya.shopping.internship.nahelper;

public class adminhome extends AppCompatActivity {
    ListView vau;
    nahelper nh;
    ArrayAdapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
        vau=findViewById(R.id.vau);
        nh=new nahelper(adminhome.this);
        ad=new ArrayAdapter(adminhome.this,android.R.layout.simple_list_item_1,nh.getallusers().get("sname"));
        vau.setAdapter(ad);
        vau.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder adb=new AlertDialog.Builder(adminhome.this);
                adb.setTitle("Action for admin "+nh.getallusers().get("sno").get(i).toString());
                adb.setMessage("Name : "+nh.getallusers().get("sname").get(i)+"\nbranch : "+nh.getallusers().get("sbranch").get(i));
                adb.setPositiveButton("Delete user", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sno= nh.getallusers().get("sno").get(i).toString();
                        nh.delete(sno);
                        nh.close();
                        Intent i1=new Intent(adminhome.this,adminhome.class);
                        startActivity(i1);
                    }
                });
                adb.setNegativeButton("Validate user", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sno= nh.getallusers().get("sno").get(i).toString();
                        nh.validate(sno);
                        nh.close();
                        Intent i1=new Intent(adminhome.this,adminhome.class);
                        startActivity(i1);
                    }
                });
                adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(adminhome.this, "did Nothing", Toast.LENGTH_SHORT).show();
                    }
                });
                adb.setCancelable(false);
                adb.show();
            }
        });
    }
}

