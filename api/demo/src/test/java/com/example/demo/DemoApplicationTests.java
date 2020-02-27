package com.example.demo;

import com.example.demo.entity.Boss;
import com.example.demo.entity.Boss1;
import com.example.demo.entity.Staff;
import com.example.demo.entity.Staff1;
import com.example.demo.repository.Boss1Repository;
import com.example.demo.repository.BossRepository;
import com.example.demo.repository.StaffRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    
    /**
     * Boss1 用于不添加任何级联
     */
    @Autowired
    Boss1Repository boss1Repository;

    @Autowired
    BossRepository bossRepository;

    @Autowired
    StaffRepository staffRepository;

    /**
     * 不添加任何级联（保存）
     */
    @Test
    public void saveTest() {
        Boss1 boss1 = new Boss1();
        boss1.setName("张老板");

        Staff1 staff1 = new Staff1();
        staff1.setName("员工一");

        Staff1 staff2 = new Staff1();
        staff2.setName("员工二");

        boss1.setStaff1sList(new ArrayList<>(Arrays.asList(staff1, staff2)));

        boss1Repository.save(boss1);
    }

    /**
     * 级联保存（PERSIST）
     */
    @Test
    public void saveCascadeTest() {
        Boss boss = new Boss();
        boss.setName("张老板");

        Staff staff1 = new Staff();
        staff1.setName("员工一");
        staff1.setBoss(boss);
        Staff staff2 = new Staff();
        staff2.setName("员工二");
        staff2.setBoss(boss);

        boss.setStaffList(new ArrayList<>(Arrays.asList(staff1, staff2)));

        bossRepository.save(boss);


    }

    /**
     * 级联合并（级联更新）MERGE
     * <p>
     * 官方文档：CascadeType.MERGE
     * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#pc-cascade-merge
     */
    @Test
    public void UpdateCascadeTest() {
        Boss boss = bossRepository.findById(1L).get();

        for (Staff staff : boss.getStaffList()) {
            staff.setName("修改后的员工");
        }
        bossRepository.save(boss);
    }

    /**
     * 级联刷新（REFRESH）
     *
     * 只有在debug的时候
     * 断点断到重新获取Boss对象，此时修改数据库里Staff表里员工数据
     * 在获取Boss对象
     * 此时，Boss对象所关联的员工数据已经更新为新修改数据
     *
     */
    @Test
    public void refreshCascadeTest() {

        Boss boss = new Boss();
        boss.setName("张老板");

        Staff staff1 = new Staff();
        staff1.setName("员工一");
        staff1.setBoss(boss);
        Staff staff2 = new Staff();
        staff2.setName("员工二");
        staff2.setBoss(boss);

        boss.setStaffList(new ArrayList<>(Arrays.asList(staff1, staff2)));

        bossRepository.save(boss);

        // 重新获取Boss对象
        Boss boss1 = bossRepository.findById(boss.getId()).get();

        System.out.println(boss1);
    }

    /**
     * 级联删除（PERSIST）
     */
    @Test
    public void deleteCascadeTest() {
        bossRepository.deleteById((long) 1);
    }
}
