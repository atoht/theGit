package demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = OtherException.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception ex) {
//        // 其他异常处理逻辑...
//    }

    @ExceptionHandler(value = CustomException.class)
    public ModelAndView notFoundErrorHandler(HttpServletRequest req, CustomException ex) {
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setViewName("add1");
        return modelAndView;
    }
    @ExceptionHandler(value = Throwable.class)
    public ModelAndView notFoundError(HttpServletRequest req, CustomException ex) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("message", ex.getMessage());
    	modelAndView.setViewName("add1");
    	return modelAndView;
    }
}
