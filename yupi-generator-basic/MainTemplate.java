package com.yupi.acm;
import java.util.Scanner;

/**
* ACM输入模板(多个数之和)
* @Author yupi
*/
public class MainTemplate{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];
        fot(int i=0;i < n;i++){
            arr[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int num: arr) {
            sum += num;
        }

        System.out.println("求和结果："+sum);

        scanner.close();
    }
}