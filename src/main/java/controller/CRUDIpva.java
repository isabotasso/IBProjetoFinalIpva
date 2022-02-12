package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class CRUDIpva
 */
@WebServlet("/CRUDIpva")
public class CRUDIpva extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IpvaDAO ipvadao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDIpva() {
        super();
        // TODO Auto-generated constructor stub
        this.ipvadao = new IpvaDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String optionIpva = request.getParameter("optionIpva");
		if (optionIpva == null) {
			optionIpva = "";
		}
		switch(optionIpva) {
		case ("insertForm"):
			showInsertIpva(request, response);
		break;
		case ("updateForm"):
			showUpdateIpva(request, response);
		break;
		case ("update"):
			updateIpva(request, response);
		break;
		case ("delete"):
			deleteIpva(request, response);
		break;
		case ("insert"):
			insertIpva(request, response);
		break;
		default:
			selectAllIpva(request, response);
	}
		private void showInsertIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			request.getRequestDispatcher("formIpva.jsp").forward(request, response);
		}
		
		private void showUpdateIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			Integer id = Integer.parseInt(request.getParameter("id"));
			Ipva u = this.ipvadao.buscarIpva(id);
			request.setAttribute("ipva", u);
			request.getRequestDispatcher("formIpva.jsp").forward(request, response);
		}
		
		private void insertIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
			Integer ano_ipvaBack = request.getParameter("ano_ipva");
			
			if (ano_ipvaBack != null) {
				if (!ano_ipvaBack.equals("")){
					Ipva ipva1 = new Ipva ano_ipvaBack);
					this.ipvadao.addIpva(ipva1);
				}
}
			response.sendRedirect("CRUDIpva");
		}
		private void selectAllIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			//System.out.println(this.cont.selectAll());
			request.setAttribute("listIpva",this.ipvadao.getListIpva());
			request.getRequestDispatcher("indexIpva.jsp").forward(request, response);
		doGet(request, response);
	}

		private void deleteIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String idBack = request.getParameter("id");
			if (idBack != null) {
				Integer id = Integer.parseInt(idBack);
				this.ipvadao.removeIpva(id);
}
			response.sendRedirect("CRUDIpva");
		}
		private void updateIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String idBack = request.getParameter("id");
			String modeloBack = request.getParameter("modelo");
			Integer ano_ipvaBack = request.getParameter("ano_ipva");
			
			if ((ano_ipvaBack != null) && (idBack != null)) {
				if (!ano_ipvaBack.equals("")){
					Integer id = Integer.parseInt(idBack);
					Ipva ipva1 = new Ipva(ano_ipvaBack);
					ipva1.setId(id);
					this.ipvadao.updateIpva(ipva1);
				}
			}
			response.sendRedirect("CRUDIpva");
		}
		
	}

