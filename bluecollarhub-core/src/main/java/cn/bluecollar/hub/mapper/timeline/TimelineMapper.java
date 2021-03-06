package cn.bluecollar.hub.mapper.timeline;

import cn.bluecollar.hub.entity.timeline.Timeline;
import cn.bluecollar.hub.entity.timeline.TimelinePost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TimeLineMapper
 *
 * @author rick
 * @date 2019/02/24 20:53
 * @description
 */
@Mapper
public interface TimelineMapper {

    List<TimelinePost> listTimelinePost(@Param("year") Integer year, @Param("month") Integer month);

    List<Timeline> listTimeline();
}
