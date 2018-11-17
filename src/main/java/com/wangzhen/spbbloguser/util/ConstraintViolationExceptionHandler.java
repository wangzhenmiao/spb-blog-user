package com.wangzhen.spbbloguser.util;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ConstraintViolationException 处理器.
 * @Description
 * @Author wangzhen
 * @Date 2018/11/17 下午2:34
 **/
public class ConstraintViolationExceptionHandler {


    /**
     * 获取批量异常信息
     * @param e
     * @return
     */
    public static String getMessage(ConstraintViolationException e){
        List<String> msgList = new ArrayList<>();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            msgList.add(constraintViolation.getMessage());
        }
        String messages = StringUtils.join(msgList.toArray(),";");
        return messages;
    }
}

