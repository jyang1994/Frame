package cn.jyuyang.tms.service;

import cn.jyuyang.tms.entity.StoreSticket;
import cn.jyuyang.tms.entity.TicketOut;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据搜索条件查询满足条件的售票点，并以分页返回
     * @param queryParam
     * @return
     */
    PageInfo<StoreSticket> selectByPageInfo(Integer pageNo,  Map<String,Object> queryParam);

    /**
     * 根据ID删除对应的售票点和对应账号
     * @param id
     */
    void delStoreSticketById(Integer id);

}
