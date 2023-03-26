package com.caoshuai.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pagination {
    // 分页条数
    public String size;
    // 页数
    public String page;
    // 关键词过滤
    public String keyword;
}
