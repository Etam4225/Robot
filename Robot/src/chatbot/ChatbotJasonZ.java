package chatbot;

public class ChatbotJasonZ implements Topic {

	private String[] keywords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private String[] songs;
	private String[] stringSongs;
	
	public ChatbotJasonZ() {
		String[] songs = {"The Shadow of the Past","A Knife in the Dark","Flight to the Ford","Many Meeting","The Council of Elrond","The Ring goes South","The Bridge of Khazad Dum","Lothlorien", "Amon Hend","The Breaking of the Fellowship","May it be"};
		String[] temp = {"lord of the ring's music", "lord of the rings music"};
		keywords = temp;
		goodbyeKeyword = "bye";
		secretKeyword = "Concerning Hobbits";
		response = "";
	}

	@Override
	public void talk(String response) {
		ChatbotMain.print("Hey! So you want to talk about generic boring things, huh? I love talking about that. So tell me something.");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Wow I love that song! isn't the title amazing?.");
				response = ChatbotMain.getInput();
			}
			
			if(ChatbotMain.findKeyword(response, "Yes", 0) >= 0)
			{
				double rand = Math.random();
				if(rand <= (1/11))
				{
					ChatbotMain.print("Wow! You know"+ songs[0] +"? Don't you love the string instruments and the voice?");
					response = ChatbotMain.getInput();
					countineTalkingAboutSubject(response, 0);
				}
				else 
				{
					if(rand <= 2/11)
					{
						ChatbotMain.print("Wow! You know"+ songs[1] +"? Don't you love the string instruments and the voice?");
						response = ChatbotMain.getInput();
						countineTalkingAboutSubject(response, 1);
					}
					else 
					{
						if(rand <= 3/11)
						{
							ChatbotMain.print("Wow! You know"+ songs[2] +"? Don't you love the string instruments and the voice?");
							response = ChatbotMain.getInput();
							countineTalkingAboutSubject(response, 2);
						}
						else 
						{
							if(rand <= 4/11)
							{
								ChatbotMain.print("Wow! You know"+ songs[3] +"? Don't you love the string instruments and the voice?");
								response = ChatbotMain.getInput();
								countineTalkingAboutSubject(response, 3);
							}
							else 
							{
								if(rand <= 5/11)
								{
									ChatbotMain.print("Wow! You know"+ songs[4] +"? Don't you love the string instruments and the voice?");
									response = ChatbotMain.getInput();
									countineTalkingAboutSubject(response, 4);
								}
								else 
								{
									if(rand <= 6/11)
									{
										ChatbotMain.print("Wow! You know"+ songs[5] +"? Don't you love the string instruments and the voice?");
										response = ChatbotMain.getInput();
										countineTalkingAboutSubject(response, 5);
									}
									else 
									{
										if(rand <= 7/11)
										{
											ChatbotMain.print("Wow! You know"+ songs[6] +"? Don't you love the string instruments and the voice?");
											response = ChatbotMain.getInput();
											countineTalkingAboutSubject(response, 6);
										}
										else 
										{
											if(rand <= 8/11)
											{
												ChatbotMain.print("Wow! You know"+ songs[7] +"? Don't you love the string instruments and the voice?");
												response = ChatbotMain.getInput();
												countineTalkingAboutSubject(response, 7);
											}
											else 
											{
												if(rand <= 9/11)
												{
													ChatbotMain.print("Wow! You know"+ songs[8] +"? Don't you love the string instruments and the voice?");
													response = ChatbotMain.getInput();
													countineTalkingAboutSubject(response, 8);
												}
												else 
												{
													if(rand <= 10/11)
													{
														ChatbotMain.print("Wow! You know"+ songs[9] +"? Don't you love the string instruments and the voice?");
														response = ChatbotMain.getInput();
														countineTalkingAboutSubject(response, 9);
													}
													else 
													{
			
															ChatbotMain.print("Wow! You know"+ songs[10] +"? Don't you love the string instruments and the voice?");
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
				response = ChatbotMain.getInput();
			}
		}
		//access variables from other classes
		ChatbotMain.print("Well, it was nice talking to you, "+ChatbotMain.chatbot.getUsername()+"!");
		ChatbotMain.chatbot.startChatting();
		
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
