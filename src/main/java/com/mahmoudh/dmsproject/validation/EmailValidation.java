package com.mahmoudh.dmsproject.validation;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

@ManagedBean
@ApplicationScoped
public class EmailValidation {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
            "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
            "(\\.[A-Za-z]{2,})$";


    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        String input = o.toString();

        //email could be null
        if (input == "") {
            return;
        }

        if (!pattern.matcher(input).matches()) {
            FacesMessage message = new FacesMessage("Your Email isn't valid");
            throw new ValidatorException(message);
        }
    }
}
