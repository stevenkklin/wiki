package com.linchao.backend.service;

import com.linchao.backend.req.EbookReq;
import com.linchao.backend.resp.EbookResp;

import java.util.List;

/**
 * @author Steven
 * @create 2023-04-07-21:32
 */
public interface EbookService {
    List<EbookResp> list(EbookReq req);
}
