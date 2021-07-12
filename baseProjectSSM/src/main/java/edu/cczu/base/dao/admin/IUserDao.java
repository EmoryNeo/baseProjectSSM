package edu.cczu.base.dao.admin;

import edu.cczu.base.domain.admin.User;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/12 13:08
 */

public interface IUserDao {


    User selectUserByUsername(User user);

    User selectByUsername(String username);

    Integer insertUserInfo(User user);
}
