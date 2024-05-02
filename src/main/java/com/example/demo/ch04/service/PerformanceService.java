package com.example.demo.ch04.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.ch04.domain.dto.PerformanceInfo;
import com.example.demo.ch04.repository.PerformanceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerformanceService {
    private final PerformanceRepository performanceRepository;

    public List<PerformanceInfo> getAllPerformanceInfo() {
        List<PerformanceInfo> reservablePerformanceInfos = performanceRepository.findByIsReserve("enable")
                .stream()
                .map(PerformanceInfo::of)
                .toList();
        if (reservablePerformanceInfos.isEmpty()) {
            return setReadyToPerformanceInfo();
        }
        return reservablePerformanceInfos;
    }

    public String isEnableReserve(UUID performanceId){
        System.out.println("Execute Production Code");
        return performanceRepository.findById(performanceId)
                .orElseThrow()
                .getIsReserve();
    }

    private List<PerformanceInfo> setReadyToPerformanceInfo(){
        PerformanceInfo readyToPerformance = PerformanceInfo.builder()
                .performanceId(UUID.fromString("0000-0000-0000-0000"))
                .performanceName("공연 준비중")
                .performanceType("none")
                .isReserve("disable")
                .build();
        return Arrays.asList(new PerformanceInfo[]{readyToPerformance});
    }

    public String getTicketName() {
        return "TicketName";
    }

}
