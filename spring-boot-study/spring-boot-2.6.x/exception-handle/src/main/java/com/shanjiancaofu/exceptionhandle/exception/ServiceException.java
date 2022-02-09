package com.shanjiancaofu.exceptionhandle.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 自定义异常
 */
@Data
@AllArgsConstructor
public class ServiceException extends Exception {
    private int code;
    private String msg;
}
