package demo.exception;

public class CustomException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	//异常信息
    public String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public static CustomException ree() {
    	CustomException t = new CustomException("用户验证失败");
    	return t ;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
