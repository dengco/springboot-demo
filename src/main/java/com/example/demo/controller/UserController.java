package com.example.demo.controller;

import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {

   // @RequiresPermissions("api:user:show")
   @ResponseBody
   @GetMapping("/show")
    public String  showUser() {
        return "这是学生信息";
    }

}
