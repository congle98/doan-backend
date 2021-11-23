package com.shoppingbackend.services.email;

import javax.servlet.http.HttpServletRequest;

public class EmailUtils {
    public static String getDomainName(HttpServletRequest request){
        return request.getServerName();
    }
}
