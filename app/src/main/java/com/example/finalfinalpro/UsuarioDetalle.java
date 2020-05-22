package com.example.finalfinalpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalfinalpro.clase.User;


import com.google.gson.Gson;

public class UsuarioDetalle extends AppCompatActivity {

    Button modificar, verServicios;

    TextView name;
    TextView surname;
    TextView phone;
    TextView age;
    TextView email;
    TextView poblation;
    TextView userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_detalle);

        modificar =(Button)findViewById(R.id.button28_3);
        verServicios =(Button)findViewById(R.id.button_9);

        Intent myIntent = getIntent();
        getIntent().getSerializableExtra("userJson");
        Gson gson = new Gson();
        final User user = gson.fromJson(getIntent().getStringExtra("userJson"), User.class);

        final String userStr = getIntent().getStringExtra("userJson");

        name=findViewById(R.id.UDname);
        name.setText(user.getName());

        surname=findViewById(R.id.UDsurname);
        surname.setText(user.getSurname());

        phone=findViewById(R.id.UDphone);
        phone.setText(user.getTelefono());

        age=findViewById(R.id.UDage);
        age.setText(user.getAge().toString());

        email=findViewById(R.id.UDemail);
        email.setText(user.getEmail());

        poblation=findViewById(R.id.UDpoblation);
        poblation.setText(user.getPoblation());

        userName=findViewById(R.id.UDusername);
        userName.setText(user.getUserName());

        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UsuarioRegistrar.class);
                startActivity(intent);
            }
        });

        verServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UsuarioServicios.class);
                intent.putExtra("userJson", userStr);
                startActivity(intent);
            }
        });
    }
}
