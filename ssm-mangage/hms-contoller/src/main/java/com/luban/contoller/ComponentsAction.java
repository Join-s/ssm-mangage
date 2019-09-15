package com.luban.contoller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luban.po.*;
import com.luban.service.ComponentsService;
import com.luban.service.LargeclassService;
import com.luban.service.SubclassService;
import com.luban.util.ComponentsExcel;
import com.luban.util.POIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("comp")
@PropertySource("classpath:systems.properties")
public class ComponentsAction {
	@Value("${imgPath}")
	public String imgPath;
	
	@Autowired
	private ComponentsService componentsService;
	@Autowired
	private LargeclassService largeclassService;
	@Autowired
	private SubclassService subclassService;


	@RequestMapping("test1")
	@ResponseBody
	public Object s(){
	return 	componentsService.selectAll();
	}
	@RequestMapping("test2")
	@ResponseBody
	public Object s2(){
		TComponent c=new TComponent();
		return 	componentsService.selectAll(c);
	}
	@RequestMapping("test3")
	@ResponseBody
	public Object s3(){
		TComponent c=new TComponent();
		c.setName("电");
		return 	componentsService.selectByCom(c);
	}




	@RequestMapping("upComp")
	public String upComp(@RequestParam("file") MultipartFile file,TComponent t, HttpServletRequest request) {
		String myImgName;
		if (!file.isEmpty()) {

			String contextPath = request.getContextPath();// "/SpringMvcFileUpload"
			String servletPath = request.getServletPath();// "/gotoAction"
			String scheme = request.getScheme();// "http"
			
			String storePath = imgPath;// 存放我们上传的文件路径

			String fileName = file.getOriginalFilename();

			File filepath = new File(storePath, fileName);
			
			t.setImg(fileName);

			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();// 如果目录不存在，创建目录
			}
			try {
				file.transferTo(new File(storePath + File.separator + fileName));// 把文件写入目标文件地址
			} catch (Exception e) {
				e.printStackTrace();
			}
			componentsService.updateByPrimaryKeySelective(t);
			
		
		}
		return "redirect:/hms/goComAdd";
	}
	
	@RequestMapping("addComp")
	public String addComp(@RequestParam("file") MultipartFile file,TComponent t, HttpServletRequest request) {
		String myImgName;
		if (!file.isEmpty()) {

			String contextPath = request.getContextPath();// "/SpringMvcFileUpload"
			String servletPath = request.getServletPath();// "/gotoAction"
			String scheme = request.getScheme();// "http"
			
			String storePath = imgPath;// 存放我们上传的文件路径

			String fileName = file.getOriginalFilename();

			File filepath = new File(storePath, fileName);
			
			t.setImg(fileName);

			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();// 如果目录不存在，创建目录
			}
			try {
				file.transferTo(new File(storePath + File.separator + fileName));// 把文件写入目标文件地址
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(t.getId()!=null){
				componentsService.insert(t);
			}
		
		}
		return "redirect:/hms/goComAdd";
	}
	
	
	
	
	@RequestMapping("upfile")
	public void upfile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		if (!file.isEmpty()) {

			String contextPath = request.getContextPath();// "/SpringMvcFileUpload"
			String servletPath = request.getServletPath();// "/gotoAction"
			String scheme = request.getScheme();// "http"

			String storePath = imgPath;// 存放我们上传的文件路径

			String fileName = file.getOriginalFilename();

			File filepath = new File(storePath, fileName);
			
			

			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();// 如果目录不存在，创建目录
			}
			try {
				file.transferTo(new File(storePath + File.separator + fileName));// 把文件写入目标文件地址
			} catch (Exception e) {
				e.printStackTrace();
//                return "error";
			}
