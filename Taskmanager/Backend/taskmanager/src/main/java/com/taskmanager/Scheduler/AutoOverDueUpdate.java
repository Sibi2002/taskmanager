package com.taskmanager.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AutoOverDueUpdate {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Scheduled(cron = "* 0 0 * * *")
    public void StatusUpdate(){
        String sql="UPDATE task_progress SET status_id=3,over_due_by= " +
                "abs(current_date - task_Progress.due_date) where status_id=1 and due_date > current_date";
        jdbcTemplate.update(sql);
    }
}
