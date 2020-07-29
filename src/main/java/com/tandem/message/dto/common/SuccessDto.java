package com.tandem.message.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessDto<T> implements java.io.Serializable {
    private T body;
    private int length = 1;
    private String message = null;


    public SuccessDto(T body, int length, String message) {
        this.body = body;
        this.length = length;
        this.message = message;
        if (length == 0) {
            if (this.body instanceof List) {
                this.length = ((List) this.body).size();
            }

            if (this.body instanceof Map) {
                this.length = ((Map) this.body).size();
            }
        }

    }

    public SuccessDto(T body, String message) {
        this.body = body;
        this.message = message;

        if (this.body instanceof List) {
            this.length = ((List) this.body).size();
        }

        if (this.body instanceof Map) {
            this.length = ((Map) this.body).size();
        }
    }

    public SuccessDto(T body, Integer length) {
        this.body = body;
        this.length = length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public SuccessDto(T body) {
        this.body = body;
        if (this.body instanceof List) {
            this.length = ((List) this.body).size();
        }

        if (this.body instanceof Map) {
            this.length = ((Map) this.body).size();
        }
    }

    public T getBody() {

        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
