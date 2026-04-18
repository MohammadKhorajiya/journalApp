package journalApplication.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests
{
    @Autowired
    private EmailService emailService;

    @Test
    public void TestSendMail()
    {
        emailService.sendEmail("khorajiyamohammad724@gmail.com"
                ,"Testing Java Mail Sender"
                ,"Hi Java Developer Mohammad You Are Crazy");
    }
}
