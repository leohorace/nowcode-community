package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
//装配到容器中
@Repository
//在容器同类型中被优先扫描到执行
@Primary
public class AlphaDaoMi implements AlphaDao {

    @Override
    public  String select() {
        return "MMMMMM";
    }

}
