package com.hjcrm.dao.system;
import com.hjcrm.constants.util.PageBean;
import com.hjcrm.bean.SystemMessage;

import java.util.List;
public interface SystemMessageDao {

    List<SystemMessage> querySystemmessages(PageBean util);

    int querySystemMessageCount();

    int saveOrUpdateMessage(SystemMessage systemMessage);

    int saveOrUpdateMessages(SystemMessage systemMessage);

    int sendMessage(SystemMessage systemMessage);

    int sendMessage2(SystemMessage systemMessage);
}
