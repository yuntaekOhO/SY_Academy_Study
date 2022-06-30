package kr.s06.product;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ProductMain {
	ArrayList<Product> list;
	BufferedReader br;
	
	public ProductMain() {
		list = new ArrayList<Product>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		} catch(IOException e) {
			
		} catch(Exception e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {br.close();} catch(IOException e) {}
			}
		}
	}
	
	//menu
	public void callMenu() throws IOException{
		//1.상품등록,2.상품목록보기,3.종료
		while(true) {
			System.out.println("1.상품등록,2.상품목록보기,3.종료");
			System.out.print("메뉴선택:");
			try {
				int num = Integer.parseInt(br.readLine());
				if(num==1) {
					input();
				} else if(num==2) {
					output();
				} else if(num==3) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("잘못 입력했습니다.");
				}
			} catch(NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
			}
		}
	}
	
	//상품등록
	public void input()throws IOException{
		Product product = new Product();
		System.out.print("상품명:");
		product.setName(br.readLine());
		System.out.print("상품가격:");
		product.setPrice(Integer.parseInt(br.readLine()));
		System.out.print("상품식별번호:");
		product.setNum(br.readLine());
		System.out.print("제조사:");
		product.setMaker(br.readLine());
		System.out.print("상품재고:");
		product.setStock(Integer.parseInt(br.readLine()));
		
		list.add(product);
	}
	
	//상품목록보기
	public void output() {
		System.out.println("상품리스트 : 총상품수(" + list.size() + ")");
		System.out.println("---------------------------------------------");
		System.out.println("상품명\t가격\t식별번호\t제조사\t상품재고");
		System.out.println("---------------------------------------------");
		for(Product p : list) {
			System.out.print(p.getName() + "\t");
			System.out.printf("%,d\t", p.getPrice());
			System.out.print(p.getNum() + "\t");
			System.out.print(p.getMaker() + "\t");
			System.out.println(p.getStock());
			
		}
	}
	
	public static void main(String[] args) {
		new ProductMain();
	}

}
