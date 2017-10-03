package chatbot;

public class ChatbotJasonY implements Topic{
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private int happyCount;
	
	public ChatbotJasonY() {
		String[] temp = {"Final Fantasy", "World of Warcraft", "Overwatch", "League of Legends", "Grand Theft Auto", "Heartstone", "Pokemon"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "Grand Chase";
		response = "";
		happyCount = 0;
	}
	
	public void talk(String response) {
		ChatbotMain.print("Games, huh? It has the power to turn one's life into a couch potato or a shut-in.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) >= -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Wow! That's my favorite game! I'm surprised you know that game. Those who know the game call it a rip off of another similar game called Elsword even though it was released in 2003 and Elsword was released in 2007.");
				happyCount++;
				response = ChatbotMain.getInput();
			}
			if(ChatbotMain.findKeyword(response, keywords[0], 0) >= 0) {
				ChatbotMain.print("Final Fantasy has a long history. From the first Final Fantasy, which was released in 1987, to Final Fantasy XV ("\n"15"\n" for those of you who can't read Roman numerials), which was released in 2016. Each Final Fantasy game has its own unqiue plot and characters.")
				response = ChatbotMain.getInput();
			}
		}
		
		if (happyCount > -2) {
			ChatbotMain.print("Well, I hate talking to you, " + ChatbotMain.chatbot.getUsername().toUpperCase() + "! You're a ****ing ***hole! WORSE PERSON I'VE EVER MEET!" );
			ChatbotMain.chatbot.startChatting();
		}
		
		if (happyCount == 0) {
			ChatbotMain.print("Well, it was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "! You're a decent person." );
			ChatbotMain.chatbot.startChatting();
		}
		
		if (happyCount == 1) {
			ChatbotMain.print("Well, it was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "! You're a pretty good person." );
			ChatbotMain.chatbot.startChatting();
		}
		
		if (happyCount == 2) {
			ChatbotMain.print("Well, it was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "! You're a cool person." );
			ChatbotMain.chatbot.startChatting();
		}
		
		if (happyCount > 2) {
			ChatbotMain.print("Well, it was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "! You're the greatest person I've ever meant." );
			ChatbotMain.chatbot.startChatting();
		}
			
	}
	
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		} 
		return false; 
	} 
}

