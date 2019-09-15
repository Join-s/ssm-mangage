package com.luban.contoller;

import com.luban.po.*;
import com.luban.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 
 * Title:GoAction
 * describe: 跳转页面
 * @version 1.0
 */
@Controller
@PropertySource("classpath:systems.properties")
public class GoAction {
	@Value("${imgUrl}")
	public String imgUrl;
	@Value("${imgPath}")
	public String imgPath;
	@Autowired
	private LargeclassService largeclassService;
	@Autowired
	private SubclassService subclassService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private UserServcie userServcie;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private RebackService rebackService;
	@Autowired
	private ComponentsService componentsService;
	
	@RequestMapping("uploadOrder")
public String uploadOrder(Integer oid ,Model m) {
		
		TOrders ulist = ordersService.selectVoByOid(oid);
		m.addAttribute("ulist", ulist);
		
	return "orderUpload";
}

	@RequestMapping("/help")
	public String help(){
		return "help";
	}
	/**
	* @Description 方法描述: 前台首页
	 */
	
	@RequestMapping("/go")
	public String goIndex(HttpSession session){
		//公告信息
		if(session.getAttribute("notList")==null) {
			session.setMaxInactiveInterval(3600);
			List<TNotice> list= noticeService.selectTop();
			session.setAttribute("notList", list);
		}
		session.setAttribute("imgUrl", imgUrl);
		session.setAttribute("imgPath", imgPath);
		
		return "index";
	}
	/**
	* @Description 方法描述: 用户登陆界面
	 */
	@RequestMapping("/goLogin")
	public String goLogin(){
		return "login";
	}
	/**
	* @Description 方法描述: 管理员登陆界面
	 */
	@RequestMapping("/goLoginsys")
	public String goLoginsys(){
		return "loginsys";
	}
	/**
	* @Description 方法描述: 用户注册
	 */
	@RequestMapping("/goRegister")
	public String goRegister(HttpSession session){
		
		List<TDepartment> det=userServcie.queryDep();
		session.setAttribute("depList",det );
		return "register";
	}
	/**
	* @Description 方法描述: 注册结果
	 */
	@RequestMapping("/goRegisterResult")
	public String goRegisterResult(){
		return "register-result";
	}
	/**
	* @Description 方法描述: 前台元件主页
	 */
	@RequestMapping("/goC")
	public String goComponentList(HttpSession session){
		//元件列表
		TLargeclass tcLargeclass=new TLargeclass();
		List<TLargeclass> list =largeclassService.selectVo(tcLargeclass);
		session.setAttribute("llist",list);
		session.setAttribute("imgUrl", imgUrl);
		session.setAttribute("imgPath", imgPath);
		return "componentList";
	}
	/**
	* @Description 方法描述: 登出
	 */
	@RequestMapping("/goOut")
	public String goOut(HttpSession session){
		session.invalidate();
		return "redirect:/hms/go";
	}
	/**
	* @Description 方法描述: 后台首页
	 */
	@RequestMapping("/goM")
	//mangage/index
	public String goM(){
		return "redirect:/hms/user/login";
	}
	/**
	* @Description 方法描述: 后台公告列表
	 */
	@RequestMapping("/goNotList")
	public String goNotList(){
		return "mangage/notice/noticeList";
	}
	/**
	* @Description 方法描述: 后台添加公告
	 */
	@RequestMapping("/goNotAdd")
	public String goNotAdd(){
		return "mangage/notice/noticeadd";
	}
	/**
	* @Description 方法描述: 后台欢迎界面
	 */
	@RequestMapping("/goWel")
	public String goWel(){
		return "mangage/welcome";
	}
	/**
	* @Description 方法描述: 后台添加元件
	 */
	@RequestMapping("/goComAdd")
	public String goComAdd(Model m){
		
		
		TLargeclassExample example =new TLargeclassExample();
		com.luban.po.TLargeclassExample.Criteria c=example.createCriteria();
		c.andIdIsNotNull();
		List<TLargeclass> largeclasses=largeclassService.selectByExample(example);
		
		TSubclassExample example2 =new TSubclassExample();
		com.luban.po.TSubclassExample.Criteria c2=example2.createCriteria();
		c2.andIdIsNotNull();
		List<TSubclass> subclasses=subclassService.selectByExample(example2);
		
		m.addAttribute("largeclasses", largeclasses);
		m.addAttribute("subclasses", subclasses);
		
		return "mangage/components/componentsAdd";
	}
	/**
	* @Description 方法描述: 后台元件库操作
	 */
	@RequestMapping("/goComH")
	public String goComH(){
		return "mangage/components/componentsHouse";
	}
	/**
	* @Description 方法描述: 后台学生订单审核操作
	 */
	@RequestMapping("/goOrdersList")
	public String goOrdersList(){
		
		return "mangage/components/ordersList";
	}
	/**
	 * 前台网页
	 * @return
	 */
	@RequestMapping("/jiehuan")
public String goJiehuan(Model mv,Integer uid){
		
		TComponentExample t=new TComponentExample();
		com.luban.po.TComponentExample.Criteria c=t.createCriteria();
		c.andRemark3EqualTo("1");
		List<TComponent> cclist=componentsService.selectByExample(t);
		
		mv.addAttribute("clist", cclist);

		RebackExample re=new RebackExample();
		com.luban.po.RebackExample.Criteria c2=re.createCriteria();
		c2.andUidEqualTo(uid);
		List<Reback> rblist=rebackService.selectByExample(re);
		mv.addAttribute("rblist", rblist);
		
		
		return "jiehuan";
	}
	
}
