package book;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class BookService {
	Book[] books = new Book[10];
	Scanner scanner = new Scanner(System.in);
	int count;
	
	{
		books[count++] = new Book(1, "사랑의기술", "문예출판사", "에리히프롬", "2021-01-19");
		books[count++] = new Book(2, "자유로부터의도피", "문예출판사", "에리히프롬", "2021-01-19");
		books[count++] = new Book(3, "긴 이름을 가진 책자에 대한 테스트", "문예출판사", "에리히프롬", "2021-01-19");
	}
	
	// 도서 추가
	void add() {
		System.out.print("도서번호 > ");
		int no = nextInt();
		System.out.print("도서명 > ");
		String name = nextLine();
		System.out.print("출판사 > ");
		String publisher = nextLine();
		System.out.print("저자 > ");
		String author = nextLine();
		System.out.print("등록일 > ");
		String regDate = nextLine();
		books[count++] = new Book(no, name, publisher, author, regDate);
	}
	// 조회
	void list() { 
		String[] listInfo =  new String[] {"도서번호", "도서명", "출판사", "저자", "등록일"};
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println(getFormat(listInfo));
		System.out.println("----------------------------------------------------------------------------------------------");
		
		for(int i = 0 ; i < count ; i++) {
			System.out.println(getBookInfo(findByIdx(i), true));
		}
	}
	// 수정
	public void modify() {
		System.out.println("modify()");
	}
	// 삭제
	void remove() {
		System.out.println("remove()");
	}
	
	
	
	
	
	// 유틸리티 메서드 (이런메서드는 일반적으로 공통 유틸리티 클래스 메서드로 별도 분리)
	// 한글 입력받기
	public String nextLine() {
		return StringUtils.trim(scanner.nextLine());
	}
	
	// 숫자 입력받기
	public int nextInt() {
		return Integer.parseInt(nextLine());
	}
	
	// 인덱스를 통한 책 객체 탐색
	private Book findByIdx(int idx) {
		return books[idx];
	}
	
	// 책 내용 toString 일반 출력
	private String getBookInfo(Book book) {
		return getBookInfo(book, false);
	}
	
	// 책 내용 toString 축약 출력
	private String getBookInfo(Book book, boolean isShort) {
		String[] strs = {book.getNo()+"", book.getName(), book.getPublisher(), book.getAuthor(), book.getRegDate()};
		if(isShort) {
			strs = subContent(strs, 3);
		}
		return getFormat(strs);
	}
	
	// 출력시 사용할 텍스트량 조절 한글 5글자, 영문 10글자
	private String getFormat(String[] strs) {
		String ret = "";
		for(String str : strs) {
			char[] words = str.toCharArray();
			int cnt = 20;
			for(char c : words) {
				if(c >= '가' && c <= '힣') {
					cnt--;
				}
			}
			ret += "%-"+cnt+"s";
		}
		return String.format(ret, (Object[])strs) ;
	}
	
	// 한글 5글자를 초과할시 말 줄임표 붙이기
	private String[] subContent(String strs[], int lastIdx) {
		for(int i = 0 ; i < strs.length ; i++) {
			if(strs[i].length() > 10 && isKorean(strs[i])) {
				strs[i] = StringUtils.substring(strs[i], 0, 9) + "..";
			}
		}
		return strs;
	}
	
	// 한글 여부 체크 (한글자라도 한글이 포함되면 한글로 인식)
	private boolean isKorean(String str) {
		boolean ret = false;
		for(char c : str.toCharArray()) {
			if(c >= '가' && c <= '힣') {
				ret = true;
			}
		}
		return ret;
	}
}
