package com.jzo2o.foundations.controller.operation;


import cn.hutool.core.bean.BeanUtil;
import com.jzo2o.api.foundations.dto.response.RegionSimpleResDTO;
import com.jzo2o.common.model.PageResult;
import com.jzo2o.foundations.model.domain.Region;
import com.jzo2o.foundations.model.dto.request.RegionPageQueryReqDTO;
import com.jzo2o.foundations.model.dto.request.RegionUpsertReqDTO;
import com.jzo2o.foundations.model.dto.request.ServePageQueryReqDTO;
import com.jzo2o.foundations.model.dto.request.ServeUpsertReqDTO;
import com.jzo2o.foundations.model.dto.response.RegionResDTO;
import com.jzo2o.foundations.model.dto.response.ServeResDTO;
import com.jzo2o.foundations.service.IRegionService;
import com.jzo2o.foundations.service.IServeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 区域表 前端控制器
 * </p>
 *
 * @author itcast
 * @since 2023-07-03
 */
@Validated

@RestController("operationServeController")
@RequestMapping("/operation/serve")
@Api(tags = "运营端 - 区域服务相关接口")
public class ServeController {
    //    @Resource
//    private IRegionService regionService;
    @Resource
    private IServeService iServeService;

    //
//    @GetMapping("/activeRegionList")
//    @ApiOperation("已开通服务区域列表")
//    public List<RegionSimpleResDTO> activeRegionList() {
//        return regionService.queryActiveRegionList();
//    }
//
    @PostMapping("/batch")
    @ApiOperation("区域服务批量新增")
    public void add(@RequestBody List<ServeUpsertReqDTO> serveUpsertReqDTOList) {
        iServeService.batchAdd(serveUpsertReqDTOList);
    }

    @PutMapping("/{id}")
    @ApiOperation("区域服务价格修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "服务id", required = true, dataTypeClass = Long.class),
            @ApiImplicitParam(name = "price", value = "价格", required = true, dataTypeClass = BigDecimal.class)
    })
    public void update(@PathVariable("id") Long id,
                       @RequestParam("price") BigDecimal price) {
        iServeService.update(id, price);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("区域服务删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "服务id", required = true, dataTypeClass = Long.class)
    })
    public void delete(@NotNull(message = "id不能为空") @PathVariable("id") Long id) {
        iServeService.deleteById(id);
    }


    @GetMapping("/page")
    @ApiOperation("区域分页查询")
    public PageResult<ServeResDTO> page(ServePageQueryReqDTO servePageQueryReqDTO) {
        return iServeService.page(servePageQueryReqDTO);
    }

    @PutMapping("/onSale/{id}")
    @ApiOperation("区域服务上架")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "服务id", required = true, dataTypeClass = Long.class),
    })
    public void onSale(@PathVariable("id") Long id) {
        iServeService.onSale(id);
    }

    @PutMapping("/offSale/{id}")
    @ApiOperation("区域服务下架")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "服务id", required = true, dataTypeClass = Long.class),
    })
    public void offSale(@PathVariable("id") Long id) {
        iServeService.offSale(id);
    }
//
//    @GetMapping("/{id}")
//    @ApiOperation("根据id查询")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "区域id", required = true, dataTypeClass = Long.class)
//    })
//    public RegionResDTO findById(@NotNull(message = "id不能为空") @PathVariable("id") Long id) {
//        Region region = regionService.getById(id);
//        return BeanUtil.toBean(region, RegionResDTO.class);
//    }
//
//    @PutMapping("/activate/{id}")
//    @ApiOperation("区域启用")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "区域id", required = true, dataTypeClass = Long.class),
//    })
//    public void activate(@PathVariable("id") Long id) {
//        regionService.active(id);
//    }
//
//    @PutMapping("/deactivate/{id}")
//    @ApiOperation("区域禁用")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "区域id", required = true, dataTypeClass = Long.class),
//    })
//    public void deactivate(@PathVariable("id") Long id) {
//        regionService.deactivate(id);
//    }
//
//    @PutMapping("/refreshRegionRelateCaches/{id}")
//    @ApiOperation("刷新区域相关缓存")
//    public void refreshRegionRelateCaches(@PathVariable("id") Long id) {
//        //todo
////        homeService.refreshRegionRelateCaches(id);
//    }
}
