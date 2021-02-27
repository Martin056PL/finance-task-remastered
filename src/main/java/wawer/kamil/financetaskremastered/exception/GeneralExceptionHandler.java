package wawer.kamil.financetaskremastered.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidFileTypeException.class)
    ResponseEntity<Object> handleIncorrectFileType(){
        return ResponseEntity.badRequest().build();
    }
}