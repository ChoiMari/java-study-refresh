
public class Ex08_Array_Rank {
	public static void main(String[] args) {
		//다차원 배열(2차원만 본다고 함)
		/*
		 [행][열] 
		 
		 영화관 좌석, PC방 좌석, 지도 좌표값, 오목, 엑셀
		 
		 */
		int[][] score = new int[3][2];
		score[0][0] = 100;
		score[0][1] = 200;
		
		score[1][0] = 300;
		score[1][1] = 400;
		
		score[2][0] = 500;
		score[2][1] = 600;
		
		for(int i = 0;i < score.length; i++) { 
			for(int j = 0;j < score[i].length;j++) { // 메모리 구조 그림보면 됨 
				// https://cafe.naver.com/msa2025?iframe_url_utf8=%2FArticleRead.nhn%253Fclubid%3D31543511%2526articleid%3D160%2526referrerAllArticles%3Dtrue
				System.out.printf("score[%d][%d] = [%d]\t", i, j, score[i][j]);
			}
			System.out.println();
		}
		
		int[][] score2 = new int[][] {{11,12},{13,14},{15,16}};
		
		// 개선된 for문을 사용해서 2차원 배열 출력
		for(int[] numArr : score2) { // 1차원 배열의 주소값 numArr
			for(int num : numArr) {
				System.out.println(num);
			}
		}
		
		
	}
}
