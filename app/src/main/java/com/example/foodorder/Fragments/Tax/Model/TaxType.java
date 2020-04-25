package com.example.foodorder.Fragments.Tax.Model;

public class TaxType {

    String id,taxtype;

    public TaxType(String id, String taxtype) {
        this.id = id;
        this.taxtype = taxtype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaxtype() {
        return taxtype;
    }

    public void setTaxtype(String taxtype) {
        this.taxtype = taxtype;
    }
}
