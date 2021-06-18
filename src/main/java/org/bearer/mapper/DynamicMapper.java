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
    List<DynamicVO> selectDynamic(int start, int end);

    int selectCount();

    int deleteById(Ids ids);

    int insertDynamic(Dynamic dynamic);
}
