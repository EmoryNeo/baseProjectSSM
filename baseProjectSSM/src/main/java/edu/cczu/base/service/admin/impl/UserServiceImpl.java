package edu.cczu.base.service.admin.impl;

import edu.cczu.base.dao.admin.IUserDao;
import edu.cczu.base.domain.admin.User;
import edu.cczu.base.service.admin.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/12 13:07
 */

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User confirmLogin(User user) {
        return null;
    }

    @Override
    public User confirmLoginUserName(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public Integer registerUser(User user) {
        return userDao.insertUserInfo(user);
    }
}
