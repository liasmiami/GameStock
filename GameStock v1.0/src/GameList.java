import java.util.*;
import java.io.*;

public class GameList {

	private ArrayList<Game> games;
	private String file;
	static Scanner in = null;

	public GameList(String file) { //create gamelist using csv file, games.csv in this case
		this.file=file;
		try {
			in = new Scanner(new File(file));
			games = new ArrayList<Game>();
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if ("".equals(line)) {
					continue;
				}
				String[] split = line.split(",");
				String name = split[0];
				String genre = split[1];
				String releaseDate = split[2];
				String platform = split[3];
				String company = split[4];
				Game game = new Game(name, genre, releaseDate, platform, company);
				games.add(game);
			}
		} catch (Exception e) {
			System.out.println("Error reading file");
		}
		in.close();
	}

	public void addGame(String name, String genre, String releaseDate, String platform, String company) {
		Game game = new Game(name, genre, releaseDate, platform, company);
		games.add(game);
	}

	public List<Game> searchByKeyword(String keyword) {
		keyword = keyword.toLowerCase();
		List<Game> result = new ArrayList<Game>();
		for (Game game : games) {
			if (game.getName().toLowerCase().contains(keyword) || game.getGenre().toLowerCase().contains(keyword)
					|| game.getCompany().toLowerCase().contains(keyword) || game.getDate().contains(keyword) ||
					game.getPlatform().toLowerCase().contains(keyword)) {
				result.add(game);
			}
		}
		return result;
	}

	public List<Game> getGameList() {
		return games;
	}

	public Game removeGame(String name) {
		ListIterator<Game> iter = games.listIterator();
		Game currentGame = null;
		while (iter.hasNext()) {
			currentGame = iter.next();
			if (currentGame.getName().equals(name)) {
				games.remove(currentGame);
				break;
			}
		}
		return currentGame;
	}

	public void save() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File(file));
		} catch (Exception ex) {
			System.out.println("Error reading file");
		}
		StringBuilder builder = new StringBuilder();
		for (Game game : games) {
			builder.append(game.getName() + "," + game.getGenre() + "," + game.getDate() + "," + game.getPlatform()
					+ "," + game.getCompany() + "\n");
		}
		pw.write(builder.toString());
		pw.close();
	}

}
