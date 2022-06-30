package kr.s03.extention;

public class PhoneMain {

	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("010-1234-5678","A1001","white","Android");
		FeaturePhone fp = new FeaturePhone("010-5678-1234","B1001","black",1000);
		
		System.out.println("==========================================");
		System.out.println("번호\t\t모델\t색상\t특징(OS/화소)");
		System.out.println("==========================================");
		System.out.print(sp.getNumber()+"\t");
		System.out.print(sp.getModel()+"\t");
		System.out.print(sp.getColor()+"\t");
		System.out.println(sp.getOs());
		
		System.out.print(fp.getNumber()+"\t");
		System.out.print(fp.getModel()+"\t");
		System.out.print(fp.getColor()+"\t");
		System.out.println(fp.getPixel());
	}

}
