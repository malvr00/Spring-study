package board.dto;

import java.time.LocalDateTime;
import lombok.Data;

//getter와 setter를 생성하고 toString, hashCode, equals 메소드 생성
// 단 setter의 경우 final선언되지 않은 필드에만 적용
@Data	
public class BoardDto {
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String creatorId;
	private LocalDateTime createdDatetime;
	private String updateId;
	private LocalDateTime updatedDatetime;
}
