package spring.core.service;

public class ClientService {

	private static ClientService INSTANCE = null;

	private ClientService() {
	}

	public static ClientService getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ClientService();
		}
		
		return INSTANCE;
	}
	
	public void clientInfo() {
		System.out.println(">>>>>>> Client Info >>>>>>>>>>>>>>>>");
	}

}
