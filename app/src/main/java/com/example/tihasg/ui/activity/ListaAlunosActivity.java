package com.example.tihasg.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tihasg.R;
import com.example.tihasg.dao.AlunoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Seja Bem-Vindo", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_lista_alunos);

        AlunoDAO dao = new AlunoDAO();

        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListaAlunosActivity.this,
                        FormularioAlunoActivity.class));
            }
        });

        setTitle("Tihasg Mobile");

        ListView ListaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        ListaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.todos()));

    }
}