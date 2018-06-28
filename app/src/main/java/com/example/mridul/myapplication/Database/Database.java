package com.example.mridul.myapplication.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.mridul.myapplication.Model.Friend;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mridul on 5/23/2018.
 */

public class Database  extends SQLiteAssetHelper{

    private static  final String  DB_NAME="friend.db";
    private static  final int DB_VER=1;

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);

    }


    // function get all friends

    public List<Friend> getFriend(){

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        //String[] sqlSelect = {"id","name","address","phone","email","designation","department","status","c_status","d_status","date","group"};
        String[] sqlSelect = {"id","name","address","phone","email"};
        String tableNmae="friends";

        qb.setTables(tableNmae);
        Cursor cursor = qb.query(db,sqlSelect,null,null,null,null,null);
        List<Friend> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {

            do{
                Friend friend =new Friend();
                friend.setId(cursor.getInt(cursor.getColumnIndex("id")));
                friend.setName(cursor.getString(cursor.getColumnIndex("name")));
                friend.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                friend.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                friend.setEmail(cursor.getString(cursor.getColumnIndex("email")));

                /*
                friend.setDesignation(cursor.getString(cursor.getColumnIndex("designation")));
                friend.setDepartment(cursor.getString(cursor.getColumnIndex("department")));
                friend.setStatus(cursor.getString(cursor.getColumnIndex("status")));
                friend.setC_status(cursor.getString(cursor.getColumnIndex("c_status")));
                friend.setD_status(cursor.getString(cursor.getColumnIndex("d_status")));
                friend.setDate(cursor.getString(cursor.getColumnIndex("date")));
                friend.setGroup(cursor.getString(cursor.getColumnIndex("group")));

                */

                result.add(friend);
            }while ( cursor.moveToNext());
        }
        return  result;


    }

 // function get all friends name


    public List<String> getNames()
    {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"name"};
        String tableNmae="friends";

        qb.setTables(tableNmae);
        Cursor cursor = qb.query(db,sqlSelect,null,null,null,null,null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {

            do{
                result.add(cursor.getString(cursor.getColumnIndex("name")));
            }while ( cursor.moveToNext());
        }
        return  result;

    }


 // function for get friends by name
    public List<Friend> getFriendsByName(String name){

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        //String[] sqlSelect = {"id","name","address","phone","email","designation","department","status","c_status","d_status","date","group"};
        String[] sqlSelect = {"id","name","address","phone","email"};
        String tableNmae="friends";

        qb.setTables(tableNmae);

            // if you wnat to get extract name , just change
            // Cursor cursor = qb.query(db,sqlSelect,"name = ?",new String[]{name},null,null,null);

            // this will like query  : select * from friends where names like "%pattern%":
        Cursor cursor = qb.query(db,sqlSelect,"name like ?",new String[]{"%"+name+"%"},null,null,null);

        List<Friend> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {

            do{
                Friend friend =new Friend();
                friend.setId(cursor.getInt(cursor.getColumnIndex("id")));
                friend.setName(cursor.getString(cursor.getColumnIndex("name")));
                friend.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                friend.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                friend.setEmail(cursor.getString(cursor.getColumnIndex("email")));

                /*
                friend.setDesignation(cursor.getString(cursor.getColumnIndex("designation")));
                friend.setDepartment(cursor.getString(cursor.getColumnIndex("department")));
                friend.setStatus(cursor.getString(cursor.getColumnIndex("status")));
                friend.setC_status(cursor.getString(cursor.getColumnIndex("c_status")));
                friend.setD_status(cursor.getString(cursor.getColumnIndex("d_status")));
                friend.setDate(cursor.getString(cursor.getColumnIndex("date")));
                friend.setGroup(cursor.getString(cursor.getColumnIndex("group")));
                */



                result.add(friend);
            }while ( cursor.moveToNext());
        }
        return  result;

    }



}
