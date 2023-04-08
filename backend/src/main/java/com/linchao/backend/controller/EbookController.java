package com.linchao.backend.controller;

import com.linchao.backend.pojo.Ebook;
import com.linchao.backend.resp.CommonResp;
import com.linchao.backend.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Steven
 * @create 2023-04-08-13:35
 */
@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    private EbookService ebookService;

    @GetMapping("/list")
    private CommonResp list() {
        CommonResp<List<Ebook>> resp = new CommonResp<>();
        List<Ebook> list =  ebookService.list();
        resp.setContent(list);
        return resp;
    }
}
