package com.base.finance.controller;



import com.alibaba.fastjson.JSON;
import com.base.finance.model.Step;
import com.base.finance.service.StepService;
import com.base.finance.vo.SearchRequestVO;
import com.base.finance.vo.UpdateRequestVO;
import com.base.finance.vo.response.BaseResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/step/")
@Slf4j
public class StepController {
    @Autowired
    private   StepService stepService;

    private boolean userLocalCache;
    @PostMapping("add")
    public int add(@RequestBody Step record){
        log.info("新增参数：{}", JSON.toJSONString(record));
        return stepService.insert(record);
    }
    @PostMapping("update")
    public int update (@RequestBody UpdateRequestVO updateRequestVO){
        log.info("修改参数：{}",JSON.toJSONString(updateRequestVO));
        Step update = new Step();
        BeanUtils.copyProperties(updateRequestVO,update);
        return  stepService.updateByPrimaryKey(update);
    }

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public BaseResponseVO<Step> get(@RequestBody SearchRequestVO searchRequestVO){
        log.info("查询参数{}",JSON.toJSONString(searchRequestVO));
        Step step = stepService.selectByPrimaryKey(searchRequestVO.getId());
        return new BaseResponseVO<>(0, "查询成功", step);

    }
    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public int delete(@RequestBody SearchRequestVO searchRequestVO){
        log.info("删除参数{}",JSON.toJSONString(searchRequestVO));
        return stepService.deleteByPrimaryKey(searchRequestVO.getId());
    }


    @RequestMapping(value = "trans",method = RequestMethod.PUT)
    public String trans(@RequestBody UpdateRequestVO updateRequestVO){
        log.info("内嵌事务参数：{}",JSON.toJSONString(updateRequestVO));
        Step update = new Step();
        BeanUtils.copyProperties(updateRequestVO,update);
        return stepService.trans(update);
    }


}
