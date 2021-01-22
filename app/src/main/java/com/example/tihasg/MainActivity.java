package com.example.tihasg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Seja Bem-Vindo", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main_principal);
        List<String> alunos = new ArrayList<>(
                Arrays.asList("Ane Teles", "Felipe Rodrigues", "Fernanda Santos", "Luiz Fernando", "Rodrigo", "Tiago Rodrigues")) ;
        ListView ListaDeAlunos = findViewById(R.id.activity_main_Lista_De_Alunos);
        ListaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                (List<String>) alunos));

    }
}