package com.example.clase18_11_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Spinner SpinFa, SpinCa;
    private EditText etMa;
    private DatabaseReference Coneccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Coneccion= FirebaseDatabase.getInstance().getReference("clases");

        etMa=(EditText) findViewById(R.id.txt_Ma);
        SpinCa=(Spinner) findViewById(R.id.spin_Ca);
        SpinFa=(Spinner) findViewById(R.id.spin_Fa);
        String [] facultad = {"Fac. Ciencia y Tecnologia","Fac. Economicas y Financieras","Fac. Arquitectura y Urbanizacion","Fac. Ciencias de la Salud"};
        ArrayAdapter <String> adapterFacultad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, facultad);
        SpinFa.setAdapter(adapterFacultad);

        String [] carrera = {"Ingenieria de Sitemas","Ingenieria de Telecomunicaciones","Medicina","Arquitectura"};
        ArrayAdapter <String> adapterCarrera = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, carrera);
        SpinCa.setAdapter(adapterCarrera);

        String materia = etMa.getText().toString();

    }
    public void registrar(View view){
        String facultad = SpinFa.getSelectedItem().toString();
        String carrera = SpinCa.getSelectedItem().toString();
        String materia = etMa.getText().toString();
        if(TextUtils.isEmpty(materia))
        {
            String id = Coneccion.push().getKey();
            Coneccion leccion = new Coneccion(id, facultad, carrera, materia);
            Coneccion.child("Distribuidos").child(id).setValue(leccion);
            Toast.makeText(this, "Se registro la materia",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Ingresa la materia",Toast.LENGTH_LONG).show();
        }

    }

}