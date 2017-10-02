package chatbot;

public class ChatbotJasonZ implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	public ChatbotJasonZ() {
		String[] songs = {"The Shadow of the Past","A knife in the dark","Flight to the ford","Many Meeting","The Council of Elrond","The ring goes South","The bridge of Khazad Dum","Lothlorien", "Amon Hend","The breaking of the fellowship","May it be"};
		String[] temp = {"lord of the ring's music", "lord of the rings music"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "Concerning Hobbits";
		response = "";
	}

	@Override
	public void talk(String response) {
		ChatbotMain.print("Hey! So you want to talk about generic boring things, huh? I love talking about that. So tell me something.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Wow I love that song! isn't the title amazing?.");
				response = ChatbotMain.getInput();
			}
			
			if(ChatbotMain.findKeyword(response, "Yes", 0) >= 0)
			{
				double rand = Math.random();
				if(rand <= (1/11))
				{
					ChatbotMain.print("Wow! You know The Shadow of the Past? Don't you love the string instruments and the voice?");
					response = ChatbotMain.getInput();
					countineTalkingAboutSubject(response);
				}
				else 
				{
					if(rand <= 2/11)
					{
						
					}
				}
			}
			else 
			{
				ChatbotMain.print("Yeah. That's pretty cool. But there are things I like even more. Tell me something else.");
				response = ChatbotMain.getInput();
			}
		}
		//access variables from other classes
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
		
	}

	private void countineTalkingAboutSubject(String response) {
		
		
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			//IMPORTANT (on the rubric)
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

}
