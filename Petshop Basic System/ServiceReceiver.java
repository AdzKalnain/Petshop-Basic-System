package bscs2b_group4;

import java.io.*;

public class ServiceReceiver implements Serializable {
    private String services;
    private String totalfee;
    private String day;
    private String month;
    private String year;

    
    public ServiceReceiver() {
        services="---";
        totalfee="---";
        day="---";
        month="---";
        year="---";
    }
    
    public ServiceReceiver(String services) {
        this();
        setService(services);
        setTotalFee(totalfee);
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    
    public void setService(String services) {
        this.services=services;
    }
    
    public String getServices() {
        return services;
    }
    
    public void setTotalFee(String totalfee) {
        this.totalfee=totalfee;
    }
    
    public String getTotalFee() {
        return totalfee;
    }
    
    public void setDay(String day){
        this.day=day;
    }
    
    public String getDay(){
        return day;
    }
    
    public void setMonth(String month){
        this.month=month;
    }
    
    public String getMonth(){
        return month;
    }
    
    public void setYear(String year){
        this.year=year;
    }
    
    public String toString() {
        return "\nServices:" +services+ "\nTotal Fees:" +totalfee+ "\nDate: " +day+ "/" +month+ "/" +year+ "\n";
    }
    
}
