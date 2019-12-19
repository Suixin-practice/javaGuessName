package guessDemmo;

public class HumanPlayer {
	//静态常量：出拳类型信息
	public static int MessageTypeFist=1;
	//静态常量：赢的时候
	public static int MessageTypeWin=2;
	//输的时候
	public static int MessageTypeLose=3;
	//msgType对应静态常量
	public void sendMessage(int msgType) {
		int index = ((int)(Math.random()*1000))%5;
		String message =null;
		switch (msgType) {
		case 1:
			message = fistWords[index];
			break;
		case 2:
			message = winWords[index];
			break;
		case 3:
			message = loseWords[index];
			break;
		}
		System.out.println(message);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getFist() {
		return fist;
	}
	public void setFist(int fist) {
		this.fist = fist;
	}
	//属性：姓名   分数，所出的拳，角色的个性化台词
	private String name;
	private int score;
	private int fist;
	private String[] fistWords = {
			"11111",
			"22222",
			"33333",
			"44444"
	};
	private String[] winWords = {
			"yyyy",
			"xxxx",
			"zzzz",
			"aaaa"
	};
	private String[] loseWords= {
			"bbbbb",
			"ccccc",
			"ddddd",
			"fffffffff"
	};
	
	//方法：得到名称，分数，播放音效，说台词，出拳
	
	
	
}
