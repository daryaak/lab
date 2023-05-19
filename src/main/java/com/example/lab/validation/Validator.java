package com.example.lab.validation;
import com.example.lab.controller.Controller;
import com.example.lab.entity.ValidationNumberError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
//import org.apache.commons.lang3.StringUtils;



@Component
public class Validator {
    private static final Logger logger = LoggerFactory.getLogger(Validator.class);
    public ValidationNumberError validateParameter(String dividend, String divisor){
        ValidationNumberError response = new ValidationNumberError();
        if (!dividend.matches("-?\\d+")){
            logger.error("В качестве делимого передано не число!");
            response.addErrormessage("В качестве делимого передано не число!");
        }
        if (!divisor.matches("-?\\d+")){
            logger.error("В качестве делителя передано не число!");
            response.addErrormessage("В качестве делимого передано не число!");
        }
        else{
            int divisor1 =Integer.parseInt(divisor);
            if(divisor1 == 0){
                logger.error("Делитель не может быть нулем!");
                response.addErrormessage("Делитель не может быть нулем!");
            }
        }
        return response;
    }

}
