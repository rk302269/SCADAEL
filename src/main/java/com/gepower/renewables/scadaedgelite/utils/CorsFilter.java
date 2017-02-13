package com.gepower.renewables.scadaedgelite.utils;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class CorsFilter implements Filter {

private final Logger log = LoggerFactory.getLogger(CorsFilter.class);

public CorsFilter() {
    log.info("CorsFilter init");
}

@Override
@Order(Ordered.HIGHEST_PRECEDENCE)
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    String acrHeaders = request.getHeader("Access-Control-Request-Headers");
	if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
        response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "POST, PUT,GET, OPTIONS, DELETE, OPTIONS");
        response.addHeader("Access-Control-Max-Age", "3600");
        response.addHeader("Access-Control-Allow-Headers",acrHeaders);
        response.addHeader("Access-Control-Expose-Headers", "Location");
	}
    chain.doFilter(req, res);
}

@Override
public void init(FilterConfig filterConfig) {
}

@Override
public void destroy() {
}

}