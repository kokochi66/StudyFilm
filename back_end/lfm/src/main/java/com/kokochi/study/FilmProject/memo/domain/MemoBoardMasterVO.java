package com.kokochi.study.FilmProject.memo.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "memo_board_master")
@Getter @Setter
@DynamicInsert @DynamicUpdate
public class MemoBoardMasterVO {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Memo_board_GEN"
    )
    @Column(name = "ID")
    private Long id;                        // PK 값

    @Column(name = "NAME", nullable = false, columnDefinition = "VARCHAR(30) DEFAULT ''")
    private String name;                    // 게시판 이름

    @Column(name = "DESCRIPTION", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT ''")
    private String description;             // 게시판 설명

    @Column(name = "CREATED_DATE", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;               //  생성 날짜

    @OneToMany(mappedBy = "master")
    private List<MemoBoardVO> boardList = new ArrayList<>();
}
