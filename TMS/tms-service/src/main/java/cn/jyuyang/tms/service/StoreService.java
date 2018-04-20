package cn.jyuyang.tms.service;

import cn.jyuyang.tms.entity.StoreSticket;

import java.util.List;

public interface StoreService {
    /**
     * 保存新增的售票点信息
     * @param storeSticket
     */
    void saveStoreSticket(StoreSticket storeSticket);

    /**
     * 查询所有经典售票信息，包括对应的帐号信息
     * @return
     */
    List<StoreSticket> selectAllStoreStricket();

    /**
     * 根据id查询对应的售票点信息
     * @param id
     * @return
     */
    StoreSticket selectStoreStricketById(Integer id);

    /**
     * 更新售票点信息
     * @param storeSticket
     */
    void updateStoreSticket(Integer id,StoreSticket storeSticket);
}
