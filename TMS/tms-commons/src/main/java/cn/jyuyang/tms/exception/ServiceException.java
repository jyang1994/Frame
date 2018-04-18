package cn.jyuyang.tms.exception;

/**
 * 重写异常方法，
 * @return 返回对应的异常信息
 */
public class ServiceException extends RuntimeException {
    public ServiceException(){}
    public ServiceException(Throwable th){
        super(th);
    }
    public ServiceException(String message,Throwable th){
        super(message,th);
    }

    public ServiceException(String message) {
        super(message);
    }


}
