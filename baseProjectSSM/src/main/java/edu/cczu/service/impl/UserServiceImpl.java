package edu.cczu.service.impl;

import edu.cczu.dao.UserDao;
import edu.cczu.domain.User;
import edu.cczu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/11 21:34
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> queryAllInfo() {
        return userDao.selectAllInfo();
    }
}
