package com.linchao.backend.req;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EbookReq extends PageReq{
    private Long id;

    private String name;


}