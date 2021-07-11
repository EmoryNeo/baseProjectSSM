package edu.cczu.controller;

import edu.cczu.utils.CpachaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/11 21:23
 */

/* 系统类控制器 */
@Controller
@RequestMapping("/system")
public class SystemController {

    /* 测试环境 */
    @RequestMapping("/index.do")
    @ResponseBody
    public String index(){
        return "index";
    }

    /* 登录 */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    /**
     *
     * @param vcodeLen
     * @param width
     * @param height
     * @param verificationCodeType：区分验证码类型
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
        session.setAttribute(verificationCodeType, verificationCode);
        BufferedImage bufferedImage = cpachaUtil.generatorRotateVCodeImage(verificationCode, true);// 画一个旋转的图，需要干扰线
        try {
            ImageIO.write(bufferedImage, "gif", response.getOutputStream());    // 生成图片写入输出流
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
