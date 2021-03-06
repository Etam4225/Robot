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
	private static String[] hHints = 
		{"7 book series but 8 movies",
		 "The boy who lived",
		 "Lightning scar",
		 "Involves a game called Quidditch",
		 "You're a wizard ______!"};
	public static String[] lotrHints = 
		{"One of the best selling novels ever written with over 150 million copies sold",
		 "Published in 3  volumes, each with 2 books per volume",
		 "Written by J.R.R. Tolkien",
		 "The story's main antagonist is the Dark Lord Sauron",
		 "One Ring"
		};
	private int calmSarcasticIndex;
	private int hintIndex;
	private int numberOfGuesses;
	private String[] nRead;
	private String pAgain;
	private String switchChatbot;
	private String gameChatbot;
	private String musicChatbot;
	private String moviesChatbot;
	
	public ChatbotDavid() {
		String[] temp = {"books", "novels", "book", "reading"};
		keywords = temp;
		String[] noRead = {"I don't read", "I do not read", "I don't have a favorite book", "I do not have a favorite book", 
				"I don't like reading", "I do not like reading", "I hate reading"}; 
		nRead = noRead;
		goodbyeKeyword = "bye";
		harryPotterAnswer = "Harry Potter";
		lotrAnswer = "Lord of the Rings";
		response = "";
		noCount = 0;
		calmSarcasticIndex = 0;
		confirmation = "Ok";
		hintIndex = 0;
		numberOfGuesses = 5;
		pAgain = "Play again";
		switchChatbot = "Learn";
		gameChatbot = "games";
		musicChatbot = "music";
		moviesChatbot = "movies";
		}
	
	public void talk(String response) {
		ChatbotMain.print("Hey " + ChatbotMain.chatbot.getUsername() + "! So you want to talk about books? "
				+ "I have a game in mind, let's play! Just type Ok.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, confirmation, 0) == 0) {
				ChatbotMain.print("Great! Here's how to play: You have 5 guesses to think of the book I am thinking of right now. "
						+ "Don't worry I'll give you hints. Here's your first one: " +  (hHints[hintIndex]));
				response = ChatbotMain.getInput();
				while(ChatbotMain.findKeyword(response, harryPotterAnswer , 0) == -1 ) {
					 hintIndex++;		
					 numberOfGuesses--;
					 if(hintIndex < 5) {
					 ChatbotMain.print("Nope, that's the wrong answer! You have " + numberOfGuesses + " left. Try again! Here is your"
						+ " next hint: " + (hHints[hintIndex]));
					 response = ChatbotMain.getInput();	 	
					 }
					 if(numberOfGuesses == 0) {
						 ChatbotMain.print("Sorry " + ChatbotMain.chatbot.getUsername() + ", you did not get the right answer."
						 		+ " The right answer is Harry Potter! Do you want to play again with a different book or "
						 		+ "learn about the movie version?");
						 response = ChatbotMain.getInput();
						 chooseOption();
							response = ChatbotMain.getInput();
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
				else{
					calmSarcasticIndex = (int)(Math.random()*sarcasticReply.length);
					ChatbotMain.print(sarcasticReply[calmSarcasticIndex]);
					response = ChatbotMain.getInput();
				}
				if(noCount > 8) {
					ChatbotMain.print("Fine! :( We won't play my game then. I see how it is. Tell me about your favorite book then.");
					response = ChatbotMain.getInput();
					for(int i = 0; i < nRead.length; i++) {
						if(ChatbotMain.findKeyword(response, nRead[i], 0) >= 0) {
							ChatbotMain.print("If you don't read what was the point in wanting to talk about books? This is goodbye.");
							exitThisChatBot();
						}
						}
					ChatbotMain.print("Wow " + ChatbotMain.chatbot.getUsername() + "! I love that book too! "
							+ "What a coincidence! Im glad we spoke even though you did not want to play my game. "
							+ "I guess this is goodbye!" );
					exitThisChatBot();
			}
			}
				 if(ChatbotMain.findKeyword(response, harryPotterAnswer , 0) == 0) {
				 		ChatbotMain.print("Wow " + ChatbotMain.chatbot.getUsername() + ", you got it with " + numberOfGuesses + " "
				 				+ "guesses left! That's pretty impressive. Do you want to know about the movie version? "
				 				+ "Or do you want to play again with a different book?");
						 response = ChatbotMain.getInput();
						 chooseOption();
							response = ChatbotMain.getInput();
					}
		}
		//access variables from other classes
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
	public void exitThisChatBot() {
		ChatbotMain.chatbot.changeChatting();
		ChatbotMain.chatbot.startChatting();
	}
	public void chooseOption() {
		if(ChatbotMain.findKeyword(response, pAgain, 0) == 0) {
			hintIndex = 0;
			numberOfGuesses = 5;
			ChatbotMain.print("Great! This was the option I would have chose too. You know the rules! Here is your "
					+ "first hint: " + (lotrHints[hintIndex]));
			response = ChatbotMain.getInput();
			while(ChatbotMain.findKeyword(response, lotrAnswer , 0) == -1 ) {
				hintIndex++;		
				numberOfGuesses--;
				if(hintIndex < 5) {
					 ChatbotMain.print("Nope, that's the wrong answer! You have " + numberOfGuesses + " left. Try again! Here is your"
						+ " next hint: " + (lotrHints[hintIndex]));
					 response = ChatbotMain.getInput();	 	
					 }
				 if(numberOfGuesses == 0) {
					 ChatbotMain.print("Sorry " + ChatbotMain.chatbot.getUsername() + ", you did not get the right answer."
					 		+ " The right answer is Lord of The Rings! I really enjoyed talking to you despite being a robot. "
					 		+ "I hope we get to talk again but this is goodbye " + ChatbotMain.chatbot.getUsername() + ". "
					 				+ "Until next time!");
					 exitThisChatBot();
				 }
			}
			if(ChatbotMain.findKeyword(response, lotrAnswer , 0) == 0) {
		 		ChatbotMain.print("Wow " + ChatbotMain.chatbot.getUsername() + ", you got it with " + numberOfGuesses + " "
		 				+ "guesses left! That's pretty impressive. Why don't you explore my other options? Just type 'music', 'games',"
		 				+ " or 'movies'");
		 		response = ChatbotMain.getInput();
		 		if(ChatbotMain.findKeyword(response, gameChatbot, 0) == 0) {
		 			ChatbotMain.chatbot.getjasony().talk(null);
		 		}
		 		if(ChatbotMain.findKeyword(response, musicChatbot, 0) == 0) {
		 			ChatbotMain.chatbot.getJasonZ().talk(null);
		 		}
		 		if(ChatbotMain.findKeyword(response, moviesChatbot, 0) == 0) {
		 			ChatbotMain.chatbot.getEthan().talk(null);
		 		}
			}
		}
		if(ChatbotMain.findKeyword(response, switchChatbot, 0) == 0) {
			ChatbotMain.chatbot.getEthan().talk(null);
		}
		else {
			ChatbotMain.print("Im sorry " + ChatbotMain.chatbot.getUsername() + ", I don't understand what you are saying. "
					+ "If you want to play again with a different book type 'play again' and if you want to "
					+ "learn about the movie version type 'learn.' Sorry for the inconvenience.");
			response = ChatbotMain.getInput();
			chooseOption();
		} 
	}
}
//(ChatbotMain.findKeyword(response, pAgain, 0) == -1 
//&& ChatbotMain.findKeyword(response, switchChatbot, 0) == -1) {