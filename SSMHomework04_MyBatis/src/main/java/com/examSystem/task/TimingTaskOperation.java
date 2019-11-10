package com.examSystem.task;

import com.examSystem.dao.ArrangeMapper;
import com.examSystem.entity.Arrange;
import com.examSystem.util.ApplicationContextProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TimingTaskOperation {

    @Scheduled(cron = "0 0,10,20,30,40,50 * * * ? ")
    public static void scanTaskQueue() {

        List<Arrange> arranges = pullData();

        if(arranges == null || arranges.size() == 0){
            return;
        }

        for (Arrange arrange : arranges) {

            LocalDateTime now = LocalDateTime.now();
            // 到达开始考试时间
            if (arrange.getArrStatus() != 1 && (now.equals(arrange.getArrStart()) || now.isAfter(arrange.getArrStart()))) {
                // 修改考试状态为1
                arrange.setArrStatus(1);
                ApplicationContextProvider.getBean(ArrangeMapper.class).updateByPrimaryKey(arrange);
                log.info("到达考试开始时间，修改考试状态：{}", arrange);
                continue;
            }

            // 到达考试结束时间
            if (arrange.getArrStatus() != -1 && (now.equals(arrange.getArrStop()) || now.isAfter(arrange.getArrStop()))) {
                // 修改考试状态为-1
                arrange.setArrStatus(-1);
                ApplicationContextProvider.getBean(ArrangeMapper.class).updateByPrimaryKey(arrange);
                log.info("到达考试结束时间，修改考试状态：{}", arrange);
            }
        }
    }

    // 从库中拉入未结束的考试
    private static List<Arrange> pullData(){

        List<Arrange> arranges = ApplicationContextProvider.getBean(ArrangeMapper.class).selectAll();

        if (arranges.stream().anyMatch((e) -> e.getArrStatus() != -1)) {
            arranges = arranges.stream()
                    .filter((e) -> e.getArrStatus() != -1)
                    .collect(Collectors.toList());
            log.info("库扫描完毕，拉入{}个任务。", arranges.size());
            return arranges;
        } else {
            log.info("库中无待扫描数据!");
            return null;
        }
    }

}
