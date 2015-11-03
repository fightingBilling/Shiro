package com.somnus.msg;

import java.io.Serializable;

/** 
 * @Description: TODO
 * @author 
 * @date 2015年11月3日 下午5:51:50 
 * @version V1.0 
 */
public class Message implements Serializable{
    private static final long serialVersionUID = 1L;
    private String sysCode;
    private String brcCode;
    private String channelNo;
    private String terminalNo;
    private String frontNo;
    private String frontTime;
    private String repCode;
    private String repMsg;

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getBrcCode() {
        return brcCode;
    }

    public void setBrcCode(String brcCode) {
        this.brcCode = brcCode;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getFrontNo() {
        return frontNo;
    }

    public void setFrontNo(String frontNo) {
        this.frontNo = frontNo;
    }

    public String getFrontTime() {
        return frontTime;
    }

    public void setFrontTime(String frontTime) {
        this.frontTime = frontTime;
    }

    public String getRepCode() {
        return repCode;
    }

    public void setRepCode(String repCode) {
        this.repCode = repCode;
    }

    public String getRepMsg() {
        return repMsg;
    }

    public void setRepMsg(String repMsg) {
        this.repMsg = repMsg;
    }

}

