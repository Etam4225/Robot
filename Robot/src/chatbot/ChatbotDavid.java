package chatbot;

public class ChatbotDavid implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotDavid() {
		String[] temp = {"book", "novel", "read", "reading", "books", "novels"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "Lord of The Rings";
		response = "";
	}

	public void talk(String response) {
		ChatbotMain.print("Hey! So you like books? I know pretty much everything about books! So tell me a book you like!");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("I've read that series! It's pretty good but there are other books that are better. Have you seen the movie?");
				response = ChatbotMain.getInput();
			}else {
				ChatbotMain.print("Yeah. That's pretty cool. But there are things I like even more. Tell me something else.");
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

