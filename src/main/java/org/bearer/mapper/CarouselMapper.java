package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.vo.Carousel;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:45
 */
@Mapper
public interface CarouselMapper {

    /**
     * 通过文章id排序，获取一定区间内的图片作为轮播图
     *
     * @param start 区间开始
     * @param end 区间结尾
     * @return List<Carousel>
     */
    List<Carousel> selectList(int start, int end);
}
