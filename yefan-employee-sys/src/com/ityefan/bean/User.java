package com.ityefan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //包含用户名，密码，登录名
    private String username;
    private String password;
    private String loginName;
}
