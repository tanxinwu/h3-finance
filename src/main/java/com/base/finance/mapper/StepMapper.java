package com.base.finance.mapper;

import com.base.finance.model.Step;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface StepMapper {
    int deleteByPrimaryKey(Long id);

    int insert(@Param("record") Step record);

    Step selectByPrimaryKey(Long id);

    List<Step> selectAll();

    int updateByPrimaryKey(Step record);
}