package pl.polsl.mushrooms.infrastructure.authentication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pl.polsl.mushrooms.application.dao.UserProjectionDao;
import pl.polsl.mushrooms.application.services.projections.UserProjectionService;
import pl.polsl.mushrooms.infrastructure.services.TokenAuthenticationService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    private UserProjectionService userProjectionService;

    public JwtLoginFilter(String url, AuthenticationManager authManager, UserProjectionService userProjectionService) {
        super(new AntPathRequestMatcher(url));
        this.userProjectionService = userProjectionService;
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {

        final String email = req.getParameter("email");
        final String password = req.getParameter("password");
        if (email == null || email.isEmpty() || password == null || password.isEmpty())
        {
            return null;
        }

        User user = new User(email, password, Collections.emptyList());

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword(),
                        user.getAuthorities()
                )
        );
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {

        TokenAuthenticationService.addAuthentication(res, auth.getName());
        addUserJson(res, auth.getName());
    }

    private void addUserJson(HttpServletResponse res, String username) throws IOException {
        final Map<String, Object> user = userProjectionService.findOneByUsername(username, UserProjectionDao.Projection.FULL);
        final Gson gson = new GsonBuilder().serializeNulls().create();
        res.getWriter().write(gson.toJson(user));
        res.setContentType("application/json");
    }

}