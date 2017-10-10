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
	private boolean nonResponse;
	private boolean link;
	private String songLiked;
	private String genreLiked;
	private String[] infoQuestions;
	private int timeAsked;
	private boolean obtainingInformation;
	
	public ChatbotJasonZ() {
		String[] Songs = {"The Shadow of the Past","A Knife in the Dark","Flight to the Ford","Many Meeting","The Council of Elrond","The Ring goes South","The Bridge of Khazad Dum","Lothlorien", "Amon Hend","The Breaking of the Fellowship","May it be"};
		String[] Songs1 = {"The Shadow of the Past","A Knife in the Dark","Flight to the Ford","Many Meeting","The Council of Elrond"};
		String[] Songs2 = {"The Ring goes South","The Bridge of Khazad Dum","Lothlorien", "Amon Hend","The Breaking of the Fellowship","May it be"};
		String[] temp = {"lord of the ring's music", "lord of the rings music", "music"};
		String[] infoquestion = {"What's your favorite Movie?", "What's your favorite genre for songs?"};
		infoQuestions = infoquestion;
		songs = Songs;
		songs1 = Songs1;
		songs2 = Songs2;
		keywords = temp;
		quiter = 0;
		goodbyeKeyword = "bye";
		secretKeyword = "Concerning Hobbits";
		response = "";
		lResponse = " ";
		nonResponse = false;
		link = false;
		obtainingInformation = true;
		timeAsked = 0;
		songLiked = "";
	}

	@Override
	public void talk(String response) {
		if(response != null)
		{
			ChatbotMain.print("Hey! So you want to talk about songs from the Fellowship of the Ring? How about a random song? Respond with yes or no.");
			response = ChatbotMain.getInput();
		}
		learnInformation();
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Wow I love that song! isn't the title amazing?.");
			}
			if(quiter == 3)
			{
				lResponse = null;
				ChatbotMain.chatbot.startChatting();
			}
			checkRepitition(response);
			if(nonResponse == true)
			{
				chooseNonResponse(response);
			}
			else 
			{
				chooseResponse(response);
			}
		
			
		}
		//access variables from other classes
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
		
	}
	
	private void learnInformation() {
		ChatbotMain.print("First, let me know about you.");
		pause(1000);
		ChatbotMain.print(infoQuestions[0]);
		response = ChatbotMain.getInput();
		songLiked = response;
		for(int i = 0; i <= songs.length; i++)
		{
			if(ChatbotMain.findKeyword(songs[i], response, 0) >= 0)
			{
				ChatbotMain.print("That's nice, you like a song from the Fellowship of the Ring!");
			}
			else 
			{
				ChatbotMain.print("Aw isn't that a shame, "+ songLiked +" isn't from Fellowship of the Ring");
			}
		}
		
		ChatbotMain.print(infoQuestions[1]);
		response = ChatbotMain.getInput(); 
		genreLiked = response;
		obtainingInformation = false;
	}

	private void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void chooseNonResponse(String response) {
		if(infoGetter("songindx", response) >= 0 )
		{
			chooseResponse(response);
		}
		else 
		{
			if(link != true)
			{
				ChatbotMain.print("Alright, choose between movies and books.");
				link = true;
			}
			
		}
		
		if(link == true && ChatbotMain.findKeyword(response, "movies", 0) >= 0)
		{
			ChatbotMain.chatbot.getEthan().talk(null);
		}
		else 
		{
			if(ChatbotMain.findKeyword(response, "book", 0) >= 0)
			{
				ChatbotMain.chatbot.getDavid().talk(null);
			}
		}
		turnBack();
	}

	private void chooseResponse(String response) {
		
		int rand = (int) (Math.floor(Math.random()*11));
		if(ChatbotMain.findKeyword(response, "Yes", 0) >= 0)
		{
			sendResponse(response, rand, infoGetter("whichSong", songs[rand]), checkIfFavorite(response));
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
					sendResponse(response, songidx, infoGetter("whichSong", songs[rand]), checkIfFavorite(songs[songidx]));
			}
		}
		turnBack();
	}

	private boolean checkIfFavorite(String string) {
		if(ChatbotMain.findKeyword(response, songLiked, 0) >= 0)
		{
			return true;
		}
		return false;
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
		if(ChatbotMain.findKeyword(response, lResponse, 0) >= 0 )
		{
			if(quiter == 0)
			{
				ChatbotMain.print("I already responded to that. Do you want a random song?");
			}
			else
			{
				if(quiter == 1)
				{
					ChatbotMain.print("Please resond with something else");
				}
				else 
				{
					if(quiter == 2)
					{
						ChatbotMain.print(".....");
					}
				}
			}
			quiter ++;
			turnBack();
		}
		else 
		{
			quiter = 0;
		}
		lResponse = response;
	}

	private void sendResponse(String response2, int songIndex, int check, boolean favorite) {
		if(songIndex >= 0)
		{
			if( check == 1 && favorite == true)
			{
				ChatbotMain.print("Wow! You know your favorite song, "+ songs[songIndex] +" is so good that we can feel the heroism and adventure in the Fellowship Theme, the warm simplicity and desire for home invoked by the Hobbits' Theme, and the dark seduction of Ring's Theme.");
			}
			else 
			{
				ChatbotMain.print("Wow! You know "+ songs[songIndex] +" is so good that we can feel the heroism and adventure in the Fellowship Theme, the warm simplicity and desire for home invoked by the Hobbits' Theme, and the dark seduction of Ring's Theme.");
			}
			
			if(check == 2 && favorite == true)
			{
				ChatbotMain.print("Wow! You know in your favorite song, "+ songs[songIndex] +", the female choir is deeper, there are more solo strings, and some lower percussion from the bass drums.");	
				
			}
			else
			{
				ChatbotMain.print("Wow! You know in "+ songs[songIndex] +", the female choir is deeper, there are more solo strings, and some lower percussion from the bass drums.");	
			}
		}
		else 
		{
			ChatbotMain.print("I don't have that song programmed, or it isn't a song. Please respond with the name of a song from the Fellowship of the ring.");
			nonResponse = true;
		}
		turnBack();
	}

	private int infoGetter(String needed, String response) {
		int needInfo = -1;
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
				if(ChatbotMain.findKeyword(songs1[i], response, 0) >= 0)
				{
					needInfo = 1;

				}
			}
			
			for(int i = 0; i<songs2.length; i++)
			{
				if(ChatbotMain.findKeyword(songs2[i], response, 0) >= 0)
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
