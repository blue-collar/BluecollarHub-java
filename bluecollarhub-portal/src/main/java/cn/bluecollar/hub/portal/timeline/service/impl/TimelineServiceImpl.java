package cn.bluecollar.hub.portal.timeline.service.impl;

import cn.bluecollar.hub.entity.timeline.Timeline;
import cn.bluecollar.hub.entity.timeline.TimelineMonth;
import cn.bluecollar.hub.entity.timeline.TimelinePost;
import cn.bluecollar.hub.mapper.timeline.TimelineMapper;
import cn.bluecollar.hub.portal.timeline.service.TimelineService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * TimeLineServiceImpl
 *
 * @author rick
 * @date 2019/02/24 20:47
 * 
 * @description
 */
@Service
public class TimelineServiceImpl implements TimelineService {

    @Resource
    private TimelineMapper timelineMapper;

    /**timelineMapper
     * 获取timeLine数据
     *
     * @return
     */
    @Override
    public List<Timeline> listTimeLine() {
        List<Timeline> timelineList = timelineMapper.listTimeline();
        genTimelineMonth(timelineList);
        return timelineList;
    }

    private List<Timeline> genTimelineMonth(List<Timeline> timelineList) {
        for(Timeline timeline : timelineList) {
            List<TimelineMonth> timelineMonthList = new ArrayList<>();
           for (int i = Calendar.DECEMBER + 1; i > 0; i--) {
               List<TimelinePost> postList = timelineMapper.listTimelinePost(timeline.getYear(), i);
               if(CollectionUtils.isEmpty(postList)) {
                   continue;
               }
               TimelineMonth month = new TimelineMonth();
               month.setCount(postList.size());
               month.setMonth(i);
               month.setPosts(postList);
               timelineMonthList.add(month);
           }
           timeline.setMonths(timelineMonthList);
        }
        return timelineList;
    }

}
