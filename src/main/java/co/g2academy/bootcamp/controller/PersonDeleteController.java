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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author fadli
 */
@WebServlet(name = "PersonDeleteController", urlPatterns = {"/delete"})
public class PersonDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // convert parameter from jsp to get database
        Integer id = Integer.parseInt(request.getParameter("id"));
        PersonService service = new PersonService();
        Person person = new Person();
        person.setId(id);
        JSONObject status = new JSONObject();
        
        // delete person
        if (service.delete(person) != null) {
            status.put("status", true);
        } else {
            status.put("status", false);
        }
        String statusJSON = status.toJSONString();
        try (PrintWriter out = response.getWriter()){
            out.print(statusJSON);
        }
           
    }

 
}
