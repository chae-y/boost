package kr.or.connect.project2.servlet;

import kr.or.connect.project2.dao.GuestbookDao;
import kr.or.connect.project2.dto.Guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestbookListServlet
 */
@WebServlet("/guestbooks")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestbookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//작성
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		GuestbookDao dao= new GuestbookDao();
		List<Guestbook> list = dao.getGuestbooks();
		for(Guestbook gb : list) {
			out.print("id : "+gb.getId()+"<br>");
			out.print("name : "+gb.getName()+"<br>");
			out.print(gb.getContent()+"<br>");
			out.print("regdate : "+gb.getRegdate()+"<br>");
		}
		out.close();
	}

}
