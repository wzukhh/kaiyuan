package com.ky.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ky.common.result.Result;
import com.ky.core.service.KyUserService;
import com.ky.dao.entity.KyUserDO;
import com.ky.dao.mapper.KyUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author weish
 * @description 针对表【ky_user】的数据库操作Service实现
 * @createDate 2023-04-20 16:30:01
 */
@Slf4j
@Service
public class KyUserServiceImpl extends ServiceImpl<KyUserMapper, KyUserDO>
        implements KyUserService {

    @Autowired
    private KyUserMapper kyUserMapper;

    @Transactional
    @Override
    public Result<String> insertBatch() {
        String[] usernames = {"老二", "张三", "李四", "王五", "赵六", "田七", "苟八", "朝九"};   //7
        String[] phones = {"13888883838", "13777773737", "13666663636", "13555553535", "13444443434", "13222223232", "13111113131"};  //7
        String[] qqs = {"123456789", "58723864528", "524352435", "3475912345", "8975937983475", "123784687534", "182375786534", "67842329834"};  //7
        String[] emails = {"13888883838", "13777773737", "13666663636", "13555553535", "13444443434", "13222223232", "13111113131"};  //7
        String[] addresses = {"北京市朝阳区", "河南省焦作市", "杭州市西湖区", "苏州市吴江区", "上海市浦东区", "深圳市宝安区", "武汉市武昌区"};  //7
        List<List<KyUserDO>> list = new ArrayList<>();
        Random random = new Random();
        Date date = new Date();
        //准备数据，十个集合，每个集合里边准备1W条数据
//        for (int i = 0; i < 100; i++) {
//            List<KyUser> iList = new ArrayList<>();
//            for (int j = 0; j < 10000; j++) {
//                int contactType = random.nextInt(3);    // 0手机号，1QQ，2邮箱
//                KyUser kyUser = new KyUser();
//                kyUser.setUserName(usernames[random.nextInt(7)]);
//                switch (contactType) {
//                    case 0:
//                        kyUser.setContact(phones[random.nextInt(7)]);
//                        kyUser.setContactType(0);
//                        break;
//                    case 1:
//                        kyUser.setContact(qqs[random.nextInt(7)]);
//                        kyUser.setContactType(1);
//                        break;
//                    case 2:
//                        kyUser.setContact(emails[random.nextInt(7)]);
//                        kyUser.setContactType(2);
//                        break;
//                }
//                kyUser.setAddress(addresses[random.nextInt(7)]);
//                kyUser.setCreateTime(date);
//                kyUser.setUpdateTime(date);
//                kyUser.setValid(0);
//                iList.add(kyUser);
//            }
//            list.add(iList);
//        }

        for (int i = 0; i < 100; i++) {
            int contactType = random.nextInt(3);    // 0手机号，1QQ，2邮箱
            KyUserDO kyUserDO = new KyUserDO();
            kyUserDO.setUserName(usernames[random.nextInt(7)]);
            switch (contactType) {
                case 0:
                    kyUserDO.setContact(phones[random.nextInt(7)]);
                    kyUserDO.setContactType(0);
                    break;
                case 1:
                    kyUserDO.setContact(qqs[random.nextInt(7)]);
                    kyUserDO.setContactType(1);
                    break;
                case 2:
                    kyUserDO.setContact(emails[random.nextInt(7)]);
                    kyUserDO.setContactType(2);
                    break;
            }
            kyUserDO.setAddress(addresses[random.nextInt(7)]);
            kyUserDO.setCreateTime(date);
            kyUserDO.setUpdateTime(date);
            kyUserDO.setValid(0);
            kyUserMapper.insert(kyUserDO);
        }

//        long start = System.currentTimeMillis();
        // 使用 Mybatis forEach 把十个集合里边的数据插入数据库
//        for (int i = 0; i < list.size(); i++) {
//            int batch = kyUserMapper.insertBatch(list.get(i));
//            log.info("第{}次插入{}条数据", i + 1, batch);
//        }
        // 使用PrepareStatement把十个集合里边的数据插入数据库
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://127.0.0.1:3306/kaiyuan?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
//            String user = "root";
//            String pwd = "root";
//            Connection connection = DriverManager.getConnection(url, user, pwd);
////            connection.setAutoCommit(false);
//            String sql = "insert into ky_user (user_name,contact,contact_type,address,create_time,update_time,valid) values(?,?,?,?,?,?,?)";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            for (int i = 0; i < list.size(); i++) {
//                List<KyUser> kyUserList = list.get(i);
//                for (int j = 0; j < kyUserList.size(); j++) {
//                    KyUser kyUser = kyUserList.get(j);
//                    ps.setString(1, kyUser.getUserName());
//                    ps.setString(2, kyUser.getContact());
//                    ps.setInt(3, kyUser.getContactType());
//                    ps.setString(4, kyUser.getAddress());
//                    ps.setDate(5, new java.sql.Date(kyUser.getCreateTime().getTime()));
//                    ps.setDate(6, new java.sql.Date(kyUser.getUpdateTime().getTime()));
//                    ps.setInt(7, kyUser.getValid());
//                    ps.addBatch();
//                }
//                ps.executeBatch();
//                ps.clearBatch();
//                log.info("第{}次插入{}条数据", i + 1, 10000);
//            }
////            connection.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        long end = System.currentTimeMillis();
//        log.info("批量插入100W条数据，每次插入1W条，总用时为：{}毫秒", end - start);
//        return Result.ok(0, (end - start) + "毫秒");
        return Result.ok();
    }
}




