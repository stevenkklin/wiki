package com.linchao.backend.service;

import com.linchao.backend.req.EbookReq;
import com.linchao.backend.resp.EbookResp;
import com.linchao.backend.resp.PageResp;

/**
 * @author Steven
 * @create 2023-04-07-21:32
 */
public interface EbookService {
    PageResp<EbookResp> list(EbookReq req);
}
