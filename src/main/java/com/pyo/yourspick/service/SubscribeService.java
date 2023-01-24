package com.pyo.yourspick.service;


import com.pyo.yourspick.domain.subscribe.Subscribe;
import com.pyo.yourspick.domain.subscribe.SubscribeRepository;
import com.pyo.yourspick.handler.ex.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;

    @Transactional
    public void 구독하기(int fromUserId, int toUserId) {
        try{
            subscribeRepository.mSubscribe(fromUserId, toUserId);
        }catch(Exception e){
            throw new CustomApiException("이미 구독한 상태입니다.");
        }



    }

    @Transactional
    public void 구독취소하기(int fromUserId, int toUserId) {
        subscribeRepository.mUnSubscribe(fromUserId, toUserId);

    }


}
