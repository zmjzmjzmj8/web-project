package com.zmj.project.common.exception;

import com.zmj.project.common.validate.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理
 * @author zmj
 */
@ControllerAdvice
public class ExceptionTranslator {
    //错误页面
    public static final String DEFAULT_ERROR_VIEW = "error.jsp";
    private static final Logger logger  = LoggerFactory.getLogger(ExceptionTranslator.class);

    /**
     * 未知异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        //不在页面上显示
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        //记录日志
        logger.warn("exception = {} url= {} ",e,req.getRequestURL());
        return mav;
    }

    /**
     * 校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = ValidationException.class)
    @ResponseBody
    public ModelAndView handle(HttpServletRequest req,ValidationException e){
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        logger.warn("exception = {} url = {}",e,req.getRequestURL());
        return mav;
    }
}
