package kr.or.connect.project2.servlet;

import kr.or.connect.project2.dao.GuestbookDao;
import kr.or.connect.project2.dto.Guestbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestbookWriteServlet
 */
@WebServlet("/guestbooks/write")
public class GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestbookWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//작성
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		GuestbookDao dao = new GuestbookDao();
		Guestbook gb = new Guestbook(name,content);
		dao.addGuestbook(gb);
	}

}
