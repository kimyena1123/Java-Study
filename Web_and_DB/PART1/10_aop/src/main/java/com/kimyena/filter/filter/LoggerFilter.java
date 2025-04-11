package com.kimyena.filter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Slf4j
public class LoggerFilter implements Filter { //servlet에 있는 Filter를 상속받아야 한다.
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //진입 전
        log.info(">>>>>>> 진입 전");

        var req = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest); //형변환
        var res = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse); //형변환

        filterChain.doFilter(req, res);

        var reqJson = new String(req.getContentAsByteArray());
        var resJson = new String(res.getContentAsByteArray());

        log.info("req: {}", reqJson);
        log.info("res: {}", resJson);


        log.info(">>>>>>> 리턴");
        //진입 후

        res.copyBodyToResponse();
    }
}
