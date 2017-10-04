package chatbot;

public class ChatbotEthan implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	
	private String[] annoyed;
	private boolean saidYesorNo;
	private int annoyedCounter;
	
	private String previousInput;
	private int convoCount;

	private String[] movieArray;
	private String chosenMovie;
	private boolean guessedMovie;
	private String[] lordHints;
	private String[] harrypotterHints;
	
	private String[] movieQuestionArray;
	
	private double myRandNum;
	
	//CONSTANTS
	private String YES;
	private String NO;
	private String START;
	
	public ChatbotEthan() {
		String[] temp = {"movie"};
		keywords = temp;
		goodbyeKeyword = "bye";
		
		String[] botAnnoyed = {"Just say yes or no >:(", "...", "for real tho pls", "seriously. stop", "ok this is your last chance to say yes or no."};
		annoyed = botAnnoyed;
		saidYesorNo = false;
		annoyedCounter = 0;
		
		secretKeyword = "N/A";
		response = "";
		convoCount = 0; //dupe responses doesnt work yet
		
		String[] myMovieArray = {"Lord of the Rings"};
		movieArray = myMovieArray;
		chosenMovie = "";
		guessedMovie = false;
		String[] mylordHints = {"hint1"};
		lordHints = mylordHints;
		String[] myharryHints = {"hint1"};
		harrypotterHints = myharryHints;
		
		myRandNum = 0;
		
		//CONSTANTS
		YES = "yes";
		NO = "no";
		START = "start";
	}

	public void talk(String response) {
		printMessage("You wanna talk about movies n stuff yea? So, " +ChatbotMain.chatbot.getUsername()+ ", you like movies? Yes or no?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			while(!saidYesorNo) {
				/*previousInput = response;
				if(previousInput.equals(response) && convoCount >= 1) {
					printMessage("Ever thought of saying something unique?");
					sameInput = true;
				}*/
				if(ChatbotMain.findKeyword(response, YES, 0) >= 0 && response.length() == 3) {
					printMessage("Good to know "+ ChatbotMain.chatbot.getUsername() + "! So do you want to play a game called Guess the Movie? Say start and we can start!");
					saidYesorNo = true;
					response = ChatbotMain.getInput();
					if(ChatbotMain.findKeyword(response, START, 0) >= 0) {
						initiateGame();
						//start the guessing game
					}
					else {
						
						//exit and ask diff question etc.?
					}
				}
				if(ChatbotMain.findKeyword(response, NO, 0) >= 0 && response.length() == 2) {
					printMessage("Ah shucks "+ ChatbotMain.chatbot.getUsername() + "...still wanna play a game anyways? If you say start ill start a game!");
					saidYesorNo = true;
					response = ChatbotMain.getInput();
					if(ChatbotMain.findKeyword(response, START, 0) >= 0) {
						initiateGame();
						//start guessing game
					}
					else {
		
					}
				}
				else {
					if(!saidYesorNo) {
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
				convoCount++;
				
			}
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("I can't even. I love pugs so much. Wow. You are so cool.");
				response = ChatbotMain.getInput();
				//remove?
			}
				response = ChatbotMain.getInput();
			
		}
		//access variables from other classes
		ChatbotMain.print("Well, it was nice talking to you, " +ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
	
	}
	public void printMessage(String message) {
		ChatbotMain.print(message);
	}
	/*public String getPreviousInput() {
		return this.previousInput;
	} dont need? */
	public double createRandNum() {
		myRandNum = Math.random();
		return myRandNum;
	}
	public void initiateGame() {
		if(myRandNum < 1) {
			chosenMovie = movieArray[0];
		}
		//printMessage(chosenMovie + " is the movie that I want you to guess"); movie is chosen *works*
		printMessage("Ok I have chosen the movie >:). Ill give you hints till you guess the movie I chose!");
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
