package com.luban.contoller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luban.po.Reback;
import com.luban.po.RebackExample;
import com.luban.po.RebackExample.Criteria;
import com.luban.po.TComponent;
import com.luban.po.TOrderdetails;
import com.luban.po.TOrders;
import com.luban.po.TUser;
import com.luban.service.ComponentsService;
import com.luban.service.OrdersService;
import com.luban.service.RebackService;
import com.luban.service.TOrderdetailsService;

/**
 * 
 * @Description 描述: 订单控制
 * @author 作者: hellc
 * @date 时间: 2018年12月13日 下午5:53:02
 */
@Controller
public class OrdersAction {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private TOrderdetailsService tOrderdetailsService;
	@Autowired
	private ComponentsService componentsService;
	@Autowired
	private RebackService rebackService;
	
	/************** 前台业务 ******************/
	// 前台订单
	@RequestMapping("/order/orders")
	public @ResponseBody TOrders selectVoByOid(Integer oid) {
		return ordersService.selectVoByOid(oid);
	}

	// 前台订单删除Vo
	@RequestMapping("/order/delete")
	public String deleteVoByid(Integer id) {
		ordersService.deleteVoByid(id);
		return "forward:/hms/user/myOrderList";

	}

	// 购物车功能
	@RequestMapping("/od/add")
	public @ResponseBody String addShoppingcat(HttpSession session, Integer id, Integer number) {
		// 购车车列表
		List<Integer> idsList = session.getAttribute("idsList") == null ? new ArrayList<Integer>()
				: (ArrayList<Integer>) session.getAttribute("idsList");
		// 购物车数量
		Map<Integer, Integer> idsMap = session.getAttribute("idsMap") == null ? new HashMap<Integer, Integer>()
				: (HashMap<Integer, Integer>) session.getAttribute("idsMap");

		if (idsList.contains(id)) {// 如果list包含了
			if (idsMap.containsKey(id)) {// map里有
				if (number == null)
					idsMap.put(id, idsMap.get(id) + 1);
				else
					idsMap.put(id, number);
			} else {// map没有
				if (number == null)
					idsMap.put(id, 1);
				else
					idsMap.put(id, number);
			}
		} else {// 如果list没有包含

			idsList.add(id);

			if (number == null)
				idsMap.put(id, 1);
			else
				idsMap.put(id, number);
		}

		List<TComponent> tComponentsList = componentsService.selectByExample(idsList);

		session.setAttribute("idsList", idsList);
		session.setAttribute("idsMap", idsMap);
		session.setAttribute("tComponentsList", tComponentsList);
//		return "redirect:/goC";// 登陆到首页
		return "OK";
	}

	// 购物车功能
	@RequestMapping("/od/delete")
	public String delete(HttpSession session, Integer id) {
		// 购车车列表
		List<Integer> idsList = session.getAttribute("idsList") == null ? new ArrayList<Integer>()
				: (ArrayList<Integer>) session.getAttribute("idsList");
		// 购物车数量
		Map<Integer, Integer> idsMap = session.getAttribute("idsMap") == null ? new HashMap<Integer, Integer>()
				: (HashMap<Integer, Integer>) session.getAttribute("idsMap");

		if (idsList.contains(id)) {// 如果list包含了
			idsList.remove(id);
			if (idsMap.containsKey(id)) {// map里有
				idsMap.remove(id);
			}
		}
		List<TComponent> tComponentsList = null;
		if (idsList != null && idsList.size() > 0) {
			tComponentsList = componentsService.selectByExample(idsList);
		}
		session.setAttribute("idsList", idsList);
		session.setAttribute("idsMap", idsMap);
		session.setAttribute("tComponentsList", tComponentsList);

		return "shoppingcart";// 登陆到首页
	}

	// 购物车功能 提交订单
	@RequestMapping("/od/addCart")
	public String addcart(HttpSession session,Integer uid) {
		List<Integer> idsList = session.getAttribute("idsList") == null ? new ArrayList<Integer>()
				: (ArrayList<Integer>) session.getAttribute("idsList");
		// 购物车数量
		Map<Integer, Integer> idsMap = session.getAttribute("idsMap") == null ? new HashMap<Integer, Integer>()
				: (HashMap<Integer, Integer>) session.getAttribute("idsMap");

		if (idsList != null && idsList.size() > 0) {
			TOrders t = new TOrders();
			t.setUid(uid);

			List<TOrderdetails> toList = new ArrayList<TOrderdetails>();

			for (Integer id : idsList) {
				TOrderdetails to = new TOrderdetails();
				to.setCid(id);
				to.setNumber(idsMap.get(id));

				toList.add(to);
			}
			int result = ordersService.insertCart(t, toList);
			if (result > 0) {
				session.removeAttribute("idsList");
				session.removeAttribute("idsMap");
				session.removeAttribute("tComponentsList");
			}
		}
		return "shoppingcart";// 登陆到首页
	}

