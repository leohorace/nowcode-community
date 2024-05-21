package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;
//bean默认name为类名首字母小写，下面自定义name
@Repository("alphaHi")
public class AlphaDaoHi implements AlphaDao {

    @Override
    public String select() {
        return "HHHHH";
    }

}
