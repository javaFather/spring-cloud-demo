package com.wzx.demo.mybatistest.mapper;

import com.wzx.demo.mybatisplus.base.SuperMapper;
import com.wzx.demo.mybatistest.entity.LoanBaseInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoanBaseMapper<T extends LoanBaseInfo> extends SuperMapper<LoanBaseInfo> {
}
