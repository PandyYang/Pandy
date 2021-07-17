package com.pandy.algorithm.huaweiod;
public class StringZip {

    public static void main(String[] args) {
        String str1 = "b10c13abc3";
        System.out.println(decompressChar(str1));
    }

    private static String decompressChar(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        int count = 0;
        StringBuilder temp = new StringBuilder();
        String aaa[]=new String[str.length()/2];
        int num[]=new int[str.length()/2];
        int k=0;
        for(int i = 0, n = chars.length; i < n; i++) {
            if((chars[i] + "").matches("[a-z]")){
                temp.append(chars[i]);
                continue;
                //
            }
            else{aaa[k]=temp.toString();}

            if((chars[i] + "").matches("[0-9]")) {
                count = count * 10 + Integer.parseInt(chars[i] + "");
                if(i!=chars.length-1&&(chars[i+1] + "").matches("[0-9]"))
                    continue;
                else{num[k]=count;}

            }

            k=k+1;
            count=0;
            temp=new StringBuilder();


        }
        for(int i=0;i<num.length-1;i++){
            for(int j=0;j<num.length-1-i;j++){
                if(num[j]>num[j+1]){
                    int temp1=num[j];
                    num[j]=num[j+1];
                    num[j+1]=temp1;
                    String tempstr=aaa[j];
                    aaa[j]=aaa[j+1];
                    aaa[j+1]=tempstr;
                }
            }
        }

        for(int j = 0; j < aaa.length; j++) {
            for(int i=0;i<num[j];i++)
                sb.append(aaa[j]);
        }
        return sb.toString();

    }
}

