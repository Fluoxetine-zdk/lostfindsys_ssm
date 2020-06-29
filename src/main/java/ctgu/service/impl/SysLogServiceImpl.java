package ctgu.service.impl;

import com.github.pagehelper.PageHelper;
import ctgu.dao.ISysLogDao;
import ctgu.entity.SysLog;
import ctgu.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return sysLogDao.findAll();
    }
}
