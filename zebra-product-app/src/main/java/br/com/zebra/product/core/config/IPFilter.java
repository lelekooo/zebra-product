package br.com.zebra.product.core.config;

import br.com.zebra.product.model.util.IP;
import br.com.zebra.product.service.IPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class IPFilter implements Filter {

    @Autowired
    IPService ipService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String header = httpRequest.getHeader("TCC-IP");
        IP ip = ipService.getOne(header);
        if(ip == null){
            throw new SecurityException("Not Allowed");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
