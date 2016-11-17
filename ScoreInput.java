//observable for ScoreService
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class ScoreInput implements ScoreServiceSubject{
	private ArrayList<Observer> observers;
	private String sport;
	private String homeName;
	private String awayName;
	private int homeScore;
	private int awayScore;

	public ScoreInput(){
		observers = new ArrayList<Observer>();
		GUIFrame frame = new GUIFrame(this);
	    frame.pack();
	}
	
	public void addObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		observers.remove(o);
	}
	
	public void notifyClients(){
		for (Observer observer : observers){
			observer.update(sport, homeName, awayName, homeScore, awayScore);
		}
	}
	
	public void sendGame(String sp, String homeTeam, String awayTeam, int home, int away){
		sport = sp;
		homeName = homeTeam;
		awayName = awayTeam;
		homeScore = home;
		awayScore = away;
		notifyClients();
	}
}

@SuppressWarnings("serial")
class GUIFrame extends JFrame {
	   private GUIPanel panel;
	   
	   public GUIFrame(ScoreInput scoreInput) {
	      setTitle("Score Input");
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	      setLocation(200,200);
	      panel = new GUIPanel(scoreInput);
	      setContentPane(panel);
	      setVisible(true);
	   }
}



@SuppressWarnings("serial")
class GUIPanel extends JPanel implements ActionListener {
	private ScoreInput scoreInput;
	
	 
	private JLabel sportlbl = new JLabel("Sport");
	private JTextField sporttxt = new JTextField("", 4);
	private JLabel homeTeamlbl = new JLabel("Home team");
	private JTextField homeTeamtxt = new JTextField("", 4);
	private JLabel awayTeamlbl = new JLabel("Away team");
	private JTextField awayTeamtxt = new JTextField("", 4);
	private JLabel homeScorelbl = new JLabel("Home score");
	private JTextField homeScoretxt = new JTextField("", 4);
	private JLabel awayScorelbl = new JLabel("Away score");
	private JTextField awayScoretxt = new JTextField("", 4);
	
	private JButton addScorebtn = new JButton("ADD NEW SCORE");
	
	public GUIPanel(ScoreInput input){
		scoreInput = input;
		add(sportlbl); add(sporttxt); add(homeTeamlbl); add(homeTeamtxt); add(awayTeamlbl); add(awayTeamtxt);
		add(homeScorelbl); add(homeScoretxt); add(awayScorelbl); add(awayScoretxt);
		
		add(addScorebtn);
		addScorebtn.addActionListener(this);
		
		setLayout(new FlowLayout());
	}
	
	public void actionPerformed(ActionEvent evt) {
	      recordResults();
	   }
	   
	   public void recordResults() {
	      String sport = sporttxt.getText();
	      String homeTeam = homeTeamtxt.getText();
	      String awayTeam = awayTeamtxt.getText();
	      int homeScore = Integer.parseInt(homeScoretxt.getText());
	      int awayScore = Integer.parseInt(awayScoretxt.getText());
	      scoreInput.sendGame(sport, homeTeam, awayTeam, homeScore, awayScore);
	      
	   }
	
}