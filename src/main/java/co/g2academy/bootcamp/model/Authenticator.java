/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.model;

import co.g2academy.bootcamp.dao.PersonDaoJDBC;
import co.g2academy.bootcamp.entity.Person;
import co.g2academy.bootcamp.service.PersonService;
import static co.g2academy.bootcamp.service.PersonService.getConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fadli
 */
public class Authenticator {
    
    // method untuk cek username dan password
    public Boolean authenticate(String userName, String password){
        PersonService personService = new PersonService();
        Person person = personService.getPersonByUserName(userName);
        return person != null
                    && userName.equalsIgnoreCase(person.getName())
                    && password.equals(person.getPassword());
    }
}
