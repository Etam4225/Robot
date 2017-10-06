package chatbot;

import java.util.Arrays;

public class ChatbotJasonZ implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String[] songs;
	private String[] songs1;
	private String[] songs2;
	private static String lResponse;
	private int quiter; 
	
	public ChatbotJasonZ() {
		String[] Songs = {"The Shadow of the Past","A Knife in the Dark","Flight to the Ford","Many Meeting","The Council of Elrond","The Ring goes South","The Bridge of Khazad Dum","Lothlorien", "Amon Hend","The Breaking of the Fellowship","May it be"};
		String[] Songs1 = {"The Shadow of the Past","A Knife in the Dark","Flight to the Ford","Many Meeting","The Council of Elrond"};
		String[] Songs2 = {"The Ring goes South","The Bridge of Khazad Dum","Lothlorien", "Amon Hend","The Breaking of the Fellowship","May it be"};
		String[] temp = {"lord of the ring's music", "lord of the rings music", "music"};
		songs = Songs;
		songs1 = Songs1;
		songs2 = Songs2;
		keywords = temp;
		quiter = 0;
		goodbyeKeyword = "bye";
		secretKeyword = "Concerning Hobbits";
		response = "";
		lResponse = " "; 
	}

	@Override
	public void talk(String response) {
		if(response != null)
		{
			ChatbotMain.print("Hey! So you want to talk about songs from the Fellowship of the Ring? How about a random song?");
		}
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Wow I love that song! isn't the title amazing?.");
				response = ChatbotMain.getInput();
			}
			if(quiter == 3)
			{
				lResponse = null;
				ChatbotMain.chatbot.startChatting();
			}
			
			checkRepitition(response);
			chooseResponse(response);
		}
		//access variables from other classes
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
		
	}
	
	private void chooseResponse(String response) {
		
		int rand = (int) (Math.floor(Math.random()*11));
		if(ChatbotMain.findKeyword(response, "Yes", 0) >= 0)
		{
			sendResponse(response, rand, infoGetter("whichSong", songs[rand]));
		}
		else 
		{
			
			if(ChatbotMain.findKeyword(response, "no", 0) >= 0)
			{
				ChatbotMain.print("What song in the Fellowship of the Ring do you want to talk about " +ChatbotMain.chatbot.getUsername()+ "?");
			}
			else
			{
					int songidx = infoGetter("songindx", response);
					sendResponse(response, songidx, infoGetter("whichSong", songs[rand]));
			}
		}
		response = ChatbotMain.getInput();
	}

	private void  turnBack(){
		talk(null);
	}
	//look at the code with strings w/ #s;
	private void checkRepitition(String response) {
		if(ChatbotMain.findKeyword(response, "yes", 0) >= 0 && lResponse.equals("yes"))
		{
			ChatbotMain.print("????");
			quiter ++;
			turnBack();
		}
		if(ChatbotMain.findKeyword(lResponse, response, 0) >= 0 )
		{
			ChatbotMain.print("I already responded to that. Do you want a random song");
			quiter ++;
			turnBack();
		}
		lResponse = response;
	}

	private void sendResponse(String response2, int songIndex, int check) {
		if( check == 1)
		{
			ChatbotMain.print("Wow! You know"+ songs[songIndex] +" is so good that we can feel the heroism and adventure in the Fellowship Theme, the warm simplicity and desire for home invoked by the Hobbits' Theme, and the dark seduction of Ring's Theme.");
		}
		else 
		{
			if(check == 2)
			{
				ChatbotMain.print("Wow! You know in "+ songs[songIndex] +", the female choir is deeper, there are more solo strings, and some lower percussion from the bass drums.");	
			}
			else 
			{
				ChatbotMain.print("I don't have that song programmed, or it isn't a song");
			}
		}
	}

	private int infoGetter(String needed, String response) {
		int needInfo = 0;
		if(needed.equals("songindx"))
		{
			for(int i = 0; i < songs.length; i++)
			{
				if(ChatbotMain.findKeyword(songs[i], response, 0) >= 0)
				{
					needInfo = i; 
				}
			}
		}
		else
		{
			
			for(int i = 0; i< songs1.length; i++)
			{
				if(ChatbotMain.findKeyword(response, songs1[i], 0) >= 0)
				{
					needInfo = 1;

				}
			}
			
			for(int i = 0; i<songs2.length; i++)
			{
				if(ChatbotMain.findKeyword(response, songs2[i], 0) >= 0)
				{
					needInfo = 2;
				}
			}
			
		}
		return needInfo;
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
