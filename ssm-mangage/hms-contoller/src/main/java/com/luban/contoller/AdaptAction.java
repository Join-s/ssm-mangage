package com.luban.contoller;

import com.luban.po.TDepartment;
import com.luban.po.TGrade;
import com.luban.po.TMajor;
import com.luban.service.DepService;
import com.luban.service.GradeService;
import com.luban.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdaptAction {
@Autowired
	private DepService depService;

@Autowired
private MajorService majorService;

@Autowired
private GradeService gradeService;


@RequestMapping("depList")
@ResponseBody
public List<TDepartment> DepList(){
	return depService.selectAllgra();
}
@RequestMapping("maxID")
	@ResponseBody
	public int maxID(){
		return depService.selectMaxId();
	}



@RequestMapping("addAdaps")
public String addAdaps(TDepartment department,TMajor major,TGrade grade,Integer numid) {
	//<option value="1">学院</option>
//	<option value="2">专业</option>
//	<option value="3">班级</option>
	
	if(numid!=null) {
		
		if(numid==1) {//学院
			
			if(depService.selectName(department.getName()).size()>0) {//有
			}else {
				int newid=depService.selectMaxId();
				department.setId(newid);
				depService.insert(department);
			}
		}else if(numid==2) {//专业
			if(majorService.selectName(major.getName()).size()>0) {
				
			}else {
				int newid=majorService.selectMaxId();
				major.setId(newid);
				majorService.insert(major);
			}
			
		}else {//班级
			if(gradeService.selectName(grade.getName()).size()>0) {
				
			}else {
				int newid=gradeService.selectMaxId();
				grade.setId(newid);
				gradeService.insert(grade);
			}
		}
	}
	return "mangage/welcome";
}

}
