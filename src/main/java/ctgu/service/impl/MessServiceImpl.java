package ctgu.service.impl;

import com.github.pagehelper.PageHelper;
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
    public List<Message> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return messageDao.findAll();
    }

    @Override
    public void addMess(Message message) throws Exception {
        messageDao.addMsee(message);
    }

    @Override
    public Message findByMessId(int id) throws Exception {
        return messageDao.findByMessId(id);
    }

    @Override
    public void updateMess(Message message) {
        messageDao.updateMess(message);
    }

    @Override
    public List<Message> findByClassMess(int classmess, int page, int size) {
        PageHelper.startPage(page,size);
        return messageDao.findByClassmess(classmess);
    }

    @Override
    public void deleteMess(int id) {
        messageDao.deleteMess(id);
    }

    @Override
    public List<Message> findSomeMessByClassmess(int classmess, int page, int size) {
        PageHelper.startPage(page,size);
        return messageDao.findByClassmess(classmess);
    }

    @Override
    public List<Message> searchMess(int page, int size, String keyword) {
        PageHelper.startPage(page,size);
        return messageDao.searchByDescription(keyword);
    }

    @Override
    public List<Message> findUserOwnMess(String username, int page, int size) {
        PageHelper.startPage(page,size);
        return messageDao.findUserOwnMess(username);
    }


}
