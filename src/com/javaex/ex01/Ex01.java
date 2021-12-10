package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) throws IOException {
		// 미니 프로젝트
		Scanner sc = new Scanner(System.in);
		
		Reader fr = new FileReader("/Users/hs/JavaStudy/file/minipro/PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		int i=0;
		System.out.println("********************************");
		System.out.println("*       전화번호 관리 프로그램       *");
		System.out.println("********************************");
		while(i==0) {
			System.out.println("");
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("--------------------------------");
			System.out.print(">메뉴번호:");
			int put = sc.nextInt();
			switch (put) {
			case 1 :
				System.out.println("1.리스트");
				break;
			case 2 :
				System.out.println("2.등록");
				break;
			case 3 :
				System.out.println("3.삭제");
				break;
			case 4 :
				System.out.println("4.검색");
				break;
			case 5 :
				System.out.println("5.종료");
				i++;
				break;
			default :
				System.out.println("잘못 입력했습니다.");
				break;
			}
		}
		sc.close();
	}
}
