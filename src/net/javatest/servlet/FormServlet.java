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
public class GetData extends HttpServlet {

	public static String Ime;
	public static String priimek;
	public static String davcna;
	public static String birthDate;
	public static String[] person;

	private String[] GetPerson(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		person = new String[4];

		// read form fields
		Ime = request.getParameter("ime");
		priimek = request.getParameter("priimek");
		davcna = request.getParameter("davcna");
		birthDate = request.getParameter("datumRojstva");

		person[0] = Ime;
		person[1] = priimek;
		person[2] = davcna;
		person[3] = birthDate;

		return person;
		convertToJson();
	}

	private void convertToJson(){

		JSONObject json = new JSONObject();

		json.put("Ime", person[0]);
		json.put("Priimek", person[1]);
		json.put("Datum rojstva", person[2]);
		json.put("Davčna številka", person[3]);

		HttpPost request = new HttpPost("http://localhost/sklenizavarovanje");
		StringEntity params = new StringEntity(json.toString());
		request.addHeader("content-type", "application/json");
		request.setEntity(params);
		HttpResponse response = httpClient.execute(request);



	}

}