package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MiniprojectApp {

	public static void main(String[] args) throws IOException {
		// 미니 프로젝트
		Scanner sc = new Scanner(System.in);
		
		// 읽어주는 빨대
		Reader fr = new FileReader("/Users/hs/JavaStudy/file/minipro/PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		int i=0;
		
		//1. 메모장에 있는거 배열에다가 넣기
		List<Person> pList = new ArrayList<Person>();
		while(true) {
			String str = br.readLine();
			if(str==null) {
			break;
			}
			String[] sArray = str.split(",");
			Person p = new Person(sArray[0], sArray[1], sArray[2]);
			pList.add(p);
		}
		br.close();
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
				System.out.println("<1.리스트>");
				for(int r=0; r<pList.size(); r++) {
					int s = r+1;
					System.out.println(s+".\t"+pList.get(r).getName()+"\t"+pList.get(r).getHp()+"\t"+pList.get(r).getCompany());
				}
				break;
			case 2 :
				System.out.println("<2.등록>");
				sc.nextLine();//개행문자 제거
				System.out.print(">이름:");
				String putname = sc.nextLine();
				System.out.print(">휴대전화:");
				String puthp = sc.nextLine();
				System.out.print(">회사전화:");
				String putcompany = sc.nextLine();
				
				Person p2 = new Person(putname, puthp, putcompany);
				pList.add(p2);
				
				Writer fw = new FileWriter("/Users/hs/JavaStudy/file/minipro/PhoneDB.txt");
				BufferedWriter bfw = new BufferedWriter(fw);

				//배열에 있는 목록 출력
				for(int r=0; r<pList.size(); r++) {
					int s = r+1;
					System.out.println(s+".\t"+pList.get(r).getName()+"\t"+pList.get(r).getHp()+"\t"+pList.get(r).getCompany());
				}
				
				//메모장으로 출력
				for(Person ps:pList) {
					String a = ps.getName()+","+ps.getHp()+","+ps.getCompany();
					bfw.write(a);
					bfw.newLine();
				}
				break;
			case 3 :
				System.out.println("<3.삭제>");
				System.out.print(">번호:");
				int	numput = sc.nextInt();
				pList.remove(--numput);
				System.out.println("[삭제되었습니다.]");
				break;
			case 4 :
				System.out.println("<4.검색>");
				sc.nextLine();//개행문자 제거
				System.out.print(">이름:");
				//String putfindname = sc.nextLine();
				//int findindex = Arrays.asList(pList).indexOf(putfindname);
				//System.out.println(pList.get(findindex).getName()+","+pList.get(findindex).getHp()+","+pList.get(findindex).getCompany());
				break;
			case 5 :
				System.out.println("********************************");
				System.out.println("*           감사합니다           *");
				System.out.println("********************************");
				i++;
				break;
			default :
				System.out.println("[다시 입력해 주세요.]");
				break;
			}
		}
		sc.close();
	}
}
