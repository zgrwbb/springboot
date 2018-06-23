package com.example.validate.web;

import com.example.validate.domain.User;
import com.example.validate.serveice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 用户congroller
 * @author wangbobo
 * @date 2018/6/20 9:08
 * 下面的方法都在user下
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 处理/user的GET请求
     * 通过requestParameter
     * @param modelMap modelMap
     * @return userList
     */
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(ModelMap modelMap) {
        modelMap.put("userList", userService.findAll());
        return "userList";
    }

    /**
     * 显示创建用户表单
     * @param modelMap modelMap
     * @return userForm
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUserForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("action", "create");
        return "userForm";
    }

    /**
     * 创建用户
     * 处理/user的post请求,用来获取用户列表
     * 通过@ModelAttribute 绑定参数,也通过@requestParam从页面中传递参数
     * @param modelMap modelMap
     * @param user user
     * @param bindingResult bindingResult
     * @return 重定向到 /user请求 然后转到userList页面
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postUser(ModelMap modelMap, @ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("action", "create");
            return "userForm";
        }
        userService.insertByUser(user);
        return "redirect:/user/";
    }

    /**
     * 删除用户
     * @param id userId
     * @return 重定向到 /user请求 然后转到userList页面
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/user/";
    }
    /**
     * 显示创建用户表单
     * @param modelMap modelMap
     * @return userForm
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateUserForm(ModelMap modelMap,@PathVariable Long id) {
        modelMap.addAttribute("user", userService.findUser(id));
        modelMap.addAttribute("action", "update");
        return "userForm";
    }

    /**
     * 修改用户
     * @param modelMap modelMap
     * @param user user
     * @param bindingResult bindingResult
     * @return 重定向到 /user请求 然后转到userList页面
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(ModelMap modelMap, @ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("action", "update");
            return "userForm";
        }
        userService.insertByUser(user);
        return "redirect:/user/";
    }

}
