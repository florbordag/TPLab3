package com.example.tplab3.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tplab3.R;
import com.example.tplab3.model.Usuario;
import com.example.tplab3.ui.registro.Registro;

import java.security.Principal;

public class MainActivity extends AppCompatActivity {
    private EditText mail, pass;
    private ViewModelLogin vml;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    public void entrar(View v){
        if(pass.getText()!=null&&mail.getText()!=null){
            vml.entrar(getApplicationContext(),pass.getText().toString(),mail.getText().toString());
        } else {
            Toast.makeText(this,"Rellene todos los campos!",Toast.LENGTH_LONG).show();
        }
    }

    public void registrarse(View v){
        Intent i = new Intent(getApplicationContext(), Registro.class);
        startActivity(i);
    }

    public void inicializar(){
        mail=findViewById(R.id.etMail);
        pass=findViewById(R.id.etPass);
        vml= ViewModelProviders.of(this).get(ViewModelLogin.class);
        vml.getMldUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario user) {
                if(user!=null){
                    Intent i = new Intent(getApplicationContext(), Registro.class);
                    i.putExtra("Usuario", user.getMail());
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario no registrado.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
