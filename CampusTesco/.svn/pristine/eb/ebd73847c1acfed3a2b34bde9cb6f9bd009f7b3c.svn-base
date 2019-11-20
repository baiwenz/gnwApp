package com.example.commonlibrary.bean;

/**
 * Created by 11191 on 2018/12/30.
 */
public class Message {
    // 响应业务状态
    private Integer status;
    // 响应消息
    private String msg;
    //重复数量
    private Integer repeat;
    //成功数量
    private Integer successnum;
    //回传数据
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * Gets the value of repeat.
     *
     * @return the value of repeat
     */
    public Integer getRepeat() {
        return repeat;
    }

    /**
     * Sets the repeat.
     * You can use getRepeat() to get the value of repeat
     *
     * @param repeat repeat
     */
    public void setRepeat(Integer repeat) {
        this.repeat = repeat;

    }

    /**
     * Gets the value of successnum.
     *
     * @return the value of successnum
     */
    public Integer getSuccessnum() {
        return successnum;
    }

    /**
     * Sets the successnum.
     * You can use getSuccessnum() to get the value of successnum
     *
     * @param successnum successnum
     */
    public void setSuccessnum(Integer successnum) {
        this.successnum = successnum;

    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Message(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Message(Integer status, String msg, Integer repeat, Integer successnum) {
        this.status = status;
        this.msg = msg;
        this.repeat = repeat;
        this.successnum = successnum;
    }
    public Message(Integer status, String msg, String data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static Message success(){
        return new Message(200, "success");
    }
    public static Message error(){
        return new Message(400, "error");
    }
    public static Message tip(Integer repeat, Integer successnum){
        return new Message(300, "Tip",repeat,successnum);
    }
    public static Message tip(String data){
        return new Message(300, "Tip",data);
    }
}
