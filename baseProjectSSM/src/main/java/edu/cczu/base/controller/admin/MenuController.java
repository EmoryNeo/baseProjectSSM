package edu.cczu.base.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/13 20:04
 */

/**
 * 菜单管理控制器
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @RequestMapping(value = "/show_list.do")
    public String doList(){
        System.out.println("Testing...");
        return "/WEB-INF/menu/list.jsp";
    }
}
