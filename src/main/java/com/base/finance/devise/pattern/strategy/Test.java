package com.base.finance.devise.pattern.strategy;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入：");
            int channel = scanner.nextInt();
            Context context = new Context(channel);
            double settle = context.settle(300D);
            System.out.println(settle);
        }
    }
}
