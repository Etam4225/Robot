package chatbot;

public class ChatbotEthan implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String response;
	
	private String[] annoyed;
	private boolean saidYesorNo;
	private int annoyedCounter;

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
	
	private double myRandNum;
	
	private String YES;
	private String NO;
	private String START;
	
	public ChatbotEthan() {
		String[] temp = {"movie", "movies"};
		keywords = temp;
		goodbyeKeyword = "bye";
		
		String[] botAnnoyed = {"Just say yes or no >:(", "....", "for real tho pls", "Stop abusing the bot!", "ok this is your last chance to say yes or no."};
		annoyed = botAnnoyed;
		saidYesorNo = false;
		annoyedCounter = 0;
		
		response = "";
				
		String[] myMovieArray = {"Lord of the Rings" ,"Harry Potter"};
		movieArray = myMovieArray;
		chosenMovie = "";
		String[] mylordHints = {"The movie takes place in the Middle earth", "There is a famous character called Frodo Baggins", "There is a ring involved *wink wink*"};
		lordHints = mylordHints;
		String[] myharryHints = {"Ever heard of the term Wingardium Leviosa?", "One word: Hogwarts", "Okay ever heard of someone called Harry?"};
		harrypotterHints = myharryHints;
		incorrectAnswer = true;
		hintCounter = 0;
		strikeCounter = 0;
		lordPick = false;
		
		String[] movieIwatch = {"Lord of the Rings", "Harry Potter"};
		movieBotWatch = movieIwatch;
		watchMovie = false;
		userMovieWatch = "";
		
		myRandNum = 0;
		
		//CONSTANTS
		YES = "yes";
		NO = "no";
		START = "start";
		
	}

	public void talk(String response) {
		printMessage("So what's your favorite movie, " +ChatbotMain.chatbot.getUsername()+ "?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			//response = ChatbotMain.getInput();
			userMovieWatch = response;
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
			while(!saidYesorNo) {
				response = ChatbotMain.getInput();
				if(ChatbotMain.findKeyword(response, YES, 0) >= 0 && response.length() == 3) {
					printMessage("Good to know "+ ChatbotMain.chatbot.getUsername() + "! So do you want to play a game called Guess the Movie? Say start and we can start!");
					saidYesorNo = true;
					response = ChatbotMain.getInput();
					if(ChatbotMain.findKeyword(response, START, 0) >= 0) {
						initiateGame();
					}
					else {
						printMessage("Not playing huh? I dont have much else for you :/");
						goToDiffChatBot();
					}
				}
				else {
					if(ChatbotMain.findKeyword(response, NO, 0) >= 0 && response.length() == 2) {
						printMessage("Ah shucks "+ ChatbotMain.chatbot.getUsername() + "...still wanna play a game anyways? If you say start ill start a game!");
						saidYesorNo = true;
						response = ChatbotMain.getInput();
						if(ChatbotMain.findKeyword(response, START, 0) >= 0) {
							initiateGame();
						}
						else {
							printMessage("Guess you aren't playing, huh? OK then laters");
							goToDiffChatBot();
						}
					}
					else {
						if(!saidYesorNo) {
							printMessage(annoyed[annoyedCounter]);
							if(annoyedCounter == 4) {
								printMessage("alright im done with you, " +ChatbotMain.chatbot.getUsername()+". Bye.");
								goToDiffChatBot();
							}
							else {
								annoyedCounter++;
							}
						}
					}
				}	
			}	
		}
		goToDiffChatBot();
		printMessage("Bye!");
	}
	public void printMessage(String message) {
		ChatbotMain.print(message);
	}
	public void goToDiffChatBot() {
		if(watchMovie) {
			printMessage("Hey since you watched " +userMovieWatch+ ",if you want to go to the other bots just say music or book");
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, "Music", 0) >= 0 && userMovieWatch.equals(movieBotWatch[0])) {
				ChatbotMain.chatbot.getJasonZ().talk(null);
			}
			if(ChatbotMain.findKeyword(response, "Music", 0) >= 0 && !userMovieWatch.equals(movieBotWatch[0])){
				printMessage("I'm sorry but the Music Chatbot doesn't have Harry Potter programmed.");
				exitThisChatBot();
			}
			if(ChatbotMain.findKeyword(response, "Book", 0) >= 0) {
				ChatbotMain.chatbot.getDavid().talk(null);
			}
		}else {
			exitThisChatBot();
		}
	}
	public void exitThisChatBot() {
		ChatbotMain.chatbot.changeChatting();
		ChatbotMain.chatbot.startChatting();
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
				printMessage("Heh, looks like I won, "+ ChatbotMain.chatbot.getUsername() + ". See you again when you can get it right.");
				incorrectAnswer = false;
				goToDiffChatBot();
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
				printMessage("Wow....guess you beat me good...GG");
				incorrectAnswer = false;
				goToDiffChatBot();
			}else {
				strikeCounter++;
				printMessage("You have " +strikeCounter+ " strike(s) now");
			}
			hintCounter++;
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
