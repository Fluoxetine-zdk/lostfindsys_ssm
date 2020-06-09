package ctgu.service;

import ctgu.entity.Message;

import java.util.List;

public interface IMessService {
    List<Message> findAll() throws Exception;

    void addMess(Message message) throws Exception;

    Message findByMessId(int id) throws Exception;

    void updateMess(Message message);
}
