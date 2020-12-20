/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fadli
 */
public class RegistrationModelValidatorTest {
    
    
    RegistrationModelValidator validator = new RegistrationModelValidator();

    @Test
    public void testValidate() {
        RegistrationModel model = new RegistrationModel();
        model.setUserName("fadlil@gmail.com");
        model.setPassword("kimikimi");
        model.setConfirmPassword("kimikimi");
        boolean actual = validator.validate(model);
        assertTrue(actual);
    }
    
    @Test
    public void testValidateWithWrongInput() {
        RegistrationModel model = new RegistrationModel();
        model.setUserName("fadlil@gmail.com");
        model.setPassword("kimikim");
        model.setConfirmPassword("kimikimi");
        boolean actual = validator.validate(model);
        assertFalse(actual);
    }

    @Test
    public void testValidateUserNameAsEmailAddress() {
        RegistrationModel model = new RegistrationModel();
        model.setUserName("fadlil@gmail.com");
        boolean actual = validator.validateUserNameAsEmailAddress(model);
        assertTrue(actual);
    }
    
    @Test
    public void testValidateUserNameAsEmailAddressWithWrongEmailFormatInput() {
        RegistrationModel model = new RegistrationModel();
        model.setUserName("fadlil#gmail.com");
        boolean actual = validator.validateUserNameAsEmailAddress(model);
        assertFalse(actual);
    }

    @Test
    public void testValidatePasswordAndConfirmPasswordIsTheSame() {
        RegistrationModel model = new RegistrationModel();
        model.setPassword("kimikimi");
        model.setConfirmPassword("kimikimi");
        boolean actual = validator.validatePasswordAndConfirmPasswordIsTheSame(model);
        assertTrue(actual);
    }
    
    @Test
    public void testValidatePasswordAndConfirmPasswordIsNotTheSame() {
        RegistrationModel model = new RegistrationModel();
        model.setPassword("kimikimi");
        model.setConfirmPassword("kimikimih");
        boolean actual = validator.validatePasswordAndConfirmPasswordIsTheSame(model);
        assertFalse(actual);
    }
    
}
