package chatbot;

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
			
			if(ChatbotMain.findKeyword(response, "Yes", 0) >= 0)
			{
				double rand = Math.random();
				if(rand <= .09)
				{
					sendResponse(response, 0);
					response = ChatbotMain.getInput();
					countineTalkingAboutSubject(response, 0);
				}
				else 
				{
					if(rand <= .18)
					{
						sendResponse(response, 1);
						response = ChatbotMain.getInput();
						countineTalkingAboutSubject(response, 1);
					}
					else 
					{
						if(rand <= .27)
						{
							sendResponse(response, 2);
							response = ChatbotMain.getInput();
							countineTalkingAboutSubject(response, 2);
						}
						else 
						{
							if(rand <= .36)
							{
								sendResponse(response, 3);
								response = ChatbotMain.getInput();
								countineTalkingAboutSubject(response, 3);
							}
							else 
							{
								if(rand <= .45)
								{
									sendResponse(response, 4);
									response = ChatbotMain.getInput();
									countineTalkingAboutSubject(response, 4);
								}
								else 
								{
									if(rand <= .55)
									{
										sendResponse(response, 5);
										response = ChatbotMain.getInput();
										countineTalkingAboutSubject(response, 5);
									}
									else 
									{
										if(rand <= .64)
										{
											sendResponse(response, 6);
											response = ChatbotMain.getInput();
											countineTalkingAboutSubject(response, 6);
										}
										else 
										{
											if(rand <= .73)
											{
												sendResponse(response, 7);
												response = ChatbotMain.getInput();
												countineTalkingAboutSubject(response, 7);
											}
											else 
											{
												if(rand <= .82)
												{
													sendResponse(response, 8);
													response = ChatbotMain.getInput();
													countineTalkingAboutSubject(response, 8);
												}
												else 
												{
													if(rand <= .91)
													{
														sendResponse(response, 9);
														response = ChatbotMain.getInput();
														countineTalkingAboutSubject(response, 9);
													}
													else 
													{
			
															sendResponse(response, 10);
															response = ChatbotMain.getInput();
															countineTalkingAboutSubject(response, 10);
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
				ChatbotMain.print("Yeah. That's pretty cool. But there are things I like even more. Tell me something else.");
				lResponse = response;
				response = ChatbotMain.getInput();
			}
		}
		//access variables from other classes
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
		
	}
	
	private void sendResponse(String response2, int songIndex) {
		if(lResponse.equals(response2))
		{
			ChatbotMain.print("I already responded to that.");
		}
		if(ChatbotMain.findKeyword(response2, "yes", 0) >= 0 )
		{
			if(checkIfInSong1(songIndex))
			{
				ChatbotMain.print("Wow! You know"+ songs[songIndex] +" is so good that we can feel the heroism and adventure in the Fellowship Theme, the warm simplicity and desire for home invoked by the Hobbits' Theme, and the dark seduction of Ring's Theme.");
			}
			else 
			{
				ChatbotMain.print("Wow! You know in "+ songs[songIndex] +", the female choir is deeper, there are more solo strings, and some lower percussion from the bass drums.");
				
			}
		}
		lResponse = response2;
	}

	private boolean checkIfInSong1(int songIndex) {
		for(int i = 0; i< songs1.length; i++)
		{
			if(songs1[i].equals(songs[songIndex]))
			{
				return true;
			}
		}
		return false;
	}

	private void countineTalkingAboutSubject(String response, int songIndex) {
		if(ChatbotMain.findKeyword(response, "yes", 0) > 0)
		{
			ChatbotMain.print("Mhm This topic bores me.");
		}
		
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
