package com.linchao.backend.service.impl;

import com.linchao.backend.mapper.EbookMapper;
import com.linchao.backend.pojo.Ebook;
import com.linchao.backend.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Steven
 * @create 2023-04-07-21:33
 */
@Service
public class EbookServiceImpl implements EbookService {

    @Autowired
    private EbookMapper ebookMapper;

    @Override
    public List<Ebook> list() {
        return ebookMapper.selectByExample(null);
    }
}
