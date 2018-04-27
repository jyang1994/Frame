package cn.jyuyang.tms.service.serviceImpl;

import cn.jyuyang.tms.entity.StoreAccount;
import cn.jyuyang.tms.entity.StoreAccountExample;
import cn.jyuyang.tms.mapper.StoreAccountMapper;
import cn.jyuyang.tms.service.StoreAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreAccountServiceImpl implements StoreAccountService{
    @Autowired
    private StoreAccountMapper storeAccountMapper;
    /**
     * 根据传来的参数，查找对应的storeACCOUNT
     *
     * @param userName
     * @return
     */
    @Override
    public StoreAccount findStoreAccount(String userName) {
        StoreAccountExample storeAccountExample = new StoreAccountExample();
        storeAccountExample.createCriteria().andManagerMobileEqualTo(userName);
        StoreAccount storeAccount = storeAccountMapper.selectByExample(storeAccountExample).get(0);
        System.out.println("mobile--------------------"+storeAccount.getManagerMobile());

        return storeAccount;
    }

    /**
     * 查找对应好的account以及对应的store
     *
     * @param userName
     * @return
     */
    @Override
    public StoreAccount findStoreAccountWithStore(String userName) {
        StoreAccount storeAccount = storeAccountMapper.findAccountWithStore(userName);
        System.out.println(storeAccount.getManagerMobile()+"--------------------------------");
        return storeAccount;
    }
}
