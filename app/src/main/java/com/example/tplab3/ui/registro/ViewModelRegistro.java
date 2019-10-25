package com.example.tplab3.ui.registro;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tplab3.model.Usuario;
import com.example.tplab3.request.ApiClient;

public class ViewModelRegistro extends ViewModel {

    private MutableLiveData<Usuario> mldUsuario;
    private MutableLiveData<String> datos;
    private ApiClient apiClient=new ApiClient();
    private Usuario u;

    public LiveData<Usuario> getMldUsuario(){
        if(mldUsuario==null){
            mldUsuario=new MutableLiveData<>();
        }
        return mldUsuario;
    }

    public LiveData<String> getDatos(){
        if(datos==null){
            datos=new MutableLiveData<>();
        }
        return datos;
    }

    public void guardar(Context context, Usuario user){
        apiClient.guardar(context,user);
    }

    public void leer(Context context){
        u=apiClient.leer(context);
        mldUsuario.setValue(u);
    }


}
