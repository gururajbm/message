package com.tandem.message.config.response;

import com.tandem.message.dto.common.SuccessDto;

public class SuccessResponse<T> {
    private SuccessDto<T> response;

    public SuccessResponse(T object) {
        this.response = new SuccessDto<>(object);
    }

    public SuccessResponse(T object, String message) {
        this.response = new SuccessDto<>(object, message);
    }

    public SuccessResponse(T object, Integer length, String message) {
        this.response = new SuccessDto<>(object, length, message);
    }

    public SuccessResponse(T object, Integer length) {
        this.response = new SuccessDto<>(object, length);
    }

    public SuccessDto<T> getResponse() {
        return response;
    }

    public void setResponse(SuccessDto<T> response) {
        this.response = response;
    }
}
