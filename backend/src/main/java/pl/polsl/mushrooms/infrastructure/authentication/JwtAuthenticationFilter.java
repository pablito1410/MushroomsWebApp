package pl.polsl.mushrooms.infrastructure.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import pl.polsl.mushrooms.application.services.UserService;
import pl.polsl.mushrooms.infrastructure.services.TokenAuthenticationService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.security.core.Authentication;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtAuthenticationFilter extends GenericFilterBean {

    private final UserService userService;

    @Autowired
    public JwtAuthenticationFilter(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        Authentication authentication = TokenAuthenticationService
                .getAuthentication((HttpServletRequest)request, userService);

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        filterChain.doFilter(request,response);
    }
}