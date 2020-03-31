package com.coffee.controller;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.coffee.entity.Student;
import com.coffee.service.stuService;

@Controller
public class stuController {
	@Resource
	stuService service;
	@Resource
	HttpSession session;

	/**
	 * http://localhost:8080/SpringbaseM/app/query/20200001
	 * spring mvc mybatis整合
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/query/{id}")
	public String queryStu(Model model, @PathVariable int id) {
		Student stu = service.getStudent(id);
		// 如果找不到, 则显示错误显示
		if (stu == null) {
			model.addAttribute("errMsg", "找不到记录, id=" + id);
			return "error_404";
			// return "redirect:/a/some.html";
			// return ResponseEntity.status(404).build();
		}
		model.addAttribute("stu", stu);
		return "info1";
	}
/**
 * http://localhost:8080/SpringbaseM/app/queryfromto?from=20200001&to=20200005
 * spring mvc mybatis整合
 * @param from
 * @param to
 * @return
 */
	@RequestMapping("/queryfromto")
	public ModelAndView queryStufromto(int from, int to) {
		List<Student> studentList = service.getStufromto(from, to);
		session.setAttribute("user", "刘伟");
		ModelAndView mv = new ModelAndView("query1");
		mv.addObject("studentList", studentList);
		return mv;

	}
}
