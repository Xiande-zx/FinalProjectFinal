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


import com.google.gson.Gson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class EmpresaServiciosLista extends AppCompatActivity {

    Button crearServicio;

    Integer temp;

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_servicios_lista);

        Intent intent = getIntent();
        temp = intent.getIntExtra("idEmp", 0);

        listView=findViewById(R.id.lista);

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

        final ArrayList<Service> list1 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getIdEmp()==temp){
                list1.add(list.get(i));
            }
        }

        USAdapter usAdapter = new USAdapter(this,list1);

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
