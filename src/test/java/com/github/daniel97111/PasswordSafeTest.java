package com.github.daniel97111;

import com.github.daniel97111.model.PasswordEntry;
import com.github.daniel97111.model.PasswordSafe;
import org.junit.Assert;
import org.junit.Test;

public class PasswordSafeTest {

    @Test
    public void whenAddingPasswordSafe_WhenAddingEntry_EntryShouldAdd() {
        //Given
        PasswordSafe passwordSafe = new PasswordSafe();
        //When
        passwordSafe.addEntries("Facebook", "daniel", "haslo");
        //Then
        Assert.assertTrue(passwordSafe.exists("Facebook", "daniel"));
    }

    @Test
    public void whenRemovePasswordSafe_WhenRemoveEntry_EntryShouldRemove() {
        //Given
        PasswordSafe passwordSafe = new PasswordSafe();
        //When
        passwordSafe.addEntries("wp.pl", "login", "pass");
        passwordSafe.addEntries("wp.us", "login1", "pas3s");
        passwordSafe.removeEntries(1);
        //Then
        Assert.assertFalse(passwordSafe.existsId(1));
    }

    @Test
    public void password_Show() {
        //Given
        PasswordSafe passwordSafe = new PasswordSafe();
        //When
        passwordSafe.addEntries("facebook","login123", "passFB");
        //Then
        Assert.assertEquals("Pass: passFB",passwordSafe.show("facebook"));


    }


    @Test
    public void giveSafeWithServicUserEntry() {
        PasswordSafe passwordSafe = new PasswordSafe();

        passwordSafe.addEntries("service", "user", "123");
        try {
            passwordSafe.addEntries("service", "user", "123");
            Assert.fail();
        } catch (RuntimeException e) {

        }
    }
}
