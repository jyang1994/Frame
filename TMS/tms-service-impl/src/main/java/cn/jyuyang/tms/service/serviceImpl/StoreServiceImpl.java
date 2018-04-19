package cn.jyuyang.tms.service.serviceImpl;

import cn.jyuyang.tms.entity.StoreAccount;
import cn.jyuyang.tms.entity.StoreSticket;
import cn.jyuyang.tms.mapper.AccountMapper;
import cn.jyuyang.tms.mapper.StoreAccountMapper;
import cn.jyuyang.tms.mapper.StoreSticketMapper;
import cn.jyuyang.tms.service.StoreService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private AccountMapper accountMapper;
  @Autowired
    private StoreAccountMapper stoerAccountMapper;
    @Autowired
    private StoreSticketMapper storeSticketMapper;

    /**
     * 保存新增的售票点信息
     *15738510296
     * @param storeSticket
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void saveStoreSticket(StoreSticket storeSticket) {
        storeSticket.setState(StoreSticket.STORE_STATE_NORMAl);
        storeSticket.setCreateTime(new Date());
        storeSticketMapper.insertSelective(storeSticket);


        StoreAccount storeAccount = new StoreAccount();
        storeAccount.setStoreSticketId(storeSticket.getId());
        storeAccount.setMobile(storeSticket.getManagerMobile());
        storeAccount.setCreateTime(new Date());
        storeAccount.setName(storeSticket.getManagerName());
        storeAccount.setPassword(DigestUtils.md5Hex(storeSticket.getManagerMobile().substring(7,11)));

        stoerAccountMapper.insertSelective(storeAccount);

        storeSticket.setAccountId(storeAccount.getId());

        storeSticketMapper.updateByPrimaryKeySelective(storeSticket);


    }
}
