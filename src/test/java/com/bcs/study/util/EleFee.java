package com.bcs.study.util;

/**
 * @Author bcs
 * @Date 2023/5/4 18:15
 * @Version 1.0
 * @Desc
 */
public class EleFee {

    public static Integer[] totalEle = {7504,7643,7887,8135,8362,8529,8791,8955,9196,9442,9673};
    public static Integer[] topEle = {2417,2443,2537,2638,2720,2826,2956,3053,3170,3264,3347};
    public static Double[] fee = {0D,10.68,9.76,6.23,4.88};

    public static void main(String[] args) {
        int lastTotal = totalEle[totalEle.length-2];
        int nowTotal = totalEle[totalEle.length-1];
        int lastTop = topEle[topEle.length-2];
        int nowTotp = topEle[topEle.length-1];
        double lastFee = fee[fee.length-2];
        double nowFee = fee[fee.length-1];
        int totalUse = nowTotal -lastTotal;
        int topUse = nowTotp -lastTop;
        double use = (double) topUse/totalUse;
        System.out.println((lastFee - nowFee + 100) * use);
    }
}
