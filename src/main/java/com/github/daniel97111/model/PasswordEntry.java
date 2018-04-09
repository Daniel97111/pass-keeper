package com.github.daniel97111.model;

public class PasswordEntry {

    private Integer id;
    private String service;
    private String password;
    private String login;

    public PasswordEntry(Integer id, String service, String password, String login) {
        this.id = id;
        this.service = service;
        this.password = password;
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
