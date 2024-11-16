package org.example.ps27852_lab8.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.service.CategorySetvice;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequiredArgsConstructor
public class GlobalInterceptor implements HandlerInterceptor {
    private final CategorySetvice categorySetvice;

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        request.setAttribute("cates", categorySetvice.getAllCategories());
    }
}
