package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.BannerAds;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BannerAdsRepository {

    @Select({"<script>",
            "select * from bannerAds ba",
            "<where>",
            "<if test='bannerAds != null'>",
            "<if test='bannerAds.title != null'>",
            " and ba.title=#{bannerAds.title}",
            "</if>",
            "</if>",
            "</where>",
            "</script>"})
    /*@Results({
            @Result(property = "province", column = "province_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.ProvinceRepository.findById"))
    })*/
    Page<BannerAds> findAll(@Param("bannerAds") BannerAds bannerAds) throws Exception;

    @Select("select * from bannerAds ba where ba.id = #{id}")
    /*@Results({
            @Result(property = "user", column = "user_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.UserRepository.findById"))
    })*/
    BannerAds findById(Long id) throws Exception;

    @Insert("insert into bannerAds(title, description, image, url, sequence, state, createDate, startDate, finishDate) values "
            + "(#{bannerAds.title}, #{bannerAds.description}, #{bannerAds.image}, #{bannerAds.url}, #{bannerAds.sequence}, #{bannerAds.state}, "
            + "#{bannerAds.createDate}, #{bannerAds.startDate}, #{bannerAds.finishDate})")
    void insert(@Param("bannerAds") BannerAds bannerAds) throws Exception;

    @Update("update bannerAds set title = #{bannerAds.title}, description = #{bannerAds.description},  image = #{bannerAds.image}, url = #{bannerAds.url},"
            + "sequence = #{bannerAds.sequence}, state = #{bannerAds.state}, createDate = #{bannerAds.createDate}, startDate = #{bannerAds.startDate},  finishDate = #{bannerAds.finishDate}"
            + "where id = #{bannerAds.id}")
    void update(@Param("bannerAds") BannerAds bannerAds) throws Exception;

    @Update("update bannerAds set deleted = 1 where id = #{id}")
    void delete(Long id) throws Exception;

}