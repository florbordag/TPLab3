package com.example.tplab3.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tplab3.R;
import com.example.tplab3.model.Usuario;
import com.example.tplab3.ui.login.MainActivity;

import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {
    private TextView dni,mail,nombre,apellido,pass;
    private ViewModelRegistro vmr;
    private Usuario u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        inicializar();

        if(getIntent().hasExtra("Usuario")){
            vmr.leer(getApplicationContext());
        }
    }

    public void inicializar(){
        dni=findViewById(R.id.tDni);
        mail=findViewById(R.id.tmail);
        nombre=findViewById(R.id.tnombre);
        apellido=findViewById(R.id.tapellido);
        pass=findViewById(R.id.tpass);
        vmr= ViewModelProviders.of(this).get(ViewModelRegistro.class);
        vmr.getMldUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario user) {
                if(u!=null){
                    user=u;
                }
                dni.setText(user.getDni()+"");
                mail.setText(user.getMail());
                nombre.setText(user.getNombre());
                apellido.setText(user.getApellido());
                pass.setText(user.getPassword());
            }
        });
    }

    public void guardar(View v){
        if(nombre.getText()!=null&&apellido.getText()!=null&&pass.getText()!=null){
            if(!validarEmail(mail.getText()+"")){
                Toast.makeText(this,"Mail invalido!",Toast.LENGTH_LONG).show();
            } else {
                if(dni.getText().length()!=8){
                    Toast.makeText(this,"DNI invalido!",Toast.LENGTH_LONG).show();
                } else {
                    vmr.guardar(getApplicationContext(),
                            new Usuario( Long.parseLong(dni.getText()+""),
                                    nombre.getText()+"",
                                    apellido.getText()+"",
                                    mail.getText()+"",
                                    pass.getText()+"" ));
                    Toast.makeText(this,"Datos guardados.",Toast.LENGTH_LONG).show();
                }
            }

        } else {
            Toast.makeText(this,"Hay campos vacios!",Toast.LENGTH_LONG).show();
        }
    }

    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public void salir(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
