package com.example.bdkj_website.mapper;

import com.example.bdkj_website.entity.Entrance;
import com.example.bdkj_website.entity.EntranceExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface EntranceMapper {
    long countByExample(EntranceExample example);

    int deleteByExample(EntranceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Entrance record);

    int insertSelective(Entrance record);

    List<Entrance> selectByExample(EntranceExample example);

    Entrance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Entrance record, @Param("example") EntranceExample example);

    int updateByExample(@Param("record") Entrance record, @Param("example") EntranceExample example);

    int updateByPrimaryKeySelective(Entrance record);

    int updateByPrimaryKey(Entrance record);
}