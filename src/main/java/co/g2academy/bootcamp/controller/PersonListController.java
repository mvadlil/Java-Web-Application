/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.controller;

import co.g2academy.bootcamp.helper.ControllerHelper;
import co.g2academy.bootcamp.entity.Person;
import co.g2academy.bootcamp.service.PersonService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fadli
 */
@WebServlet(name = "PersonListController", urlPatterns = {"/personlist"})
public class PersonListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        if ( session.getAttribute("userName") == null ) {
            ControllerHelper.dispatchToView(request, response, "/view/login.jsp");
        } else {
            PersonService personService = new PersonService();
            List<Person> persons = personService.getPersons();
            request.setAttribute("persons", persons);
            ControllerHelper.dispatchToView(request, response, "/view/person-list.jsp");
        }
        
        
    }

}
