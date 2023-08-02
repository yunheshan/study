package com.bcs.study.util;

/**
 * @Author bcs
 * @Date 2023/5/4 18:15
 * @Version 1.0
 * @Desc
 */
public class EleFee {

    public static Integer[] totalEle = {7504,7643,7887,8135,8362,8529};
    public static Integer[] topEle = {2417,2443,2537,2638,2720,2826};

    public static void main(String[] args) {
        int lastTotal = totalEle[totalEle.length-2];
        int nowTotal = totalEle[totalEle.length-1];
        int lastTop = topEle[topEle.length-2];
        int nowTotp = topEle[topEle.length-1];
        int totalUse = nowTotal -lastTotal;
        int topUse = nowTotp -lastTop;
        double use = (double) topUse/totalUse;
        System.out.println(108 * use);
    }
}
