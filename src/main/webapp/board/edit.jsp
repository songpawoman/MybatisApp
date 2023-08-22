<%@page import="org.sp.mybatisapp.repository.OracleBoardDAO"%>
<%@page import="org.sp.mybatisapp.domain.Board"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%! OracleBoardDAO oracleBoardDAO=new OracleBoardDAO(); %>
<%
	//파라미터를 넘겨받아 update board set title=?, writer=?, content=?
	//where board_idx=?
	request.setCharacterEncoding("utf-8"); //받기 전에 인코딩 처리해야함

	String title=request.getParameter("title");
	String writer=request.getParameter("writer");
	String content=request.getParameter("content");
	int board_idx=Integer.parseInt(request.getParameter("board_idx"));
%>
<jsp:useBean id="board" class="org.sp.mybatisapp.domain.Board"/>
<jsp:setProperty property="*" name="board" />
<%
	//오라클에 수정
	int result = oracleBoardDAO.update(board);
	
	out.print("<script>");
	if(result>0){
		out.print("alert('수정성공');");
		out.print("location.href='/board/content.jsp?board_idx="+board_idx+"';");
	}else{
		out.print("alert('수정실패');");
		out.print("history.back();");
	}
	out.print("</script>");
%>








