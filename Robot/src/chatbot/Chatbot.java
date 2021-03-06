package chatbot;

public class Chatbot {

	private String username;
	private boolean chatting;
	private ChatbotEthan ethan;
	private ChatbotJasonY jasony;
	private ChatbotJasonZ JasonZ;
	private ChatbotDavid david;
	
	public Chatbot() {
		ethan = new ChatbotEthan();
		jasony = new ChatbotJasonY();
		JasonZ = new ChatbotJasonZ();
		david = new ChatbotDavid();
		//ADD YOUR CLASSES
		username = "Unknown User";
		chatting = true;
	}

	public String getUsername() {
		return username;
	}
	
	public ChatbotEthan getEthan() {
		return ethan;
	}
	public ChatbotJasonY getjasony() {
		return jasony;
	}
	public ChatbotJasonZ getJasonZ() {
		return JasonZ;
	}
	public ChatbotDavid getDavid() {
		return david;
	}
	public void startChatting() {
		ChatbotMain.print("Hi! I am an entertainment bot that talks about movies, books, music, and games! How about you tell me your name?");
		username = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What would you like to talk about " + ChatbotMain.chatbot.getUsername() + "?");
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
				ChatbotMain.print("Hmmm.... maybe you should try saying movie, books, music, or games.");
			} 
		}
	}

	public void changeChatting() {
		chatting = true;
	}

}
