package com.tandem.message.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDto<T> implements java.io.Serializable {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T body;
    private String message;

    public ErrorDto(T body, String message) {
        this.body = body;
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
