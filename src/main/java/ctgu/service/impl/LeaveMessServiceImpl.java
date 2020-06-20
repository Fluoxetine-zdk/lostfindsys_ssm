package ctgu.service.impl;


import com.github.pagehelper.PageHelper;
import ctgu.dao.ILeaveMessDao;
import ctgu.entity.LeaveMessage;
import ctgu.service.ILeaveMessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("leaveMessService")
@Transactional
public class LeaveMessServiceImpl implements ILeaveMessService {

    @Autowired
    private ILeaveMessDao leaveMessDao;

    @Override
    public List<LeaveMessage> findAllLeaveMess(int id)  {
        return leaveMessDao.findLeaveMessByMsgid(id);
    }

    @Override
    public List<LeaveMessage> findAllLeaveMess(int id, int page, int size) {
        PageHelper.startPage(page,size);
        return leaveMessDao.findLeaveMessByMsgid(id);
    }

    @Override
    public void deleteLeaveMess(int id) {
        leaveMessDao.deleteLeaveMess(id);
    }

    @Override
    public void addLeaveMessage(LeaveMessage leaveMessage) {
        leaveMessDao.addLeaveMessage(leaveMessage);
    }


}
