package com.example.finalpmdm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import BaseDatosRoom.Persona;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmento1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //COSAS DEL FRAGMENTO (LAYOUT)
    EditText fieldnombre;
    EditText fieldemail;
    EditText fieldgithub;
    TextView fieldedad;
    Button botoncalcular;
    Button botonguardar;

    static Boolean nuevo=false;


    public Fragmento1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmento1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmento1 newInstance(String param1, String param2) {
        Fragmento1 fragment = new Fragmento1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


        try{
            if(!savedInstanceState.isEmpty()){
                fieldnombre.setText(savedInstanceState.getString("nombre"));
                fieldedad.setText(Integer.toString(savedInstanceState.getInt("edad")));
                fieldemail.setText(savedInstanceState.getString("email"));
                fieldgithub.setText(savedInstanceState.getString("github"));

                if(fieldnombre.getText().toString().equalsIgnoreCase("")){
                    nuevo=true;
                }else{
                    nuevo=false;
                }
            }
        }catch (Exception ex){
            Log.e("error fragment","Nulo en savedInstance");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //TOdo esto se hace cuando se crea la aplicacion
        View view =inflater.inflate(R.layout.fragment_fragmento1, container, false);    //creo el view

        //Asigno las cosas del fragmento
         fieldnombre = (EditText)  view.findViewById(R.id.campo_nombre);
         fieldedad = (TextView) view.findViewById(R.id.campo_edad);
         fieldemail = (EditText) view.findViewById(R.id.campo_email);
         fieldgithub = (EditText) view.findViewById(R.id.campo_github);
         botoncalcular = (Button) view.findViewById(R.id.btn_calcular);
         botonguardar= (Button) view.findViewById(R.id.btn_guardar);

        botonguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona p= new Persona(fieldnombre.getText().toString(),Integer.parseInt(fieldedad.getText().toString()),
                        fieldemail.getText().toString(),fieldgithub.getText().toString());

                if(nuevo==true){

                    MainActivity.nuevaPersona(p);   //Introduce esa persona
                    MainActivity.instancia.ActualizarListadoPersonas(); //Actualiza el listado

                }else{
                    MainActivity.actualizaPersona(p);
                }

            }
        });

            /*  No va aqui :)
        try{
            if(!savedInstanceState.isEmpty()){
                fieldnombre.setText(savedInstanceState.getString("nombre"));
                fieldedad.setText(Integer.toString(savedInstanceState.getInt("edad")));
            }
        }catch (Exception ex){
            Log.e("error fragment","Nulo en savedInstance");
        }*/


        return view;
    }



}