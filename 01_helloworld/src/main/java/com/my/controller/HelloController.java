package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @create 2018-06-26 16:39
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public Map<Object,Object> HelloWorld(){
       /* Te t = new Te();
        t.setA("ttt");
        Te t2 = new Te();
        t2.setA("ttt3");
        ArrayList<Te> objects = new ArrayList<>();
        objects.add(t);
        objects.add(t2);
        Res res = new Res();
        res.setObj(objects);
        res.setStatus(1);*/

        HashMap<Object, Object> map1 = new HashMap<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("xxxxsqlid1xxx");
        strings.add("xxxxsqlid2xxx");
        strings.add("xxxxsqlid3xxx");
        strings.add("xxxxsqlid4xxx");
        map1.put("datasource",strings);
        map1.put("runId","xxxxxxrunidxxxx");

        return map1;
    }
    class Te{
        private String a;

        public void setA(String a) {
            this.a = a;
        }

        public String getA() {
            return a;
        }
    }
    class Res{
        private int status;
        private Object obj;

        public void setStatus(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public Object getObj() {
            return obj;
        }
    }
}
