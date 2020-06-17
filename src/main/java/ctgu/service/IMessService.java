package ctgu.service;

import ctgu.entity.Message;

import java.util.List;

public interface IMessService {
    List<Message> findAll(int page, int size) throws Exception;

    void addMess(Message message) throws Exception;

    Message findByMessId(int id) throws Exception;

    void updateMess(Message message);

    List<Message> findByClassMess(int classmess, int page, int size);

    void deleteMess(int id);

    List<Message> findSomeMessByClassmess(int classmess,int page,int size);

    List<Message> searchMess(int page, int size, String keyword);
}
