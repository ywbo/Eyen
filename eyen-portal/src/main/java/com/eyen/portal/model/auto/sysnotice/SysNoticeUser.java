package com.eyen.portal.model.auto.sysnotice;

import java.io.Serializable;

/**
 * 用户系统公告
 *
 * @author yuwenbo
 * @date 2022/11/7 23:02
 **/
public class SysNoticeUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     **/
    private String id;

    /**
     * 公告id
     **/
    private String noticeId;

    /**
     * 用户id
     **/
    private String userId;

    /**
     * 0未阅读 1 阅读
     **/
    private Integer state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public SysNoticeUser(String id, String noticeId, String userId, Integer state) {

        this.id = id;
        this.noticeId = noticeId;
        this.userId = userId;
        this.state = state;

    }
}
