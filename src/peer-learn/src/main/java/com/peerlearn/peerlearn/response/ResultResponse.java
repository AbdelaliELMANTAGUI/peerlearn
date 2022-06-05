package com.peerlearn.peerlearn.response;

import lombok.Data;

@Data
public class ResultResponse<T> {
    private final T result;

    public ResultResponse(T result) {
        this.result = result;
    }
}
