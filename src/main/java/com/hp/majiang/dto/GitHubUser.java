package com.hp.majiang.dto;

import lombok.*;

/**
 * @ClassName GitHubUser
 * @Description TODO
 * @Author 17126
 * @Date 2020/6/13 16:37
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GitHubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
