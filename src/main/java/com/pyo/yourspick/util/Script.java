package com.pyo.yourspick.util;

public class Script {

    /* Exception 발생시 알려주는 Script */
    public static String back(String msg){

        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("alert('"+msg+"');");
        sb.append("history.back();");
        sb.append("</script>");
        return sb.toString();
    }

}
