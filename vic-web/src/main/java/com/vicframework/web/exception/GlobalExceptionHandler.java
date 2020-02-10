package com.vicframework.web.exception;

import com.vicframework.web.enums.EnumGlobalException;
import com.vicframework.web.model.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected RestResponse handleConstraintViolation(
            javax.validation.ConstraintViolationException ex) {
        String error = "Validation error" + ex.getConstraintViolations();
        return RestResponse.failed(EnumGlobalException.E01001.getCode(), error);

    }

    /**
     *
     * @param e 异常对象
     * @return 响应体
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public RestResponse missingServletRequestParameter(MissingServletRequestParameterException e) {
        String error = e.getParameterName() + " parameter is missing";
        return RestResponse.failed(EnumGlobalException.E01001.getCode(), error);
    }

    //...handle other excepton

}
