package com.co.kr.develog;


import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(value = NOT_FOUND, reason = "엔터티가 존재하지 않음")
public class DataNotFoundExcetpion extends RuntimeException {

    public DataNotFoundExcetpion(String message) {
        super(message);
    }

}
