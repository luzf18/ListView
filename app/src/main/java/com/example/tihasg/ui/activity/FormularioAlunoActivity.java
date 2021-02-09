package com.example.tihasg.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tihasg.R;
import com.example.tihasg.dao.AlunoDAO;
import com.example.tihasg.model.Aluno;

import java.io.Serializable;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo Contato";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private final AlunoDAO dao = new AlunoDAO();
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APPBAR);
        inicialiacaoDosCampos();
        configuraBotaoSalvar();


        Intent dados = getIntent();
        if (dados.hasExtra("aluno")) {
            aluno = (Aluno) dados.getSerializableExtra("aluno");
            campoNome.setText(aluno.getNome());
            campoTelefone.setText(aluno.getTelefone());
            campoEmail.setText(aluno.getEmail());
        } else {
            aluno = new Aluno();
        }

    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.acitivity_formulario_aluno_botao_salvar);
        botaoSalvar.setOnClickListener(view -> {
            Toast.makeText(FormularioAlunoActivity.this,
                    "Salvo",
                    Toast.LENGTH_SHORT).show();
            preencheAluno();
            if (aluno.temIdValido()) {
                dao.edita(aluno);
            } else {
                {
                    dao.salva(aluno);
                }
                finish();
                Intent intent = new Intent(this, ListaAlunosActivity.class);
                startActivity(intent);
            }
        });
    }

    private void inicialiacaoDosCampos() {
        campoNome = findViewById(R.id.acitivity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.acitivity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.acitivity_formulario_aluno_email);
    }

    private void preencheAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
    }

}