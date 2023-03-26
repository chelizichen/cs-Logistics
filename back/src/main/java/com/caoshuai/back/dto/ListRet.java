package com.caoshuai.back.dto;

import java.util.List;

public class ListRet {
    public List list;
    public Long total;

    public ListRet(List list,Long total){
        this.list = list;
        this.total = total;
    }

}
