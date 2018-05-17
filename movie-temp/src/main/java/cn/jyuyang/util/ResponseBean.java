package cn.jyuyang.util;

public class ResponseBean {
    private Object result;
    private String status;
    private String message;

    public static ResponseBean success(){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setStatus("success");
        return responseBean;
    }
    public static ResponseBean success(Object o){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setStatus("success");
        responseBean.setResult(o);
        return responseBean;
    }
    public static ResponseBean error(String message) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setStatus("error");
        responseBean.setMessage(message);
        return responseBean;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
