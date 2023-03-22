package com.example.traductorv1;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> resultado = new MutableLiveData<>();
    Map<String, String> diccionario = new HashMap<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();

        diccionario.put("blanco", "white");
        diccionario.put("negro", "black");
        diccionario.put("violeta", "violet");


        diccionario.put("azul", "blue");
        diccionario.put("celeste", "sky blue");
        diccionario.put("verde", "green");

        diccionario.put("rojo", "red");
        diccionario.put("naranja", "orange");
        diccionario.put("marron", "brown");

    }

    public LiveData<String> getResultado() {
        if (resultado.getValue() == null) {
            this.resultado = new MutableLiveData<>();
        }

        return resultado;
    }

    public void traducir(String palabra) {
        String traduccion = "No se encontro la palabra";
        try {
            if (palabra.isEmpty()) {
                throw new ClassCastException();
            }

            if (diccionario.containsKey(palabra)) {
                traduccion = diccionario.get(palabra);
                Log.d("onClick", "funcionando");
            }
            resultado.setValue(traduccion);
        } catch (ClassCastException ex) {
            Toast.makeText(context, "Usted debe ingresar una palabra", Toast.LENGTH_LONG).show();
        }
    }
}
