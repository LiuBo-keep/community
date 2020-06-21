package com.hp.majiang.model;

import lombok.*;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author 17126
 * @Date 2020/6/14 21:07
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;


}
