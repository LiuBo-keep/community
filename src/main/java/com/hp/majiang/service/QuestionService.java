package com.hp.majiang.service;

import com.hp.majiang.dto.QuestionDTO;
import com.hp.majiang.mapper.QuestionMapper;
import com.hp.majiang.mapper.UserMapper;
import com.hp.majiang.model.Question;
import com.hp.majiang.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName QuestionService
 * @Description TODO
 * @Author 17126
 * @Date 2020/6/27 18:42
 */

@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDTO> list() {

        List<Question> list = questionMapper.list();
        ArrayList<QuestionDTO> arrayList = new ArrayList<>();
        for (Question question:list){
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            arrayList.add(questionDTO);
        }
        return arrayList;
    }
}
