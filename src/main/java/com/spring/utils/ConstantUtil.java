package com.spring.utils;

import java.text.DecimalFormat;

public class ConstantUtil {
    public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60; //24 Hours (in seconds)
    public static final String JWT_TOKEN_PREFIX = "Bearer ";
    public static final String JWT_HEADER_STRING = "Authorization";
    public static final String JWT_TOKEN_SECRET = "spring@9911";
    public static final String[] ALLOWED_ORIGINS = new String[]{"http://localhost:4200"};
    public static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
    public static final String JOB_GROUP_NAME = "job_group";
    public static final String TRIGGER_NAME_SUFFIX = "Trigger";
    public static final String SALES_CLASS_NAME_PREFIX = "com.utcl.scheduler.jobs.alerts.sales.";
    public static final String USER_VALIDATE_API = "http://localhost:8080/app/User/verifyUser";

    public static final String USERROLE = "USR";
    public static final String ADMINROLE = "ADMIN";

    
    
}
