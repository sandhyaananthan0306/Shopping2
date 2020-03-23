package com.example.sandhya.shopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    Context con;
    LayoutInflater li;
    Integer[] image;
    String[] name,price;

    public MyAdapter(Context con, Integer[] image, String[] name, String[] phone) {
        this.con = con;
        this.image = image;
        this.name= name;
        this.price = price;
        li=LayoutInflater.from(con);
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int i) {
        return image;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    ImageView iv1;
    TextView n,p;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View myview=li.inflate(R.layout.clist,null);
        iv1=myview.findViewById(R.id.iv1);
        n=myview.findViewById(R.id.name);
        p=myview.findViewById(R.id.price);
        iv1.setImageResource(image[i]);
        n.setText(name[i]);
        p.setText(price[i]);
        return myview;
    }
}

