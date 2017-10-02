package chatbot;

public class ChatbotJasonY implements Topic{
	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotJasonY() {
		String[] temp = {"Final Fantasy", "World of Warcraft", "Overwatch", "League of Legends", "Grand Theft Auto", "Heartstone", "Pokemon"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "Grand Chase";
		response = "";
	}
	
	public void talk(String response) {
		ChatbotMain.print("Games, huh? It has the power to turn one into a couch potato or a shut-in.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) >= -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Wow! That's my favorite game! I'm surprised you know that game. Those who know the game call it a rip off of another similar game called Elsword even though it was released in 2003 and Elsword was released in 2007.");
				response = ChatbotMain.getInput();
			}
			if(ChatbotMain.findKeyword(response, keywords[0], 0) >= 0) {
				ChatbotMain.print("Final Fantasy has a long history. From the first Final Fantasy, which was released in 1987, to Final Fantasy XV ("\n"15"\n" for those of you who can't read Roman numerials), which was released in 2016. Each Final Fantasy game has its own unqiue plot and characters.")
				response = ChatbotMain.getInput();
			}
		}
		ChatbotMain.print("Well, it was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "!");
		ChatbotMain.chatbot.startChatting();
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

