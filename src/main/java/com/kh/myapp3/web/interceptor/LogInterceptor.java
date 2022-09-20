package com.kh.myapp3.web.interceptor;

import com.kh.myapp3.web.session.LoginOkConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    //컨트롤러 호출 전
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle called!");
        String requestURI = request.getRequestURI(); //클라이언트의 요청 URI

        UUID uuid = UUID.randomUUID(); //요청 추적번호
        request.setAttribute(LoginOkConst.TRANSACTION_ID, uuid);

        log.info("REQUEST [{}][{}][{}]", uuid, requestURI, handler);
        return true;
    }

    //컨트롤러 수행 후 뷰가 렌더링되기 전
    //컨트롤러에서 예외발생시 호출되지 않음
    //parameter ModelAndView: 컨트롤러에서 넘어온 모델, 뷰
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle called!");
        String requestURI = request.getRequestURI(); //클라이언트의 요청 URI
        String uuid = String.valueOf(request.getAttribute(LoginOkConst.TRANSACTION_ID));

        log.info("REQUEST [{}][{}][{}]", uuid, requestURI, handler);
    }

    //뷰가 렌더링되고 응답메세지가 클라이언트에 전송된 후
    //컨트롤러에서 예외발생 유무에 상관없이 항상 호출
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion!");
        String requestURI = request.getRequestURI(); //클라이언트의 요청 URI
        String uuid = String.valueOf(request.getAttribute(LoginOkConst.TRANSACTION_ID));

        log.info("REQUEST [{}][{}][{}]", uuid, requestURI, handler);

        if (ex != null) {
            log.error("afterCompletion error!!", ex);
        }
    }
}
