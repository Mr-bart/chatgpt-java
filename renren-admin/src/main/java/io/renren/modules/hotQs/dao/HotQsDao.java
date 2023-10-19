package io.renren.modules.hotQs.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.hotQs.entity.HotQsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 热门问题表
 *
 * @author Mr.star 26011687@qq.com
 * @since 1.0.0 2023-04-10
 */
@Mapper
public interface HotQsDao extends BaseDao<HotQsEntity> {
	
}