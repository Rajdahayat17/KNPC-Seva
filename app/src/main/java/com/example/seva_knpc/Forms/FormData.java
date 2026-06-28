package com.example.seva_knpc.Forms;

public class FormData {
    private String name, pdfUrl;

    public FormData() {
    }

    public FormData(String name, String pdfUrl) {
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
