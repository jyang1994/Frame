package cn.jyuyang.tms.service;

import cn.jyuyang.tms.entity.StoreSticket;

public interface StoreService {
    /**
     * 保存新增的售票点信息
     * @param storeSticket
     */
    void saveStoreSticket(StoreSticket storeSticket);
}
