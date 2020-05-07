package com.hjcrm.service.patter;

import com.hjcrm.bean.PatterType;
import com.hjcrm.dao.patter.PatterTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("patterTypeService")
public class PatterTypeService {
    @Autowired
    private PatterTypeDao patterTypeDao;

    public List<PatterType> queryPattertype() {
        return patterTypeDao.queryPattertype();
    }

    public int addPattertype(PatterType patterType) {
        if (patterType.getPatterTypeId() == 0) {
            return patterTypeDao.addPattertype(patterType);//add
        } else {
            return patterTypeDao.updatePattertype(patterType);//update
        }
    }

    public int deletepatterType(String patterTypeIds) {
        List<String> list=new ArrayList<String>();
        for (String s:patterTypeIds.split(",")
             ) {
        list.add(s);
        }
        return patterTypeDao.deletepatterType(list);
    }
}
