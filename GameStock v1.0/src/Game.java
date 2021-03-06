
public class Game {

	private String name;
	private String genre;
	private String releaseDate;
	private String platform;
	private String company;
	private String rating;

	public Game(String name, String genre, String releaseDate, String platform, String company) {
		this.name = name;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.platform = platform;
		this.company = company;
	}
	
	public Game(String name, String genre, String releaseDate, String platform, String company, String rating) { //same but with rating
		this.name = name;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.platform = platform;
		this.company = company;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public String getGenre() {
		return genre;
	}

	public String getDate() {
		return releaseDate;
	}

	public String getPlatform() {
		return platform;
	}

	public String getCompany() {
		return company;
	}
	
	public String getRating() {
		return rating;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
}
