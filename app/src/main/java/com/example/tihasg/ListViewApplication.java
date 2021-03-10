package com.example.tihasg;

import android.app.Application;

import com.example.tihasg.dao.AlunoDAO;
import com.example.tihasg.model.Aluno;

public class ListViewApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Fernando", "1234", "lyiz.feh12@gmail.com"));
        dao.salva(new Aluno("Fernanda", "1234", "fs069690@gmail.com"));
    }
}
