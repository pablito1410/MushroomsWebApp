package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.boot.actuate.trace.TraceProperties;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.boot.actuate.trace.WebRequestTraceFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;


@Component
public class RequestTraceFilter extends WebRequestTraceFilter {

    private final String[] excludedEndpoints = new String[]{"/css/**", "/js/**", "/trace", "/assets/**"};

    RequestTraceFilter(TraceRepository repository, TraceProperties properties) {
        super(repository, properties);
    }

    @Override
    protected boolean shouldNotFilter(final HttpServletRequest request) throws ServletException {
        return Arrays.stream(excludedEndpoints)
                .anyMatch(e -> new AntPathMatcher().match(e, request.getServletPath()));
    }

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        HttpServletResponse teeResponse = new HttpServletResponseWrapper(response);
//
//        filterChain.doFilter(request, teeResponse);
//
//        request.setAttribute("responseBody", teeResponse.getHeader());
//
//        super.doFilterInternal(request, teeResponse, filterChain);
//    }

    @Override
    protected Map<String, Object> getTrace(HttpServletRequest request) {
        Map<String, Object> trace = super.getTrace(request);

        byte[] outputBuffer = (byte[]) request.getAttribute("responseBody");

        if (outputBuffer != null) {
            trace.put("responseBody", new String(outputBuffer));
        }

        return trace;
    }
}
