package com.example.project1_felipe_acunna_venegas.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project1_felipe_acunna_venegas.R;
import com.example.project1_felipe_acunna_venegas.controlador.Persona;
import com.example.project1_felipe_acunna_venegas.db.MemoriaArray;

public class RegistroActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private EditText rut;
    private EditText edad;
    private Spinner deporte;
    private TextView controladorDeCantidad;
    private Switch switchSexual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre =(EditText) findViewById(R.id.txtNombre1);
        apellido=(EditText) findViewById(R.id.txtApellido1);
        rut=(EditText) findViewById(R.id.txtRut1);
        edad=(EditText) findViewById(R.id.txtEdad);
        deporte=(Spinner) findViewById(R.id.spinnerDeporte1);
        switchSexual = (Switch) findViewById(R.id.switchSexo1);
        controladorDeCantidad=(TextView) findViewById(R.id.txtCantidad1);
        if (MemoriaArray.lista.size()>0){
            controladorDeCantidad.setText(""+MemoriaArray.lista.size());
        }
        //////////////////////////////////////////////////////////////////////////boton volver
        Button btnVolver=(Button)findViewById(R.id.volverRegistro);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),MainActivity.class);
                startActivityForResult(intent,0);
            }
        });
        Button btnRegistrar=(Button)findViewById(R.id.buttonRegistro1);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean masculino = true;
                if (switchSexual.isChecked()){
                    masculino=false;
                }

                if(comprobarValoresAsignados()==true){
                    Persona oPersona=new  Persona();
                    oPersona.setNombre(nombre.getText().toString());
                    oPersona.setApellido(apellido.getText().toString());
                    oPersona.setRut(rut.getText().toString());
                    oPersona.setEdad(Integer.parseInt(edad.getText().toString()));
                    oPersona.setSexo(masculino);
                    oPersona.setDeporte(deporte.getSelectedItem().toString());
                    MemoriaArray.lista.add(oPersona);

                    System.out.println(oPersona.toString());
                    Intent intent=new  Intent(v.getContext(),MainActivity.class);
                    startActivityForResult(intent,0);
                }else{
                    Toast.makeText(getBaseContext(),"corrija valores\n faltan o estan erroneos",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    boolean comprobarValoresAsignados(){
        String nombreVar= String.valueOf(nombre.getText());
        String apellidoVar= String.valueOf(nombre.getText());
        String rutVar= String.valueOf(nombre.getText());
        String edadVar= String.valueOf(nombre.getText());
        if (nombreVar.trim().isEmpty()){
            return false;
        }
        else if (apellidoVar.trim().isEmpty()){
            return false;
        }
        else if (rutVar.trim().isEmpty()){
            return false;
        }
        else if (edadVar.trim().isEmpty()){
            return false;
        }
        return true;
    }


    }
