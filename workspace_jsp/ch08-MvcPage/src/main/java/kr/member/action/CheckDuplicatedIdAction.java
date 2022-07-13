package kr.member.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.member.dao.MemberDAO;
import kr.member.vo.MemberVO;

public class CheckDuplicatedIdAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");

		// 전송된 데이터 반환
		String id = request.getParameter("id");

		MemberDAO dao = MemberDAO.getInstance();
		//ajax를 통해 파라미터로 넘어온 key="id", value="폼입력" 값을 db 테이블의 아이디와 중복 체크
		//해당 ID가 있다면 member는 생성, ID가 없다면 member는 null
		MemberVO member = dao.checkMember(id);

		/*
		 * [ lib/jackson ] 
		 * JSON 형식으로 변환하기를 원하는 문자열을 HashMap에 key와 value의 쌍으로 저장한 후
		 * ObjectMapper의 writeValueAsString에 Map 객체를 전달해서 
		 * 일반 문자열 데이터를 JSON 형식의 문자열 데이터로 변환 후 반환
		 */
		//이 HashMap에 넣는 키,값 쌍은 json 형식의 문자열임
		Map<String, String> mapAjax = new HashMap<String, String>();
		if (member == null) { // 아이디 미중복
			mapAjax.put("result", "idNotFound");
		} else {// 아이디 중복
			mapAjax.put("result", "idDuplicated");
		}

		ObjectMapper mapper = new ObjectMapper();
		//HashMap에 키가 result이고 값이 [idNotFound|idDuplicated]인 String 타입의 쌍을
		//JSON 형식의 문자열 데이터로 변환
		String ajaxData = mapper.writeValueAsString(mapAjax);
		//변환된 문자열 데이터를 request에 저장
		request.setAttribute("ajaxData", ajaxData);
		//ajax_view.jsp는 HashMap에 넣은 키,값을 단순히 json형식으로 표현할 뿐이다
		return "/WEB-INF/views/common/ajax_view.jsp";
	}

}
