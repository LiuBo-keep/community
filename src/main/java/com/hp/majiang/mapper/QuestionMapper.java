package com.hp.majiang.mapper;

import com.hp.majiang.model.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName QuestionMapper
 * @Description TODO
 * @Author 17126
 * @Date 2020/6/27 17:03
 */

@Mapper
public interface QuestionMapper {
    List<Question> list();
}
