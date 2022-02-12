package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class CRUDCarro
 */
@WebServlet("/CRUDCarro")
public class CRUDCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarroDAO carrodao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDCarro() {
        super();
        // TODO Auto-generated constructor stub
        this.carrodao = new CarroDAO();
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
		String optionCarro = request.getParameter("optionCarro");
		if (optionCarro == null) {
			optionCarro = "";
		}
		switch(optionCarro) {
		case ("insertForm"):
			showInsertCarro(request, response);
		break;
		case ("updateForm"):
			showUpdateCarro(request, response);
		break;
		case ("update"):
			updateCarro(request, response);
		break;
		case ("delete"):
			deleteCarro(request, response);
		break;
		case ("insert"):
			insertCarro(request, response);
		break;
		default:
			selectAllCarros(request, response);
	}
}
	private void showInsertCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
		private void showUpdateCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			Integer id = Integer.parseInt(request.getParameter("id"));
			Carro u = this.carrodao.buscarCarro(id);
			request.setAttribute("carro", u);
			request.getRequestDispatcher("form.jsp").forward(request, response);
		}
		
		private void insertCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String modeloBack = request.getParameter("modelo");
			Integer ano_carroBack = request.getParameter("ano_carro");
			if ((modeloBack != null) && (ano_carroBack != null)) {
				if (!modeloBack.equals("")){
					Carro carro1 = new Carro(modeloBack, ano_carroBack);
					this.carrodao.addCarro(carro1);
				}
	}
			response.sendRedirect("CRUDCarro");
		}
		private void selectAllCarros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			//System.out.println(this.cont.selectAll());
			request.setAttribute("listCarro",this.carrodao.getListCarro());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		private void deleteCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String idBack = request.getParameter("id");
			if (idBack != null) {
				Integer id = Integer.parseInt(idBack);
				this.carrodao.removeCarro(id);
			}
			response.sendRedirect("CRUDCarro");
		}
		private void updateCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String idBack = request.getParameter("id");
			String modeloBack = request.getParameter("modelo");
			Integer ano_carroBack = request.getParameter("ano_carro");
		
			if ((modeloBack != null) && (ano_carroBack != null)) {
				if (!modeloBack.equals("")){
					Integer id = Integer.parseInt(idBack);
					Carro carro1 = new Carro(modeloBack, ano_carroBack);
					carro1.setId(id);
					this.carrodao.updateCarro(carro1);
				}
			}
			response.sendRedirect("CRUDCarro");
		}
}
	
