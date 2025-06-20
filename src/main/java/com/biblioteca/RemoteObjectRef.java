package com.biblioteca;

public class RemoteObjectRef {
    private String objectName;
    private String methodName;

    public RemoteObjectRef(String objectName, String methodName) {
        this.objectName = objectName;
        this.methodName = methodName;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getMethodName() {
        return methodName;
    }
}
