package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/logins")
@Api(tags = "登录")
public class LoginController {

    @PostMapping(value = "/login")
    @ApiOperation(value = "登录",notes = "登录校验",tags = "Login",httpMethod = "POST")//方法的swagger注释
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id" ,value = "文章Id",required = true,dataType = "String"),
//            @ApiImplicitParam(name = "name" ,value = "文章名称",required = true,dataType = "String"),
//    })//这个注解是针对请求参数是@RequestParam方式的时候，可以给每个参数添加swagger文档上的注释
    @ApiResponses({//方法返回值的swagger注释
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 400,message = "用户输入错误"),
            @ApiResponse(code = 500,message = "系统内部错误")
    })
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            return "密码不正确";
        } catch (LockedAccountException lae) {
            return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            return "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {
            return "登录成功";
        } else {
            token.clear();
            return "登录失败";
        }
    }
}
