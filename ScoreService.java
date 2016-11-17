import java.util.ArrayList;

//Observable for Clients, Observer for ScoreInput
//How do I make it implement both subject and observer

public class ScoreService implements ClientSubject, Observer{
	//private ScoreInput scoreInput;
	private ArrayList<Client> clients;
	private String sport;
	private String homeTeam;
	private String awayTeam;
	private int homeScore;
	private int awayScore;
	
	
	public ScoreService(ScoreInput si){
		//scoreInput = si; 
		si.addObserver(this); //registers scoreService as observer of ScoreInput
		clients = new ArrayList<Client>(); //adds list of clients
		}
	
	public void addClient(Client c){
		clients.add(c);
	}
	
	public void removeClient(Client c){
		clients.remove(c);
	}
	
	public void notifyClients(){
		for (Client client : clients){
			client.update(this);
		}
	}
	
	// So Clients can pull information
	public String getSport(){
		return sport;
	}
	
	public String getHomeTeam(){
		return homeTeam;
	}
	
	public String getAwayTeam(){
		return awayTeam;
	}
	
	public int getHomeScore(){
		return homeScore;
	}
	
	public int getAwayScore(){
		return awayScore;
	}
	
	//to implement Observer interface
	public void update(String thesport, String homeName, String awayName, int homeResult, int awayResult){
		sport = thesport;
		homeTeam = homeName;
		awayTeam = awayName;
		homeScore = homeResult;
		awayScore = awayResult;
		notifyClients();
	}
	
	
}