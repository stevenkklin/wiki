package com.linchao.backend.service;

import com.linchao.backend.req.EbookQueryReq;
import com.linchao.backend.req.EbookSaveReq;
import com.linchao.backend.resp.EbookQueryResp;
import com.linchao.backend.resp.PageResp;

/**
 * @author Steven
 * @create 2023-04-07-21:32
 */
public interface EbookService {
    PageResp<EbookQueryResp> list(EbookQueryReq req);

    void save(EbookSaveReq req);

}
