package com.example.finalfinalpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.finalfinalpro.clase.Emp;


import com.google.gson.Gson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class UsuarioDetalleEmpresa extends AppCompatActivity {

    private TextView name;
    private TextView description;
    private TextView number;
    private TextView email;
    private TextView adress;

    Integer temp;

    Emp emp;

    Button verListadoServicios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_detalle_empresa);
        verListadoServicios = (Button)findViewById(R.id.button6);

        name=findViewById(R.id.EmpName);
        number=findViewById(R.id.EmpPhone);
        email=findViewById(R.id.EmpEmail);
        adress=findViewById(R.id.EmpDirecction);

        Intent intent = getIntent();
        temp = intent.getIntExtra("idEmp", 0);

        String json ="";

        try {
            InputStream stream = getAssets().open("Emp.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json  = new String(buffer);
        } catch (Exception e) { }

        ArrayList<Emp> listEmp  = new ArrayList<Emp>(Arrays.asList(new Gson().fromJson(json, Emp[].class)));

        for (int i = 0; i < listEmp.size(); i++ ) {
            if (temp == listEmp.get(i).getId()) {
                emp=listEmp.get(i);
                name.setText(emp.getName());
                number.setText(Integer.toString(emp.getNumber()));
                email.setText(emp.getEmail());
                adress.setText(emp.getAdress());
            }
        }


        verListadoServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EmpresaServiciosLista.class);
                intent.putExtra("idEmp",temp);
                startActivity(intent);
            }
        });
    }
}
