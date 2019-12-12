package com.sectors.utils;

import com.sectors.model.SectorsDTO;
import com.sectors.model.PriceDTO;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class CompareHelper {


    /**
     *
     * @return
     * "chart": { "caption": "Company Comparison", "xAxisName": "Time Range", "yAxisName": "Price Per Share", "theme": "fusion"},
     */
    public static String getBarChart() {

        return "\"chart\": { \"caption\": \"Company Comparison\", \"xAxisName\": \"Time Range\", \"yAxisName\": \"Price Per Share\", \"theme\": \"fusion\"}, ";
        //return "\"chart\": { \"caption\": \"Company Comparison\", \"xAxisName\": \"Time Range\", \"yAxisName\": \"Price Per Share\", \"theme\": \"fusion\"}, ";
    }

    //"categories": [{
    //                "category": [{"label": "10:00"},{"label": "10:05"},{"label": "10:10"},{"label": "10:10"}]
    //                    }],
    public static String getBarCategories(List<PriceDTO> list) {
        //[ {"label": "10:00"},{"label": "10:05"},{"label": "10:10"},{"label": "10:10"} ]
        StringBuffer categories = new StringBuffer("\"categories\": [{  \"category\": ");

        categories.append(categoriesList(list));

        categories.append("  }],");
        return categories.toString();
}


    /**
     * "dataset": [
     *             {
     *                 "seriesname": "IBN Stock", "data": [
     *                 "data": [
     *                     {
     *                         "value": "6000"
     *                     },
     *                     {
     *                         "value": "19700"
     *                     }
     *                 ]
     *             },
     *             {
     *                 "seriesname": "IDD Stock",
     *                 "data": [
     *                     {
     *                         "value": "19000"
     *                     },
     *                     {
     *                         "value": "14300"
     *                     }
     *                 ]
     *             }
     *         ]
     * @param sectorsDTO
     * @param list
     * @return
     */
//    public static String getBarDataSet(CompanyDTO companyDTO, List<StockPriceDTO> list) {
//        StringBuffer dataSet = new StringBuffer("\"dataset\": [  {  \"seriesname\": \"" + companyDTO.getCompanyName() + "\", \"data\": [ ");
//
//
//        String valueList = dataSetList(list);
//        dataSet.append(valueList);
//
//        dataSet.append(" ] } ]");
//        return dataSet.toString();
//    }

    public static String getBarDataSetForOneSector(SectorsDTO sectorsDTO , List<PriceDTO> list) {
        StringBuffer dataSet = new StringBuffer("");
        dataSet.append("\"dataset\": [ ");
        dataSet.append(dataSetList(sectorsDTO, list));
        dataSet.append(" ]");
        return dataSet.toString();
    }

    public static String getBarDataSetForTwoSectors(SectorsDTO firstSectorDTO, SectorsDTO secondSectorDTO, List<PriceDTO> listOne, List<PriceDTO> listTwo) {
        StringBuffer dataSet = new StringBuffer("");
        dataSet.append("\"dataset\": [ ");
        dataSet.append(dataSetList(firstSectorDTO, listOne));
        dataSet.append(dataSetList(secondSectorDTO, listTwo));
        dataSet.append(" ]");
        return dataSet.toString();
    }
    /**
     *     {
     *     "value": "19000"
     *      },
     *     {
     *      "value": "14300"
     *     }
     * @param list
     * @return
     */
    static String dataSetList(SectorsDTO sectorsDTO , List<PriceDTO> list) {
        StringBuffer valueList = new StringBuffer("");
        valueList.append("{\"seriesname\": \"" + sectorsDTO.getSectorName() + "\", \"data\": [ ");

        for(PriceDTO priceDTO : list) {
            valueList.append("{ \"value\": \"" + priceDTO.getCurrentPrice() + "\" }, ");
        }
        valueList.append("] },");

        return valueList.toString();
    }



    /**
     *
     * [{"label": "10:00"},{"label": "10:05"},{"label": "10:10"},{"label": "10:10"}]
     *
     * @param list
     * @return
     */
    static String categoriesList(List<PriceDTO> list) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        StringBuffer categoriesList = new StringBuffer("[ ");

        for(PriceDTO priceDTO : list) {
            categoriesList.append("{\"label\": ");
            categoriesList.append("\"" + df.format(priceDTO.getDateTime()) + "\"");
            categoriesList.append("},");
        }

        categoriesList.append("]");
        return categoriesList.toString();
    }
}
