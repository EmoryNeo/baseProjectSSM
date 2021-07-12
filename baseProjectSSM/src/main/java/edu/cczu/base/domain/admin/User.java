package edu.cczu.base.domain.admin;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/12 11:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;                                          // UUID
    private String username;                                    // 用户名
    private String password;                                    // 密码
    private String phone;                                       // 联系电话
    private String age;                                        // 年龄
    private String email;                                       // 邮箱
    private String gender;                                      // 性别[0：女   1：男]
    private String photo;                                       // 头像
    private String address;                                     // 地址
}
