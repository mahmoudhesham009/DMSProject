package com.mahmoudh.dmsproject.validation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@ApplicationScoped
public class NameValidation {
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o.toString() == "") {
            FacesMessage message = new FacesMessage("Name is required");
            throw new ValidatorException(message);
        }
    }
}
