package demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import demo.entity.Commodity;

public interface CommodityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    Commodity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);
    
    List<Commodity> selectByALL();

    List<Commodity> selectByArrayId(@Param("id")String[] roles);
}