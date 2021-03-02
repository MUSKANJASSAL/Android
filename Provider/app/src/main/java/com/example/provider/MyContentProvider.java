package com.example.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import androidx.annotation.Nullable;

public class MyContentProvider extends ContentProvider {

    SQLiteDatabase myDB;

    public MyContentProvider() {
    }
    public static final String authority = "com.muskan.my.content.provider";
    public static final Uri content_uri_1 = Uri.parse("content://"+authority);

    static int EMP = 1;
    static int EMP_ID = 2;

    static UriMatcher myURI = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        myURI.addURI(authority,"emp", EMP);
        myURI.addURI(authority,"emp/#", EMP_ID);
    }

    private class MyOwnDatabase extends SQLiteOpenHelper {
    private static final String DB_NAME = "company";
    private static final String DB_TABLE = "emp";
    private static final int DB_VERSION = 1;

        public MyOwnDatabase(Context ct){
            super(ct, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table "+DB_TABLE+" (_id integer primary key autoincrement,emp_name text,profile text);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("drop table if exists "+DB_TABLE);
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        long row = myDB.insert()
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        MyOwnDatabase myHelper = new MyOwnDatabase(getContext());
        myDB = myHelper.getWritableDatabase();
        if(myDB!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
