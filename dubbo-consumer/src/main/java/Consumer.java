import cn.netbuffer.dubbo.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        System.out.printf("consumer start\n");
        IUserService userService = context.getBean(IUserService.class);
        System.out.printf("userService.getUser(1L):%s\n",userService.getUser(1L));
    }
}