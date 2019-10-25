package com.example.tplab3.ui.login;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tplab3.model.Usuario;
import com.example.tplab3.request.ApiClient;

public class ViewModelLogin extends ViewModel {
    private MutableLiveData<Usuario> mldUser;
    private ApiClient apiClient=new ApiClient();
    private Usuario u;

    public LiveData<Usuario> getMldUsuario(){
        if(mldUser==null){
            mldUser=new MutableLiveData<>();
        }
        return mldUser;
    }

    public void entrar(Context context, String pass, String mail){
        u=apiClient.login(context,mail,pass);
        mldUser.setValue(u);
    }
}
