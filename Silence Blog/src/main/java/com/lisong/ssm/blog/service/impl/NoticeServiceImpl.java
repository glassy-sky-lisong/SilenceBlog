package com.lisong.ssm.blog.service.impl;

import com.lisong.ssm.blog.entity.Notice;
import com.lisong.ssm.blog.mapper.NoticeMapper;
import com.lisong.ssm.blog.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : lisong
 * @date : 2019-09-24 01:14
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired(required = false)
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> listNotice(Integer status)  {
        return noticeMapper.listNotice(status);
    }

    @Override
    public void insertNotice(Notice notice)  {
        noticeMapper.insert(notice);
    }

    @Override
    public void deleteNotice(Integer id)  {
        noticeMapper.deleteById(id);
    }

    @Override
    public void updateNotice(Notice notice)  {
        noticeMapper.update(notice);
    }

    @Override
    public Notice getNoticeById(Integer id)  {
        return noticeMapper.getNoticeById(id);
    }
}
