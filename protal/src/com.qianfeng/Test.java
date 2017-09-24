import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class Test {
    //包装任务
    static Scheduler defaultScheduler;
    static JobDetail build;
    static {
        try {
            defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        build = JobBuilder.newJob(firstJob.class).build();
    }
    //指定任务规则
    public static CronScheduleBuilder cron(){
        return CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
    }

    public static void main(String[] args) {
        CronTrigger trigger = TriggerBuilder.newTrigger().startNow().withSchedule(cron()).build();
        try {
            defaultScheduler.scheduleJob(build,trigger);
            //开始执行
            defaultScheduler.start();
            //查找任务
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
