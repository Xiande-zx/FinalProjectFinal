package com.example.finalfinalpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalfinalpro.clase.Service;
import com.example.finalfinalpro.R;
import com.google.gson.Gson;

public class UsuarioDetalleServicio extends AppCompatActivity {

    Service service;

    private TextView type;
    private TextView description;

    Button detalleEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_detalle_servicio);

        Intent myIntent = getIntent();
        getIntent().getSerializableExtra("serviceJson");
        Gson gson = new Gson();
        service =gson.fromJson(getIntent().getStringExtra("serviceJson"), Service.class);

        type=findViewById(R.id.UDStype);
        type.setText(service.getType());

        description=findViewById(R.id.UDSdescription);
        description.setText(service.getDescription());

        final Integer idEmp = service.getIdEmp();

        detalleEmp=findViewById(R.id.detalleEmp);
        detalleEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioDetalleServicio.this,UsuarioDetalleEmpresa.class);
                intent.putExtra("idEmp",idEmp);
                startActivity(intent);
            }
        });


    }
}
