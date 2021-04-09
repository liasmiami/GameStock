import java.util.*;
import java.io.*;

public class GameList {

	private ArrayList<Game> games;
	static Scanner in = null;

	public GameList(String file) {
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
					|| game.getCompany().toLowerCase().contains(keyword)) {
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
			pw = new PrintWriter(new File("games.csv"));
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

	public String toStringNames() {
		String list="";
		for(Game game:games)list+=game.getName()+"\n";
		return list;
	}
	
	public String toStringFull() {
		String list="";
		for(Game game:games) {
			for(String component:game.getComponents()) {
				list+=component+", ";
			}
			list=list.substring(0, list.length()-2); //gets rid of trailing comma
			list+="\n";
		}
		return list;
	}

}
