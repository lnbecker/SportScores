import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CollegeClient implements Client{
	private ScoreService scoreService;
	private String preferredCollege;
	private String sport;
	private String homeTeam;
	private String awayTeam;
	private int homeScore;
	private int awayScore;
	
	public CollegeClient(String college, ScoreService sv){
		this.scoreService = sv;
		sv.addClient(this);
		preferredCollege = college;
		}
	
	public void update(ScoreService sv){
		if (preferredCollege.equals(sv.getHomeTeam()) || preferredCollege.equals(sv.getAwayTeam())){
			sport = sv.getSport();
			homeTeam = sv.getHomeTeam();
			awayTeam = sv.getAwayTeam();
			homeScore = sv.getHomeScore();
			awayScore = sv.getAwayScore();
			display();
		}
	}
	
	public void display(){
		JFrame frame = new JFrame(preferredCollege + " News");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel notification;
		if(homeScore>awayScore){
			notification = new JLabel("   " + homeTeam + " defeated " + awayTeam + " in " + sport + ", " + homeScore + " to " + awayScore);
		}
		else {
			notification = new JLabel("   " + awayTeam + " defeated " + homeTeam + " in " + sport + ", " + awayScore + " to " + homeScore);
		}
        notification.setPreferredSize(new Dimension(275, 100));
        frame.getContentPane().add(notification, BorderLayout.CENTER);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}
}