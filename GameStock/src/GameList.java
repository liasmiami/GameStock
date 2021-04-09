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
	
	public Game removeGame(String name) {
		ListIterator<Game> iter = games.listIterator();
		Game currentGame = null;
		while(iter.hasNext()) {
			currentGame = iter.next();
			if (currentGame.getName().equals(name)) {
				games.remove(currentGame);
				break;
			}
		}
		return currentGame;
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
			list=list.substring(0, list.length()-2);
			list+="\n";
		}
		return list;
	}

}
