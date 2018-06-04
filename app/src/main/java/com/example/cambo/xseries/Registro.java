package com.example.cambo.xseries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {
    EditText et_nombre,et_appellido,et_correo,et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_nombre = (EditText)findViewById(R.id.et_name);
        et_appellido = (EditText)findViewById(R.id.et_apellido);
        et_correo = (EditText)findViewById(R.id.et_correo);
        et_password = (EditText)findViewById(R.id.et_passw);
    }

public void Registro(View view){
        String nombre = et_nombre.getText().toString();
        String apellido = et_appellido.getText().toString();
        String correo = et_correo.getText().toString();
        String password = et_password.getText().toString();

        if(nombre.length() == 0 || apellido.length() == 0 || correo.length() == 0 || password.length()== 0 ){
            Toast.makeText(this, "Todos los campos son obligatorios ", Toast.LENGTH_SHORT).show();

        }else{
            Validar(correo,password);

            Toast.makeText(this, "Registro en proceso", Toast.LENGTH_SHORT).show();

        }


    }


    private void Validar(String usr, String pass){

        // Validar Correo
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(usr);

        // Validar Password
        Pattern patt = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,15})");
        //("(?=\w*\d)](?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$");
        Matcher matcher2 = patt.matcher(pass);


        if (mather.find() == true && matcher2.find() == true ) {
            Toast.makeText(this, "Correo y Password Validos", Toast.LENGTH_LONG).show();
            //System.out.println("El email ingresado es válido.");

        } else {
            Toast.makeText(this, "EEROR!! Correo o password Invalido", Toast.LENGTH_SHORT).show();
            //System.out.println("El email ingresado es inválido.");
        }


/*
        if (matcher2.find() == true) {
            Toast.makeText(this, "Password Valido", Toast.LENGTH_SHORT).show();
            //System.out.println("Password es válido.");

        } else {
            Toast.makeText(this, "Password Invalido", Toast.LENGTH_SHORT).show();
            //System.out.println("Password no es inválido.");
        }*/









    }

}
