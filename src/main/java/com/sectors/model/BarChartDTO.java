package com.sectors.model;

import net.sf.json.JSONObject;

public class BarChartDTO {

    private JSONObject dataSource;
    private String firstSector;
    private String secondSector;

    private String fromTime;
    private String toTime;
    private String chartType;

    public JSONObject getDataSource() {
        return dataSource;
    }

    public void setDataSource(JSONObject dataSource) {
        this.dataSource = dataSource;
    }

    public String getFirstSector() {
        return firstSector;
    }

    public void setFirstSector(String firstSector) {
        this.firstSector = firstSector;
    }

    public String getSecondSector() {
        return secondSector;
    }

    public void setSecondSector(String secondSector) {
        this.secondSector = secondSector;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }
}
