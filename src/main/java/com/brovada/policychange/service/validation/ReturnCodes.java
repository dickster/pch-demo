package com.brovada.policychange.service.validation;

import java.util.EnumSet;


// TODO : each workflow should have its own EnumSet that it can return.
public enum ReturnCodes {
    _100, _200, _300("300");

    private final String msg;

    public static EnumSet<ReturnCodes> codes = EnumSet.allOf(ReturnCodes.class);

    ReturnCodes() {
        this.msg = this.ordinal()+"";
    }

    ReturnCodes(String msg) {
        this.msg = msg;
    }


}
