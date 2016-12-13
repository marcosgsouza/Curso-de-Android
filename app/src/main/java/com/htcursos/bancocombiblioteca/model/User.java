package com.htcursos.bancocombiblioteca.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by Vinicius on 26/11/2016.
 */

public class User extends SugarRecord {

    @Unique
    private String name;
    private String email;


    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
