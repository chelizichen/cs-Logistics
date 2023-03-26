package com.caoshuai.back.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Ret <T>{
    public Integer code;
    public String message;
    public T data;

    public static <T>Ret success(T data) {
        Ret<T> ok = new Ret<>(0, "ok", data);
        return ok;
    }
}
