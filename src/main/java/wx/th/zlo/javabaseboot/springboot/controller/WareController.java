package wx.th.zlo.javabaseboot.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wx.th.zlo.javabaseboot.springboot.entity.WarehouseEntity;
import wx.th.zlo.javabaseboot.springboot.repository.WarehouseMapper;

import java.util.List;

/**
 * ClassName: WareController
 * Description: TODO
 * Author: zlo
 * Date: 2022/10/13 10:26
 * Version: 1.0.0
 */
@RestController
@RequestMapping("/ware")
public class WareController {
    @Autowired
    WarehouseMapper warehouseMapper;


    @RequestMapping("/getlist")
    public List<WarehouseEntity> getList(){
        QueryWrapper<WarehouseEntity> query = new QueryWrapper<>();
        // query.like("fullName","1");
        query.lambda().like(WarehouseEntity::getId,"%1%");
        return  warehouseMapper.selectList(query);
    }
}
