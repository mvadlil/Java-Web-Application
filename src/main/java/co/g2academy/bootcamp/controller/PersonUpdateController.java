/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.controller;

import static co.g2academy.bootcamp.helper.ControllerHelper.dispatchToView;
import co.g2academy.bootcamp.entity.Person;
import static co.g2academy.bootcamp.helper.EncryptionHelper.encrypt;
import co.g2academy.bootcamp.model.UpdateModel;
import co.g2academy.bootcamp.model.UpdateModelValidator;
import co.g2academy.bootcamp.service.PersonService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fadli
 */
@WebServlet(name = "PersonUpdateController", urlPatterns = {"/update"})
public class PersonUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer id = Integer.parseInt(request.getParameter("id"));
        PersonService service = new PersonService();
        Person person = service.getPersonById(id);
        if(person != null) {
            request.setAttribute("person", person);
            dispatchToView(request, response, "/view/update.jsp");
        } else {
            dispatchToView(request, response, "/view/update-error.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UpdateModel model = new UpdateModel();
        model.setId(Integer.valueOf(request.getParameter("id")));
        model.setPassword(request.getParameter("password"));
        model.setConfirmPassword(request.getParameter("confirmPassword"));
        
        // get database
        PersonService service = new PersonService();
        Person person = service.getPersonById(model.getId());
        
        UpdateModelValidator validator = new UpdateModelValidator();
        
        if(validator.validate(model)) {
            if(person!= null) {
                person.setPassword(encrypt(model.getPassword()));
                if(service.save(person) != null) {
                    dispatchToView(request, response, "/view/update-success.jsp");
                }
            } else {
                request.setAttribute("error", "Person you try to update is not available");
                dispatchToView(request, response, "/view/update-error.jsp");
            }
        } else {
            request.setAttribute("error", "Password is Empty or did not match");
            request.setAttribute("person", person);
            dispatchToView(request, response, "/view/update.jsp");
        }
    }
}
