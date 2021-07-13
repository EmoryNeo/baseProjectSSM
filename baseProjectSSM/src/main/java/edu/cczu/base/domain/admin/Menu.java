package edu.cczu.base.domain.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/13 21:52
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private String id;                                          // id：主键字段
    private String parentId;                                    // 父类id
    private String name;                                        // 菜单名称
    private String url;                                         // 点击后的url
    private String icon;                                        // 菜单icon图标

}
