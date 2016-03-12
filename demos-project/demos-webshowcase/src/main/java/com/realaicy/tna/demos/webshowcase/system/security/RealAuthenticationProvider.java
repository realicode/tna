package com.realaicy.tna.demos.webshowcase.system.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Realaicy on 2015/5/11.
 * XXX
 */
@Component
public class RealAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        // use the credentials to try to authenticate against the third party system
        if (name.equals("realaicy")) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "admin";
                }
            });
            grantedAuths.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "apiuser";
                }
            });
            return new UsernamePasswordAuthenticationToken(name, password, grantedAuths);

        } else if (name.equals("apiuser")) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "apiuser";
                }
            });
            return new UsernamePasswordAuthenticationToken(name, password, grantedAuths);

        } else {
            throw new UsernameNotFoundException("UsernameNotFoundException");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
