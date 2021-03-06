package com.hp.majiang.mapper;

import com.hp.majiang.model.Question;
import com.hp.majiang.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author 17126
 * @Date 2020/6/15 17:35
 */

@Mapper
@Repository
public interface UserMapper {

    public Integer add(User user);

    public void create(Question question);

    User findById(Integer id);
}
