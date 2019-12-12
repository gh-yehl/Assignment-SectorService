package com.sectors.service;

import com.sectors.model.PriceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("service-company")
public interface CompanyFeignService {

    @RequestMapping(value = "/getCompanyCodesBySector", method= RequestMethod.GET)
    public List<String> getCompanyCodesBySector(@RequestParam("sectorName") String sectorName);
}