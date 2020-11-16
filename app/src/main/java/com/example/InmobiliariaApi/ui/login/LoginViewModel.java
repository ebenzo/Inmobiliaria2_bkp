package com.example.InmobiliariaApi.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.InmobiliariaApi.request.ApiClient;


public class LoginViewModel extends AndroidViewModel {

    private MutableLiveData<Integer> error;
    private MutableLiveData<String> token;
    private Context context;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();

    }

    public LiveData<Integer> getError(){
        if(error==null){
            error=new MutableLiveData<>();
        }
        return error;
    }

    public MutableLiveData<String> getToken(){
        if(token==null){
            token=new MutableLiveData<>();
        }
        return token;
    }

    public void ingresar(String email,String clave){
        Call<String> datos = ApiClient.getMyApiClient().getToken(email, clave);

        datos.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful())
                {
                    token.postValue(response.body());
                    Toast.makeText(context, "'tas logueado: " + token, Toast.LENGTH_LONG).show();
                    SharedPreferences sh = context.getSharedPreferences("datos", 0);
                    SharedPreferences.Editor editor = sh.edit();
                    editor.putString("token", "Bearer " + token.getValue());//probar si funciona asi para que lo tome como un token
                    //editor.putString("email", email);
                    editor.commit();

                    /*Intent intent = new Intent(context, MainActivity.class);//aca mandar a la activity correspondiente
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);*/
                }
                else {
                    error.postValue(1);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                error.postValue(0);
                Log.d("ID:",t.getMessage());
                Toast.makeText(context, "error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });
    }
}