	// 购物车功能 清除购物车
	@RequestMapping("/od/deleteCart")
	public String deleteCart(HttpSession session) {
		session.removeAttribute("idsList");
		session.removeAttribute("idsMap");
		session.removeAttribute("tComponentsList");
		return "shoppingcart";// 登陆到首页
	}

	/****************** 后台业务 ********************/

	/**
	 * 
	 * @Description 方法描述: 显示订单列表
	 * @param 参数:@return
	 * @return 返回类型:String
	 * @throws 异常: status 审核状态 1：未审核 2：已审核 3：打回
	 */
	@RequestMapping("/or/queryList")
	public String findList(HttpSession session, Integer pageNum, Integer status, Integer oid) {
		// status 1：未审核 2：已审核 3：打回
		if (pageNum == null || pageNum < 1) {
			if (session.getAttribute("pageNum") == null)
				pageNum = 1;
			else
				pageNum = (Integer) session.getAttribute("pageNum");
		}

		PageHelper.startPage(pageNum, 1000000);// 页面大小

		if (oid == null) {
			session.setAttribute("oid", null);
		}

		if (session.getAttribute("oid") != null)
			oid = (Integer) session.getAttribute("oid");

		if (session.getAttribute("status") == null)
			status = 0;
		else {
			if (status == null)
				status = (Integer) session.getAttribute("status");
		}

		if (status != 0)
			PageHelper.orderBy("createtime DESC");

		List<TOrders> ulist = ordersService.selectVoByUid(oid);

		PageInfo<TOrders> pageInfo = new PageInfo<TOrders>(ulist);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("oid", oid);
		session.setAttribute("OrdersPageInfo", pageInfo);
		session.setAttribute("status", status);

		return "mangage/orders/ordersList";
	}

	/**
	 * 
	 * @Description 方法描述: 批量删除学生订单
	 * @param 参数:@param ids
	 * @param 参数:@return
	 * @return 返回类型:String
	 * @throws 异常:
	 */
	@RequestMapping("deleteStuOrders")
	public String deleteStuOrders(Integer[] ids) {
		int i = ordersService.deleteStuOrders(ids);
		return "redirect:/hms/or/queryList";
	}
	
	@RequestMapping("or/update")
	public String update(TOrders t) {
		ordersService.update(t);
		
		return "redirect:/hms/or/queryList";
	}

	/**
	 * 
	 * @Description 方法描述: 显示订单菜单
	 * @param 参数:@return
	 * @return 返回类型:String
	 * @throws 异常:
	 */
	@RequestMapping("/or/queryHouse")
	public String findHouse(Model mv) {
		RebackExample re=new RebackExample();
		com.luban.po.RebackExample.Criteria c=re.createCriteria();
		c.andIdNotBetween(-1, -2);
		List<Reback> rblist=rebackService.selectByExample(re);
		mv.addAttribute("rblist", rblist);
		
		return "mangage/orders/ordersHouse";
	}
	//借入元件
	@RequestMapping("/or/insertReaback")
	public String insertReaback(Reback reback,HttpSession session) {
		reback.setCname(componentsService.findById(reback.getCid()).getName());
		reback.setCreatetime(new Date());
		reback.setState(0);
		TUser tu=(TUser)session.getAttribute("user");
		reback.setUname(tu.getName());
		rebackService.insert(reback);
		return "redirect:/hms/user/shoppingcat";
		
	}
	@RequestMapping("/or/updateById")
	public String  updateById(Reback record) {
		rebackService.updateByPrimaryKeySelective(record);
		return "mangage/orders/ordersHouse";
	}
	@RequestMapping("/or/deleteById")
	public String  deleteById(Reback record) {
		rebackService.deleteByPrimaryKey(record.getId());
		return "mangage/orders/ordersHouse";
	}

}
