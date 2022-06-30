package kr.s06.score;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ScoreMain {
	BufferedReader br;
	ArrayList<Score> mlist;

	public ScoreMain() {
		mlist = new ArrayList<Score>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null)try {br.close();} catch (IOException e) {}
		}
	}

	public void callMenu() throws IOException {
		while (true) {
			System.out.println("1.성적입력,2.성적출력,3.성적저장,4.파일읽기,5.종료");
			System.out.print("메뉴선택:");
			try {
				int num = Integer.parseInt(br.readLine());
				if (num == 1) {// 성적입력
					inputScore();
				} else if (num == 2) {// 성적출력
					printScore();
				} else if (num == 3) {// 성적저장
					writeFile();
				} else if (num == 4) {// 파일읽기
					readFile();
				} else if (num == 5) {// 종료
					System.out.println("성적관리를 종료합니다.");
					break;
				} else {
					System.out.println("잘못 입력했습니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요!!");
			}
		}
	}

	// 성적 입력
	public void inputScore() throws IOException {
		// Score 객체 생성
		Score s = new Score();
		// 이름 입력
		System.out.print("이름:");
		s.setName(br.readLine());
		// 국어 입력
		s.setKorean(parseInputData("국어:"));
		// 영어 입력
		s.setEnglish(parseInputData("영어:"));
		// 수학 입력
		s.setMath(parseInputData("수학:"));
		// ArrayList에 Score 객체 저장
		mlist.add(s);
	}

	// 성적 입력 조건 체크
	public int parseInputData(String course) throws IOException {
		while (true) {
			System.out.print(course);
			try {
				int num = Integer.parseInt(br.readLine());
				// 성적 유효 범위(0~100) 체크
				if (num < 0 || num > 100) {
					throw new ScoreValueException("0~100사이의 값만 인정");
				}
				return num;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요!");
			} catch (ScoreValueException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// 성적 출력
	public void printScore() {
		// 이름,국어,영어,수학,총점,평균,등급 출력
		System.out.println("--------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
		System.out.println("--------------------------------");
		for (Score s : mlist) {
			/*System.out.print(s.getName() + "\t");
			System.out.print(s.getKorean() + "\t");
			System.out.print(s.getEnglish() + "\t");
			System.out.print(s.getMath() + "\t");
			System.out.print(s.makeSum() + "\t");
			System.out.printf("%.2f\t", s.makeAvg());
			System.out.println(s.makeGrade());*/
			System.out.print(s.toString());
		}
	}

	public void writeFile() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("score.txt");
			fw.write("--------------------------------\n");
			fw.write("이름\t국어\t영어\t수학\t총점\t평균\t등급\n");
			fw.write("--------------------------------\n");
			for (Score s : mlist) {
				fw.write(s.toString());
			}
			fw.flush();
			System.out.println("파일을 성공적으로 저장하였습니다.");
		} catch (IOException e) {
			System.out.println("파일 저장에 실패했습니다.");
			e.printStackTrace();
		} finally {
			if (fw != null)try {fw.close();} catch (IOException e) {}
		}
	}

	public void readFile() {
		FileReader fr = null;
		int msg;
		try {
			fr = new FileReader("score.txt");
			while ((msg = fr.read()) != -1) {
				System.out.print((char) msg);
			}
			System.out.println("파일을 성공적으로 읽어왔습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 읽기 실패");
			e.printStackTrace();
		} finally {
			if (fr != null)try {fr.close();} catch (IOException e) {}
		}
	}

	public static void main(String[] args) {
		/*
		 * [실습] 메뉴 : 성적입력,성적출력,성적저장(score.txt),파일읽기,종료
		 */
		new ScoreMain();
	}
}
