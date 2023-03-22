package com.example.traductorv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mv;
    private EditText palabraIngresada;
    private Button btnTraducir;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //crear el ViewModel
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        //Accedo a los componentes de la lista
        this.palabraIngresada = findViewById(R.id.editTextPalabra);
        this.btnTraducir = findViewById(R.id.buttonTraducir);
        this.txtResultado = findViewById(R.id.txtViewResultado);

        //Coloco el observer al mutable del ViewModel
        mv.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String resultado) {
                txtResultado.setText(resultado);
            }
        });

        //Listener del boton
        this.btnTraducir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("onClick", "funcionando");
                mv.traducir(palabraIngresada.getText().toString().trim().toLowerCase());
            }
        });
    }
}