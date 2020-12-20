/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.controller;

import co.g2academy.bootcamp.model.Authenticator;
import co.g2academy.bootcamp.model.LoginModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static co.g2academy.bootcamp.helper.ControllerHelper.dispatchToView;
import static co.g2academy.bootcamp.helper.EncryptionHelper.encrypt;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fadli
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1. show login page
        //2. no logic at all
        dispatchToView(request, response, "/view/login-view.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // configuration of http session
        response.setContentType("text/html");
        
        //1. mapping between model with request parameter
        LoginModel login = new LoginModel();
        login.setUserName(request.getParameter("userName"));
        login.setPassword(encrypt(request.getParameter("password")));
        
        //2. authenticate 
        // untuk menyambungkan antara LoginModel dan Person
        Authenticator authenticator = new Authenticator();
        if(authenticator.authenticate(login.getUserName(), login.getPassword())){
            
            // http sesstion
            HttpSession session = request.getSession(true); // reuse existing session if exist or create one
            session.setAttribute("userName", login.getUserName());
            session.setMaxInactiveInterval(3600); // 1 hour
            
            //3. send userName to JSP view success, jadi ada namanya saat berhasil login.
            request.setAttribute("userName", login.getUserName());
            //4. show login-success-view.jsp
            dispatchToView(request, response, "/view/login-success-view.jsp");
        } else {
            //5. show login-error-view if authentication process failed
            dispatchToView(request, response, "/view/login-error-view.jsp");
        }
    }
}
