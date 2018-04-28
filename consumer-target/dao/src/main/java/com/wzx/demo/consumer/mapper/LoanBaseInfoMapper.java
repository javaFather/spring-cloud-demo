package com.wzx.demo.consumer.mapper;


import com.wzx.demo.LoanBaseInfo;

import java.util.Map;

/**
 * @author wangzx
 * @date 2018/4/20 10:52:16
 */
public interface LoanBaseInfoMapper {
    /** 获取单个对象**/
    LoanBaseInfo find(Map<String,Object> map);
}
