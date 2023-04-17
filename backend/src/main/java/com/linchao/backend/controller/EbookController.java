package com.linchao.backend.controller;

import com.linchao.backend.req.EbookQueryReq;
import com.linchao.backend.req.EbookSaveReq;
import com.linchao.backend.resp.CommonResp;
import com.linchao.backend.resp.EbookQueryResp;
import com.linchao.backend.resp.PageResp;
import com.linchao.backend.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Steven
 * @create 2023-04-13-14:23
 */
@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookQueryReq req) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp();
        ebookService.save(req);
        return resp;
    }
}



