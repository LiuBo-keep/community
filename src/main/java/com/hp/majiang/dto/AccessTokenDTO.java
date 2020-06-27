package com.hp.majiang.dto;

import lombok.*;

/**
 * @ClassName AccessTokenDTO
 * @Description TODO
 * @Author 17126
 * @Date 2020/6/13 14:03
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
