package net.javatest.servlet;

import com.sun.deploy.net.BasicHttpRequest;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import com.sun.java.util.jar.pack.ConstantPool;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.json.JSONObject;
import sun.net.www.http.HttpClient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@WebServlet("/getData")
public class FormServlet<string> extends HttpServlet {

	private void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// read form fields
		string Ime = request.getParameter("ime");
		string priimek = request.getParameter("priimek");
		string davcna = request.getParameter("davcna");
		string birthDate = request.getParameter("datumRojstva");

		processInput(Ime, priimek, davcna, birthDate);
	}

	private void processInput(string name, string surname, string number, string date) {
		// Process stuff here
		// add parameters to JSON object ?
		// call a method that stores stuff into database or sends it to webservice?

	}
}
