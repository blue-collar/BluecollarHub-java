package cn.bluecollar.hub.portal.timeline.service;

import cn.bluecollar.hub.entity.timeline.Timeline;

import java.util.List;

/**
 * TimeLineService
 *
 * @author rick
 * @date 2019/02/24 20:47
 * 
 * @description
 */
public interface TimelineService {

    /**
     * 获取timeLine数据
     * @return
     */
    List<Timeline> listTimeLine();
}
