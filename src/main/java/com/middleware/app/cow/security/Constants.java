package com.middleware.app.cow.security;
public class Constants {

    // Spring Security

    public static final String LOGIN_URL = "/login";
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";
    public static final String ROLES = "roles";
    public static final String ACCESS_CONTROL_EXPOSE_HEADERS = "access-control-expose-headers";

    public static final String REDIRECT = "redirect";
    public static final String ROLE_CUSTOMER = "ROLE_CUSTOMER";
    public static final String CLIENTE = "cliente";
    public static final String ROLE_COMPANY = "ROLE_COMPANY";
    public static final String EMPRESA = "empresa";
    public static final String ADMINISTRADOR = "administrador";

    // JWT

    public static final String ISSUER_INFO = "https://www.autentia.com/";
    public static final String SUPER_SECRET_KEY = "1234";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

}
