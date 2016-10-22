package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by root on 19.10.16.
 */

@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(SpittrNotFoundException.class)
    public String handleDuplicateSpittle() {
        return "error/SpittrNotFound";
    }
}
