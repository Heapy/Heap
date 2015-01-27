package by.ibragimov.natrus.controllers;

import by.ibragimov.natrus.utils.ReflectionUtils;
import by.ibragimov.natrus.domain.dtos.BaseDto;
import by.ibragimov.natrus.domain.dtos.bookmars.BookmarkDto;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseDtoHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Gson GSON = new Gson();
    private static final Map<Class, Boolean> cache = new ConcurrentHashMap<>();

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Boolean answer = cache.get(parameter.getParameterType());
        if (answer == null) {
            answer = ReflectionUtils.isImplementsInterface(BaseDto.class, parameter.getParameterType());
            cache.put(parameter.getParameterType(), answer);
        }
        return answer;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory)
            throws Exception {
        return GSON.fromJson(getJsonFromRequest(webRequest), parameter.getParameterType());
    }

    private String getJsonFromRequest(WebRequest webRequest) throws IOException {
        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
        HttpServletRequest request = servletWebRequest.getRequest();
        return IOUtils.toString(request.getInputStream(), "UTF-8");
    }
}
