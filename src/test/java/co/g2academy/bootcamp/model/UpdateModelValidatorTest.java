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
public class UpdateModelValidatorTest {
    
    private final UpdateModelValidator validator = new UpdateModelValidator();
    private final UpdateModel model = new UpdateModel();
    
    @Test
    public void testValidate() {
        model.setPassword("nakama");
        model.setConfirmPassword("nakama");
        boolean actual = validator.validate(model);
        assertTrue(actual);
    }
    
    @Test
    public void testValidateWithWrongParameter() {
        model.setPassword("nakama");
        model.setConfirmPassword("nakamaa");
        boolean actual = validator.validate(model);
        assertFalse(actual);
    }
    
    @Test
    public void testValidateWithEmptyParameter() {
        model.setPassword("");
        model.setConfirmPassword("");
        boolean actual = validator.validate(model);
        assertFalse(actual);
    }
    
}
