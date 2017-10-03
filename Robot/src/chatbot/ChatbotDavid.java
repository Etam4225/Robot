package chatbot;

public class ChatbotDavid implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String[] hints;
	private String confirmation;
	
	public ChatbotDavid() {
		String[] temp = {"book"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "Harry Potter";
		response = "";
		String[] hintList = {""};
		hints = hintList;
		//String[] confirmationGame = {"Sure", "Ok", "Why not", "Yes"};
		confirmation = "Ok";
	}

	public void talk(String response) {
		ChatbotMain.print("Hey! So you like reading books? So do I! I have a game in mind, let's play!");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, confirmation, 0) >= 0) {
				ChatbotMain.print("Great! Here's how to play: You have 5 guesses to think of the book I am thinking of right now. "
						+ "Don't worry I'll give you hints. Here's your first one: ");
				response = ChatbotMain.getInput();
			}else {
				ChatbotMain.print("That's no fun. It's be an easy game! Let's play!");
				response = ChatbotMain.getInput();
			}
		}
		//access variables from other classes
		ChatbotMain.print("Well, it was nice talking to you, " +ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	
	}
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			//IMPORTANT (on rubric) USE FINDKEYWORD OVER INDEX OF
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

}

