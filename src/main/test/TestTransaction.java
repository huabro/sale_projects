
import com.tianyu.pojo.User;
import com.tianyu.service.UserService;
import com.tianyu.util.ExcelHelp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sh.mao on 2019/1/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTransaction {
    @Resource
    UserService userService;

    @Test
    public void testInsert() {
        Integer userID = 8;
        String loginName = "a";
        String passward = "a";
        try {
            userService.update(userID, loginName, null, "0");
//            userService.propa(userID,loginName,null,"0");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    @Test
    public void testExport() {
//        List<Map<String, Object>> userList=new ArrayList();
//        Map<String, Object> initMap = new HashMap<String, Object>();
//        initMap.put("sheetName", "sheet1");
//        userList.add(initMap);
//        String columnNames[] = {"序号", "关卡", "UID", "手机号", "邮箱", "身份", "公司ID", "类型", "提交时间", "开通时间", "来源", "完成时间"};//列名
//        String keys[] = {"num", "stage", "uid", "mobile", "email", "role", "corpID", "openType", "applyTime", "resultTime", "sourceFrom", "finishTime"};//map中的key
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        try {
//            ExcelHelp.createWorkBook(userList, keys, columnNames).write(os);
//            ExcelHelp.excleExport(request, response, os, "参加记录");
//        } catch (IOException e) {
//        }
    }
}
