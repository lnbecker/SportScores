
public interface ScoreServiceSubject {
	public void addObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyClients();
}
