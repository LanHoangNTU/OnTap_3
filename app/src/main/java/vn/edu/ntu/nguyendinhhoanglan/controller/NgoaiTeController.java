package vn.edu.ntu.nguyendinhhoanglan.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.nguyendinhhoanglan.model.NgoaiTe;

public class NgoaiTeController extends Application implements INgoaiTeController {
    List<NgoaiTe> list = new ArrayList<>();

    public NgoaiTeController() {
    }

    @Override
    public List<NgoaiTe> getAll() {
        return list;
    }

    @Override
    public void addItem(NgoaiTe ngoaiTe) {
        list.add(ngoaiTe);
    }
}
