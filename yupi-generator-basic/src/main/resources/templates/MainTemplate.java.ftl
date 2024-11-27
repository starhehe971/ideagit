package com.yupi.acm;
import java.util.Scanner;

/**
* ACM输入模板(多个数之和)
* @Author ${author}
*/
public class MainTemplate{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        <#if loop>
            while(scanner.hasNext()){
        </#if>

        int n = scanner.nextInt();

        int[] arr = new int[n];
        fot(int i=0;i < n;i++){<#--i<n必须用空格隔开，否则有歧义-->
            arr[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int num: arr) {
            sum += num;
        }

        System.out.println("${outputText}"+sum);
        <#if loop>
            }
        </#if>

        scanner.close();
    }
}