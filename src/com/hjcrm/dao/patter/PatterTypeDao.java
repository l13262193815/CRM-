package com.hjcrm.dao.patter;

import com.hjcrm.bean.PatterType;

import java.util.List;

public interface PatterTypeDao {
    List<PatterType> queryPattertype();

    int addPattertype(PatterType patterType);

    int updatePattertype(PatterType patterType);

    int deletepatterType(List<String> list);
}
