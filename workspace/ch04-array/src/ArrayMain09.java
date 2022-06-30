public class ArrayMain09 {

	public static void main(String[] args) {
		if(args.length>0) { //데이터가 전달됨
			for(int i=0;i<args.length;i++) {
				System.out.print(args[i] + " ");
			}
			
		}else {//전달된 데이터 없음
			System.out.print("입력한 내용이 없습니다.");
		}
	}

}
