package cn.bluecollar.hub.entity.timeline;

import lombok.Data;

import java.util.Date;

/**
 * TimeLineData
 *
 * @author rick
 * @date 2019/02/24 20:39
 * @description
 */
@Data
public class TimelinePost {

    private Integer id;

    private String title;

    private String description;

    private String postType;

    private Date createTime;

}
