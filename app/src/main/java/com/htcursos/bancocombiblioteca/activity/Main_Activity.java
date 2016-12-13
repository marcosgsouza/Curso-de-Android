package com.htcursos.bancocombiblioteca.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.htcursos.bancocombiblioteca.R;
import com.htcursos.bancocombiblioteca.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vinicius on 26/11/2016.
 */

public class Main_Activity extends AppCompatActivity {
    @BindView(R.id.btn_cadastrar)
    Button btnCadastrar;
    @BindView(R.id.edt_nome)
    EditText edtNome;
    @BindView(R.id.edt_email)
    EditText edtEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_cadastrar)
    public void cadastrarUsuario(){
        String name = edtNome.getText().toString();
        String email = edtEmail.getText().toString();
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email)) {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.save();
            Toast.makeText(Main_Activity.this, "Usuario Salvo!", Toast.LENGTH_SHORT).show();
            finish();



        } else {
            Toast.makeText(Main_Activity.this, "Todos os campos devem ser preenchidos!", Toast.LENGTH_SHORT).show();
        }
    }
}
