package vip.epss.service;


import vip.epss.domain.Root;

public interface RootService {
    //注册(限管理员)
    public boolean RegNewRoot(Root root);
    //管理员登录(限管理员)
    public Root LoginCheck(Root root);
    //更改密码(限管理员)
    public boolean UpdatePassword(Integer id, String new_password);
}
