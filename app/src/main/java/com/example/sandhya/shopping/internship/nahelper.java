package com.example.sandhya.shopping.internship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class nahelper extends SQLiteOpenHelper {
    Context con;

    public nahelper(Context context) {
        super(context, "Collage",null,1);
        con=context;
    }

    public void register(String sname,int sage,String sgender,String spass,String semail,String sphone,String sbranch)
    {
        SQLiteDatabase sandhya=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("sname",sname);
        cv.put("sage",sage);
        cv.put("sgender",sgender);
        cv.put("spass",spass);
        cv.put("semail",semail);
        cv.put("sphone",sphone);
        cv.put("sbranch",sbranch);
        cv.put("validate","false");
        sandhya.insert("student",null,cv);
        sandhya.close();
        Toast.makeText(con,"Registered sucessfully",Toast.LENGTH_SHORT).show();
    }
    public void validate(String sno)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String[] value2={sno};
        ContentValues cv=new ContentValues();
        cv.put("validate","true");
        db.update("student",cv,"s;no=?",value2);
        db.close();
        Toast.makeText(con, "Validated sucessfully", Toast.LENGTH_SHORT).show();
    }
    public void delete(String sno)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String[] value={sno};
        db.delete("student","sno=?",value);
        db.close();
        Toast.makeText(con, "Deleted user sucessfully", Toast.LENGTH_SHORT).show();
    }
    public boolean login(String username, String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String[] cols={"semail","spass","validate"};
        String[] values={username,password};
        Cursor c=db.query("student",cols,"semail=? and spass=?",values,null,null,null);

        if(c.getCount()!=0)  {
            if(c.moveToFirst()) {
                if (c.getString(2).equals("true")) {
                    return true;
                } else {
                    Toast.makeText(con, "You are not validated by admin", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
            else  {
                return false;
            }
        }
        else
        {
            Toast.makeText(con, "You are not regsitered", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public boolean check(String phonenumber)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String[] cols={"sphone","validate"};
        String[] values={phonenumber};
        Cursor d=db.query("student",cols,"sphone=?",values,null,null,null);
        if(d.getCount()!=0)  {
            if(d.moveToFirst()) {
                if (d.getString(2).equals("true")) {
                    return true;
                } else {
                    Toast.makeText(con, "You are not validated by admin", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
            else  {
                return false;
            }
        }
        else {
            Toast.makeText(con, "You are not regsitered", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public HashMap<String,ArrayList> getallusers()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String[] cols={"sno","sname","sage","sgender","semail","sphone","sbranch"};
        Cursor cur=db.query("student",cols,null,null,null,null,null);
        ArrayList sno=new ArrayList();
        ArrayList sname=new ArrayList();
        ArrayList sage=new ArrayList();
        ArrayList sgender=new ArrayList();
        ArrayList semail=new ArrayList();
        ArrayList sphone=new ArrayList();
        ArrayList sbranch=new ArrayList();
        HashMap hm=new HashMap();
        if(cur.moveToFirst()) {
            do {
                sno.add(cur.getInt(0) + "");
                sname.add(cur.getString(1));
                sage.add(cur.getInt(2) + "");
                sgender.add(cur.getString(3));
                semail.add(cur.getString(4));
                sphone.add(cur.getString(5));
                sbranch.add(cur.getString(6));
            }
            while (cur.moveToNext());
        }
        cur.close();
        db.close();
        hm.put("sno",sno);
        hm.put("sname",sname);
        hm.put("sage",sage);
        hm.put("sgender",sgender);
        hm.put("semail",semail);
        hm.put("sphone",sphone);
        hm.put("sbranch",sbranch);
        return hm;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String t1="Create table student(sno integer primary key autoincrement,sname text,sage integer,"
                + "sgender text,spass text,semail text,sphone text,sbranch text,validate text);";
        db.execSQL(t1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
