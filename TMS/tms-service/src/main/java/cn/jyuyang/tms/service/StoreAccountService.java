package cn.jyuyang.tms.service;

import cn.jyuyang.tms.entity.StoreAccount;

public interface StoreAccountService {
    /**
     * 根据传来的参数，查找对应的storeACCOUNT
     * @param userName
     * @return
     */
    StoreAccount findStoreAccount(String userName);

    /**
     * 查找对应好的account以及对应的store
     * @param userName
     * @return
     */
    StoreAccount findStoreAccountWithStore(String userName);
}
