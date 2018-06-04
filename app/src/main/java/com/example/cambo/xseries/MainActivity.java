package com.example.cambo.xseries;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText et_usr , et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_usr = (EditText)findViewById(R.id.et_user);
        et_pass = (EditText)findViewById(R.id.et_passw);
    }

    // Login Usuario
    public void Login (View view){

        String usuario = et_usr.getText().toString();
        String password = et_pass.getText().toString();


        //Validar  llenado de campos  (correo, password)

            //length verifica cuantos caracteres tiene la cadena de texto
        if(usuario.length() == 0){
            // correo no ingresado
            Toast.makeText(this, "Ingresa un correo", Toast.LENGTH_SHORT).show();
        }if(password.length()== 0 ){
            //Contraseña no ingresada
            Toast.makeText(this, "Ingresa un Password", Toast.LENGTH_SHORT).show();
        }
        if (usuario.length() !=0 && password.length() != 0) {
            // Correo y contraseña ingresados
            Validar(usuario,password);
            Administrador(usuario,password);
            Usuario(usuario,password);


            //Toast.makeText(this, "Inicio de Sesion en Proceso", Toast.LENGTH_SHORT).show();


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
            Toast.makeText(this, "Correo y Password Validos", Toast.LENGTH_SHORT).show();
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

    public void Registrar (View view){

        Intent registrar = new Intent(this,Registro.class);
        startActivity(registrar);

    }

    public  void Administrador (String usr ,String pass){

        String admin = "Idp@Admin.com";
        String passAdm = "Admin123";

        if (usr.equals(admin)  && passAdm.equals(pass) ){
            Toast.makeText(this, "Holi crayolii", Toast.LENGTH_SHORT).show();
            Intent adm = new Intent(this,Admin.class );
            startActivity(adm);

        }



    }

    public void Usuario (String usr, String pass){
        String nombre = "Ricardo";
        String correo = "cambonchi@gmail.com";
        String password = "Hola1234";

        if(correo.equals(usr)&& password.equals(pass)){
            Toast.makeText(this, "Bienvenido "+ nombre, Toast.LENGTH_SHORT).show();
            Intent usu = new Intent(this,Usuario.class);
            startActivity(usu);


        }else{
            Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();

        }



    }







}
