package chatbot;

public class ChatbotJasonY implements Topic{
	private String[] keywords;
	private String[] responses;
	private String[] insultWords;
	private String[] goodWords;
	private String goodbyeKeyword;
	private String secretKeyword;
	private String response;
	private int happyCount;
	
	public ChatbotJasonY() {
		String[] temp = {"Grand Chase" , "Final Fantasy", "World of Warcraft", "Overwatch", "Games"};
		keywords = temp;
		String[] res = {"Wow! That's my favorite game! I'm surprised you know that game. Those who know the game call it a rip "
				+ "Final Fantasy has a long history. From the first Final Fantasy, which was released in 1987, to Final Fantasy XV, which was released in 2016. The franchise was made from a company called \"Square Einx\". Each Final "
				+ "Fantasy game has its own unqiue plot and characters. They are mostly about saving the world from some kind of "
				+ "peril. The franchise is very popular that it even had its own anime adaption and one of the Final Fantasy "
				+ "characters named \"Cloud\" was released in the game \"Super Smash Brothers\".", 
		};
		responses = res;
		String[] insult = {"suck", "terrible", "trash", "horrific", "disgusting", "bad"};
		insultWords = insult;
		String[] praise = {"good", "nice", "great", "cool"};
		goodWords = praise;
		goodbyeKeyword = "bye";
		secretKeyword = "Grand Chase";
		response = "";
		happyCount = 0;
		
	}
	
