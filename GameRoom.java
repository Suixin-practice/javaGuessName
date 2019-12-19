package guessDemmo;

import java.util.Scanner;

public class GameRoom {
	//属性：记分牌，道具，参与游戏的玩家，房间号，房间名称，
//	private String weapon;
	private HumanPlayer player1  = null;
	private comPlayer2 player2 = null;
	//房间ID
	private long roomId;
	//房间名称
	private String roomName;
	//房间密码
	private String roomPass;
	//方法：开始游戏，初始化游戏，显示菜单，选择人物，判断输赢（可以定义在裁判中）
	
	public GameRoom(String roomName,String roomPass) {
		if("admin".equals(roomName) && "123".equals(roomPass)) {
			System.out.println("密码错误，进不去！");
			return;
		}
//		this.setRoomName(roomName);
		initName();
		startGame();
		endGame();
	}
	
	public void initName() {
		//1实例化玩家对象
		player1 = new HumanPlayer();
		player2 = new comPlayer2();
		//2选择角色
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
		//出拳
		gaming();
		//打印结果
	}

	private void gaming() {
		while(true) {
			System.out.println(player1.getName()+"请出拳：");
			Scanner input = new Scanner(System.in);
			//player1.setFist(new Scanner(System.in).nextInt());
			player1.setFist(input.nextInt());
			int fist1 = player1.getFist();
			player2.getFist();
			int fist2 = player2.getFist();
			//判断输赢
			int result = judge(fist1,fist2);
			if(result == -1) {
				System.out.println("结果："+player1.getName()+"是赢家");
				player1.sendMessage(player1.MessageTypeWin);
				player2.sendMessage(player2.MessageTypeLose);
			}else if(result == 0) {
				System.out.println("结果："+player1.getName()+"和"+player2.getName()+"平手");
				System.out.println("平局");
			}else {
				System.out.println("结果："+player2.getName()+"是赢家");
				player1.sendMessage(player1.MessageTypeLose);
				player2.sendMessage(player2.MessageTypeWin);
			}
			System.out.println("是否继续？y/n");
			String answer = new Scanner(System.in).next();
			if(!"y".equalsIgnoreCase(answer)) {
				break;
			}
		}
	}
	public void showMenu() {
		System.out.println("欢迎进入《"+roomName+"》游戏房间");
		System.out.println("出拳规则：1-剪刀，2-布，3-石头");
	}
	public void choiceRole() {
		System.out.println("对方角色：1-凤姐，2-妮妮，3-正南，4-阿呆");
		System.out.println("请选择：");
		int choice = new Scanner(System.in).nextInt();
		String[] nameArray = {"凤姐","妮妮","正南","阿呆"};
		//需要验证输入
		player2.setName(nameArray[choice-1]);
		player1.setName("夜鸢茵蜘蛛");
		System.out.println(player1.getName()+"VS"+player2.getName());
	}
	public int judge(int fist1,int fist2) {
		if(fist1 == fist2) return 0;
		if(fist1 == 1 && fist2 ==3 || fist1 ==2 && fist1 == 1 || fist1 ==3 &&fist2==2) {
			//玩家一分数+1，玩家二分数-1
			player1.setScore(player1.getScore()+1);
			player2.setScore(player2.getScore()-1);
			return -1;//玩家一胜利
		}
		player1.setScore(player1.getScore()-1);
		player2.setScore(player2.getScore()+1);
		//玩家2胜利
		return 1;
	}
	public void endGame() {
		System.out.println("游戏结束~");
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
