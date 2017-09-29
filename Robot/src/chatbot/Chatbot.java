package chatbot;

public class Chatbot {

	private String username;
	private boolean chatting;
	private Topic ethan;
	private Topic jasonY;
	private Topic jasonZ;
	
	public Chatbot() {
		ethan = new ChatbotEthan();
		username = "Unknown User";
		chatting = true;
	}

	public String getUsername() {
		return username;
	}
	
	public Topic getEthan() {
		return ethan;
	}
	public void startChatting() {
		ChatbotMain.print("Hi! I am an intelligent machine that can respond to your input. Tell me your name.");
		username = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What would you like to talk about?");
			String response = ChatbotMain.getInput();
			if(ethan.isTriggered(response)) {
				chatting = false;//exits the while loop
				//IMPORTANT TO KNOW YOU GET GRADED FOR THIS
				ethan.talk(response);
				
			}else {
				ChatbotMain.print("I'm sorry. I don't understand. I never said I was perfect.");
			}
		}
	}

}
