
public class UserInfo {
	
	private String name;
	private String userId;

	public String getName() {
		return name;
	}
	
	public String getUserId(String name) {
		
		int spaceCount = 0;
		String userId = "Guest";
		
		for(int i = 0; i < name.length(); i++) {
			char character = name.charAt(i);
			if(Character.isWhitespace(character)) {
				spaceCount++;
				if(spaceCount == 2) {
					char initial;
					String[] nameArray = name.split(" ", 3);
					initial = name.charAt(0);
					userId = initial + nameArray[2];
				}
				else if(spaceCount == 1) {
					char initial;
					String[] nameArray = name.split(" ", 2);
					initial = name.charAt(0);
					userId = initial + nameArray[1];
				}
			}
		}
		return "\nGenerated User ID: " + userId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
