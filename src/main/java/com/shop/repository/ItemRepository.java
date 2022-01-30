package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {
    List<Item> findByItemNm(String itemNm);//메소드
    //OR 조건
    List<Item> findByItemNmOrItemDetail(String ItemNm, String itemDetail);
    //Less than 조건
    List<Item> findBypriceLessThan(Integer price);
    //OrderBy속성명Desc 내림차순
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")//jsql문법으로 작성
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price desc",nativeQuery = true )//value 안에 네이티브 쿼리문 작성
    List<Item> findByItemDetailBynative(@Param("itemDetail") String itemDetail);

}
