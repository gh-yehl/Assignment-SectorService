package com.sectors.controller;

import com.sectors.model.BarChartDTO;
import com.sectors.model.PriceDTO;
import com.sectors.model.SectorsDTO;
import com.sectors.service.CompanyFeignService;
import com.sectors.service.SectorsService;
import com.sectors.service.StockPriceFeignService;
import com.sectors.utils.CompareHelper;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(maxAge = 3600)
@RestController
public class SectorsController {

    private final static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SectorsController.class);

    @Autowired
    private SectorsService sectorsService;

    @Autowired
    private CompanyFeignService companyFeignService;
    @Autowired
    private StockPriceFeignService stockPriceFeignService;
    /**
     *
     * @return
     */
    @RequestMapping(value = "/getAllSectors", method = RequestMethod.GET)
    public List<SectorsDTO> getAllSectors() {

        List<SectorsDTO> list = sectorsService.findAll();
        return list;
    }


    @RequestMapping(value = "/compareSector",method = RequestMethod.POST)
    public BarChartDTO compareCompany(@RequestBody BarChartDTO barChartDTO) {
        String dataSource ="";

        String firstSector = barChartDTO.getFirstSector();
        String secondSector = barChartDTO.getSecondSector();

        //display single company Chart
        if (secondSector == null || "".endsWith(secondSector.trim()) ) {
            dataSource = dataSourceForOneSector(firstSector);
        }
        //display two company comparison chart
        else{
            dataSource = dataSourceForTwoSectors(firstSector, secondSector);
        }

        LOGGER.info("data source ======================>" + dataSource);
        JSONObject dataSourceObj = JSONObject.fromObject(dataSource);
        barChartDTO.setDataSource(dataSourceObj);

        LOGGER.info("barChartDTO.getDataSource()===================================>"+barChartDTO.getDataSource());

        return barChartDTO;
    }


    private String dataSourceForOneSector(String sectorName) {
        SectorsDTO sectorsDTO = sectorsService.findSectorBySectorName(sectorName);
        List<String> companyCodesList =  companyFeignService.getCompanyCodesBySector(sectorName);
        List<PriceDTO> list = stockPriceFeignService.getAvgPriceList(companyCodesList);


        String barChart = CompareHelper.getBarChart();
        String barCategories = CompareHelper.getBarCategories(list);
        String barDataSet = CompareHelper.getBarDataSetForOneSector(sectorsDTO, list);

        String dataSource = "{" + barChart + barCategories + barDataSet + "}";
        return dataSource;
    }

    private String dataSourceForTwoSectors(String firstSectorName, String secondSectorName) {
        SectorsDTO sectorOneDTO = sectorsService.findSectorBySectorName(firstSectorName);
        SectorsDTO sectorTwoDTO = sectorsService.findSectorBySectorName(secondSectorName);

        List<String> firSectorCompanyCodes =  companyFeignService.getCompanyCodesBySector(firstSectorName);
        List<String> secSectorCompanyCodes =  companyFeignService.getCompanyCodesBySector(secondSectorName);

        List<PriceDTO> firSectorAvgPriceList = stockPriceFeignService.getAvgPriceList(firSectorCompanyCodes);
        List<PriceDTO> secSectorAvgPriceList = stockPriceFeignService.getAvgPriceList(secSectorCompanyCodes);


        String barChart = CompareHelper.getBarChart();
        String barCategories = "";
        //use the longer time range as the xAxis
        if(firSectorAvgPriceList.size() > secSectorAvgPriceList.size()) {
            barCategories = CompareHelper.getBarCategories(firSectorAvgPriceList);
        }
        else {
            barCategories = CompareHelper.getBarCategories(secSectorAvgPriceList);
        }

        String barDataSet = CompareHelper.getBarDataSetForTwoSectors(sectorOneDTO, sectorTwoDTO, firSectorAvgPriceList, secSectorAvgPriceList);
        String dataSource = "{" + barChart + barCategories + barDataSet + "}";
        return dataSource;
    }



}
