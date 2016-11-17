// Serves as the "Subject" interface so even though the real client subject is scoreService, Score Input
// implements ClientSubject because it is the observable class for ScoreService

public interface ClientSubject {
	public void addClient(Client c);
	public void removeClient(Client c);
	public void notifyClients();
}
