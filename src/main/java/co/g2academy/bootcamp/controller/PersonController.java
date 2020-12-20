/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.controller;

import co.g2academy.bootcamp.entity.Person;
import co.g2academy.bootcamp.service.PersonService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author fadli
 */
@WebServlet(name = "PersonController", urlPatterns = {"/persons"})
public class PersonController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PersonService personService = new PersonService();
        List<Person> persons = personService.getPersons();
        JSONArray jsonArray = new JSONArray();
        for (Person person : persons) {
            JSONObject jsonPerson = new JSONObject();
            jsonPerson.put("id", person.getId());
            jsonPerson.put("name", person.getName());
            jsonArray.add(jsonPerson);
        }       
        String personsJSON = jsonArray.toJSONString();
        try (PrintWriter out = response.getWriter()) {
            out.print(personsJSON);
        }
    }

}
