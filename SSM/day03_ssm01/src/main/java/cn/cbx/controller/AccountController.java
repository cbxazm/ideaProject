package cn.cbx.controller;

import cn.cbx.domain.Account;
import cn.cbx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户web
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/findAll")
     public String findAll(Model model){
        System.out.println("表现层...");
        //调用业务层的方法
        List<Account> accounts = accountService.findAll();
               model.addAttribute("list",accounts);
        return "list";
     }

    /**
     * 用来保存用户
     * @return
     */
     @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
     }

}
