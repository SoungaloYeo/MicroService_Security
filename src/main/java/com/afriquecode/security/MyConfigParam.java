package com.afriquecode.security;

/**
 *
 * @author yéo <yeo at sygno.tech>
 */
public class MyConfigParam {
      public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="SgloYeo";
    public static final long EXPIRATION=1*24*3600*1000;  // 1jr de durée 
    public static final String HEADER_PREFIX="Bearer ";
    
}
