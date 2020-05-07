package com.hjcrm.dao.patter;

import com.hjcrm.bean.Patter;
import com.hjcrm.bean.PatterType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatterDao {
    /*查询场景名称*/
    List<PatterType> queryPattertype(Patter patter);

    /*查询话术内容*/
    List<Patter> queryPatter(Patter patter);

    int saveOrUpdatePatter(Patter patter);//添加

    int saveOrUpdatePatters(Patter patter);//修改

    int deletePatter(@Param("userid") String userid, @Param("patterids") String patterids);

    int updatePatterIsShare(String patterid);
}
