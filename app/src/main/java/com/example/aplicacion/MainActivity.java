package com.example.aplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplicacion.db.DbHelper;

public class MainActivity extends AppCompatActivity {
    private EditText edtlogin, edtpass;
    private Button btnregistrarse, btnIniciarSesion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.Portada);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtlogin=findViewById(R.id.edtLogin);
        edtpass=findViewById(R.id.edtPassword);
        btnregistrarse=findViewById(R.id.btnRegistrarse);
        btnIniciarSesion=findViewById(R.id.btnIniciarSesion);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = "kat";
                String password = "1234";
                String log = edtlogin.getText().toString();
                String pass= edtpass.getText().toString();

                if(log.equals("") || (login!="kat" && password!="1234")){
                    Toast.makeText(getApplicationContext(),"Campos Vacios"+pass, Toast.LENGTH_LONG).show();



                    }else {
                    Intent intent = new Intent(MainActivity.this, MainActivityInicio.class);
                    /*  intent.putExtras(enviadato);*/
                    startActivity(intent);

                }




            }
        });

        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityRegistro.class);
                /*  intent.putExtras(enviadato);*/
                startActivity(intent);


            }
        });


    }}