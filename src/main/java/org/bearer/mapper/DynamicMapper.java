package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.dto.Ids;
import org.bearer.entity.po.Dynamic;
import org.bearer.entity.vo.DynamicVO;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/10 13:46
 */
@Mapper
public interface DynamicMapper {
    /**
     * 获取动态
     *
     * @param start 第一个index
     * @param end 最后一个index
     * @return List<DynamicVO>
     */
    List<DynamicVO> selectDynamic(int start, int end);

    /**
     * 获取总条数
     *
     * @return int
     */
    int selectCount();

    /**
     * 通过动态id删除动态
     *
     * @param ids 只取动态id
     * @return int
     */
    int deleteById(Ids ids);

    /**
     * 保存动态
     *
     * @param dynamic 动态信息
     * @return int
     */
    int insertDynamic(Dynamic dynamic);
}
