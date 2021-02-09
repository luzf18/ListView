package com.example.tihasg.ui.activity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tihasg.R;
import com.example.tihasg.dao.AlunoDAO;
import com.example.tihasg.model.Aluno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Tihasg Mobile";
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Seja Bem-Vindo", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_lista_alunos);
        configuraFabNovoAluno();
        setTitle(TITULO_APPBAR);


        if (dao.todos().size() == 0) {
            dao.salva(new Aluno("Fernando", "991090427", "luiz@gmail.com"));
            dao.salva(new Aluno("Fernanda", "991090428", "fernanda@gmail.com"));
        }

    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(view -> abreFormularioAlunoActivity());
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        setTitle("Tihasg Mobile");
        ListView ListaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        final List<Aluno> alunos = dao.todos();
        configuraAdapter(ListaDeAlunos, alunos);
        configuraListenerDeCliquePorItem(ListaDeAlunos);
    }

    private void configuraListenerDeCliquePorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener(this::onItemClick);
    }

    private void configuraAdapter(ListView listaDeAlunos, List<Aluno> alunos) {
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                alunos));
    }

    private void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
        Aluno alunoEscolhido = (Aluno) AdapterView.getItemAtPosition(posicao); 
        Intent vaiParaFormularioActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
        vaiParaFormularioActivity.putExtra("aluno", alunoEscolhido);
        startActivity(vaiParaFormularioActivity);
    }
}