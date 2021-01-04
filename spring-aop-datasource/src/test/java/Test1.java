import com.mashibing.tx.service.BookService;
import com.mashibing.tx.service.MulService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

public class Test1 {

    @Test
    public void test() throws FileNotFoundException {
        System.out.println("test");
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.checkout("zhangsan", 1);
    }

    @Test
    public void testTransaction() {
        System.out.println("testTransaction");
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        MulService mulService = context.getBean("mulService", MulService.class);
        mulService.mulTx();
    }


    @Test
    public void testTransactionXml() {
        System.out.println("testTransaction");
        ApplicationContext context = new ClassPathXmlApplicationContext("application-tx.xml");
        MulService mulService = context.getBean("mulService", MulService.class);
        mulService.mulTx();
    }
}
