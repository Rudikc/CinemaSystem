package ua.rudikc.cinema.filters;

import ua.rudikc.cinema.factory.LanguageBundleFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static ua.rudikc.cinema.utils.Constants.*;


/**
 * Filter to read users locale and set the correct bundle
 */
public class LocalizationFilter implements Filter {

    private String defaultBundle;
    private String locale;

    @Override
    public void init(FilterConfig filterConfig) {
        defaultBundle = filterConfig.getInitParameter(BUNDLE);
        locale = filterConfig.getInitParameter(LOCALE);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String localeSession = (String) httpRequest.getSession().getAttribute(LOCALE);

        if (localeSession == null) {
            httpRequest.getSession().setAttribute(LOCALE, locale);
            httpRequest.getSession().setAttribute(BUNDLE, defaultBundle);

        }else{
            httpRequest.getSession().setAttribute(BUNDLE, LanguageBundleFactory.getBundle(localeSession));
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
