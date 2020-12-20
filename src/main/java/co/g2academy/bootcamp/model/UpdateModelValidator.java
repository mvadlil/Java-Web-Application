/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.model;

/**
 *
 * @author fadli
 */
public class UpdateModelValidator {
    public Boolean validate(UpdateModel model) {
        return model.getPassword().trim().length() > 0
                && model.getConfirmPassword().trim().length() > 0
                && model.getPassword().equals(model.getConfirmPassword());
    }
}
