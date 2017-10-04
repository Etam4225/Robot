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
	private String lResponse;
	
	public ChatbotJasonZ() {
		String[] Songs = {"The Shadow of the Past","A Knife in the Dark","Flight to the Ford","Many Meeting","The Council of Elrond","The Ring goes South","The Bridge of Khazad Dum","Lothlorien", "Amon Hend","The Breaking of the Fellowship","May it be"};
		String[] Songs1 = {"The Shadow of the Past","A Knife in the Dark","Flight to the Ford","Many Meeting","The Council of Elrond"};
		String[] Songs2 = {"The Ring goes South","The Bridge of Khazad Dum","Lothlorien", "Amon Hend","The Breaking of the Fellowship","May it be"};
		String[] temp = {"lord of the ring's music", "lord of the rings music", "music"};
		songs = Songs;
		songs1 = Songs1;
		songs2 = Songs2; 
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "Concerning Hobbits";
		response = "";
		lResponse = "";
	}

	@Override
	public void talk(String response) {
		ChatbotMain.print("Hey! So you want to talk about songs from the Fellowship of the Ring? How about a random song?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Wow I love that song! isn't the title amazing?.");
				response = ChatbotMain.getInput();
			}
			checkRepitition(response);
			if(ChatbotMain.findKeyword(response, "Yes", 0) >= 0)
			{
				double rand = Math.random();
				if(rand <= .09)
				{
					sendResponse(response, 0, 1);
					response = ChatbotMain.getInput();
				}
				else 
				{
					if(rand <= .18)
					{
						sendResponse(response, 1, 1);
						response = ChatbotMain.getInput();
					}
					else 
					{
						if(rand <= .27)
						{
							sendResponse(response, 2, 1);
							response = ChatbotMain.getInput();
						}
						else 
						{
							if(rand <= .36)
							{
								sendResponse(response, 3, 1);
								response = ChatbotMain.getInput();
							}
							else 
							{
								if(rand <= .45)
								{
									sendResponse(response, 4, 2);
									response = ChatbotMain.getInput();
								}
								else 
								{
									if(rand <= .55)
									{
										sendResponse(response, 5, 2);
										response = ChatbotMain.getInput();
									}
									else 
									{
										if(rand <= .64)
										{
											sendResponse(response, 6, 2);
											response = ChatbotMain.getInput();
										}
										else 
										{
											if(rand <= .73)
											{
												sendResponse(response, 7, 2);
												response = ChatbotMain.getInput();
											}
											else 
											{
												if(rand <= .82)
												{
													sendResponse(response, 8, 2);
													response = ChatbotMain.getInput();
												}
												else 
												{
													if(rand <= .91)
													{
														sendResponse(response, 9, 2);
														response = ChatbotMain.getInput();
													}
													else 
													{
			
															sendResponse(response, 10, 2);
															response = ChatbotMain.getInput();
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
					ChatbotMain.print("What song do you want to talk about " +ChatbotMain.chatbot.getUsername()+ "?");
					lResponse = response;
				}
				else
				{
					int songindx = 0;
					int whichArray = 0;
					String songCheck = checkWhichSong(response);
					if(songCheck == "")
					{
						exceptionRes();
					}
					try 
					{
						songindx = Integer.parseInt(songCheck.substring(1, 2));
					}
					catch(java.lang.StringIndexOutOfBoundsException r)
					{
						exceptionRes();
					}
					if(songindx == -1)
					{
						exceptionRes();
					}
					try
					{
						whichArray = Integer.parseInt(songCheck.substring(0,1));
					}
					catch(java.lang.StringIndexOutOfBoundsException e)
					{
						exceptionRes();
					}
					sendResponse(response,songindx, whichArray);
				}
			}
			response = ChatbotMain.getInput();
		}
		//access variables from other classes
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
		
	}
	
	private void checkRepitition(String response2) {
		if(lResponse.equals(response2))
		{
			ChatbotMain.print("I already responded to that.");
			ChatbotMain.getInput();
		}
		lResponse = response2;
	}

	private void exceptionRes() {
		ChatbotMain.print("Not recognized.");
		ChatbotMain.getInput();
		
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
