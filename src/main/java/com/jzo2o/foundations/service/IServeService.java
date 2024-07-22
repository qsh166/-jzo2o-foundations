package com.jzo2o.foundations.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jzo2o.common.model.PageResult;
import com.jzo2o.foundations.model.domain.Serve;
import com.jzo2o.foundations.model.domain.ServeItem;
import com.jzo2o.foundations.model.dto.request.ServePageQueryReqDTO;
import com.jzo2o.foundations.model.dto.request.ServeUpsertReqDTO;
import com.jzo2o.foundations.model.dto.response.ServeResDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IServeService  extends IService<Serve> {
    /**
     *分页查询
     * @param servePageQueryReqDTO
     * @return
     */
    PageResult<ServeResDTO> page(ServePageQueryReqDTO servePageQueryReqDTO);

    /**
     * 指定区域新增服务
     * @param serveUpsertReqDTOList
     */
    void batchAdd(List<ServeUpsertReqDTO> serveUpsertReqDTOList);

    /**
     * 修改价格
     * @param id
     * @param price
     */
    void update(Long id, BigDecimal price);

    /**
     * 区域服务上架
     * @param id
     */
    void onSale(Long id);

    /**
     * 区域服务下架
     * @param id
     */
    void offSale(Long id);

    /**
     * 区域服务删除
     * @param id
     */
    void deleteById(Long id);
}
