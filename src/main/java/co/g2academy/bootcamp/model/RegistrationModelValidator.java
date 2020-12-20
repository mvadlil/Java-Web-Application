/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.model;

import java.util.regex.Pattern;

/**
 *
 * @author fadli
 */
public class RegistrationModelValidator {
    
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    
    public Boolean validate(RegistrationModel model) {
        return validateUserNameAsEmailAddress(model)
                && validatePasswordAndConfirmPasswordIsTheSame(model);
    }
    
    public Boolean validateUserNameAsEmailAddress(RegistrationModel model) {
        // regex input Email Address
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        return model.getUserName()!= null && pattern.matcher(model.getUserName()).matches();
    }
    
    public Boolean validatePasswordAndConfirmPasswordIsTheSame(RegistrationModel model){
        return model.getPassword().trim().length() > 0
                && model.getPassword().equals(model.getConfirmPassword());
    }
    
}
