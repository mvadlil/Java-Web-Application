/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.helper;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fadli
 */
public class ControllerHelper {
    
    public static void dispatchToView(HttpServletRequest request,HttpServletResponse response, String jspView) throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspView);
        dispatcher.forward(request, response);
        
    }
    
}
