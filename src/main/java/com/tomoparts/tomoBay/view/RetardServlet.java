/**_________________________________________________________________________________________________ 
 * Copyright(C) 2016 Jan P.C. Hanson 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *________________________________________________________________________________________________*/
package com.tomoparts.tomoBay.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tomoparts.tomoBay.presenters.AbstractPresenter;
import com.tomoparts.tomoBay.presenters.PresenterFactory;
import com.tomoparts.tomoBay.presenters.presenterActions.concreteActions.PeriodicServicesController;

/**
 * 
 * @author Jan P.C. Hanson
 *
 **/
public class RetardServlet extends HttpServlet
{

	/**needed to avoid warnings**/
	private static final long serialVersionUID = 1800217544542757667L;

	/**
	 * CTOR
	 **/
	public RetardServlet()
	{super();}
	
	/**
	 * service method, this controls how the servlet responds to particular URL query strings
	 * @param request the http request to the servlet
	 * @param response the http response to the servlet
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String pause = request.getParameter("pause");
		String result = "";
		
		PeriodicServicesController pauseController = new PeriodicServicesController();
		
		if(pause.equals("true"))
		{
			pauseController.execute("PAUSE");
			result = "OK : services paused";
		}
		else if(pause.equals("false"))
		{
			pauseController.execute("START");
			result = "OK : services started";
		}
		else
		{result = "invalid parameter: '"+pause+"'";}
		out.write(result);
		out.close();
	}
}