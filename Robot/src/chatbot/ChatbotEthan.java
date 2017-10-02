package chatbot;

public class ChatbotEthan implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String YES = "YES";
	private String NO = "NO";
	private boolean saidYesorNo;
	
	public ChatbotEthan() {
		String[] temp = {"movie","lord of the rings", "watching"};
		
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "Lord of the Rings";
		
		response = "";
	}

	public void talk(String response) {
		ChatbotMain.print("Movies eh? I love movies to be honest. Hey, " + ChatbotMain.chatbot.getUsername() + ", you like movies man? Yes or no?");
		response = ChatbotMain.getInput();
		saidYesorNo = false;
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, YES, 0) >= 0) {
				
			}
			else
			{
				if(ChatbotMain.findKeyword(response, NO, 0) >= 0) {
					
				}
				else {
					while(!saidYesorNo) {
						ChatbotMain.print("Uhhh...just say yes or no plz");
						response = ChatbotMain.getInput();			
						if(ChatbotMain.findKeyword(response, YES, 0) >= 0 || ChatbotMain.findKeyword(response, NO, 0) >= 0) {
							saidYesorNo = true;
						}
					}
				}
			}
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("OH MAN ITS THE BEST MAN");
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
	public String startGame() {
		return "xd";
	}
	

}
