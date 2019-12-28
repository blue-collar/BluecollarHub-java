package cn.bluecollar.hub.entity.timeline;

import lombok.Data;

import java.util.List;

/**
 * TimeLine
 *
 * @author rick
 * @date 2019/02/24 20:33
 * @description
 */
@Data
public class Timeline {

    private Integer year;

    private Integer count;

    private List<TimelineMonth> months;
}
