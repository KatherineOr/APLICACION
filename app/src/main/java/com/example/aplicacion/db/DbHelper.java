package com.example.aplicacion.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String TABLE_REGISTROS = "usuarios";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "registros.db";
   // protected static final String TABLE_REGISTROS = "t_registros";



    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_REGISTROS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "dni TEXT NOT NULL," +
                "correo TEXT NOT NULL," +
                "password TEXT NOT NULL)");

        Log.d("DbHelper", "Tabla creada: " + TABLE_REGISTROS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Actualizar la tabla si es necesario
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_REGISTROS;

        db.execSQL(dropTableQuery);
        onCreate(db);
    }
}