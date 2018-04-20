package cn.jyuyang.tms.service.serviceImpl;

import cn.jyuyang.tms.entity.StoreAccount;
import cn.jyuyang.tms.entity.StoreSticket;
import cn.jyuyang.tms.entity.StoreSticketExample;
import cn.jyuyang.tms.mapper.AccountMapper;
import cn.jyuyang.tms.mapper.StoreAccountMapper;
import cn.jyuyang.tms.mapper.StoreSticketMapper;
import cn.jyuyang.tms.service.StoreService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private AccountMapper accountMapper;
  @Autowired
    private StoreAccountMapper storeAccountMapper;
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
        storeAccount.setStoreSciketId(storeSticket.getId());
        storeAccount.setManagerMobile(storeSticket.getManagerMobile());
        storeAccount.setCreateTime(new Date());
        storeAccount.setManagerName(storeSticket.getManagerName());
        storeAccount.setPassword(DigestUtils.md5Hex(storeSticket.getManagerMobile().substring(7,11)));
        storeAccount.setUpdateTime(new Date());
        storeAccountMapper.insertSelective(storeAccount);

        storeSticket.setAccountId(storeAccount.getId());

        storeSticketMapper.updateByPrimaryKeySelective(storeSticket);


    }

    /**
     * 查询所有经典售票信息，包括对应的帐号信息
     *
     * @return
     */
    @Override
    public List<StoreSticket> selectAllStoreStricket() {

        StoreSticketExample storeSticketExample = new StoreSticketExample();
        return   storeSticketMapper.selectByExample(storeSticketExample);

    }

    /**
     * 根据id查询对应的售票点信息
     *
     * @param id
     * @return
     */
    @Override
    public StoreSticket selectStoreStricketById(Integer id) {
        return storeSticketMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新售票点信息
     *
     * @param storeSticket
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateStoreSticket(Integer id,StoreSticket storeSticket) {
        storeSticket.setUpdateTime(new Date());
        storeSticketMapper.updateByPrimaryKeySelective(storeSticket);

        storeSticket = storeSticketMapper.selectByPrimaryKey(id);

        StoreAccount storeAccount = storeAccountMapper.selectByPrimaryKey(1);

        storeAccount.setManagerMobile(storeSticket.getManagerMobile());
        storeAccount.setPassword(DigestUtils.md5Hex(storeSticket.getManagerMobile().substring(7,10)));
        storeAccount.setManagerName(storeSticket.getManagerName());
        storeAccount.setUpdateTime(new Date());
        storeAccountMapper.updateByPrimaryKeySelective(storeAccount);
    }
}
