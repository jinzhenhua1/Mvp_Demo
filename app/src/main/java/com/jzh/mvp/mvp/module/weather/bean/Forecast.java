package com.jzh.mvp.mvp.module.weather.bean;

import androidx.annotation.NonNull;

public class Forecast {
    private String date = "";
    private String high = "";
    private String fengli = "";
    private String low = "";
    private String fengxiang = "";
    private String type = "";


    public void setDate(String date) {
        this.date = date;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public String getHigh() {
        return high;
    }

    public String getFengli() {
        return fengli;
    }

    public String getLow() {
        return low;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public String getType() {
        return type;
    }


    @NonNull
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer("{");
        str.append("date:").append(date).append(",");
        str.append("high:").append(high).append(",");
        str.append("fengli:").append(fengli).append(",");
        str.append("low:").append(low).append(",");
        str.append("fengxiang:").append(fengxiang).append(",");
        str.append("type:").append(type.toString()).append("}");

        return str.toString();
    }
}