	public void talk(String response) {
		ChatbotMain.print("Games, huh? They have the power to turn one's life into a couch potato or a shut-in. Pretty scary stuff but if "
				+ "played with moderation, one can prevent that. But anyways what do you want to talk about?");
		response = ChatbotMain.getInput();
		while(ChatbotMain.findKeyword(response, goodbyeKeyword, 0) == -1) {
			for(int i = 0; i < insultWords.length; i++) {
				if (ChatbotMain.findKeyword(response, insultWords[i], 0) >= 0) {
					ChatbotMain.print("Nope, take that back.");
					happyCount--;
					i=0;
					response = ChatbotMain.getInput();
				}
			}
			
			for(int i = 0; i < goodWords.length; i++) {
				if (ChatbotMain.findKeyword(response, goodWords[i], 0) >= 0) {
					ChatbotMain.print("RIGHT!");
					happyCount++;
					i=0;
					response = ChatbotMain.getInput();
				}
			}			
			
			for(int i = 0; i < keywords.length; i++) {
				
			}
			
			if(ChatbotMain.findKeyword(response, secretKeyword, 0) >= 0) {
				ChatbotMain.print("Wow! That's my favorite game! I'm surprised you know that game. Those who know the game call it a rip "
						+ "off of another similar game called Elsword even though it was released in 2003 and Elsword was released in 2007."
						+ "Anyways Grand Chase is a platform MMORPG where the player goes around killing monsters to progress through the "
						+ "stages. There's always a boss monster at the end of the stage. As the player progress, the bosses have more hit "
						+ "points making it harder to kill. The player can unlock more characters -besides the crappy ones that are given to "
						+ "the player but Rin is a good character - by buying the missions in the shop and completing them. Some of the "
						+ "mission may require the player to complete more than mission to unlock the character. "
						+ "The player can also buy comestics through the means of real life cash.");
				happyCount++;
				response = ChatbotMain.getInput();
			}
			
			else if(ChatbotMain.findKeyword(response, keywords[0], 0) >= 0) {
				ChatbotMain.print("Final Fantasy has a long history. From the first Final Fantasy, which was released in 1987, to Final "
						+ "Fantasy XV, which was released in 2016. The franchise was made from a company called \"Square Einx\". Each Final "
						+ "Fantasy game has its own unqiue plot and characters. They are mostly about saving the world from some kind of "
						+ "peril. The franchise is very popular that it even had its own anime adaption and one of the Final Fantasy "
						+ "characters named \"Cloud\" was released in the game \"Super Smash Brothers\".");
				response = ChatbotMain.getInput();
			}
			
			else if(ChatbotMain.findKeyword(response,keywords[1], 0) >= 0) {
				ChatbotMain.print("World of Warcraft or sometimes abbreviated as \"WOW\" is a massively multiplayer online role playing game "
						+ "also abbreviated as \"MMORPG\". This game was released in 2004 by a company called \"Blizzard\". In the game, "
						+ "the player goes around killing monster for drops and armor. The materials dropped can be used to create equips "
						+ "and other things. Apparently there's a common misconpetion which is World of Warcraft is the MMORPG which is not "
						+ "the case.");
				response = ChatbotMain.getInput();
			}
			
			else if(ChatbotMain.findKeyword(response, keywords[2], 0) >= 0) {
				ChatbotMain.print("Overwatch is a game made by a company called \"Blizzard\". It is a \"team-based multiplayer online first-person "
						+ "shooter\". The game is very much like MOBA games where the player picks a hero before her or she enters the arena. The "
						+ "player is in a team with 5 players including the player himself or herself. The team is up against another team of 5. "
						+ "There are different game modes and each mode has a different objective and playstyle to it. One game mode, Escort, is a "
						+ "game mode in which the Attacking team's objective is to move the payload to a delivery point, while the Defenders must "
						+ "halt the Attackers' progress until time runs out. Assault is a game mode in which the Attacking and Defending teams must "
						+ "attempt to take or defend capture points across the map. Both teams battle over control of the map, one team on offense, "
						+ "the other on defense. The attackers' goal is to capture critical objectives, while the defenders must maintain control "
						+ "over them until time runs out. Hybrid Game Mode starts with an Assault and ends with an Escort section. These two parts "
						+ "behave exactly as their stand-alone Game Modes do. On Control maps, two teams fight over a series of objective areas in "
						+ "a best-of-three format. When a team is in control of the roundâ€™s objective area, they will make progress toward "
						+ "capturing it, and whichever team gets to 100% first wins the round. Each round (up to 3 total) will feature a new "
						+ "objective area located in a different part of the map.");
				response = ChatbotMain.getInput();
			}
			
			else { 
				ChatbotMain.print("Altough I may be an intelligent machine, I don't know everything in the world.");
				response = ChatbotMain.getInput(); 
			}
		}  
		
		if (happyCount < -2) {
			ChatbotMain.print("Well, I hate talking to you, " + ChatbotMain.chatbot.getUsername().toUpperCase() + "! WORSE PERSON I'VE EVER MEET!" );
			ChatbotMain.chatbot.startChatting();
		}
		 
		if (happyCount == -2) {
			ChatbotMain.print("Well, it was *pause* nice talking to you, " + ChatbotMain.chatbot.getUsername() + "! You're a mean person." );
			ChatbotMain.chatbot.startChatting();
		}
		
		if (happyCount == -1) {
			ChatbotMain.print("Well, it was *pause* nice talking to you, " + ChatbotMain.chatbot.getUsername() + "! You're negative person." );
			ChatbotMain.chatbot.startChatting();
		}
		
		if (happyCount == 0) {
			ChatbotMain.print("Well, it was okay talking to you, " + ChatbotMain.chatbot.getUsername() + "! You're a decent person." );
			ChatbotMain.chatbot.startChatting();
		}
		
		if (happyCount == 1) {
			ChatbotMain.print("Well, it was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "! You're a pretty good person." );
			ChatbotMain.chatbot.startChatting();
		}
		
		if (happyCount == 2) {
			ChatbotMain.print("Well, it was nice talking to you, " + ChatbotMain.chatbot.getUsername() + "! You're a cool person." );
			ChatbotMain.chatbot.startChatting();
		}
		
		if (happyCount > 2) {
			ChatbotMain.print("I LOVE talking to you, " + ChatbotMain.chatbot.getUsername() + "! You're the greatest person I've ever "
					+ "meet. I wish we could have chatted more.");
			ChatbotMain.chatbot.startChatting();
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
