package com.anuradha.demo.model;

public class ErrorMessageModel {
    private String errorMsg;
    private String className;
    private int lineNo;

    public ErrorMessageModel() {
    }

    public ErrorMessageModel(String errorMsg, String className, int lineNo) {
        this.setErrorMsg(errorMsg);
        this.setClassName(className);
        this.setLineNo(lineNo);
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getLineNo() {
        return lineNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }
}
