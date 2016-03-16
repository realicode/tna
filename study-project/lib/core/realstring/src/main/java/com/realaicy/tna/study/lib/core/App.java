package com.realaicy.tna.study.lib.core;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String temp = "0.10.242变更都应当评估其对产品质量的潜在影响；" +
                "企业可以根据变更的性质、范围、对产品质量潜在影响的程度将变更分类（如主要、次要变更）；" +
                "判断变更所需的验证、额外的检验以及稳定性考察应当有科学依据；\n";
        String res = StringUtils.strip(temp, "0123456789.");
        System.out.println(res);

        String temp2 = "0.10.242变更都应当评估其对产品质量的潜在影响；" +
                "企业可以根据变更的性质、范围、对产品质量潜在影响的程度将变更分类（如主要、次要变更）；" +
                "判断变更所需的验证、额外的检验以及稳定性考察应当有科学依据；\n";
        String res2 = StringUtils.strip(temp2, ".");
        System.out.println(res2);



        String s = "send an e-mail  发送电子邮件";
        s = temp;
        int  realindex = 0;

//     System.out.print('\u4e00');
//    System.out.print('\u9fa5');

// 把 这unicode编码 两个边界汉字（最大和最小）转换成 十进制
//   int i= Integer.parseInt("4e00",16);
//   int j= Integer.parseInt("9fa5",16);
//   获取它们之间的差值
//   System.out.println(i-j);
//
// 试验字符串的 compereTo方法 比较 这两个汉字
//   System.out.println("一".compareTo("\u9fa5"));


        for (int index = 0; index < s.length() - 1; index++) {

// 将每一个角标的字符(字母 汉字 空格等)一次转换成字符串
            String w = s.substring(index, index + 1);
//
// System.out.println(w.compareTo("\u4e00"));
// System.out.println(w.compareTo("\u9fa5"));
//  而java采用unicode编码，汉字的范围是 "\u4e00"（一）到"\u9fa5"（龥）
            if (w.compareTo("\u4e00") > 0 && w.compareTo("\u9fa5") < 0) {
                System.out.println("第一个中文的索引位置:" + index);
                realindex = index;
// 获取第一个汉字索引位置 跳出循环
                break;
            }
        }

        System.out.println(temp.substring(realindex));
        System.out.println(temp.substring(0,8));
        System.out.println( StringUtils.strip("acb", "c"));


    }//end of main
}
