package journalApplication.Schedular;

import journalApplication.Cache.AppCache;
import journalApplication.Entity.JournalEntry;
import journalApplication.Entity.User;
import journalApplication.Enums.Sentiment;
import journalApplication.Repository.UserRepositoryImpl;
import journalApplication.Service.EmailService;
import journalApplication.Service.SentimentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserSchedular
{
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private AppCache appCache;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @Scheduled(cron = "0 0 10 ? * FRI")
    public void fetchUsersAndSendSAMail()
    {
        System.out.println("--- Scheduler Method Started ---");
        List<User> users=userRepository.getUserForSA();
        System.out.println("Users found: " + users.size());
        for(User user:users)
        {
            List<JournalEntry> journalEntries=user.getJournalEntries();
            List<Sentiment> sentiments=journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x->x.getSentiment()).collect(Collectors.toList());
            Map<Sentiment, Integer>sentimentCount=new HashMap<>();
            for (Sentiment sentiment:sentiments)
            {
                if (sentiment !=null)
                {
                    sentimentCount.put(sentiment, sentimentCount.getOrDefault(sentiment,0) + 1);
                }
                Sentiment mostFrequentSentiment=null;
                int maxCount=0;
                for (Map.Entry<Sentiment, Integer> entry:sentimentCount.entrySet())
                {
                    if (entry.getValue()>maxCount)
                    {
                        maxCount=entry.getValue();
                        mostFrequentSentiment=entry.getKey();
                    }
                }
                if (mostFrequentSentiment!=null)
                {
                    emailService.sendEmail(user.getEmail(),"Sentiment for last 7 days",mostFrequentSentiment.toString());
                }
            }
        }
    }

    @Scheduled(cron = "0 */10 * * * *")
    public void clearAppCache()
    {
        appCache.init();
    }
}