//            return "success";//返回到成功页面
			try {
				List<String[]> lists = POIUtil.readExcel(file);
				List<TComponent> tComponentsList=new ArrayList<TComponent>();
				for (String[] s : lists) {
					if(s.length>=8) {
						TComponent t = new TComponent();
						t.setName(s[0]);//元件名
						if (s[1] != null && !"".equals(s[1].trim())) {
							t.setSpecification(s[1]);
						} else {
							t.setSpecification("Nothing Specification");
						}
						t.setVal(s[2]);// 值
						if (s[3] != null && !"".equals(s[3].trim())) {
							t.setPrice(Float.parseFloat(s[3]));// 单价
						} else {
							t.setPrice((Float) 0f);// 单价
						}
						if (s[4] != null && !"".equals(s[4].trim())) {
							t.setStore((int) Float.parseFloat(s[4]));// 库存
						} else {
							t.setStore(1);// 库存
						}
						if (s[5] != null && !"".equals(s[5].trim())) {
							t.setPlace(s[5]);// 库存位置
						} else {
							t.setPlace("#AAA");// 库存位置
						}


						TSubclass ts = new TSubclass();
						if (s[6] != null && !"".equals(s[6].trim())) {
							ts.setName(s[6]);
						} else {
							ts.setName("其他");
						}
						TLargeclass tl = new TLargeclass();
						if (s[7] != null && !"".equals(s[7].trim())) {
							tl.setName(s[7]);
						} else {
							tl.setName("其他");
						}
						ts.settLargeclass(tl);

						t.settSubclass(ts);

						tComponentsList.add(t);
					}
				//	TLargeclassExample tle = new TLargeclassExample();
				//	com.luban.po.TLargeclassExample.Criteria c = tle.createCriteria();
				//	c.andIdEqualTo(tl.getId());
				//	List tlelist = largeclassService.selectByExample(tle);
				//	if (tlelist == null || tlelist.size() < 1) {
				//		largeclassService.insert(tl);
				//	}
				//	TSubclassExample tce = new TSubclassExample();
				//	com.luban.po.TSubclassExample.Criteria cc = tce.createCriteria();
				//	cc.andIdEqualTo(ts.getId());
				//	List cclist = subclassService.selectByExample(tce);
				//	if (cclist == null || cclist.size() < 1) {
				//		subclassService.insert(ts);
				//	}
				//	componentsService.insert(t);
				//	System.out.println();
				}//for
				TLargeclass lcTemp=new TLargeclass();
int idtemp=0;
int len=tComponentsList.size();
String lcNameLast="*";
//大类处理
for(int i=0;i<len;i++){
//获取
	lcTemp=tComponentsList.get(i).gettSubclass().gettLargeclass();
	List<TLargeclass> lclisttemp=new ArrayList<TLargeclass>();
	lclisttemp=largeclassService.selectByName(lcTemp.getName());
	//数据库不存在
	if(lclisttemp==null || lclisttemp.size()<=0){
			lcNameLast=lcTemp.getName();
			idtemp=largeclassService.selectMaxId();
			lcTemp.setId(idtemp);
			largeclassService.insert(lcTemp);
	}else {
		//存在
		if(lcTemp.getName()==lcNameLast){
			lcTemp.setId(lclisttemp.get(0).getId());
		}else{
			//lclisttemp=largeclassService.selectByName(lcTemp.getName());
			lcTemp.setId(lclisttemp.get(0).getId());
		}
	}
}////大类处理

//小类处理
				TSubclass scTemp=new TSubclass();
				int scidLast;
				String scNameLast="*";
				for(int j=0;j<len;j++){

					//
					scTemp=tComponentsList.get(j).gettSubclass();
					List<TSubclass> scList=new ArrayList<TSubclass>();
					scList=subclassService.selectByName(scTemp.getName());

					//不存在
					if(scList==null || scList.size()<=0){
						scidLast=subclassService.selectMaxId();
						scTemp.setId(scidLast);
						scTemp.setLid(scTemp.gettLargeclass().getId());
						subclassService.insert(scTemp);
					}else{
						//存在
						scTemp.setId(scList.get(0).getId());
						scTemp.setLid(scList.get(0).getLid());

					}
}////小类处理
//处理元件
				TComponent cpTemp=new TComponent();
				for(int k=0;k<len;k++){
					try{
						cpTemp=tComponentsList.get(k);
						cpTemp.setSid(cpTemp.gettSubclass().getId());
						cpTemp.setId(componentsService.selectMaxId());
						componentsService.insert(cpTemp);
					}catch (Exception e){
						e.printStackTrace();
					}
				}////处理元件
				System.out.println("insert success end");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
//            return "error";//返回到失败的页面
			System.out.println("返回到失败的页面");
		}
	}
	@RequestMapping("downComAll")
	public void updown() {
		System.out.println("查询中");
		List<TComponent> clist = componentsService.selectAll();
		System.out.println("查询结束");
		ComponentsExcel cex = new ComponentsExcel();
		cex.setTitle(TComponent.head(), ",");
		cex.setDatas(clist);
		cex.setPathAndName("d:", "元件信息.xlsx");
		int i = cex.InitExcel();
		System.out.println(i);
	}
	/**
	 * @Description 方法描述: 后台查看所有元件
	 */
	@RequestMapping("queryAll")
	public String queryAll(Integer pageNum, HttpSession session, TComponent tComponent, String lei, String zonghe,
			String kucun) {
		if (pageNum == null) {
			pageNum = 1;
		}
		// 分页
		PageHelper.startPage(pageNum, 15);
		// 模糊查询
		TComponent t2 = tComponent;// 模糊查询
		if ((TComponent) session.getAttribute("tComponent") != null) {
			tComponent = (TComponent) session.getAttribute("tComponent");
		}
		if (t2.getName() != null) {
			tComponent.setName(t2.getName());
		}
		// 排序
		if ("1".equals(lei)) {
			PageHelper.orderBy("sid");
			session.setAttribute("lei", "1");
			session.removeAttribute("name");
			session.removeAttribute("kucun");
		} else if ("1".equals(zonghe)) {
			PageHelper.orderBy("name");
			session.setAttribute("zonghe", "1");
			session.removeAttribute("kucun");
			session.removeAttribute("lei");
		} else if ("1".equals(kucun)) {
			PageHelper.orderBy("store desc");
			session.setAttribute("kucun", "1");
			session.removeAttribute("name");
			session.removeAttribute("lei");
		} else {
			if (session.getAttribute("lei") != null && "1".equals((String) session.getAttribute("lei"))) {
				session.removeAttribute("name");
				session.removeAttribute("kucun");
				PageHelper.orderBy("sid");
			} else if (session.getAttribute("name") != null && "1".equals((String) session.getAttribute("name"))) {
				session.removeAttribute("kucun");
				session.removeAttribute("lei");
				PageHelper.orderBy("name");
			} else if (session.getAttribute("kucun") != null && "1".equals((String) session.getAttribute("kucun"))) {
				session.removeAttribute("name");
				session.removeAttribute("lei");
				PageHelper.orderBy("store desc");
			} else {
				session.removeAttribute("name");
				session.removeAttribute("lei");
				PageHelper.orderBy("store desc");

			}
		}
		session.setAttribute("tComponent", tComponent);
		//tComponent.setSid(null);
		List<TComponent> clist = componentsService.selectByCom(tComponent);
		PageInfo<TComponent> pageInfo = new PageInfo<TComponent>(clist);
		session.setAttribute("largepageInfo", pageInfo);
		return "mangage/components/componentsList";
	}

	/**
	 * @Description 方法描述: 前台根据元件分类显示元件
	 */
	@RequestMapping("queryBySid")
	public String queryBySid(HttpSession session, Integer pageNum, TComponent tComponent, String price, String zonghe,
			String kucun) {

		// 获取元件分类
		// 元件列表
		TLargeclass tcLargeclass = new TLargeclass();
		List<TLargeclass> list = largeclassService.selectVo(tcLargeclass);
		session.setAttribute("llist", list);
		// 获取分页
		if (pageNum == null) {
			pageNum = 1;
		}
		PageHelper.startPage(pageNum, 10);
		// 模糊查询
		TComponent t2 = tComponent;// 模糊查询
		if ((TComponent) session.getAttribute("tComponent") != null) {
			tComponent = (TComponent) session.getAttribute("tComponent");
		} else {
			//tComponent.setSid(1);
		}
		if (t2.getName() != null) {
			tComponent.setName(t2.getName());
		}
		if (t2.getSid() != null && t2.getSid() != 0) {
			tComponent.setSid(t2.getSid());
		}
		// 获取排序条件
		if ("1".equals(price)) {
			PageHelper.orderBy("price");
			session.setAttribute("price", "1");
			session.removeAttribute("name");
			session.removeAttribute("kucun");
		} else if ("1".equals(zonghe)) {
			PageHelper.orderBy("name");
			session.setAttribute("zonghe", "1");
			session.removeAttribute("kucun");
			session.removeAttribute("lei");
		} else if ("1".equals(kucun)) {
			PageHelper.orderBy("store desc");
			session.setAttribute("kucun", "1");
			session.removeAttribute("name");
			session.removeAttribute("price");
		} else {
			if (session.getAttribute("price") != null && "1".equals((String) session.getAttribute("price"))) {
				session.removeAttribute("name");
				session.removeAttribute("kucun");
				PageHelper.orderBy("price");
			} else if (session.getAttribute("name") != null && "1".equals((String) session.getAttribute("name"))) {
				session.removeAttribute("kucun");
				session.removeAttribute("price");
				PageHelper.orderBy("name");
			} else if (session.getAttribute("kucun") != null && "1".equals((String) session.getAttribute("kucun"))) {
				session.removeAttribute("name");
				session.removeAttribute("price");
				PageHelper.orderBy("store desc");
			}
		}
		// 查询元件，返回列表
		session.setAttribute("tComponent", tComponent);
		List<TComponent> clist = componentsService.selectByCom(tComponent);
		PageInfo<TComponent> pageInfo = new PageInfo<TComponent>(clist);
		session.setAttribute("compPageInfo", pageInfo);
		return "componentList";
	}

	@RequestMapping("findById")
	public @ResponseBody TComponent selectVoById(@RequestBody Integer id) {
		TComponent t = componentsService.selectVoById(id);
		return t;
	}

	// 根据id删除元件
	@RequestMapping("delete")
	public String delete(Integer[] ids) {
		System.out.println(ids.length);
		for (Integer d : ids) {
			System.out.println(d);
		}

		int i = componentsService.delete(ids);

		return "redirect:/hms/comp/queryAll";

	}

}
