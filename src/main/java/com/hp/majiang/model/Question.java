package com.hp.majiang.model;

import lombok.*;

/**
 * @ClassName Question
 * @Description TODO
 * @Author 17126
 * @Date 2020/6/21 9:11
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
}
