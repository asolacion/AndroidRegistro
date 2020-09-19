package com.example.project1_felipe_acunna_venegas.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project1_felipe_acunna_venegas.R;

//////////////////////////////////////////////////////////////////////////aqui inicia
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//////////////////////////////////////////////////////////////////////////creacion de botones

//////////////////////////////////////////////////////////////////////////boton registrar
        Button btnRegistrar=(Button)findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),RegistroActivity.class);
                startActivityForResult(intent,0);
            }
        });

//////////////////////////////////////////////////////////////////////////boton mostrar
        Button btnMostrar =(Button)findViewById(R.id.btnMostrar);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MostrarActivity.class);
                startActivityForResult(intent,0);
            }
        });
//////////////////////////////////////////////////////////////////////////boton listar
        Button btnListar = (Button)findViewById(R.id.btnListar);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ListarActivity.class);
                startActivityForResult(intent,0);
            }
        });

    }
}