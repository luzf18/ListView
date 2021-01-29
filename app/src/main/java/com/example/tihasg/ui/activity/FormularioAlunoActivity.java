package com.example.tihasg.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tihasg.R;
import com.example.tihasg.dao.AlunoDAO;
import com.example.tihasg.model.Aluno;

import java.time.temporal.ValueRange;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

       final AlunoDAO dao = new AlunoDAO();


       final EditText campoNome = findViewById(R.id.acitivity_formulario_aluno_nome);
       final EditText campoTelefone = findViewById(R.id.acitivity_formulario_aluno_telefone);
       final EditText campoEmail = findViewById(R.id.acitivity_formulario_aluno_email);

        Button botaoSalvar = findViewById(R.id.acitivity_formulario_aluno_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FormularioAlunoActivity.this,
                        "Salvo",
                        Toast.LENGTH_SHORT).show();
                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();

                Aluno alunoCriado = new Aluno(nome, telefone, email);
                dao.salva(alunoCriado);

                startActivity(new Intent(FormularioAlunoActivity.this,
                        ListaAlunosActivity.class));

            }
        });
    }
}