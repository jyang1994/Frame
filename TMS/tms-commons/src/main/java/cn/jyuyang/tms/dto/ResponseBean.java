package cn.jyuyang.tms.dto;

public class ResponseBean {
    private String status;
    private String message;
    private Object data;
    public static final String ERROR = "error";
    public static final String SUCCESS = "success";

    public static ResponseBean error(String message){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setStatus(ERROR);
        responseBean.setMessage(message);
        return responseBean;
    }
    public static ResponseBean success(){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setStatus(SUCCESS);
        return responseBean;
    }
    public static ResponseBean success(Object data){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setStatus(SUCCESS);
        responseBean.setData(data);
        return responseBean;
    }

    public ResponseBean() {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
