package com.buckzy.plaid.model;

import java.util.List;

public class Numbers {
    private List<NumberACH> ach;
    private List<NumberEFT> eft;
    private List<NumberInternational> international;
    private List<NumberBACS> bacs;

    public List<NumberACH> getAch() {
        return ach;
    }

    public void setAch(List<NumberACH> ach) {
        this.ach = ach;
    }

    public List<NumberEFT> getEft() {
        return eft;
    }

    public void setEft(List<NumberEFT> eft) {
        this.eft = eft;
    }

    public List<NumberInternational> getInternational() {
        return international;
    }

    public void setInternational(List<NumberInternational> international) {
        this.international = international;
    }

    public List<NumberBACS> getBacs() {
        return bacs;
    }

    public void setBacs(List<NumberBACS> bacs) {
        this.bacs = bacs;
    }
}
