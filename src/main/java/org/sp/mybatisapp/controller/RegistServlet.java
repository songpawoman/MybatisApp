package org.sp.mybatisapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sp.mybatisapp.domain.Board;
import org.sp.mybatisapp.repository.MySQLBoardDAO;

//글쓰기 요청을 처리하는 서블릿 ( JSP로 작성해도 되지만
//공부목적상 일부러 서블릿..)
public class RegistServlet extends HttpServlet{
	MySQLBoardDAO boardDAO = new MySQLBoardDAO();
	
	//파라미터 받기 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		//입력시도 
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		boardDAO.insert(board);
		
		
		PrintWriter out = response.getWriter();
		
		out.print("제목은 "+title+"<br>");
		out.print("작성자는 "+writer+"<br>");
		out.print("내용은 "+content+"<br>");
		
		//list.jsp를 재요청하도록 응답정보를 구성하자
		//클라이언트 웹브라우저로 하여금, 지정한 URL로 재접속을 유도..
		response.sendRedirect("/board/list.jsp");  //location.href="";
	}
}








