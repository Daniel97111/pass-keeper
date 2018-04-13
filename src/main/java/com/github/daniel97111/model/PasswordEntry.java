package com.github.daniel97111.model;


import java.util.Objects;

public class PasswordEntry {

    private Integer id;
    private String service;
    private String password;
    private String login;

    public PasswordEntry() {
    }

    public PasswordEntry(String service, String password, String login) {
        this.service = service;
        this.password = password;
        this.login = login;
    }

    public PasswordEntry(Integer id, String service, String password, String login) {
        this.id = id;
        this.service = service;
        this.password = password;
        this.login = login;
    }
    /*    public PasswordEntry(Integer id, String service, String password, String login) {
        this.id = id;
        this.service = service;
        this.password = password;
        this.login = login;

    }*/

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordEntry that = (PasswordEntry) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(service, that.service) &&
                Objects.equals(password, that.password) &&
                Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, service, password, login);
    }

    @Override
    public String toString() {
        return "PasswordEntry{" +
                "id= " + id +
                ", service= " + service +
                ", password= " + password +
                ", login " + login +
                '}' + "\n";
    }

    public static class Builder {

        private int id;
        private String service;
        private String login;
        private String password;

        private Builder() {
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withService(String service) {
            this.service = service;
            return this;
        }

        public Builder withLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

      /*  public PasswordEntry build() {
         //   return new PasswordEntry(id, password, login, service);
        }*/


    }
}
