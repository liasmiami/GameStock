
public class Game {
	
	private String name;
	private String genre;
	private String releaseDate;
	private String platform;
	private String company;
	
	public Game(String name, String genre, String releaseDate, String platform, String company) {
		this.name = name;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.platform = platform;
		this.company = company;
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
}
