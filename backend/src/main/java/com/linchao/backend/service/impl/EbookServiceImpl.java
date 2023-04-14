package com.linchao.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linchao.backend.BackendApplication;
import com.linchao.backend.mapper.EbookMapper;
import com.linchao.backend.pojo.Ebook;
import com.linchao.backend.pojo.EbookExample;
import com.linchao.backend.req.EbookReq;
import com.linchao.backend.resp.EbookResp;
import com.linchao.backend.resp.PageResp;
import com.linchao.backend.service.EbookService;
import com.linchao.backend.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author Steven
 * @create 2023-04-07-21:33
 */
@Service
public class EbookServiceImpl implements EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(BackendApplication.class);

    @Autowired
    private EbookMapper ebookMapper;

    @Override
    public PageResp<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }

        PageHelper.startPage(req.getPage(),req.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("总行数: {}", pageInfo.getTotal());
        LOG.info("总页数: {}", pageInfo.getPages());

//        List<EbookResp> respList = new ArrayList<>();
//        for (Ebook ebook : ebookList) {
////            EbookResp ebookResp = new EbookResp();
////            BeanUtils.copyProperties(ebook, ebookResp);
            //  对象复制
//            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
//
//            respList.add(ebookResp);
//        }

        PageResp<EbookResp> pageResp = new PageResp();

        //  列表复制
        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }
}
