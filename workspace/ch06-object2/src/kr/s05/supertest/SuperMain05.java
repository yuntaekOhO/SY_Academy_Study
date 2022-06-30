package kr.s05.supertest;

//부모 클래스
class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String getLocation() {
		return "x:" + x + ",y:" + y;
	}
}

//자식 클래스
class Point3D extends Point{
	int z;
	
	public Point3D(int x, int y, int z) {
		//부모 클래스의 인자가 있는 생성자 호출
		super(x,y);
		this.z = z;
	}
	
	@Override
	public String getLocation() {
		return "x:" + x + ",y:" + y + ",z:" + z;
	}
}

public class SuperMain05 {
	public static void main(String[] args) {
		Point3D p3 = new Point3D(1,2,3);
		System.out.println(p3.getLocation());
	}
}
