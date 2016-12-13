package com.htcursos.bancocombiblioteca.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.htcursos.bancocombiblioteca.R;
import com.htcursos.bancocombiblioteca.adapter.UserListAdapter;
import com.htcursos.bancocombiblioteca.model.User;
import com.orm.SugarRecord;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vinicius on 26/11/2016.
 */

public class ListActivity extends AppCompatActivity {
    @BindView(R.id.btn_novo_usuario)
    Button btn_novoUsuario;
    @BindView(R.id.list_cadastro)
    ListView listCadastro;

    private UserListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);


        btn_novoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListActivity.this, Main_Activity.class));
            }
        });

        listCadastro.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(ListActivity.this)
                        .setTitle("Excluir usuario")
                        .setMessage("Deseja exluir mesmo trouxa?")
                        .setNegativeButton("Não", null)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                User user = adapter.getItem(position);
                                user.delete();
                                updateList();
                            }
                        }).show();
                return true;
            }
        });
    }

    private void updateList(){
        adapter = new UserListAdapter(this,User.listAll(User.class));
        listCadastro.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }

}
