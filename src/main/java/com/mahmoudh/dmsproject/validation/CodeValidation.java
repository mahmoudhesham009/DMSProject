package com.mahmoudh.dmsproject.validation;

import com.mahmoudh.dmsproject.service.EmployeeService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@ApplicationScoped
public class CodeValidation {
    private EmployeeService employeeService;

    public CodeValidation() {
        this.employeeService = EmployeeService.getInstance();
    }

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o.toString() == "") {
            FacesMessage message = new FacesMessage("Code is required");
            throw new ValidatorException(message);
        }
        int code;
        try {
            code = Integer.parseInt(o.toString());
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Code must contain digits only");
            throw new ValidatorException(message);
        }

        if (employeeService.isCodeUsed(o.toString())) {
            FacesMessage message = new FacesMessage("employee code already Exist");
            throw new ValidatorException(message);
        }
    }

}
