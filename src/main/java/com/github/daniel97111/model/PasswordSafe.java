package com.github.daniel97111.model;

import java.util.*;

public class PasswordSafe {

    private HashMap<Integer, PasswordEntry> entries = new HashMap<>();
    private Integer nextId = 0;

    public void addEntries(String service, String login, String password) {
        Integer id = nextId++;
        PasswordEntry passwordEntry = new PasswordEntry(id, service, password, login);
        entries.put(passwordEntry.getId(), passwordEntry);
    }

    public void removeEntries(Integer id) {
      entries.remove(id);
    }



    public String show(String service){
        for (PasswordEntry passwordEntry : entries.values()) {
            if (passwordEntry.getService().equals(service)) {
                return passwordEntry.getPassword();
            }
        }
        return null;
    }



}


