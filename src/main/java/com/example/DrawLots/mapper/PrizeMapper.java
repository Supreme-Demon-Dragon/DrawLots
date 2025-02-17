package com.example.DrawLots.mapper;

import com.example.DrawLots.model.po.Lotresult;
import com.example.DrawLots.model.po.Prize;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PrizeMapper
{
    //按照lots_id查询
    @Select("SELECT * FROM `prizes` WHERE `lots_id`=#{lotsId}")
    List<Prize> getPrizeByLotsId(int lotsId);

    //按照lots_id和type查询
    @Select("SELECT * FROM `prizes` WHERE `id` = #{id}")
    Prize getPrizeById(int id);

    //添加lots_id这次抽奖的一项奖项
    @Insert("INSERT INTO `prizes`(`lots_id`,`type`,`name`,`number`,`picture_url`,`description`) VALUES(#{lotsId},#{type},#{name},#{number},#{pictureUrl},#{description})")
    void addNewPrize(Prize prize);

    //查询数据库中发布的抽奖数量
    @Select("SELECT COUNT(1) FROM `prizes`")
    int getPrizeAllNumber();

    //查询数据库中该抽奖有几个奖项
    @Select("SELECT `id` FROM `prizes` WHERE `lots_id` = #{lotsId}")
    int[] getPrizeIds(int lotsId);

    //查询数据库中该奖项名额有几人
    @Select("SELECT `number` FROM `prizes` WHERE `id` = #{id}")
    int getPrizeNumber(int id);


    //判断lotsId是否存在
    @Select("SELECT EXISTS(SELECT 1 FROM `prizes` WHERE `lots_id`=#{lotsId})")
    boolean judgeExistsOfLotsId(int lotsId);


    // 更新奖项的name
    @Update("UPDATE `prizes` SET `name`=#{name} WHERE `lots_id`=#{lotsId} AND `type`=#{type}")
    void updatePrizeName(int lotsId, String type, String name);

    // 更新奖项的number
    @Update("UPDATE `prizes` SET `number`=#{number} WHERE `lots_id`=#{lotsId} AND `type`=#{type}")
    void updatePrizeNumber(int lotsId, String type, int number);

    // 更新奖项的picture_url
    @Update("UPDATE `prizes` SET `picture_url`=#{pictureUrl} WHERE `lots_id`=#{lotsId} AND `type`=#{type}")
    void updatePrizePictureUrl(int lotsId, String type, String pictureUrl);

    // 更新奖项的description
    @Update("UPDATE `prizes` SET `description`=#{description} WHERE `lots_id`=#{lotsId} AND `type`=#{type}")
    void updatePrizeDescription(int lotsId, String type, String description);
}
