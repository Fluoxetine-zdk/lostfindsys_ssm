package ctgu.service;

import ctgu.entity.Message;

import java.util.List;

public interface IMessService {
    public List<Message> findAll() throws Exception;

    public void addMess(Message message) throws Exception;
}
