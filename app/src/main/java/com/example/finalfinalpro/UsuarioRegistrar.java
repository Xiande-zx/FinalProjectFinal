package com.example.finalfinalpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalfinalpro.clase.User;
import com.example.finalfinalpro.R;
import com.google.gson.Gson;

public class UsuarioRegistrar extends AppCompatActivity {

    private String userName;
    private String password;

    private String name;
    private String surname;
    private String phone;
    private Integer age;
    private String poblation;
    private String email;
    private boolean inmune;

    private EditText Rname;
    private EditText Rsurname;
    private EditText Rphone;
    private EditText Rage;
    private EditText Rpoblation;
    private EditText Remail;
    private EditText Rinmune;

    private EditText RuserName;
    private EditText Rpassword;

    Button detalleUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_registrar);

        Rname=findViewById(R.id.Rname);
        Rsurname=findViewById(R.id.Rsurname);
        RuserName=findViewById(R.id.Rusername);
        Rpassword=findViewById(R.id.Rpassword);
        Rphone=findViewById(R.id.RphoneNumber);
        Rage=findViewById(R.id.Rage);
        Rpoblation=findViewById(R.id.Remail);
        Remail=findViewById(R.id.Remail);

        Intent intent = getIntent();
        if(intent!=null){
            getIntent().getSerializableExtra("userJson");
            Gson gson = new Gson();
            final User user = gson.fromJson(getIntent().getStringExtra("userJson"), User.class);
            Rname.setText(user.getName());
            Rsurname.setText(user.getSurname());
            RuserName.setText(user.getUserName());
            Rpassword.setText(user.getPoblation());
            Rphone.setText(user.getTelefono());
            Rage.setText(String.valueOf(user.getAge()));
            Rpoblation.setText(user.getPoblation());
            Remail.setText(user.getEmail());
        }

        detalleUsuario = (Button)findViewById(R.id.button2);

        detalleUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=RuserName.getText().toString();
                password=Rpassword.getText().toString();
                name=Rname.getText().toString();
                surname=Rsurname.getText().toString();
                phone=Rphone.getText().toString();
                String agee = Rage.getText().toString();
                age=Integer.parseInt(agee);
                poblation=Rpoblation.getText().toString();
                email=Remail.getText().toString();

                if (name.isEmpty()){
                    error("nom");
                }else if (surname.isEmpty()){
                    error("cognom");
                }else if (userName.isEmpty()){
                    error("username");
                }else if (password.isEmpty()){
                    error("password");
                }else if (phone.isEmpty()){
                    error("telefon");
                }else if (agee.isEmpty()){
                    error("edat");
                }else if(poblation.isEmpty()){
                    error("poblacio");
                }else if(email.isEmpty()){
                    error("email");
                }else{
                    User user = new User(1,userName,password,name,surname,phone,age,poblation,email,true);
                    Intent intent = new Intent(UsuarioRegistrar.this,UsuarioDetalle.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void error(String str){
        Context context = getApplicationContext();
        CharSequence text = "El camp "+str+" no pot estar buit!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
