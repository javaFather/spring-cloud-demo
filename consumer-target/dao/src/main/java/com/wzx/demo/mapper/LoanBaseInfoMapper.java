package com.wzx.demo.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wzx.demo.LoanBaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author wangzx
 * @date 2018/4/20 10:52:16
 */
@Mapper
public interface LoanBaseInfoMapper extends BaseMapper{
    /** 获取单个对象**/
    @Select("find")
    LoanBaseInfo find(@Param("loanno") String loanNo);
}
