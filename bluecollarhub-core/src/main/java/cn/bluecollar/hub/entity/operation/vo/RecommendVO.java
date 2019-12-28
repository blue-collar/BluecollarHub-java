package cn.bluecollar.hub.entity.operation.vo;

import cn.bluecollar.hub.entity.operation.Recommend;
import cn.bluecollar.hub.entity.operation.Tag;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * RecommendVo
 *
 * @author rick
 * @date 2019/02/22 10:49
 * @description
 */
@Data
public class RecommendVO extends Recommend {

    private String description;

    private Long readNum;

    private Long commentNum;

    private Long likeNum;

    private String urlType;

    private String cover;

    private Date createTime;

    private List<Tag> tagList;

}
