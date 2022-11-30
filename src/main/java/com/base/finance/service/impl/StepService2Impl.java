package com.base.finance.service.impl;

import com.base.finance.mapper.StepMapper;
import com.base.finance.model.Step;
import com.base.finance.service.Step2Service;
import com.base.finance.service.StepService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class StepService2Impl implements Step2Service {

    private final StepMapper stepMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long id) {
        return stepMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public int insert(Step record) {
        return stepMapper.insert(record);
    }

    @Override
    public Step selectByPrimaryKey(Long id) {
        return stepMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Step> selectAll() {
        return stepMapper.selectAll() ;
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public int updateByPrimaryKey(Step record) {
        int result = stepMapper.updateByPrimaryKey(record);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String trans(Step record) {
        //REQUIRED
        // outer transaction
        Step insert = new Step();
        BeanUtils.copyProperties(record,insert);
        insert.setId(18L);
        int result = stepMapper.insert(insert);
        log.info("插入结果：{}",result);
        // inner transaction throw Exception will be affect outer transaction
        updateByPrimaryKey(record);
        int i = 9/0;
        return "success";
    }
}
