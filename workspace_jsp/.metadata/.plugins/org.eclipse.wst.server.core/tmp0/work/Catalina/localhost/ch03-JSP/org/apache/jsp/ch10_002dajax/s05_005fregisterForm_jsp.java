/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.63
 * Generated at: 2022-06-30 06:54:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.ch10_002dajax;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class s05_005fregisterForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>아이디 중복 체크</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	ul{\r\n");
      out.write("		padding: 0;\r\n");
      out.write("		margin: 0;\r\n");
      out.write("		list-style: none;\r\n");
      out.write("	}\r\n");
      out.write("	ul li{\r\n");
      out.write("		padding: 0;\r\n");
      out.write("		margin: 0 0 10px 0;\r\n");
      out.write("	}\r\n");
      out.write("	label{\r\n");
      out.write("		width: 100px;\r\n");
      out.write("		float: left;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	$(function(){\r\n");
      out.write("		//아이디 중복 체크 결과 -> 0 : 아이디 중복체크 미실시, 아이디 중복\r\n");
      out.write("		//				   -> 1 : 아이디 미중복\r\n");
      out.write("		let count = 0;\r\n");
      out.write("		\r\n");
      out.write("		//이벤트 연결\r\n");
      out.write("		$('#confirmId').click(function(){\r\n");
      out.write("			if($('#id').val().trim()==''){ //공백만 입력 경우\r\n");
      out.write("				alert('아이디를 입력하세요!');\r\n");
      out.write("				$('#id').val(''); 		   //공백 제거\r\n");
      out.write("				$('#id').focus();\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			//서버와 비동기 통신 ajax - JSON\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url:'confirmId.jsp',      //요청 URL\r\n");
      out.write("				type:'post', 			  //데이터 전송 방식\r\n");
      out.write("				data:{id:$('#id').val()}, //서버로 보낼 데이터\r\n");
      out.write("				dataType:'json', 		  //서버로부터 전송되어지는 데이터의 타입\r\n");
      out.write("				cache:false,			  //캐시 미사용, 낮은 버전의 브라우저는 원격지에서 캐시가 공개되는 경우가 있음\r\n");
      out.write("				timeout:3000,			  //3000ms이 지나도록 표시 되지않을시 에러\r\n");
      out.write("				success:function(param){\r\n");
      out.write("					if(param.result == 'idDuplicated'){\r\n");
      out.write("						//아이디 중복\r\n");
      out.write("						count = 0;\r\n");
      out.write("						$('#id_signed').text('이미 등록된 아아디').css('color','red');\r\n");
      out.write("					}else if(param.result == 'idNotFound'){\r\n");
      out.write("						//아이디 미중복\r\n");
      out.write("						count = 1;\r\n");
      out.write("						$('#id_signed').text('사용 가능한 아이디').css('color','green');\r\n");
      out.write("					}else{ //오류 failure\r\n");
      out.write("						count = 0;\r\n");
      out.write("						alert('아이디 중복 체크 오류!');\r\n");
      out.write("					}\r\n");
      out.write("				},\r\n");
      out.write("				error:function(){\r\n");
      out.write("					count = 0;\r\n");
      out.write("					alert('네트워크 오류 발생!');\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("		}); //end of click\r\n");
      out.write("		\r\n");
      out.write("		//최초에 아이디 중복 체크에 성공한 후 식별자가 #id인 text의 내용 변경 후 \r\n");
      out.write("		//중복체크를 하지않고 submit 누르는 상황 방지\r\n");
      out.write("		//식별자가 #id인 text의 내용 변경될시 span을 지워버림\r\n");
      out.write("		$('#insert_form #id').keydown(function(){\r\n");
      out.write("			$('#id_signed').text('');\r\n");
      out.write("			count = 0;\r\n");
      out.write("		}); //end of keydown\r\n");
      out.write("		\r\n");
      out.write("		$('#insert_form').submit(function(){\r\n");
      out.write("			if($('#id').val().trim()==''){\r\n");
      out.write("				alert('아이디를 입력하세요');\r\n");
      out.write("				$('#id').val('').focus();\r\n");
      out.write("				return false;\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			if(count==0){\r\n");
      out.write("				alert('아이디 중복 체크 필수');\r\n");
      out.write("				return false;\r\n");
      out.write("			}\r\n");
      out.write("		}); //end of submit\r\n");
      out.write("		\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form id=\"insert_form\" method=\"post\">\r\n");
      out.write("	<fieldset>\r\n");
      out.write("		<legend>데이터 추가</legend>\r\n");
      out.write("		<ul>\r\n");
      out.write("			<li>\r\n");
      out.write("				<label for=\"id\">아이디</label>\r\n");
      out.write("				<input type=\"text\" name=\"id\" id=\"id\">\r\n");
      out.write("				<input type=\"button\" id=\"confirmId\" value=\"아이디 중복체크\">\r\n");
      out.write("				<span id=\"id_signed\"></span>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li>\r\n");
      out.write("				<input type=\"submit\" value=\"전송\">\r\n");
      out.write("			</li>\r\n");
      out.write("		</ul>\r\n");
      out.write("	</fieldset>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
