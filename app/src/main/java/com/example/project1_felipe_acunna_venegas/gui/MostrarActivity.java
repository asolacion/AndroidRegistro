package com.example.project1_felipe_acunna_venegas.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project1_felipe_acunna_venegas.R;
import com.example.project1_felipe_acunna_venegas.controlador.Persona;
import com.example.project1_felipe_acunna_venegas.db.MemoriaArray;

public class MostrarActivity extends AppCompatActivity {

    private TextView nombre;
    private TextView apellido;
    private TextView rut;
    private TextView edad;
    private TextView sexo;
    private TextView deporte;
    private TextView numeroDeMuestra;
    int controladosDeNumeroDeUsuario=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
         nombre=(TextView) findViewById(R.id.textViewNombre);
        apellido=(TextView) findViewById(R.id.textViewApellido);
        rut=(TextView) findViewById(R.id.textViewRut);
        edad=(TextView) findViewById(R.id.textViewEdad);
        sexo=(TextView) findViewById(R.id.textViewSexo);
        deporte=(TextView) findViewById(R.id.textViewDeporte);
        numeroDeMuestra=(TextView) findViewById(R.id.textViewActualNumero);
        Button controladorBotonAtras=(Button)findViewById(R.id.btnAtras);
        controladorBotonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(controladosDeNumeroDeUsuario>1) {
                    controladosDeNumeroDeUsuario--;
                    MostrarEnPantalla();
                }
            }
        });

        Button controladorBotonSiguiente=(Button)findViewById(R.id.btnSiguiente);
        controladorBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(controladosDeNumeroDeUsuario<MemoriaArray.lista.size())
                controladosDeNumeroDeUsuario++;
                MostrarEnPantalla();
            }
        });

        if(MemoriaArray.lista.size()>0){
            controladosDeNumeroDeUsuario=controladosDeNumeroDeUsuario+1;
            MostrarEnPantalla();
        }
        //////////////////////////////////////////////////////////////////////////boton volver
        Button btnVolver=(Button)findViewById(R.id.volverMostrar);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),MainActivity.class);
                startActivityForResult(intent,0);
            }
        });
        }public void MostrarEnPantalla(){
            Persona p =MemoriaArray.lista.get(controladosDeNumeroDeUsuario-1);
            nombre.setText(p.getNombre());
            apellido.setText(p.getApellido());
            edad.setText(""+p.getEdad());
            rut.setText(p.getRut());
            deporte.setText(p.getDeporte());
            sexo.setText(identificadorDeGenero());
            numeroDeMuestra.setText(""+(controladosDeNumeroDeUsuario));
    }
    public String identificadorDeGenero(){
        Persona p =MemoriaArray.lista.get(controladosDeNumeroDeUsuario-1);
        if(p.getSexo()==true){
            return "hombre";
        }
        else {
            return "mujer";
        }
    }
}