package com.ky.web.filter;

import com.ky.dao.entity.KyUserDO;
import com.ky.dao.mapper.KyUserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *
 * <p>
 *
 * @author WSH
 * @date 2022-11-07 10:02:44
 */
@SpringBootTest
public class CommonFilterTest {

    @Autowired
    private KyUserMapper kyUserMapper;

    @Test
    public void addTest(){
        String[] usernames = {"老二","张三","李四","王五","赵六","田七","苟八"};   //7
        String[] phones = {"13888883838","13777773737","13666663636","13555553535","13444443434","13222223232","13111113131"};  //7
        String[] qqs = {"123456789","58723864528","524352435","3475912345","8975937983475","123784687534","182375786534"};  //7
        String[] emails = {"13888883838","13777773737","13666663636","13555553535","13444443434","13222223232","13111113131"};  //7
        String[] addresses = {"北京市朝阳区","河南省焦作市","杭州市西湖区","苏州市吴江区","上海市浦东区","深圳市宝安区","武汉市武昌区"};  //7
        List<List<KyUserDO>> list = new ArrayList<>();
        Random random = new Random();
        //准备数据，十个集合，每个集合里边准备1W条数据
        for (int i = 0; i < 10; i++) {
            List<KyUserDO> iList = new ArrayList<>();
            for (int j = 0; i < 10000; i++) {
                int contactType = random.nextInt(3);    // 0手机号，1QQ，2邮箱
                KyUserDO kyUserDO = new KyUserDO();
                kyUserDO.setUserName(usernames[random.nextInt(8)]);
                switch (contactType){
                    case 0:
                        kyUserDO.setContact(phones[random.nextInt(8)]);
                        kyUserDO.setContactType(0);
                        break;
                    case 1:
                        kyUserDO.setContact(qqs[random.nextInt(8)]);
                        kyUserDO.setContactType(1);
                        break;
                    case 2:
                        kyUserDO.setContact(emails[random.nextInt(8)]);
                        kyUserDO.setContactType(2);
                        break;
                }
                kyUserDO.setAddress(addresses[random.nextInt(8)]);
                kyUserDO.setCreateTime(new Date());
                kyUserDO.setUpdateTime(new Date());
                kyUserDO.setValid(0);
                iList.add(kyUserDO);
            }
            list.add(iList);
        }

        //准备把十个集合里边的数据插入数据库
        for (int i = 0; i < list.size(); i++) {
            kyUserMapper.insertBatch(list.get(i));
        }

    }

}
