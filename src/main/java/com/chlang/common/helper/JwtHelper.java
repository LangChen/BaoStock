package com.chlang.common.helper;

import com.chlang.common.exception.PlatfromException;
import com.chlang.common.resp.common.ErrorCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT处理类
 */
@Component
public class JwtHelper {
    Logger logger = LoggerFactory.getLogger(JwtHelper.class);

    /**
     * 需要32个字节的加密字符串
     */
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiredTime}")
    private Long expiredTime;

    /**
     * 创建Token
     * @param userAccount
     * @return
     */
    public String createToken(String userAccount){
        //设置过期时间，如果使用redis，可以去掉，
        Map<String,Object> claims = new HashMap<>();
        claims.put("userAccount",userAccount);
        Date now = new Date();
        //设置超时时间
        Date exp = new Date(now.getTime()+expiredTime*1000);

        String token = Jwts.builder()
                .setClaims(claims)
                .setId(userAccount)
                .setExpiration(exp)
                .signWith(getKey())
                .compact();
        return token;
    }

    /**
     * 验证token的有效性
     * @param token
     */
    public Claims verifyToken(String token)throws Exception{
        Claims claims = null;
        try {
            claims = Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
            logger.info(claims.toString());
            //OK, we can trust this JWT
        } catch (JwtException e) {
            //don't trust the JWT!
            throw new PlatfromException(ErrorCode.TOKEN_FAILED_ERROR,"无效的令牌");
        }
        return claims;
    }

    /**
     * 获取加解密的key
     * @return
     */
    private SecretKey getKey(){
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }
}
