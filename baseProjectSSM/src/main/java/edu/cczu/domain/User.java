package edu.cczu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/11 21:29
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
}
