package com.yt;

import java.util.Random;
import java.util.Scanner;

public class hello extends Object{
    public static void main(String[] args) {
//        int[] arr={1,2,3,4};
//        Random random =new Random();
//        int i = random.nextInt(100);
//        System.out.print(i);

//        Scanner sc = new Scanner(System.in);
//        int i = sc.nextInt();
//        System.out.println(i);
//        String s ="123";

        Animal animal =new Animal();
        if (animal instanceof dog){
            System.out.printf("是的");
        }
        else {
            System.out.printf("否");
        }
    }


}
