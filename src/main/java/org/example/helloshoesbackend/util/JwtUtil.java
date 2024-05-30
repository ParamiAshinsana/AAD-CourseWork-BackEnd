package org.example.helloshoesbackend.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(ignoreResourceNotFound = true, value = "classpath:otherprops.properties")
public class JwtUtil {

    //The serialVersionUID is a unique identifier used in Java serialization
    // to ensure that a serialized object can be deserialized correctly,
    // even if the class definition has changed
    private static final long serialVersionUID = 234234523523L;

    public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60 * 12;


    @Value("${jwt.secret}")
    private String secretKey;

}
