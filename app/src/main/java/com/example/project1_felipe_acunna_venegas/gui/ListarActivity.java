package com.example.project1_felipe_acunna_venegas.gui;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.project1_felipe_acunna_venegas.R;
import com.example.project1_felipe_acunna_venegas.controlador.Persona;
import com.example.project1_felipe_acunna_venegas.db.MemoriaArray;
import java.util.ArrayList;
import java.util.List;

public class ListarActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        for (Persona p:MemoriaArray.lista) {System.out.println(p.toString());
        }
        ListView listViewController =(ListView)findViewById(R.id.listarPersona);

        ArrayAdapter<String> oAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listarPersonas());
        listViewController.setAdapter(oAdapter);

        //////////////////////////////////////////////////////////////////////////boton volver
        Button btnVolver = (Button) findViewById(R.id.volverListar);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
    private List<String> listarPersonas(){
        List<String> lista=new ArrayList<String>();
        for (Persona p:MemoriaArray.lista) {
            lista.add("nombre: "+p.getNombre()+"\napellido: "+p.getApellido()+"\nrut: "+p.getRut());

        }
        System.out.println(lista.toString());
        return lista;
    }
}