package guessDemmo;

public class HumanPlayer {
	//��̬��������ȭ������Ϣ
	public static int MessageTypeFist=1;
	//��̬������Ӯ��ʱ��
	public static int MessageTypeWin=2;
	//���ʱ��
	public static int MessageTypeLose=3;
	//msgType��Ӧ��̬����
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
	//���ԣ�����   ������������ȭ����ɫ�ĸ��Ի�̨��
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
	
	//�������õ����ƣ�������������Ч��˵̨�ʣ���ȭ
	
	
	
}
