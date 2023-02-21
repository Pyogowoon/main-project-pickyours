package com.pyo.yourspick.domain.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubscribeRepository extends JpaRepository<Subscribe, Integer> {

        /* 구독하기 쿼리 */
    @Modifying
    @Query(value = "INSERT INTO Subscribe(fromUserId ,toUserId,createDate) VALUES( :fromUserId, :toUserId, now())", nativeQuery = true)
    int mSubscribe(@Param("fromUserId") int fromUserId, @Param("toUserId") int toUserId);

        /* 구독취소 쿼리 */
    @Modifying
    @Query(value = "DELETE FROM Subscribe WHERE fromUserId = :fromUserId AND toUserId = :toUserId", nativeQuery = true)
    int mUnSubscribe(@Param("fromUserId") int fromUserId, @Param("toUserId") int toUserId);


     /*구독 여부 확인 쿼리 */
    @Query(value = "SELECT COUNT(*) FROM Subscribe WHERE fromUserId = :principalId AND toUserId = :pageUserId", nativeQuery = true)
    int mSubscribeState(@Param("principalId") int principalId, @Param("pageUserId") int pageUserId);

    /* 구독 횟수 확인 쿼리 */
    @Query(value = "SELECT COUNT(*) FROM Subscribe WHERE fromUserId = :pageUserId", nativeQuery = true)
    int mSubscribeCount(@Param("pageUserId") int pageUserId);

}
