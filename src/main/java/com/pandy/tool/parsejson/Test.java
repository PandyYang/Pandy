package com.pandy.tool.parsejson;

import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class Test {

    public static void main(String[] args) {

        try {

            // 读取
            BufferedReader in = new BufferedReader(new FileReader("/Users/pandy/IdeaProjects/mytest/src/C2.json"));
            String str;


            // 写入
            BufferedWriter ipout = new BufferedWriter(new FileWriter("/Users/pandy/IdeaProjects/Pandy/src/main/java/com/pandy/test/testone/ip.txt", true));
            BufferedWriter domainout = new BufferedWriter(new FileWriter("/Users/pandy/IdeaProjects/Pandy/src/main/java/com/pandy/test/testone/domain.txt", true));
            BufferedWriter urlout = new BufferedWriter(new FileWriter("/Users/pandy/IdeaProjects/Pandy/src/main/java/com/pandy/test/testone/url.txt", true));


            while ((str = in.readLine()) != null) {

                Model model = new Model();
                Model modelObj = JSONObject.parseObject(str, model.getClass());
                System.out.println(modelObj.toString());

                String ipOrDomain = modelObj.getC2Server().split(",")[0];

                // 区分C2Server的 ip和域名
                if (Character.isDigit(ipOrDomain.charAt(0))) {
                    ipout.write(ipOrDomain + "\n");
                } else {
                    domainout.write(ipOrDomain + "\n");
                }

                // url全部写入url文件
                String url = modelObj.getURL();
                urlout.write(url + "\n");

                // 区分url的ip和域名
                String url_ip_or_url = url.split(":")[1].split("//")[1];
                if (Character.isDigit(url_ip_or_url.charAt(0))) {
                    ipout.write(url_ip_or_url + "\n");
                } else {
                    // 如果是domain
                    domainout.write(url_ip_or_url + "\n");
                }
            }
                ipout.close();
                domainout.close();
                urlout.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
