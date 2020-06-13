package com.hp.majiang.provider;

import com.alibaba.fastjson.JSON;
import com.hp.majiang.dto.AccessTokenDTO;
import com.hp.majiang.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName GitHubProvider
 * @Description TODO
 * @Author 17126
 * @Date 2020/6/13 14:00
 */

@Component
public class GitHubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody requestBody = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request=new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(requestBody)
                .build();
        try(Response response=okHttpClient.newCall(request).execute()){
            String string = response.body().string();
            int index1 = string.indexOf("=");
            int index2 = string.indexOf("&");
            System.out.println(index1+"===="+index2);
            System.out.println(string);
            System.out.println(string.substring(index1+1,index2));
            String str =string.substring(index1+1,index2);
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public GitHubUser getUser(String accesToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accesToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GitHubUser gitHubUser = JSON.parseObject(string, GitHubUser.class);
            return gitHubUser;
        } catch (IOException e) {
        }

        return null;
    }
}
