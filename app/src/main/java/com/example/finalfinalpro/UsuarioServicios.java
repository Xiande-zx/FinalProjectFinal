package com.example.finalfinalpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.finalfinalpro.UserAdapter.USAdapter;
import com.example.finalfinalpro.clase.Service;
import com.example.finalfinalpro.clase.User;
import com.example.finalfinalpro.R;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class UsuarioServicios extends AppCompatActivity {

    Button detalleUsuario, empresaServicios;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_servicios);

        detalleUsuario =(Button)findViewById(R.id.button4);
        empresaServicios =(Button)findViewById(R.id.button5);
        listView=findViewById(R.id.lista);

        Intent myIntent = getIntent();
        getIntent().getSerializableExtra("userJson");
        Gson gson = new Gson();
        final User user = gson.fromJson(getIntent().getStringExtra("userJson"), User.class);

        final String userStr = getIntent().getStringExtra("userJson");

        detalleUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UsuarioDetalle.class);
                intent.putExtra("userJson", userStr);
                startActivity(intent);
            }
        });

        empresaServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EmpresasLista.class);
                startActivity(intent);
            }
        });

        String json ="";

        try {
            InputStream stream = getAssets().open("ServiceList.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json  = new String(buffer);
        } catch (Exception e) { }

        final ArrayList<Service> list  = new ArrayList<Service>(Arrays.asList(new Gson().fromJson(json, Service[].class)));

        USAdapter usAdapter = new USAdapter(this,list);

        listView.setAdapter(usAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Service service = new Service(list.get(position).getId(),list.get(position).getType(),list.get(position).getDescription(),list.get(position).getIdEmp());
                Gson gson = new Gson();
                String serviceJson = gson.toJson(service);

                Intent activity2Intent = new Intent(getApplicationContext(), UsuarioDetalleServicio.class);
                activity2Intent.putExtra("serviceJson", serviceJson);
                startActivity(activity2Intent);

            }
        });


    }
}
