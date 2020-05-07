package com.hjcrm.service.system;

import com.hjcrm.constants.util.PageBean;
import com.hjcrm.dao.system.SystemMessageDao;
import com.hjcrm.bean.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("systemMessageService")
public class SystemMessageService {
    @Autowired
    private SystemMessageDao systemMessageDao;

    public List<SystemMessage> querySystemmessages(PageBean util) {
        return systemMessageDao.querySystemmessages(util);
    }

    public int querySystemMessageCount() {
        return systemMessageDao.querySystemMessageCount();
    }

    public int saveOrUpdateMessage(SystemMessage systemMessage) {
        if (systemMessage.getSystemmessageId() == 0) {//add
            return systemMessageDao.saveOrUpdateMessage(systemMessage);//添加
        } else {
            return systemMessageDao.saveOrUpdateMessages(systemMessage);//修改
        }
    }


    public int sendMessage(SystemMessage systemMessage) {
        return systemMessageDao.sendMessage(systemMessage);
    }

    public int sendMessage2(SystemMessage systemMessage) {
            return systemMessageDao.sendMessage2(systemMessage);
    }
}
