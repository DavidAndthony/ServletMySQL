package com.zubiri.jsps.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zubiri.parking.ParkingVehiculos;
import com.zubiri.parking.Vehiculo;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Servlet implementation class VerCoches
 */
public class VerCoches extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public VerCoches() {
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
		ParkingVehiculos parking = new ParkingVehiculos();
		//parkin.añadirCoche();
		parking.verCoches();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>"+ parking.formattedParking() +"</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
