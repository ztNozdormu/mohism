package cn.mohist.mohism.business.pay.mapper;

import cn.mohist.mohism.business.pay.model.TransOrder;
import cn.mohist.mohism.business.pay.model.TransOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransOrderMapper {
    int countByExample(TransOrderExample example);

    int deleteByExample(TransOrderExample example);

    int deleteByPrimaryKey(String transOrderId);

    int insert(TransOrder record);

    int insertSelective(TransOrder record);

    List<TransOrder> selectByExample(TransOrderExample example);

    TransOrder selectByPrimaryKey(String transOrderId);

    int updateByExampleSelective(@Param("record") TransOrder record, @Param("example") TransOrderExample example);

    int updateByExample(@Param("record") TransOrder record, @Param("example") TransOrderExample example);

    int updateByPrimaryKeySelective(TransOrder record);

    int updateByPrimaryKey(TransOrder record);
}