package com.example.sandhya.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class home3 extends AppCompatActivity {
    ListView list;
    Integer[] image={R.drawable.aa,R.drawable.bb,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o};
    String[] name={"Jeans Pant- MEN","T-Shirt-MEN","Jacket- MEN","Top- WOMEN","Top- WOMEN","Top- WOMEN","Top- WOMEN","Top- WOMEN","Jeans pant- WOMEN","T-Shirt- WOMEN","Ethinic Salwar- WOMEN","Sari- WOMEN","Ethinic Lehenga- WOMEN","Skirt- WOMEN","Skirt- WOMEN","Dress- WOMEN"};
    String[] price={"Rs.800.00","Rs.550.00","Rs.1545.00","Rs.670.00","Rs.490.00","Rs.780.00","Rs.450.00","Rs.760.00","Rs.400.00","Rs.1400.00","Rs.2190.00","Rs.2540.00","Rs.780.00","Rs.678.00","Rs.999.00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);
        list=findViewById(R.id.list);
        MyAdapter ma=new MyAdapter(home3.this,image,name,price);
        list.setAdapter(ma);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0) {
                    Intent i0=new Intent(home3.this,i1.class);
                    startActivity(i0);
                }
                else if(i==1) {
                    Intent i1=new Intent(home3.this,i2.class);
                    startActivity(i1);
                }
                else if(i==2) {
                    Intent i2=new Intent(home3.this,i3.class);
                    startActivity(i2);
                }
                else if(i==3) {
                    Intent i3=new Intent(home3.this,i4.class);
                    startActivity(i3);
                }
                else if(i==4) {
                    Intent i4=new Intent(home3.this,i5.class);
                    startActivity(i4);
                }
                else if(i==5) {
                    Intent i5=new Intent(home3.this,i6.class);
                    startActivity(i5);
                }
                else if(i==6) {
                    Intent i6=new Intent(home3.this,i7.class);
                    startActivity(i6);
                }
                else if(i==7) {
                    Intent i7=new Intent(home3.this,i8.class);
                    startActivity(i7);
                }
                else if(i==8) {
                    Intent i8=new Intent(home3.this,i9.class);
                    startActivity(i8);
                }
                else if (i==9) {
                    Intent i9=new Intent(home3.this,i10.class);
                    startActivity(i9);
                }
                else if(i==10) {
                    Intent i10=new Intent(home3.this,i11.class);
                    startActivity(i10);
                }
                else if (i==11) {
                    Intent i11=new Intent(home3.this,i12.class);
                    startActivity(i11);
                }
                else if (i==12) {
                    Intent i12=new Intent(home3.this,i13.class);
                    startActivity(i12);
                }
                else if(i==13) {
                    Intent i13=new Intent(home3.this,i14.class);
                    startActivity(i13);
                }
                else if(i==14) {
                    Intent i14=new Intent(home3.this,i15.class);
                    startActivity(i14);
                }
            }
        });
    }
}
