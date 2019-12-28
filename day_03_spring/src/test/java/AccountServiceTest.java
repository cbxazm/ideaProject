import com.Service.AccountService;
import com.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//使用junit单元测试，测试配置
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
      @Autowired
      @Qualifier("proxyAccountService")
    private AccountService service;
      @Test
    public  void testTransfer(){
           service.transfer("aaa","ccc",100f);
      }
      @Test
    public void testFindAll(){
          List<Account> allAccount = service.findAllAccount();
          for(Account account:allAccount){
              System.out.println(account);
          }
      }
}
