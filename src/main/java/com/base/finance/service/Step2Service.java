package com.base.finance.service;

import com.base.finance.model.Step;

import java.util.List;

public interface Step2Service {

    int deleteByPrimaryKey(Long id);

    int insert(Step record);

    Step selectByPrimaryKey(Long id);

    List<Step> selectAll();

    int updateByPrimaryKey(Step record);

    String trans(Step record);
}
