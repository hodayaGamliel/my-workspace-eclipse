package org.apache.test;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import main.java.hod.test.Hod;
import main.java.hod.test.VelocityUtil;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 public static boolean firstTime = true;
	
    /**
     * Default constructor. 
     */
    public TestServlet() {
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		try
		{
			 Hod hod = new Hod();
			 System.out.println(1 + " " + firstTime);
			  if (firstTime == true)
			  {
			  for (int i = 0; i < 5; i++)
			   {
				   hod.throwExcep();
			   }
			  firstTime = false;
				 System.out.println(2 + " " + firstTime);

			  }
				 System.out.println(3 + " " + firstTime);

			  
				Template template = VelocityUtil.instance().getTemplate("helloworld.vm");
				VelocityContext ctx = VelocityUtil.instance().createContext();
				
				ctx.put("test", hod);
				ctx.put("name", "hodaya");
				
				StringWriter writer = new StringWriter();
				template.merge(ctx, writer);
				String str = writer.toString();
				response.getWriter().println(str);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}	 
		   		   	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
