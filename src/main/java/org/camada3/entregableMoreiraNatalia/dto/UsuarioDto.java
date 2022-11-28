package org.camada3.entregableMoreiraNatalia.dto;

import java.io.Serializable;

public class UsuarioDto implements Serializable {

    private Integer id;
    private  Boolean Admin;
    private String userName;
    private String password;

    private UsuarioDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAdmin() {
        return Admin;
    }

    public void setAdmin(Boolean admin) {
        Admin = admin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
