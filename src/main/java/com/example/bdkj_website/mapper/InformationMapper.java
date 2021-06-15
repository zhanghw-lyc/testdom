package com.example.bdkj_website.mapper;

import com.example.bdkj_website.entity.Information;
import com.example.bdkj_website.entity.InformationExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface InformationMapper {
    long countByExample(InformationExample example);

    int deleteByExample(InformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Information record);

    int insertSelective(Information record);

    List<Information> selectByExample(InformationExample example);

    Information selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByExample(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}