package com.linchao.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linchao.backend.BackendApplication;
import com.linchao.backend.mapper.EbookMapper;
import com.linchao.backend.pojo.Ebook;
import com.linchao.backend.pojo.EbookExample;
import com.linchao.backend.req.EbookQueryReq;
import com.linchao.backend.req.EbookSaveReq;
import com.linchao.backend.resp.EbookQueryResp;
import com.linchao.backend.resp.PageResp;
import com.linchao.backend.service.EbookService;
import com.linchao.backend.util.CopyUtil;
import com.linchao.backend.util.SnowFlake;
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

    @Autowired
    private SnowFlake snowFlake;

    @Override
    public PageResp<EbookQueryResp> list(EbookQueryReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }

        PageHelper.startPage(req.getPage(), req.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("总行数: {}", pageInfo.getTotal());
        LOG.info("总页数: {}", pageInfo.getPages());

//        List<EbookQueryResp> respList = new ArrayList<>();
//        for (Ebook ebook : ebookList) {
////            EbookQueryResp ebookResp = new EbookQueryResp();
////            BeanUtils.copyProperties(ebook, ebookResp);
        //  对象复制
//            EbookQueryResp ebookResp = CopyUtil.copy(ebook, EbookQueryResp.class);
//
//            respList.add(ebookResp);
//        }

        PageResp<EbookQueryResp> pageResp = new PageResp();

        //  列表复制
        List<EbookQueryResp> list = CopyUtil.copyList(ebookList, EbookQueryResp.class);
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        System.out.println("pageResp" + pageResp);

        return pageResp;
    }

    @Override
    public void save(EbookSaveReq req) {
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            // 新增
            ebook.setId(snowFlake.nextId());
            ebookMapper.insert(ebook);
        } else {
            // 更新
            ebookMapper.updateByPrimaryKey(ebook);
        }
    }

    @Override
    public void delete(Long id) {
        ebookMapper.deleteByPrimaryKey(id);
    }
}
