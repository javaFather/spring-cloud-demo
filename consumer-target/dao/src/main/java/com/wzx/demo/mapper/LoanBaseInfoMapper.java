package com.wzx.demo.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wzx.demo.LoanBaseInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangzx
 * @date 2018/4/20 10:52:16
 */
@Mapper
public interface LoanBaseInfoMapper<T extends LoanBaseInfo> extends BaseMapper<LoanBaseInfo>{

}
