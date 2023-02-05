package com.example.madarasalog;

import androidx.annotation.NonNull;

public class RecordLog {

    private Integer stdId;
    private String date;
    private Integer sabakLine;
    private Integer sabakSipara;
    private Integer sabki;
    private Integer manzil;
    private Integer id;

    public RecordLog(Integer id, Integer stdId, String date, Integer sabakLine, Integer sabakSipara, Integer sabki, Integer manzil) {
        this.id = id;
        this.stdId = stdId;
        this.date = date;
        this.sabakLine = sabakLine;
        this.sabakSipara = sabakSipara;
        this.sabki = sabki;
        this.manzil = manzil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStdId() {
        return stdId;
    }

    public void setStdId(Integer stdId) {
        this.stdId = stdId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSabakLine() {
        return sabakLine;
    }

    public void setSabakLine(Integer sabak) {
        this.sabakLine = sabak;
    }

    public Integer getSabakSipara() {
        return sabakSipara;
    }

    public void setSabakSipara(Integer sabak) {
        this.sabakSipara = sabak;
    }

    public Integer getSabki() {
        return sabki;
    }

    public void setSabki(Integer sabki) {
        this.sabki = sabki;
    }

    public Integer getManzil() {
        return manzil;
    }

    public void setManzil(Integer manzil) {
        this.manzil = manzil;
    }

    @NonNull
    public String toString()
    {
        return getId().toString();
    }
}
