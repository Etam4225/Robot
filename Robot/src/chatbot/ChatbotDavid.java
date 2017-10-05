package chatbot;

public class ChatbotDavid implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String harryPotterAnswer;
	private String lotrAnswer;
	private String response;
	private String confirmation;
	private int noCount;
	private static String[] calmReply =
		{"Why not? Trust me, it will be an easy game. Let's play!",
				"We will get nowhere if you keep saying No.",
					"Please just say Ok"
		};
	private static String[] sarcasticReply =
		{"This is really frustrating for me. Clearly I am talking to a poorly made chatbot",
				"You get off on this don't you?",
					"Hey look at me! I'm a guy with a clearly limited vocabulary whos whole knowledge of English can fit in a single Tweet."
		};
	private static String[] hints = 
		{"7 book series but 8 movies",
		 "The boy who lived",
		 "Lightning scar",
		 "Involves a game called Quidditch",
		 "You're a wizard ______!"};
	private int calmSarcasticIndex;
	private int hintIndex;
	private int numberOfGuesses;
	
	public ChatbotDavid() {
		String[] temp = {"books", "novels", "book", "reading"};
		keywords = temp;
		goodbyeKeyword = "bye";
		harryPotterAnswer = "Harry Potter";
		lotrAnswer = "Lord of the Rings";
		response = "";
		noCount = 0;
		calmSarcasticIndex = 0;
		confirmation = "Ok";
		hintIndex = 0;
		numberOfGuesses = 5;
	}
	
	public void talk(String response) {
		ChatbotMain.print("Hey " + ChatbotMain.chatbot.getUsername() + "! So you want to talk about books? "
				+ "I have a game in mind, let's play! Just type Ok.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, confirmation, 0) == 0) {
				ChatbotMain.print("Great! Here's how to play: You have 5 guesses to think of the book I am thinking of right now. "
						+ "Don't worry I'll give you hints. Here's your first one: " +  (hints[hintIndex]));
				response = ChatbotMain.getInput();
				if(ChatbotMain.findKeyword(response, harryPotterAnswer , 0) == 0) {
			 		ChatbotMain.print("Wow " + ChatbotMain.chatbot.getUsername() + ", you got it in " + numberOfGuesses + " "
			 				+ "guesses! That's pretty impressive. Do you want to know about the movie version? "
			 				+ "Or do you want to play again with a different book?");
				}
				 if(numberOfGuesses == 0) {
					 ChatbotMain.print("Sorry " + ChatbotMain.chatbot.getUsername() + ", you did not get the right answer."
					 		+ " The right answer is Harry Potter! Do you want to play again with a different book or "
					 		+ "learn about the movie version?");
				 }
				 while(ChatbotMain.findKeyword(response, harryPotterAnswer , 0) == -1) {
					 hintIndex++;		
					 numberOfGuesses--;
					 ChatbotMain.print("Nope, that's the wrong answer! You have " + numberOfGuesses + " left. Try again! Here is your"
						+ " next hint: " + (hints[hintIndex]));
					 response = ChatbotMain.getInput();	 	
					 if(ChatbotMain.findKeyword(response, harryPotterAnswer , 0) == 0) {
					 		ChatbotMain.print("Wow " + ChatbotMain.chatbot.getUsername() + ", you got it in " + numberOfGuesses + " "
					 				+ "guesses! That's pretty impressive. Do you want to know about the movie version? "
					 				+ "Or do you want to play again with a different book?");
						}
				}
			}
			while(ChatbotMain.findKeyword(response, "no", 0) == 0) {
				noCount++;
				if(noCount < 5) {
					calmSarcasticIndex = (int)(Math.random()*calmReply.length);
					ChatbotMain.print(calmReply[calmSarcasticIndex]);
					response = ChatbotMain.getInput();
				}
				else {
					calmSarcasticIndex = (int)(Math.random()*sarcasticReply.length);
					ChatbotMain.print(sarcasticReply[calmSarcasticIndex]);
					response = ChatbotMain.getInput();
				}
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

