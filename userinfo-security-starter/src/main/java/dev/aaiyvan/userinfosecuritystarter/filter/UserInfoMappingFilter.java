package dev.aaiyvan.userinfosecuritystarter.filter;

import dev.aaiyvan.userinfosecuritystarter.context.UserLoader;
import dev.aaiyvan.userinfosecuritystarter.model.UserInfo;
import dev.aaiyvan.userinfosecuritystarter.parser.JwtParser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * A Spring Security filter that runs once per request to map user info from JWT to SecurityContext.
 */
@Component
@RequiredArgsConstructor
public class UserInfoMappingFilter extends OncePerRequestFilter {

    private final JwtParser jwtParser;
    private final UserLoader userLoader;

    /**
     * Processes each HTTP request to extract the user's information from JWT and load it into the SecurityContext.
     *
     * @param request the HTTP request
     * @param response the HTTP response
     * @param filterChain the filter chain
     */
    @Override
    @SneakyThrows
    protected void doFilterInternal
            (
                    @NonNull final HttpServletRequest request,
                    @NonNull final HttpServletResponse response,
                    final FilterChain filterChain
            ) {
        UserInfo userInfo = jwtParser.getUserInfoFromToken(request);
        userLoader.putIntoContext(userInfo);
        filterChain.doFilter(request, response);
    }
}