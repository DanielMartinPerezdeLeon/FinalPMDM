package com.example.finalpmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import BaseDatosRoom.*;

public class MainActivity extends AppCompatActivity {

    BaseDatos bd;
    Consultas consultas;

    List listpersonas;  //Lista con todas las personas de la base de datos
    ArrayList<String> listanombres= new ArrayList<String>();//ArrayList principal para llevar los datos
    Spinner spinner;    //Spinner de personas
    ArrayAdapter<String> adapter;  //Adaptador

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //CRECION BASES DE DATOS
        bd= Room.databaseBuilder(getApplicationContext(),BaseDatos.class,"base de datos").allowMainThreadQueries().build();    //Construye la base de datos, le pongo el allowmain... para no tener que usar Threads

        consultas = bd.consultas();   //Crea una clase para hacer las consultas
        //List<Persona> listapersonas = consultas.getAll();


        //INICIALIZADOR SPINNER
        spinner = (Spinner) findViewById(R.id.spinner);


        adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listanombres);
        spinner.setAdapter(adapter);


        //normalmente ya esta en la bd
        //Creo la Persona principal con mis datos
        //Persona p1= new Persona("Dani",21,"aqui",true);
        //consultas.insertAll(p1);


        //Creacion del fragmento
        Fragmento1 newFragment = new Fragmento1();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        transaction.replace(R.id.fragmentContainerView3, newFragment);
        transaction.addToBackStack(null);

        transaction.commit();




       ActualizarListadoPersonas();





    }

    public void ActualizarListadoPersonas(){

        //lista que llama y guarda a todos los datos de la bd
        listpersonas= consultas.getAll();


        //Actualiza cada listanombres con los nombres de cada persona
        for(int i=0; i<listpersonas.size();i++){
            Persona p=(Persona)listpersonas.get(i);
            listanombres.add(i,p.getNombre());
        }



        //Actualiza el spinner
        adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listanombres);
        spinner.setAdapter(adapter);
    }

}