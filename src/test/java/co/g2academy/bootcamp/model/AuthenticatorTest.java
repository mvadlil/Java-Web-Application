/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.model;

import static co.g2academy.bootcamp.helper.EncryptionHelper.encrypt;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fadli
 */
public class AuthenticatorTest {
    
    public AuthenticatorTest() {
    }

    @Test
    public void testAuthenticate() {
        Authenticator authenticator = new Authenticator();
        Boolean actual = authenticator.authenticate("fadlil@gmail.com", encrypt("nakama"));
        assertTrue(actual);
    }
    
    @Test
    public void testAuthenticateWithFalseAccount() {
        Authenticator authenticator = new Authenticator();
        Boolean actual = authenticator.authenticate("fadlil@gmail.com", encrypt("nakamaa"));
        assertFalse(actual);
    }
    
}
