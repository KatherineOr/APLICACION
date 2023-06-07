package com.example.aplicacion;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicacion.db.DbHelper;

public class MainActivityRegistro extends AppCompatActivity {

     EditText edtnombrecompleto, edtdni, edtcorreoelectronico, edtpassword;
      Button btnregistro;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        edtnombrecompleto=findViewById(R.id.edtNombreCompleto);
        edtdni=findViewById(R.id.edtDNI);
        edtcorreoelectronico=findViewById(R.id.edtCorreoElectronico);
        edtpassword=findViewById(R.id.edtPasswordR);
        btnregistro=findViewById(R.id.btnRegistrarse2);

        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbHelper dbHelper = new DbHelper(MainActivityRegistro.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                String nombre =edtnombrecompleto.getText().toString();
                String dni=edtdni.getText().toString();
                String correo=edtcorreoelectronico.getText().toString();
                String password=edtpassword.getText().toString();

                if (db != null) {
                    ContentValues values = new ContentValues();
                    values.put("nombre",  nombre);
                    values.put("dni",  dni);
                    values.put("correo",  correo);
                    values.put("password",  password);

                    long newRowId = db.insert(DbHelper.TABLE_REGISTROS, null, values);


                    if (newRowId != -1) {
                        Toast.makeText(MainActivityRegistro.this, "USUARIO CREADO", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivityRegistro.this, "ERROR AL CREAR USUARIO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivityRegistro.this, "ERROR AL OBTENER LA BASE DE DATOS", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
