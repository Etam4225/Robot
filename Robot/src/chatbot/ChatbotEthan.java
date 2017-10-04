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
	private boolean sameInput;
	
	private String YES;
	private String NO;
	
	public ChatbotEthan() {
		String[] temp = {"movie", "Lord of the Rings", "watch"};
		keywords = temp;
		goodbyeKeyword = "bye";
		String[] botAnnoyed = {"Just say yes or no >:(", "...", "for real tho pls", "seriously. stop", "ok this is your last chance to say yes or no."};
		annoyed = botAnnoyed;
		secretKeyword = "N/A";
		response = "";
		saidYesorNo = false;
		annoyedCounter = 0;
		convoCount = 0;
		sameInput = false;
		
		YES = "yes";
		NO = "no";
	}

	public void talk(String response) {
		printMessage("You wanna talk about movies n stuff yea? So, " +ChatbotMain.chatbot.getUsername()+ ", you like movies? Yes or no?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			while(!saidYesorNo) {
				previousInput = response;
				if(previousInput.equals(response) && convoCount >= 1) {
					printMessage("Ever thought of saying something unique?");
					sameInput = true;
				}
				if(ChatbotMain.findKeyword(response, YES, 0) >= 0 && response.length() == 3) {
					printMessage("Good to know "+ ChatbotMain.chatbot.getUsername() + "!");
					saidYesorNo = true;
				}
				if(ChatbotMain.findKeyword(response, NO, 0) >= 0 && response.length() == 2) {
					printMessage("Ah shucks "+ ChatbotMain.chatbot.getUsername() + "...still wanna play a game anyways?");
					saidYesorNo = true;
				}
				else {
					printMessage(annoyed[annoyedCounter]);
					response = ChatbotMain.getInput();
					if(annoyedCounter == 4) {
						printMessage("alright im done with you, " +ChatbotMain.chatbot.getUsername()+". Bye.");
						ChatbotMain.chatbot.startChatting();
					}
					else {
						annoyedCounter++;
					}
				}
				sameInput = false;
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
