// === DbHelper.java ===
package com.example.jakspot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "jakspot_db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_WISHLIST = "favorite_places";
    private static final String COL_ID = "id";
    private static final String COL_NAMA = "nama_tempat";
    private static final String COL_LOKASI = "lokasi";
    private static final String COL_GAMBAR = "gambar_id";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_WISHLIST + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAMA + " TEXT, "
                + COL_LOKASI + " TEXT, "
                + COL_GAMBAR + " INTEGER )";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WISHLIST);
        onCreate(db);
    }

    public void addFavorite(Tempat tempat) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAMA, tempat.getNama());
        values.put(COL_LOKASI, tempat.getLokasi());
        values.put(COL_GAMBAR, tempat.getGambar());
        db.insert(TABLE_WISHLIST, null, values);
        db.close();
    }

    public void removeFavorite(String namaTempat) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_WISHLIST, COL_NAMA + " = ?", new String[]{namaTempat});
        db.close();
    }

    public boolean isFavorited(String namaTempat) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_WISHLIST, null, COL_NAMA + " = ?",
                new String[]{namaTempat}, null, null, null);
        boolean exists = cursor.moveToFirst();
        cursor.close();
        db.close();
        return exists;
    }

    public List<Tempat> getAllFavorites() {
        List<Tempat> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_WISHLIST, null);
        if (cursor.moveToFirst()) {
            do {
                Tempat tempat = new Tempat(
                        cursor.getInt(cursor.getColumnIndexOrThrow(COL_GAMBAR)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_NAMA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_LOKASI)),
                        "Favorit" // atau isi sesuai default kategori
                );
                list.add(tempat);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
}
