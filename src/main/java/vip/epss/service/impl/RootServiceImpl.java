package vip.epss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import vip.epss.dao.RootMapper;
import vip.epss.domain.Root;
import vip.epss.domain.RootExample;
import vip.epss.domain.Student;
import vip.epss.service.RootService;

import java.util.Collection;
import java.util.List;

@Service(value="rootService")
public class RootServiceImpl implements RootService {

    @Autowired
    private RootMapper rootMapper;

    @Override
    public boolean RegNewRoot(Root root) {
        //先查询是否存在该用户
        RootExample rootExample = new RootExample();
        RootExample.Criteria criteria = rootExample.createCriteria();
        criteria.andUsernameEqualTo(root.getUsername());
        List<Root> roots = rootMapper.selectByExample(rootExample);
        if(roots.size() > 0){
            //存在同名用户
            System.out.println("存在同名用户");
            return false;
        }else{
            int i = rootMapper.insertSelective(root);
            System.out.println("成功添加了"+i+"个 管理员");
            return true;
        }
    }

    @Override
    public Root LoginCheck(Root root) {
        Root newRoot = rootMapper.selectByLogin(root);
        if(newRoot!=null && newRoot.getPassword().equals(root.getPassword())){
            return newRoot;
        }
        return null;
    }

    @Override
    public boolean UpdatePassword(Integer id, String new_password) {
        Root root = rootMapper.selectByPrimaryKey(id);
        if(root.getPassword()==new_password){
            System.out.println("与原密码相同");
            return false;
        }else{
            Root new_root = new Root();
            new_root = root;
            new_root.setPassword(new_password);
            rootMapper.updateByPrimaryKey(new_root);
            System.out.println("更改密码成功");
            return true;
        }
    }

}
