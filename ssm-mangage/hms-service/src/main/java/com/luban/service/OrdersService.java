package com.luban.service;

import java.util.List;
import java.util.Map;

import com.luban.po.TOrderdetails;
import com.luban.po.TOrders;

public interface OrdersService {
	//根据uid
	List<TOrders> selectVoByUid(Integer oid );
	//根据订单id查询
	TOrders selectVoByOid(Integer oid);
	 //删除Vo
    int deleteVoByid(Integer id);
    int update(TOrders tOrders);
    //添加订单
    int insertCart(TOrders tOrders,List<TOrderdetails> tOrderdetailsList) ;
    //后台批量删除学生订单
      int deleteStuOrders(Integer[] ids) ;
}
