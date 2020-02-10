package com.vicframework.web.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumGlobalException {

    E01001("01001", "Param error, please refer to the api document");

    private String code;
    private String msg;
    private String[] parameters;
    private static Map<String, EnumGlobalException> code2Enum = new HashMap();

    private EnumGlobalException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }


}
