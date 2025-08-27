package kr.or.kosa;

import java.util.Random;

public class Cinama {
	// 멤버필드, 생성자, static, method, 메뉴 구성
	/*
	  예매하기, 예매조회, 좌석조회, 예매취소, 시스템종료
	  + 추가 기능 
	  	좌석 변경, 한 번에 여러개의 좌석 예매
	*/
	
	private String[][] seat; // 영화관 좌석
	private String[][] ranInfo; // 예매정보: 예매번호-행번호-열번호
	// 행 - 인덱스번호에 해당하는 그 라인의 좌석 한 줄의 예매정보
	//TODO key-value
	
	// 생성자
	public Cinama(String[][] seat, String[][] ranInfo) {
		this.seat = seat;
		this.ranInfo = ranInfo;
		initSeat(); // 객체 생성 시 좌석 초기화
		initRanInfo(); // 예매 정보 초기화
	}
	
	//getter & setter
	public String[][] getSeat() {
		return seat;
	}
	
	public void setSeat(String[][] seat) {
		this.seat = seat;
	}
	
	public String[][] getRanInfo() {
		return ranInfo;
	}
	
	public void setRanInfo(String[][] ranInfo) {
		this.ranInfo = ranInfo;
	}
	
	// 좌석 초기화(초기 객체 생성 + 상영 종료 시에 사용)
	private void initSeat() {
		for(int i = 0;i < seat.length;i++) {
			for(int j = 0;j < seat[i].length;j++) {
				seat[i][j] = i + "-" + j; // 빈 의자 배치
			}
		}
	}
	
	//예매 정보 초기화 - 좌석과 동일한 크기로 초기화
	private void initRanInfo() {
		for(int i = 0;i < ranInfo.length;i++) {
			for(int j = 0;j < ranInfo[i].length;j++) {
				ranInfo[i][j] = ""; 
			}
		}
	}
	
	//예매 번호 생성
	public String createTicketNum() {
		Random r = new Random();
		String ran = Integer.toString(r.nextInt(8) + 1);
		for(int i = 0;i < 7;i++) {
			ran += Integer.toString(r.nextInt(9)); 
		}
		return ran;
	}
	
	
	//예매 하기
	/**
	 * 영화관 좌석 예매해주는 메서드
	 * @param row 좌석 행번호
	 * @param col 좌석 열번호
	 * @return 예매번호
	 */
	public String ticketBuy(int row, int col) {
		String ran = createTicketNum(); // 예매번호 생성 메서드 호출
		ranInfo[row][col] = ran +"-"+ row + "-" + col; // 예매 정보 저장
		seat[row][col] = " X ";
		System.out.println("예매가 완료 되었습니다.");
		System.out.printf("좌석번호 : %d-%d, 예매 번호 : [%s]\n", row, col, ran);
		System.out.println("감사합니다.");
		return ran;
	}
	
	//예매 번호로 좌석 조회하는 메서드
	public void ranBySeat(String ran) {
		try {
			boolean isTicket = false;
			int row = 0;
			int col = 0;	
			for(String[] rarr:ranInfo) {
				for(String r : rarr) {
					if(r.contains(ran)) {
						String[] strArr = r.split("-");
						isTicket = true;
						row = Integer.parseInt(strArr[1]);
						col = Integer.parseInt(strArr[2]);
					}
					
				}
			}
			if(isTicket) {
				System.out.println("고객님이 예매하신 좌석은 " 
						+ row + "-" + col + "입니다.\n");
			} else {
				System.out.println("예매 번호에 해당하는 좌석이 없습니다.");
				System.out.println("확인 후 다시 시도해 주시길 바랍니다.");
			}
			
		} catch(NullPointerException ex) {
			System.out.println("[입력 오류] 잘못된 입력입니다.\n확인 후, 다시 시도해주세요.");
		}
	}

	//좌석 현황
	public void checkCinamaSeat() {
		System.out.println("*******좌석 현황*******");
		for(int i = 0;i < seat.length;i++) {
			for(int j = 0;j < seat[i].length;j++) {
				System.out.printf("[%s]", seat[i][j].equals(i + "-" + j) ? i + "-" + j : " X ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}
	
	//좌석 조회(예매 가능한지)
	public boolean checkSeatNumber(int row, int col) {
		if(seat[row][col].equals(row + "-" + col)) {
			return true;
		} else {
			return false;
		}
	}
	
	//예매 취소
	public void cancleTicket(String ran) {
		try {
			boolean isTicket = false;
			int row = 0;
			int col = 0;
			for(String[] rarr:ranInfo) {
				for(String r : rarr) {
					if(r.contains(ran)) {
						String[] strArr = r.split("-");
						isTicket = true;
						row = Integer.parseInt(strArr[1]);
						col = Integer.parseInt(strArr[2]);
					}
					
				}
			}		
			if(isTicket) {
				seat[row][col] = row + "-" + col;
				ranInfo[row][col] = ""; //예매 정보에서 삭제
				System.out.println("취소가 완료 되었습니다.\n");
			}else {
				System.out.println("[입력 오류] 일치하는 예매번호가 없습니다.");
				System.out.println("확인 후 다시 실행해주시길 바랍니다.\n");
			}	
		} catch(NullPointerException ex) {
			System.out.println("[입력 오류] 잘못된 입력입니다.\n확인 후, 다시 시도해주세요.");
		}
	
	}
	
	// 상영 종료(좌석 초기화)
	public void endMovie() {
		System.out.println("상영이 종료되었습니다.");
		initSeat(); //-> 좌석 초기화
		initRanInfo(); // 예매 정보 초기화
	}
	
	// 영화관 예매 프로그램 종료
	public boolean closeCinama() {
		System.out.println("이용해 주셔서 감사합니다.");
		return false;
	}
	
}
