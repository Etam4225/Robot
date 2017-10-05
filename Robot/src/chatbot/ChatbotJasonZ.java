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
	private String[] recordedReponses;
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
		if(ChatbotMain.findKeyword(response, "Yes", 0) >= 0)
		{
			double rand = Math.random();
			if(rand <= .09)
			{
				sendResponse(response, 0, 1);
			}
			else 
			{
				if(rand <= .18)
				{
					sendResponse(response, 1, 1);
				}
				else 
				{
					if(rand <= .27)
					{
						sendResponse(response, 2, 1);
					}
					else 
					{
						if(rand <= .36)
						{
							sendResponse(response, 3, 1);
						}
						else 
						{
							if(rand <= .45)
							{
								sendResponse(response, 4, 2);
							}
							else 
							{
								if(rand <= .55)
								{
									sendResponse(response, 5, 2);
								}
								else 
								{
									if(rand <= .64)
									{
										sendResponse(response, 6, 2);
									}
									else 
									{
										if(rand <= .73)
										{
											sendResponse(response, 7, 2);
										}
										else 
										{
											if(rand <= .82)
											{
												sendResponse(response, 8, 2);
											}
											else 
											{
												if(rand <= .91)
												{
													sendResponse(response, 9, 2);
												}
												else 
												{
		
														sendResponse(response, 10, 2);
												}
											}
										}
									}
								}
							}
						}
					}
				}
				
			}
		}
		else 
		{
			
			if(ChatbotMain.findKeyword(response, "no", 0) >= 0)
			{
				ChatbotMain.print("What song in the Fellowship of the Ring do you want to talk about " +ChatbotMain.chatbot.getUsername()+ "?");
			}
			else
			{
				int songindx = 0;
				int whichArray = 0;
				String songCheck = checkWhichSong(response);
				
				if(songCheck != "")
				{
					try 
					{
						songindx = Integer.parseInt(songCheck.substring(1, 2));
					}
					catch(java.lang.StringIndexOutOfBoundsException r)
					{
						exceptionRes(response);
					}
					if(songindx == -1)
					{
						exceptionRes(response);
					}
					try
					{
						whichArray = Integer.parseInt(songCheck.substring(0,1));
					}
					catch(java.lang.StringIndexOutOfBoundsException e)
					{
						exceptionRes(response);
					}
					sendResponse(response,songindx, whichArray);
				}
				else 
				{
					ChatbotMain.print(".");
				}
			}
		}
		response = ChatbotMain.getInput();
	}

	private void  turnBack(){
		ChatbotMain.chatbot.getJasonZ().talk(null);
	}

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

	private void exceptionRes(String Response) {
		ChatbotMain.print(Response+" not recognized.");
		turnBack();
		
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

	private String checkWhichSong(String resp) {
		String locationOfSong = "";
		int songIndx = -1;
		for(int i = 0; i < songs.length; i++)
		{
			if(ChatbotMain.findKeyword(songs[i], resp, 0) >= 0)
			{
				songIndx = i; 
			}
		}
		for(int i = 0; i< songs1.length; i++)
		{
			if(ChatbotMain.findKeyword(songs1[i], resp, 0) >= 0)
			{
				locationOfSong += 1; 
				locationOfSong += songIndx; 
			}
		}
		for(int i = 0; i<songs2.length; i++)
		{
			if(ChatbotMain.findKeyword(songs2[i], resp, 0) >= 0)
			{
				locationOfSong += 2; 
				locationOfSong += songIndx;
			}
		}
		return locationOfSong;
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
