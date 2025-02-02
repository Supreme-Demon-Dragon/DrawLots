package com.example.DrawLots.model.vo;

import com.example.DrawLots.model.po.Lotresult;
import com.example.DrawLots.model.po.Lots;
import com.example.DrawLots.model.po.Prize;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Getter
public class LotsFullVO {
    private int id;
    private int uid;
    private String nickname;
    private int type;
    private Timestamp startTime;
    private Timestamp endTime;
    private int joinLimit;
    private int joinMethod;
    private int joinedNumber;
    private int choice;
    private int[] randomRange;
    private int randomNumber;

    public LotsFullVO(Lots lots) {
        this.id = lots.getId();
        this.uid = lots.getUid();
        this.nickname = lots.getNickname();
        this.type = lots.getType();
        this.startTime = lots.getStartTime();
        this.endTime = lots.getEndTime();
        this.joinLimit = lots.getJoinLimit();
        this.joinMethod = lots.getJoinMethod();
        this.joinedNumber = lots.getJoinedNumber();
        this.choice = lots.getChoice();
        this.randomRange = new int[] {lots.getRandomRangeMin(),lots.getRandomRangeMax()};
        this.randomNumber = lots.getRandomNumber();
    }
}
