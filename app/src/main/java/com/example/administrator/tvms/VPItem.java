package com.example.administrator.tvms;

public class VPItem {
    int id;
    String ordinanceNo;
    String articleNo;
    String violation;
    float penalty;

    public int getId() {
        return id;
    }

    public VPItem(String ordinanceNo, String articleNo, String desc, String penalty) {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdinanceNo() {
        return ordinanceNo;
    }

    public void setOrdinanceNo(String ordinanceNo) {
        this.ordinanceNo = ordinanceNo;
    }

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public String getVioaltion() {
        return violation;
    }

    public void setVioaltion(String vioaltion) {
        this.violation = vioaltion;
    }

    public float getPenalty() {
        return penalty;
    }

    public void setPenalty(float penalty) {
        this.penalty = penalty;
    }

    public VPItem(int id, String ordinanceNo, String articleNo, String violation, float penalty) {
        this.id = id;
        this.ordinanceNo = ordinanceNo;
        this.articleNo = articleNo;
        this.violation = violation;
        this.penalty = penalty;
    }
}
