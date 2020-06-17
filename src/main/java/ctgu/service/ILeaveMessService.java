package ctgu.service;

import ctgu.entity.LeaveMessage;

import java.util.List;

public interface ILeaveMessService {
    List<LeaveMessage> findAllLeaveMess(int id);

    List<LeaveMessage> findAllLeaveMess(int id, int page, int size);

    void deleteLeaveMess(int id);
}
