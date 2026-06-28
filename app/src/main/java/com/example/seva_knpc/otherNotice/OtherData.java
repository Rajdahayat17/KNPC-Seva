package com.example.seva_knpc.otherNotice;

public class OtherData {

    private String name, pdfUrl;


    public OtherData(){

    }
    public OtherData(String name, String pdfUrl) {
        this.name = name;
        this.pdfUrl = pdfUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

}
