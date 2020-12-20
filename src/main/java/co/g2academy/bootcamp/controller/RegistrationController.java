/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.controller;

import static co.g2academy.bootcamp.helper.ControllerHelper.dispatchToView;
import co.g2academy.bootcamp.entity.Person;
import static co.g2academy.bootcamp.helper.EncryptionHelper.encrypt;
import co.g2academy.bootcamp.model.RegistrationModel;
import co.g2academy.bootcamp.model.RegistrationModelValidator;
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
@WebServlet(name = "RegistrationController", urlPatterns = {"/register"})
public class RegistrationController extends HttpServlet {

    private static final String REGISTRATION_PAGE = "/view/registration.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // show registration form
        dispatchToView(request, response, REGISTRATION_PAGE);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // receive data from registration form and save it to database
        RegistrationModel registration = new RegistrationModel();
        registration.setUserName(request.getParameter("userName"));
        registration.setPassword(request.getParameter("password"));
        registration.setConfirmPassword(request.getParameter("confirmPassword"));
        
        RegistrationModelValidator validator = new RegistrationModelValidator();
        if ( validator.validate(registration) ) {
            //create person service and person entity to save person data to database
            Person person = new Person();
            person.setName(registration.getUserName());
            // encript password first if you want
            person.setPassword(encrypt(registration.getPassword()));
            
            PersonService service = new PersonService();
            Person p = service.save(person);
            if ( p != null ) {
                // go to registration page
                dispatchToView(request,response, "/view/registration-success.jsp");
                return;
            }
        }
        // failed validation 
        String error = "Username already taken, or password not match with confirm password";
        request.setAttribute("error", error);
        request.setAttribute("userName", registration.getUserName());
        dispatchToView(request, response, REGISTRATION_PAGE);
    }

}
