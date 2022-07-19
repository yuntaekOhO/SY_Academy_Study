package kr.util;
/*
 * 게시글 제목,내용에 html 태그 입력한 경우 처리
 */
public class StringUtil {
	//HTML태그를 허용하면서 줄바꿈
	public static String useBrHtml(String str) {
		if(str==null) return null;
		//엔터
		return str.replaceAll("\r\n","<br>")
				  .replaceAll("\r", "<br>")
				  .replaceAll("\n", "<br>");
	}
	
	//HTML태그를 허용하지 않으면서 줄바꿈
	public static String userBrNoHtml(String str) {
		if(str==null) return null;
		
		return str.replaceAll("<", "&lt;")
				  .replaceAll(">", "&gt;")
				  .replaceAll("\r\n", "<br>")
				  .replaceAll("\r", "<br>")
				  .replaceAll("\n", "<br>");
	}
	
	//HTML 허용하지 않음
	public static String useNoHtml(String str) {
		if(str==null) return null;
		
		return str.replaceAll("<", "&lt;")
				  .replaceAll(">", "&gt;");
	}
	
	//지정한 문자열 개수 이후에 ...으로 처리
	public static String shortWords(int length, String content) {
		if(content==null) return null;
		
		if(content.length() > length) {
			return content.substring(0,length) + " ...";
		}
		
		return content;
	}
}
