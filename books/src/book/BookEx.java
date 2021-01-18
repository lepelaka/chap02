package book;

public class BookEx {
	public static void main(String[] args) {

		BookService ss = new BookService();
		
		boolean run = true;
		while(run) {
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("1.조회 2. 추가 3. 수정 4. 삭제 5. 단일조회 6. 종료");
			System.out.println("--------------------------------------------------");
			int input = ss.nextInt();
			switch (input) {
			case 1:
				ss.list(); // 목록
				break;
			case 2:
				ss.add();
				break;
			case 3:
				ss.modify();
				break;
			case 4:
				ss.remove();
				break;
			case 5:
				System.out.println("준비중입니다");
				break;
			case 6:
				return; // 메서드 종료(main method)

			}
		}
	}
}
