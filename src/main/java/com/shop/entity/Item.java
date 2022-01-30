package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name="item")//item 테이블과 매핑
@Getter
@Setter
@ToString
public class Item {

    @Id
    @Column(name="item_id")//item_id column과 매핑
    @GeneratedValue(strategy = GenerationType.AUTO)//기본키 생성 전략 AUTO
    private Long id; //상품 코드

    @Column(nullable = false, length = 50)//null허용? , String 필드 기본 길이는  255가 default length로 변경 가능
    private String itemNm; //상품명

    @Column(name="price", nullable = false)
    private int price; //가격

    @Column(nullable = false)
    private int stockNumber; //재고

    @Lob
    @Column(nullable = false)
    private String itemDetail; //상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; //판매 상태


    private LocalDateTime regTime; //등록 시간

    private LocalDateTime updateTime; //수정 시간
}
