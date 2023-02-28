package com.example.finalpmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import BaseDatosRoom.*;

public class MainActivity extends AppCompatActivity {

    BaseDatos bd;
    Consultas consultas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd= Room.databaseBuilder(getApplicationContext(),BaseDatos.class,"base de datos").allowMainThreadQueries().build();    //Construye la base de datos

        consultas = bd.consultas();   //Crea una clase para hacer las consultas
        //List<Persona> listapersonas = consultas.getAll();


        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        Persona p1= new Persona("Dani",21,"aqui",true);



        Fragmento1 newFragment = new Fragmento1();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragmentContainerView3, newFragment);
        transaction.addToBackStack(null);

        transaction.commit();


        ArrayList<Persona> listapersonas = new ArrayList<Persona>();

        listapersonas = ActualizarListadoPersonas();



    }

    public ArrayList<Persona> ActualizarListadoPersonas(){

        List listpersonas= consultas.getAll();

        return new ArrayList<Persona>(listpersonas);
    }

}