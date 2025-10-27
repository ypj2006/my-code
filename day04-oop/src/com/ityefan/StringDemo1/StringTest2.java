package com.ityefan.StringDemo1;

public class StringTest2 {
    public static void main(String[] args) {
        //我要做一个生成验证码的程序,每位可能是大写，小写和数字
        String code = getCode(4);
        System.out.println(code);
    }
        public static String getCode(int n){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        String code = "";
        for (int i = 0; i < n; i++) {
            int index = (int)(Math.random()*str.length());
            char ch = str.charAt(index);
            code  += ch;
        }
        return code;

    }
}
