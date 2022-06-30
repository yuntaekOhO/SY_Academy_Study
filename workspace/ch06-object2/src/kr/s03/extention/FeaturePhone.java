package kr.s03.extention;

//자식 클래스
public class FeaturePhone extends Phone{
	private int pixel;//사진 화소
	
	//생성자
	public FeaturePhone(String number, String model, String color, int pixel) {
		this.number = number;
		this.model = model;
		this.color = color;
		this.pixel = pixel;
	}

	public int getPixel() {
		return pixel;
	}
	
}
