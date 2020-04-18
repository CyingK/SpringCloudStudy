package com.cying.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer statusCode;
    private String message;
    private T data;

    public CommonResult(Integer statusCode, String message) {
        this(statusCode, message, null);
    }

}
