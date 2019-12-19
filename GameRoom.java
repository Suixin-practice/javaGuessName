package guessDemmo;

import java.util.Scanner;

public class GameRoom {
	//���ԣ��Ƿ��ƣ����ߣ�������Ϸ����ң�����ţ��������ƣ�
//	private String weapon;
	private HumanPlayer player1  = null;
	private comPlayer2 player2 = null;
	//����ID
	private long roomId;
	//��������
	private String roomName;
	//��������
	private String roomPass;
	//��������ʼ��Ϸ����ʼ����Ϸ����ʾ�˵���ѡ������ж���Ӯ�����Զ����ڲ����У�
	
	public GameRoom(String roomName,String roomPass) {
		if("admin".equals(roomName) && "123".equals(roomPass)) {
			System.out.println("������󣬽���ȥ��");
			return;
		}
//		this.setRoomName(roomName);
		initName();
		startGame();
		endGame();
	}
	
	public void initName() {
		//1ʵ������Ҷ���
		player1 = new HumanPlayer();
		player2 = new comPlayer2();
		//2ѡ���ɫ
		for (int i = 0; i < 40; i++) {
			System.out.println("*");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void startGame() {
		showMenu();
		choiceRole();
		//��ȭ
		gaming();
		//��ӡ���
	}

	private void gaming() {
		while(true) {
			System.out.println(player1.getName()+"���ȭ��");
			Scanner input = new Scanner(System.in);
			//player1.setFist(new Scanner(System.in).nextInt());
			player1.setFist(input.nextInt());
			int fist1 = player1.getFist();
			player2.getFist();
			int fist2 = player2.getFist();
			//�ж���Ӯ
			int result = judge(fist1,fist2);
			if(result == -1) {
				System.out.println("�����"+player1.getName()+"��Ӯ��");
				player1.sendMessage(player1.MessageTypeWin);
				player2.sendMessage(player2.MessageTypeLose);
			}else if(result == 0) {
				System.out.println("�����"+player1.getName()+"��"+player2.getName()+"ƽ��");
				System.out.println("ƽ��");
			}else {
				System.out.println("�����"+player2.getName()+"��Ӯ��");
				player1.sendMessage(player1.MessageTypeLose);
				player2.sendMessage(player2.MessageTypeWin);
			}
			System.out.println("�Ƿ������y/n");
			String answer = new Scanner(System.in).next();
			if(!"y".equalsIgnoreCase(answer)) {
				break;
			}
		}
	}
	public void showMenu() {
		System.out.println("��ӭ���롶"+roomName+"����Ϸ����");
		System.out.println("��ȭ����1-������2-����3-ʯͷ");
	}
	public void choiceRole() {
		System.out.println("�Է���ɫ��1-��㣬2-���ݣ�3-���ϣ�4-����");
		System.out.println("��ѡ��");
		int choice = new Scanner(System.in).nextInt();
		String[] nameArray = {"���","����","����","����"};
		//��Ҫ��֤����
		player2.setName(nameArray[choice-1]);
		player1.setName("ҹ���֩��");
		System.out.println(player1.getName()+"VS"+player2.getName());
	}
	public int judge(int fist1,int fist2) {
		if(fist1 == fist2) return 0;
		if(fist1 == 1 && fist2 ==3 || fist1 ==2 && fist1 == 1 || fist1 ==3 &&fist2==2) {
			//���һ����+1����Ҷ�����-1
			player1.setScore(player1.getScore()+1);
			player2.setScore(player2.getScore()-1);
			return -1;//���һʤ��
		}
		player1.setScore(player1.getScore()-1);
		player2.setScore(player2.getScore()+1);
		//���2ʤ��
		return 1;
	}
	public void endGame() {
		System.out.println("��Ϸ����~");
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomPass() {
		return roomPass;
	}
	public void setRoomPass(String roomPass) {
		this.roomPass = roomPass;
	}
	
	
	
}
