package edu.cczu.base.service.admin;

import edu.cczu.base.domain.admin.User;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/12 13:06
 */

public interface IUserService {

    User confirmLogin(User user);

    User confirmLoginUserName(String username);

    Integer registerUser(User user);
}
