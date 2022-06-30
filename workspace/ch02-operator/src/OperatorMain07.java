public class OperatorMain07 {

	public static void main(String[] args) {
		System.out.println("====논리연산자====");
		
		//변수 선언
		boolean a, b, result;
		//변수 초기화
		a = true;
		b = false;
		
		//논리곱 &&  둘 다 true면 true 그 외 false
		//선 조건이 false이면 후 조건은 실행하지 않는다
		result = a && b;
		System.out.println("a && b = " + result);
		
		//논리합 || 하나라도 true면 true
		//선 조건이 true이면 후 조건은 실행하지 않는다
		result = a || b;
		System.out.println("a || b = " + result);
		
		//부정
		result = !a;
		System.out.println("!a = " + result);
	}

}
