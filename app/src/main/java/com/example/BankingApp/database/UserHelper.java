package com.example.BankingApp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.BankingApp.database.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Sachin Sasane', 'ssasane451@gmail.com','7584','86002164011', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Tejas pinjarkar', 'tejas@gmail.com','1258','976617674889', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Suraj Tupke', 'suraj@gmail.com','8896','738575896', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Harshal Pinjarkar', 'harsgal@gmail.com','7752','9856440038', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Supriya Jadhav', 'supriya@gmail.com','3669','80870048962', 90500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Pratiksha', 'pratikshah@gmail.com','9985','8855640238', 75000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Shivansh', 'shivansh@gmail.com','1207','8895640215', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Nishu', 'nishu@gmail.com','4522','995760021539', 95000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Rohit Sharma', 'rohit@gmail.com','6582','93009565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,' kl rahul', 'kl@gmail.com','5450','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'ambani', 'ambani@gmail.com','2656','9999999999999', 980000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Hritik roshan', 'hitish@gmail.com','1203','999995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Shivraj', 'shivraj@gmail.com','5566','9119541001', 58000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Satyam', 'satyam@gmail.com','2236','625454642205', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Shreyanshi', 'shre@gmail.com','6692','69893641266', 96010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}