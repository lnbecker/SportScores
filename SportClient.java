import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SportClient implements Client{
	private String preferredSport;
	private String homeTeam;
	private String awayTeam;
	private int homeScore;
	private int awayScore;
	
	public SportClient(String sport, ScoreService sv){
		sv.addClient(this);
		preferredSport = sport;
		}
	
	public void update(ScoreService sv){
		if (preferredSport.equals(sv.getSport())){
			homeTeam = sv.getHomeTeam();
			awayTeam = sv.getAwayTeam();
			homeScore = sv.getHomeScore();
			awayScore = sv.getAwayScore();
			display();
		}
	}
	
	public void display(){
		JFrame frame = new JFrame(preferredSport + " News");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel notification;
		if(homeScore>awayScore){
			notification = new JLabel("   The " + homeTeam + " " + preferredSport  + " team defeated " + awayTeam + ", " + homeScore + " to " + awayScore);
		}
		else {
			notification = new JLabel("   The " + awayTeam + " " + preferredSport  + " team defeated " + homeTeam + ", " + awayScore + " to " + homeScore);
		}
        notification.setPreferredSize(new Dimension(275, 100));
        frame.getContentPane().add(notification, BorderLayout.CENTER);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}
	

}




