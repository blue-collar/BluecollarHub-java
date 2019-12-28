package cn.bluecollar.hub.portal.timeline.controller;

import cn.bluecollar.hub.common.Result;
import cn.bluecollar.hub.entity.timeline.Timeline;
import cn.bluecollar.hub.portal.timeline.service.TimelineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TimeLineController
 *
 * @author rick
 * @date 2019/02/24 20:46
 * 
 * @description
 */
@RestController
@RequestMapping("/timeline")
public class TimelineController {

    @Resource
    private TimelineService timelineService;

    @GetMapping("")
    public Result listTimeline() {
        List<Timeline> timelineList = timelineService.listTimeLine();

        return Result.ok().put("timelineList",timelineList);
    }
}
