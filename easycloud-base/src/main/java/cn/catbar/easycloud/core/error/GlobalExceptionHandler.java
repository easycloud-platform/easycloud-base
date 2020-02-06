package cn.catbar.easycloud.core.error;


import cn.catbar.easycloud.core.AppResultBuilder;
import cn.catbar.easycloud.core.bean.AppResult;
import cn.catbar.easycloud.core.eum.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 404异常处理
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public AppResult<String> errorHandler(HttpServletRequest request, NoHandlerFoundException exception, HttpServletResponse response) {
        return AppResultBuilder.faile(ResultCode.NOT_FOUND);
    }

    /**
     * 405异常处理
     */
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public AppResult<String> errorHandler(HttpServletRequest request, HttpRequestMethodNotSupportedException exception, HttpServletResponse response) {
        return AppResultBuilder.faile(ResultCode.METHOD_NOT_ALLOWED);
    }

    /**
     * 415异常处理
     */
    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public AppResult<String> errorHandler(HttpServletRequest request, HttpMediaTypeNotSupportedException exception, HttpServletResponse response) {
        return AppResultBuilder.faile(ResultCode.UNSUPPORTED_MEDIA_TYPE);

    }

    /**
     * 500异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public AppResult<String> errorHandler (HttpServletRequest request, Exception exception, HttpServletResponse response) {
        return AppResultBuilder.faile(ResultCode.INTERNAL_SERVER_ERROR);

    }


}