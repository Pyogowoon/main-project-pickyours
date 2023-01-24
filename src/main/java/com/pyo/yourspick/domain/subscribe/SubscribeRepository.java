package com.pyo.yourspick.domain.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubscribeRepository extends JpaRepository<Subscribe , Integer> {

    @Modifying
    @Query(value = "INSERT INTO subscribe(fromUserId ,toUserId,createDate) VALUES( :fromUserId, :toUserId, now())", nativeQuery = true)
 int mSubscribe(@Param("fromUserId") int fromUserId, @Param("toUserId")int toUserId);

    @Modifying
    @Query(value = "DELETE FROM subscribe WHERE fromUserId = :fromUserId AND toUserId = :toUserId" , nativeQuery = true)
 int mUnSubscribe(@Param("fromUserId") int fromUserId,  @Param("toUserId") int toUserId);

}
