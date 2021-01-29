package com.example.tihasg.dao;

import com.example.tihasg.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class    AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    public List<Aluno> todos;

    public void salva(Aluno aluno) {
        alunos.add(aluno);


    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
