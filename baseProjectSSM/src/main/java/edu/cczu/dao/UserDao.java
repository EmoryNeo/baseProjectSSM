package edu.cczu.dao;

import edu.cczu.domain.User;

import java.util.List;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/11 21:29
 */
public interface UserDao {

    List<User> selectAllInfo();

}
