package model;


public class Movie {

	private String title;
	private String year;
	private String genre;
	private String director;
	private String poster;
	private String rating;
	private String runTime;
	private String plot;
	private boolean response;
	
	public Movie(String title, String year, String genre, String director, 
			String poster,String rating, String runTime, String plot, boolean response) {
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.director = director;
		this.poster = poster;
		this.rating = rating;
		this.runTime = runTime;
		this.plot = plot;
		this.response = response;
	}


	public boolean getResponse() {
		return response;
	}

	public String getPlot() {
		return plot;
	}

	public String getRating() {
		return rating;
	}

	public String getRunTime() {
		return runTime;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getGenre() {
		return genre;
	}

	public String getDirector() {
		return director;
	}

	public String getPoster() {
		return poster;
	}
	
	
}
