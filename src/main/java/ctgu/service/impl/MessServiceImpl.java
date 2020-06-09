package ctgu.service.impl;

import ctgu.dao.IMessageDao;
import ctgu.entity.Message;
import ctgu.service.IMessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("messService")
@Transactional
public class MessServiceImpl implements IMessService {

    @Autowired
    private IMessageDao messageDao;

    @Override
    public List<Message> findAll() throws Exception {
        return messageDao.findAll();
    }

    @Override
    public void addMess(Message message) throws Exception {
        messageDao.addMsee(message);
    }

}
