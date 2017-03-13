package controler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Movie;

@WebServlet("/InfoMovieServlet")
public class InfoMovieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		title = title.replace(" ", "+");

		URL url = new URL("http://www.omdbapi.com/?t=" + title);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		Scanner sc = new Scanner(connection.getInputStream());
		StringBuilder result = new StringBuilder();
		while (sc.hasNextLine()) {
			result.append(sc.nextLine());
		}
		sc.close();
		
		String json = result.toString();
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		Movie movie = null;
		if (obj.get("Response").getAsBoolean()) {
			movie = new Movie(obj.get("Title").getAsString(), obj.get("Year").getAsString(),
					obj.get("Genre").getAsString(), obj.get("Director").getAsString(), obj.get("Poster").getAsString(),
					obj.get("imdbRating").getAsString(), obj.get("Runtime").getAsString(),
					obj.get("Plot").getAsString(), obj.get("Response").getAsBoolean());
		} else {
			movie = new Movie("", "", "", "", "", "", "", "", false);
		}
		request.setAttribute("movie", movie);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
