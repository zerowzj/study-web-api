package com.company.project.webapi.support.ext;

import com.company.exception.entity.BaseException;
import com.company.project.webapi.support.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Map;

/**
 * 异常处理器
 *
 * @author wangzhj
 */
@EnableWebMvc
@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Map<String, Object> resolveException(Exception ex) {
        LOGGER.error("发生异常", ex);

        Map<String, Object> result;
        if (ex instanceof BaseException) {
            BaseException bex = (BaseException) ex;
            result = Results.buildNotOk(bex.getErrorCode(), bex.getErrorDesc());
        } else {
            result = Results.buildNotOk("9999", "系统异常");
        }
        return result;
    }
}