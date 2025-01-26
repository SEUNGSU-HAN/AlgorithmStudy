package com.boj.problem.bronze;
import java.util.Scanner;

public class Main_2438 {
	static int n;

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for(int i=0; i < n; i++){
            for(int j=0; j < i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

	}

}
