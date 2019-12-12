package com.sectors.service;

import com.sectors.model.PriceDTO;
import com.sectors.model.StockPriceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("service-import")
public interface StockPriceFeignService {

    @RequestMapping(value = "/getAvgPriceList", method= RequestMethod.GET)
    public List<PriceDTO> getAvgPriceList(@RequestParam("companyCodesList") List<String> companyCodesList);
}