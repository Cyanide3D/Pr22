package com.example.Pr22.service;

import com.example.Pr22.InvokerMBean;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.management.MBeanServer;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SchedulerService extends StandardMBean implements InvokerMBean {

    @Autowired
    private BankService bankService;
    @Autowired
    private CardService cardService;
    private final Path BANK_DATA_PATH = Path.of("bank.txt");
    private final Path CARD_DATA_PATH = Path.of("card.txt");

    protected SchedulerService() throws NotCompliantMBeanException {
        super(InvokerMBean.class);
    }

    @PostConstruct
    @SneakyThrows
    public void init() {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.example.Pr22.service:type=SchedulerService");
        mbs.registerMBean(this, objectName);
    }

    @Scheduled(cron = "0 0/30 * * * ?")
    @SneakyThrows
    @Override
    public void doScheduledTask() {
        Files.deleteIfExists(BANK_DATA_PATH);
        Files.writeString(BANK_DATA_PATH, bankService.getAllBanks().toString());

        Files.deleteIfExists(CARD_DATA_PATH);
        Files.writeString(CARD_DATA_PATH, cardService.getAllCards().toString());
    }
}
