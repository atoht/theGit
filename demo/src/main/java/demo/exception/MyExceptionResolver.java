package demo.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

//@Component
public class MyExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
    	ex.printStackTrace();
    	CustomException customException = null;
        // 异常处理，例如将异常信息存储到数据库
    	if(ex instanceof CustomException) {
            customException = (CustomException) ex;
        }
//    	else if (ex instanceof Throwable) {
//        	customException = (Throwable) ex;
//        }
        else {
            //如果抛出的不是系统自定义的异常则重新构造一个未知错误异常
            //这里我就也有CustomException省事了，实际中应该要再定义一个新的异常
            customException = new CustomException("系统未知错误");
        }
    	
        // 视图显示专门的错误页
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", customException.getMessage());
        modelAndView.setViewName("add1");
        return modelAndView;
    }
}
