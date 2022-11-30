package com.base.finance.vo;

import lombok.Data;

import java.util.Date;
@Data
public class UpdateRequestVO {

    private Long id;

    private String code;


    private Long creatUser;


    private Long modifyUser;
}
