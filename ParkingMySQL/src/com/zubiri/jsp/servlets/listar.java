package com.zubiri.jsp.servlets;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zubiri.parking.Coche;
import com.zubiri.parking.ParkingVehiculos;
import com.zubiri.parking.Vehiculo;

/**
 * Servlet implementation class Listar
 */
@WebServlet("/Listar")
public class listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexion = DriverManager.getConnection("jdbc:mysql:thin:localhost:3306:parkingMySQL", "root", "zubiri");
			Statement sentencia = conexion.createStatement();
			
			String select =
					"SELECT * FROM Coches;";
		
			ResultSet coches = sentencia.executeQuery(select);
			
			out.println("<html>");
			out.println("<head><title>Respuesta</title>");
			out.println("<body>");
			out.println("<h1>Respuesta desde servidor</h1>");
			
			while(coches.next()){
			
			
						
					int numRuedas =	coches.getInt("numRuedas");
					
					String marca = coches.getString("marca");
					
					String matricula = coches.getString("matricula");
							 
				
				out.println("<p>" + numRuedas +","+marca+","+matricula + "</p>");
			}
			out.println("</body></html>");
		
		}catch(Exception e){
			
		}
	}
}


