package vn.edu.ntu.nguyendinhhoanglan.controller;

import java.util.List;

import vn.edu.ntu.nguyendinhhoanglan.model.NgoaiTe;

public interface INgoaiTeController {
    public List<NgoaiTe> getAll();
    public void addItem(NgoaiTe ngoaiTe);
}
