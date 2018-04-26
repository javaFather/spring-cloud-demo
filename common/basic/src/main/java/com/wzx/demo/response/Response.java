package com.wzx.demo.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangzx
 * @date 2018/4/24 11:18:03
 */
@Data
public class Response<T> implements Serializable{
    /**成功码**/
    public static final String SUCCESS_CODE = "000000";

    /** 响应码**/
    private String repCode;

    /**响应消息**/
    private String repMsg;

    /** 操作流水号**/
    private String flowId;

    /**返回数据**/
    private T data;

    /**是否成功**/
    public boolean isSuccess() {
        return SUCCESS_CODE.equals(this.repCode);
    }

    public static Response ok(){
        Response response = new Response();
        response.repCode = SUCCESS_CODE;
        return response;
    }

    public static Response ok(String reqCode,String repMsg){
        Response response = new Response();
        response.repCode = reqCode;
        response.repMsg = repMsg;
        return response;
    }
    public  Response<T> addResponse(T data){
        this.repCode = SUCCESS_CODE;
        this.data = data;
        return this;
    }


}
