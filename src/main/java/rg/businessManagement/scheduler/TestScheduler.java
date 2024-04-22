package rg.businessManagement.scheduler;

import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestScheduler {
	
	private static final Logger logger = LoggerFactory.getLogger(TestScheduler.class);
	
	@Scheduled(cron="0 */10 * * * *")
	public void testScheduler() {
		logger.info("App is live at: {}", ZonedDateTime.now().toString());
	}
}
