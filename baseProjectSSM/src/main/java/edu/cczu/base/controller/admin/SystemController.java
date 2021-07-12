package edu.cczu.base.controller.admin;

import edu.cczu.base.domain.admin.User;
import edu.cczu.base.service.admin.IUserService;
import edu.cczu.base.utils.CpachaUtil;
import edu.cczu.base.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/11 21:23
 */

/* 系统类控制器 */
@Controller
@RequestMapping("/system")
public class SystemController {

    @Resource
    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    // 跳转到欢迎页面
    @RequestMapping(value = "/to_welcome.do")
    public String comeToWelcome(){
        return "welcome";
    }

    /* 登录 */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(User user, String verificationCode, HttpSession session){
        Map<String, String> map = new HashMap<>();
        if("".equals(user.getUsername()) || null == user.getUsername()){
            map.put("type", "500");
            map.put("msg", "用户名不可为空");
            return map;
        }
        if("".equals(user.getPassword()) || null == user.getPassword()){
            map.put("type", "500");
            map.put("msg", "用户名不可为空");
            return map;
        }
        if(StringUtils.isEmpty(verificationCode)){
            map.put("type", "500");
            map.put("msg", "验证码不可为空");
            return map;
        }
        String verCode = (String) session.getAttribute("verificationCode");
        if(!verCode.equalsIgnoreCase(verificationCode)){
            map.put("type", "500");
            map.put("msg", "验证码错误");
            return map;
        }

        // 到数据库中进行验证
        User processUsername = userService.confirmLoginUserName(user.getUsername());
        if(null == processUsername){
            map.put("type", "500");
            map.put("msg", "用户名不存在");   // 应该是在鼠标离开用户名框的时候判断
            return map;
        }
        if(!MD5Util.getMD5(user.getPassword()).equals(processUsername.getPassword())){
            map.put("type", "500");
            map.put("msg", "密码错误");
            return map;
        }

        // 执行到此处：表示可以登录成功
        map.put("type", "200");
        map.put("msg", "登录成功");
        // 登录成功之后，应该将用户信息放入session中
        session.setAttribute("user", processUsername);
        return map;
    }

    /**
     * 用于生成本系统适用的所有类型的验证码
     * @param vcodeLen 验证码长度，默认是４位
     * @param width 验证码图片的宽度
     * @param height 验证码图片的高度
     * @param verificationCodeType 区分验证码类型
     * @param session
     * @param response
     */
    @RequestMapping(value = "/get_verification_code.do", method = RequestMethod.GET)
    public void generateVerificationCode(
            @RequestParam(value = "vl", defaultValue = "4", required = false) Integer vcodeLen,
            @RequestParam(value = "width", defaultValue = "100", required = false) Integer width,
            @RequestParam(value = "height", defaultValue = "30", required = false) Integer height,
            @RequestParam(value = "type", defaultValue = "loginType", required = true) String verificationCodeType,
            HttpSession session,
            HttpServletResponse response
            ){

        CpachaUtil cpachaUtil = new CpachaUtil(vcodeLen, width, height);

        // 使用工具根据提交的参数生成验证码
        String verificationCode = cpachaUtil.generatorVCode();
        // 日志打印
        System.out.println("生成的验证码=============================>" + verificationCode);
        // 将验证码放入session域属性空间中。后期有可能会使用，例如验证码有效时间
        session.setAttribute("verificationCode", verificationCode);
        BufferedImage bufferedImage = cpachaUtil.generatorRotateVCodeImage(verificationCode, true);// 画一个旋转的图，需要干扰线
        try {
            ImageIO.write(bufferedImage, "gif", response.getOutputStream());    // 生成图片写入响应流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
