package by.epam.springbootmvc.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

@ControllerAdvice
public class ApplicationExceptionHandle {
    @ExceptionHandler({ApplicationExceptions.class, AsyncRequestTimeoutException.class})
    public String loginExceptionHandle() {
        return "error";
    }
}
