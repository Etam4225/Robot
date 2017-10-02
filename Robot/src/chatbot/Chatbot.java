package chatbot;

public class Chatbot {

	private String username;
	private boolean chatting;
	private Topic ethan;
	private Topic jasony;
	private Topic JasonZ;
	private Topic david;
	
	public Chatbot() {
		ethan = new ChatbotEthan();
		jasony = new ChatbotJasony();
		JasonZ = new ChatbotJasonZ();
		david = new ChatbotDavid();
		//ADD YOUR CLASSES
		username = "Unknown User";
		chatting = true;
	}

	public String getUsername() {
		return username;
	}
	
	public Topic getEthan() {
		return ethan;
	}
	public Topic getjasony() {
		return jasony;
	}
	public Topic getJasonZ() {
		return JasonZ;
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
				//isTriggered for every topic.
			}else if(jasony.isTriggered(response)) {
				chatting = false;
				jasony.talk(response);
			}else if(JasonZ.isTriggered(response)) {
				chatting = false;
				JasonZ.talk(response);
				
			}else if(david.isTriggered(response)) {
				chatting = false;
				david.talk(response);
			}
			else {
				ChatbotMain.print("I'm sorry. I don't understand. I never said I was perfect.");
			} 
		}
	}

}
