package com.example.finalpmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.room.RenameTable;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import BaseDatosRoom.*;

public class MainActivity extends AppCompatActivity {

    static BaseDatos bd;
    static Consultas consultas;

    Persona personaseleccionada;    //Persona que mostrar en el fragment

    FragmentContainerView contenedorfragmento;


    List listpersonas;  //Lista con todas las personas de la base de datos
    ArrayList<String> listanombres= new ArrayList<String>();//ArrayList principal para llevar los datos
    Spinner spinner;    //Spinner de personas
    ArrayAdapter<String> adapter;  //Adaptador


    Fragment fragment;


    static MainActivity instancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instancia=this;

        //CRECION BASES DE DATOS
        //bd= Room.databaseBuilder(getApplicationContext(),BaseDatos.class,"base de datos").fallbackToDestructiveMigration().build();
        bd= Room.databaseBuilder(getApplicationContext(),BaseDatos.class,"base de datos").allowMainThreadQueries().build();    //Construye la base de datos, le pongo el allowmain... para no tener que usar Threads

        consultas = bd.consultas();   //Crea una clase para hacer las consultas
        //List<Persona> listapersonas = consultas.getAll();


        //INICIALIZADOR SPINNER
        spinner = (Spinner) findViewById(R.id.spinner);


        adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listanombres);
        spinner.setAdapter(adapter);


        //Inicializador contenedor fragment
        contenedorfragmento= (FragmentContainerView) findViewById(R.id.fragmentContainerView3);

        //Inicialiador botones nueva_persona, borrarpersona
        Button btn_personanueva =(Button) findViewById(R.id.btn_personanueva);
        Button btn_borrarpersona = (Button) findViewById(R.id.btn_borrarpersona);

        //botonguardar = contenedorfragmento.getFragment().getView().findViewById(R.id.btn)

        //normalmente ya esta en la bd
        //Creo la Persona principal con mis datos
        //Persona p1= new Persona("Daniel Martin",21,"Sevilla",true, "damarpele@gmail.com", "https://github.com/DanielMartinPerezdeLeon");
        Persona p2= new Persona("Persona de ejemplo",21,"aqui",true, "email@yahoo.net", "github.com");
        Persona p3=consultas.finByName("prueba");
        consultas.deletePersona(p2);
        consultas.insertAll(p2);


        //Creacion del fragmento

        personaseleccionada=consultas.finByName("Daniel Martin");



        ActualizarListadoPersonas();


        //Cuando se selecciona algo en el spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override   //Si es un objeto
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                personaseleccionada=consultas.finByName(spinner.getItemAtPosition(position).toString());

                Bundle bundle = new Bundle();
                bundle.putString("nombre",personaseleccionada.getNombre());
                bundle.putInt("edad",personaseleccionada.getEdad());
                bundle.putString("email",personaseleccionada.getEmail());
                bundle.putString("github",personaseleccionada.getGithub());
                // set Fragmentclass Arguments
                fragment=contenedorfragmento.getFragment();
                fragment.onCreate(bundle);

                //botonguardar=fragment.getView().findViewById(R.id.btn_guardar);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                System.out.println("Esto no deberia ocurrir nunca?");
            }
        });


        //On_click del btn persona_nueva
        btn_personanueva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("nombre","");
                bundle.putInt("edad",0);
                bundle.putString("email","");
                bundle.putString("github","");
                fragment=contenedorfragmento.getFragment();
                fragment.onCreate(bundle);

                //botonguardar=fragment.getView().findViewById(R.id.btn_guardar);
            }
        });

        btn_borrarpersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona p=consultas.findSingleByNombre(spinner.getSelectedItem().toString());
                consultas.deletePersona(p);
                listanombres.clear();
                ActualizarListadoPersonas();
            }
        });

        //On_click del btn borrar persona


        /*botonguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText fieldnombre = (fragment.getView().findViewById(R.id.campo_nombre));
                EditText fieldedad = (fragment.getView().findViewById(R.id.campo_edad));
                EditText fieldemail = (fragment.getView().findViewById(R.id.campo_email));
                EditText fieldgithub = (fragment.getView().findViewById(R.id.campo_github));



                Persona p= new Persona(fieldnombre.getText().toString(),Integer.getInteger(fieldedad.getText().toString()),
                        fieldemail.getText().toString(),fieldgithub.getText().toString());

                MainActivity.nuevaPersona(p);

            }
        });*/

    }

    public void ActualizarListadoPersonas(){

        //lista que llama y guarda a todos los datos de la bd
        listpersonas= consultas.getAll();


        //Actualiza cada listanombres con los nombres de cada persona
        for(int i=0; i<listpersonas.size();i++){
            Persona p=(Persona)listpersonas.get(i);
            if(i>=listanombres.size()){ //si esta por encima del tamaño lo añade
                listanombres.add(i,p.getNombre());
            }else { //si no lo sobrescribe
                listanombres.set(i, p.getNombre());
            }
        }



        //Actualiza el spinner
        adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listanombres);
        spinner.setAdapter(adapter);

        Bundle bundle = new Bundle();
        bundle.putString("nombre",personaseleccionada.getNombre());
        bundle.putInt("edad",personaseleccionada.getEdad());
        bundle.putString("email",personaseleccionada.getEmail());
        bundle.putString("github",personaseleccionada.getGithub());
        // set Fragmentclass Arguments
        fragment=contenedorfragmento.getFragment();
        fragment.onCreate(bundle);
    }


    public static void nuevaPersona(Persona p){
        consultas.insertAll(p);
    }

    public static void actualizaPersona(Persona p){
        consultas.updatePersona(p);
    }
}