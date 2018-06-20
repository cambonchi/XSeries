package com.example.cambo.xseries;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
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
            //Validar y registrar en la Base de datos
            Validar(correo,password,nombre,apellido);

        }


    }

 private void Validar(String usr, String pass, String nombre , String apellido ) {

     // Validar Correo
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(usr);

        // Validar Password
        Pattern patt = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,15})");
        Matcher matcher2 = patt.matcher(pass);

        //correo
        if (mather.find() == false) {
            Toast.makeText(this, "EEROR!! Correo@example.com", Toast.LENGTH_SHORT).show();
        } else if (matcher2.find() == false){
            Toast.makeText(this, "Password debe contener [MAYUS,minus,1234]   Ejemplo: pAssw0rd ", Toast.LENGTH_LONG).show();
        }else{
//            Toast.makeText(this, "Correo y password Validos ", Toast.LENGTH_SHORT).show();


            DataBase usuario = new DataBase(this,"usuarios",null, 1);
            SQLiteDatabase BaseDeDatos = usuario.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("nombre",nombre);
            registro.put("apellido",apellido);
            registro.put("correo",usr);
            registro.put("contraseña",pass);
            registro.put("saldo","100");
            BaseDeDatos.insert("usuarios",null,registro );
            BaseDeDatos.close();
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            et_nombre.setText("");
            et_appellido.setText("");
            et_password.setText("");
            et_correo.setText("");
            et_password.setText("");

        }
    }








}
