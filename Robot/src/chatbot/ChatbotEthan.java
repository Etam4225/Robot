package chatbot;

public class ChatbotEthan implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String response;
	
	private String[] annoyed;
	private boolean saidYesorNo;
	private int annoyedCounter;
	
	private String previousInput;
	private int convoCount;

	private String[] movieArray;
	private String chosenMovie;
	private String[] lordHints;
	private String[] harrypotterHints;
	private boolean incorrectAnswer;
	private int hintCounter;
	private int strikeCounter;
	private boolean lordPick;
	
	private String userMovieWatch;
	private String[] movieBotWatch;
	private boolean watchMovie;
	
	//private String[] movieQuestionArray; DONT NEED YET NOT IMPLEMENTED
	
	private double myRandNum;
	
	//CONSTANTS
	private String YES;
	private String NO;
	private String START;
	
	public ChatbotEthan() {
		String[] temp = {"movie", "movies"};
		keywords = temp;
		goodbyeKeyword = "bye";
		
		String[] botAnnoyed = {"Just say yes or no >:(", "...", "for real tho pls", "seriously. stop", "ok this is your last chance to say yes or no."};
		annoyed = botAnnoyed;
		saidYesorNo = false;
		annoyedCounter = 0;
		
		response = "";
		
		convoCount = 0; 
		
		String[] myMovieArray = {"Lord of the Rings" ,"Harry Potter"};
		movieArray = myMovieArray;
		chosenMovie = "";
		String[] mylordHints = {"The movie takes place in the Middle earth", "There is a famous character called Frodo Baggins", "There is a ring involved *wink wink*"};
		lordHints = mylordHints;
		String[] myharryHints = { "Ever heard of the term Wingardium Leviosa?", "One word: Hogwarts", "Okay ever heard of someone called Harry?"};
		harrypotterHints = myharryHints;
		incorrectAnswer = true;
		hintCounter = 0;
		strikeCounter = 0;
		lordPick = false;
		
		String[] movieIwatch = {"Star Wars", "Lord of the Rings", "Harry Potter"};
		movieBotWatch = movieIwatch;
		watchMovie = false;
		
		myRandNum = 0;
		
		//CONSTANTS
		YES = "yes";
		NO = "no";
		START = "start";
		
		//chatbotmain.chatbot.getMYTOPIC.isTriggered(response);
	}

	public void talk(String response) {
		printMessage("So what's your favorite movie, " +ChatbotMain.chatbot.getUsername()+ "?");
		response = ChatbotMain.getInput();
		previousInput = response;
		userMovieWatch = previousInput;
		for(int i = 0; i < movieBotWatch.length; i++) {
			if(ChatbotMain.findKeyword(response, movieBotWatch[i], 0) >= 0) {
				printMessage("Wow I watched " + movieBotWatch[i] + " too!");
				watchMovie = true;
			} 
		}
		if(!watchMovie) {
			printMessage("Ah, I didn't watch " + userMovieWatch);
		}
		printMessage("So, " +ChatbotMain.chatbot.getUsername()+ ", you like movies in general? Yes or no?");
		response = ChatbotMain.getInput();
		//previousInput = response;
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			checkDupeResponse();
			while(!saidYesorNo) {
				if(ChatbotMain.findKeyword(response, YES, 0) >= 0 && response.length() == 3) {
					printMessage("Good to know "+ ChatbotMain.chatbot.getUsername() + "! So do you want to play a game called Guess the Movie? Say start and we can start!");
					saidYesorNo = true;
					response = ChatbotMain.getInput();
					if(ChatbotMain.findKeyword(response, START, 0) >= 0) {
						initiateGame();
					}
					else {
						printMessage("uh....okay so is there anything else you want me to talk about");
					}
				}
				else {
					if(ChatbotMain.findKeyword(response, NO, 0) >= 0 && response.length() == 2) {
						checkDupeResponse();
						printMessage("Ah shucks "+ ChatbotMain.chatbot.getUsername() + "...still wanna play a game anyways? If you say start ill start a game!");
						saidYesorNo = true;
						response = ChatbotMain.getInput();
						if(ChatbotMain.findKeyword(response, START, 0) >= 0) {
							initiateGame();
						}
						else {
							printMessage("uh....okay so is there anything else you want me to talk about? or u wanna leave?");
							//ask for his favorite movie? have an array of movies chatbot "watched"?
							//if its something youve watched and it has a book related to it and link to book?
						}
					}
					else {
						if(!saidYesorNo) {
							checkDupeResponse();
							printMessage(annoyed[annoyedCounter]);
							response = ChatbotMain.getInput();
							if(annoyedCounter == 4) {
								printMessage("alright im done with you, " +ChatbotMain.chatbot.getUsername()+". Bye.");
								annoyedCounter = 0;
								ChatbotMain.chatbot.startChatting();
							}
							else {
								annoyedCounter++;
							}
						}
					}
				}	
			}
				response = ChatbotMain.getInput();
			
		}
		printMessage("Guess you don't feel like playing eh? Bye then I suppose. I'll make sure to watch " + userMovieWatch + " when I can " + ChatbotMain.chatbot.getUsername() + "!" );
		ChatbotMain.chatbot.startChatting();
	
	}
	public void printMessage(String message) {
		ChatbotMain.print(message);
	}
	public void checkDupeResponse() {
		if(previousInput.equals(response) && convoCount > 0) {
			printMessage("Ever thought of saying something unique?");
		}
		convoCount++;
	}
	public void initiateGame() {
		myRandNum = Math.random();
		if(myRandNum < .5) {
			chosenMovie = movieArray[0];
			lordPick = true;
		}
		else {
			chosenMovie = movieArray[1];
		}
		printMessage("Ok I have chosen the movie >:). Ill give you hints till you guess the movie I chose! The rules are simple. Guess the movie and you win...3 strikes and you lose.");
		incorrectAnswer = true;
		while(incorrectAnswer) {
			if(strikeCounter == 3) {
				printMessage("Heh, looks like I won, "+ ChatbotMain.chatbot.getUsername());
				response = ChatbotMain.getInput();
				incorrectAnswer = false;
			}
			else {
				if(hintCounter < lordHints.length && lordPick) {
					printMessage("Heres the #"+ (hintCounter + 1) +" hint: " + lordHints[hintCounter]);
				}
				else {
					printMessage("Heres the #"+ (hintCounter + 1) +" hint: " + harrypotterHints[hintCounter]);
				}
			}
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, chosenMovie, 0) >= 0) {
				printMessage("HOLY SMOKES! YOU GUESSED THE MOVIE! SWEETNESS!");
				incorrectAnswer = false;
			}else {
				strikeCounter++;
				printMessage("You have " +strikeCounter+ " strike(s) now");
			}
			hintCounter++;
		}
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
