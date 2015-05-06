package com.zubiri.jsp.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import com.zubiri.parking.Coche;
import com.zubiri.parking.ParkingVehiculos;
import com.zubiri.parking.Vehiculo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class CreaCoche
 */
public class addcoche extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addcoche() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		
		String tipoVehiculo = "Coche";
		int numRuedas = Integer.parseInt(request.getParameter("numRuedas").trim());
		String marca = request.getParameter("marca");	
		String matricula = request.getParameter("matricula");
		
	
		//ParkingVehiculos.addVehiculo(tipoVehiculo, numRuedas, combustible, marca, auto, consumo, matricula, color, codBarras, numPinones, tipoBici);

		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexion = DriverManager.getConnection("jdbc:mysql:thin:localhost:3306:parkingMySQL", "root", "zubiri");
			Statement sentencia = conexion.createStatement();
			
			String create = 
					"CREATE TABLE IF NOT EXIST Coches(" +
					"matricula varchar(7) primary key not null" +
					"marca varchar(30)" +
					"numRuedas int(2));";
			
			String insert =
					"INSERT INTO Coches" +
					"VALUES(" + matricula + ", " + marca + ", " + numRuedas +");";
			
			String select =
					"SELECT * FROM Coches" +
					"WHERE matricula = " + matricula + ";";
			
			sentencia.execute(create);
			sentencia.execute(insert);
			ResultSet coches = sentencia.executeQuery(select);
			
					
					int numRuedas1 =	coches.getInt("numRuedas");
					
					String marca1 = coches.getString("marca");
					
					String matricula1 = coches.getString("matricula");
			
			out.println("<html>");
			out.println("<head><title>Respuesta</title>");
			out.println("<body>");
			out.println("<h1>Respuesta desde servidor</h1>");
			out.println("<p>" + matricula1 +","+marca1+","+ numRuedas1 +"</p>");
			out.println("</body></html>");
		
		}catch(Exception e){
			
		}
	}
}
