package kr.board.vo;

public class BoardReplyVO {
	private int re_num;
	private String re_content;
	private String re_date;
	private String re_modifydate;
	private int board_num;//부모글 번호
	private int mem_num;//회원번호(작성자)
	private String id;//아이디(작성자)
	private String ip;
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public String getRe_date() {
		return re_date;
	}
	public void setRe_date(String re_date) {
		this.re_date = re_date;
	}
	public String getRe_modifydate() {
		return re_modifydate;
	}
	public void setRe_modifydate(String re_modifydate) {
		this.re_modifydate = re_modifydate;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
