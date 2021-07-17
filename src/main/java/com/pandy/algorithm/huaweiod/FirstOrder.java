package com.pandy.algorithm.huaweiod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FirstOrder {
    private static Integer n = 3;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> topDates = new ArrayList<>();
        int i = 0;
        while (in.hasNextLine()){
            String orderDate = in.nextLine();
            if(validateDate(orderDate)){
                topDates.add(orderDate);
            }
            i++;
            if(i>=n)break;
        }
        Integer topUserNum =  doGetTopUserNum(topDates);
        System.out.println(topUserNum);
        in.close();
    }

    /**
     * ��ȡ�浥����
     * @param topDates
     * @return
     */
    public static Integer doGetTopUserNum(List<String> topDates){
        Integer topUser = 0;
        Map<String,String> map = new HashMap<>();
        if(topDates !=null && topDates.size()!=0){

            for (String topDate: topDates) {
                String[] dateAndSec = topDate.split("\\.");
                String pre = dateAndSec[0];
                String suf = dateAndSec[1];
                putMinValueToMap(pre,suf,map);
            }

            // map�д�ŵ��Ѿ����ⵥ���� Ϊ�˽����ɱʱ����ȫ��ͬ������ ��Ҫ�������е����� �ҳ����ⵥ����ֵ�
            for (Map.Entry<String,String> entry: map.entrySet()){
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(entry.getKey()).append(".").append(entry.getValue());

                for (int i = 0; i < topDates.size(); i++) {
                    if(stringBuffer.toString().equals(topDates.get(i))){
                        topUser++;
                    }
                }
            }

        }
        return map.size();
    }

    /**
     * У��ʱ��Ϸ���
     * @param date
     * @return
     */
    public static boolean validateDate(String date){
        Boolean validate = true ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            simpleDateFormat.parse(date);
        } catch (ParseException e) {
            validate = false;
        }
        return validate;

    }

    /**
     * ��map��ȡ��С����
     * @param datePreFix
     * @param dateSuffix
     * @param map
     */
    public static void putMinValueToMap(String datePreFix, String dateSuffix, Map<String,String> map){
        // ��������ȡ����Ӧ��ʱ��
        Integer value = map.get(datePreFix) == null ? null : Integer.valueOf(map.get(datePreFix));
        // û�����ڵ�ʱ�� �����Ӧ�����ں�ʱ��
        if(value==null){
            map.put(datePreFix,dateSuffix);
        // ��������Ѵ���  ����ȡ�������ں͵�ǰ����ıȽ�  ���ڵĴ��� �������Ӧ����ΪС��ʱ��
        }else if(value > Integer.parseInt(dateSuffix)){
            map.put(datePreFix,dateSuffix);
        }
    }
}
