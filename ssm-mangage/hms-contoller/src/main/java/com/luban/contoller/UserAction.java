package com.luban.contoller;

import com.luban.po.TGrade;
import com.luban.po.TMajor;
import com.luban.po.TUser;
import com.luban.service.UserServcie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Title:UserAction describe:user控制层
 *
 * @日期 2018-10-30 下午9:08:45
 */
@Controller
@RequestMapping("/user")
public class UserAction {

    // 注入业务层
    @Resource
    private UserServcie userServcie;

    /**
     * @Description 方法描述: 用户登陆跳转
     */
    @RequestMapping("/login")
    public String stuLogin(Model model, TUser user, HttpSession session) {
        if (session.getAttribute("user") == null) {

            TUser tuser = userServcie.login(user);

            if (tuser != null && "0".equals(user.getRemark1())) {// 学生登陆成功
                model.addAttribute("flag", true);

                model.addAttribute("user", tuser);
                session.setAttribute("user", tuser);
                session.setAttribute("userID", tuser.getId());
                return "redirect:/hms/go";// 登陆到首页

            } else if (tuser != null && "1".equals(user.getRemark1())) {// 管理员登陆成功
                session.setAttribute("user", tuser);
                session.setAttribute("userID", tuser.getId());
                model.addAttribute("flag", true);
                return "mangage/index";// 登陆到后台首页
            } else if("1".equals(user.getRemark1())){// 没有登录成功
                model.addAttribute("flag", false);
                return "redirect:/hms/goLoginsys";// 重新登陆
            }else{
                model.addAttribute("flag", false);
                return "redirect:/hms/goLogin";// 重新登陆
            }

        } else {
            session.invalidate();
            //TUser u = (TUser) session.getAttribute("user");
            //if ("0".equals(u.getRemark1())) {
            //    return "redirect:/hms/go";// 登陆到首页
            //
            //} else if ("1".equals(u.getRemark1()) ){
            //    return "mangage/index";// 登陆到后台首页
            //}else{
                return "redirect:/hms/goLogin";// 重新登陆
            //}
        }
    }

    /*
     * 订单列表及详情显示
     */
    @RequestMapping("/myOrderList")
    public String selectVo(HttpSession session) {
        int uid = (TUser) session.getAttribute("user") == null ? 0 : ((TUser) session.getAttribute("user")).getId();
        TUser u = userServcie.selectVo(uid);
        if (u != null) {


            session.setAttribute("orderList", u.gettOrders());
        }
        return "personal-enter";
    }

    /*
     * 購物車
     */
    @RequestMapping("/shoppingcat")
    public String selectShoppingCat(HttpSession session, Integer cid) {
        int uid = (TUser) session.getAttribute("user") == null ? 0 : ((TUser) session.getAttribute("user")).getId();
        TUser u = userServcie.selectVo(uid);
        if (u != null) {
            session.setAttribute("shoppingList", u.gettOrders());
        }

        return "shoppingcart";
    }

//	/**
//	 * 查询所有学院
//	 */
//	@RequestMapping("/queryDep")
//	public 
//	@ResponseBody
//	List<TDepartment> queryDep() {
//		return null;
//		
//	}

    /**
     * 根据学院id查询专业
     */
    @RequestMapping("/queryByDep")
    public @ResponseBody
    List<TMajor> queryByDep(@RequestBody Integer did) {

        List<TMajor> list = userServcie.queryByDep(did);

        return list;

    }

    /**
     * 根据专业查询班级
     */
    @RequestMapping("/queryByMag")
    public @ResponseBody
    List<TGrade> queryByMag(@RequestBody Integer mid) {
        List<TGrade> list = userServcie.queryByMag(mid);
        return list;

    }

    /**
     * 注册学生用户
     */
    @RequestMapping("register")
    public String register(TUser user) {
        //查重
        //@RequestParam("file") MultipartFile myfile
        //插入
//		List<Users> ulist=userService.findByName(users.getUname());
//        if(ulist.size()>0){
//            return "login";
//        }
//        //文件为空时
//      if(myfile.isEmpty()){
//            System.out.println("文件未上传");
//        }else{
//          try {
//              //上传后的地址，注意("/upload")是表示文件上传后的目标文件夹
//              String realPath = request.getSession().getServletContext().getRealPath(uimgPath);
//              System.out.println("打印文件上传的路径"+realPath);
//              //获取文件名
//              String filename = myfile.getOriginalFilename();
//              //获取文件后缀名
//              String extensionname = filename.substring(filename.lastIndexOf(".") + 1);
//              //给上传的文件起别名，有很多种方式
//              String newFilename=String.valueOf(System.currentTimeMillis())+"."+extensionname;
//              //创建File对象，传入目标路径参数，和新的文件别名
//              File dir=new File(realPath,newFilename);
//              users.setUimg(new File(uimgPath,newFilename).toString());
//              if (!dir.exists()){//如果dir代表的文件不存在，则创建它，
//                  dir.mkdirs();//
//              }
//              //如果存在则直接执行下面操作
//              myfile.transferTo(dir);//将上传的实体文件复制到指定目录upload下
//          } catch (IOException e) {
//              e.printStackTrace();
//          }
//        }
//        users.setId(userService.getMaxUid());
//        users.setUtype("1");
//        userService.registerUser(users);
//         return "login";

        if (!(userServcie.selectByNum(user.getJnumber()).size() > 0)) {
            int i = userServcie.insertUser(user);
            if (i > 0) {
                return "redirect:/hms/goLogin";
            }

        }

        return "redirect:/hms/goRegister";
    }


}
