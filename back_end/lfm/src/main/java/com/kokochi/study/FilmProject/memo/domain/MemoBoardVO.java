package com.kokochi.study.FilmProject.memo.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "memo_board")
@Getter @Setter
@DynamicInsert @DynamicUpdate
public class MemoBoardVO {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Memo_board_GEN"
    )
    private Long id;                        // PK 값

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id")
    private MemoBoardMasterVO master;       // 게시판 매핑

    @Column(nullable = false)
    private String title;                   // 게시글 제목

    @Column(nullable = false)
    private String writer;                  // 게시글 작성자

    private String contents;                // 게시글 내용

    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean isUse;                  // 사용가능 여부

    @Column(columnDefinition = "int default 0")
    private int readNum;                    // 조회수

    @Column(name = "CREATED_DATE", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;               //  생성 날짜
}
