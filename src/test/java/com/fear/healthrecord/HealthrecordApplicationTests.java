package com.fear.healthrecord;

import com.fear.healthrecord.myunitls.NameGen;
import com.fear.healthrecord.service.impl.ManagementServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class HealthrecordApplicationTests {
     @Autowired
     ManagementServiceImpl service;
    @Test
    void createuser() {
        Map<String,Object> map=new HashMap<>();
        Random random=new Random();
        for(int i=0;i<10;i++) {
            String name = NameGen.createname();
            map.put("basic_name", name);
            int age = random.nextInt(70);
            map.put("basic_age", String.valueOf(age));
            int identity_id = (int) ((Math.random() * 9 + 1) * 10000000);
            map.put("identity_id", String.valueOf(identity_id));
            int basic_contact = (int) ((Math.random() * 9 + 1) * 100000);
            map.put("basic_contact", String.valueOf(basic_contact));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date now = c.getTime();
            int m = random.nextInt(12);
            int d = random.nextInt(30);
            c.add(Calendar.DATE, d);
            c.add(Calendar.MONTH, m);
            c.add(Calendar.YEAR, -age);
            String basic_birthday = sdf.format(c.getTime());
            map.put("basic_birthday", basic_birthday);
            service.insertuser(map);
        }

    }
    @Test
    void  insert(){
        Map<String,Object> map1=new HashMap<>();
        map1.put("index_id","K000007");
        map1.put("info_mperson","胡机将");
        Random random=new Random();
        for (int j=1;j<24;j++)
        {
            map1.put("basic_id",j);
            int i=0;
            while (true) {
//                 i = (int) (Math.random() * 9000) + 1000;
                i=random.nextInt(120);
                if(i>50&&i<4000)
                    break;
            }
           map1.put("info_result",i);
      System.out.println(map1);
        service.insertuserinfo(map1);}
    }
    @Test
    void testselect(){
        Map<String,Object> map1=new HashMap<>();
        map1.put("basic_id",2);
        System.out.println(map1);
        List<Map<String,Object>> map2=new ArrayList<>();
      service.deleteuser(map1);
    }
}
