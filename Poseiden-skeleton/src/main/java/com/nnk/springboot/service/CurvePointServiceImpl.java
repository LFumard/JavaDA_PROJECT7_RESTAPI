package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurvePointServiceImpl implements CurvePointService{

    @Autowired
    CurvePointRepository curvePointRepository;

    @Override
    public List<CurvePoint> findAll() {
        return curvePointRepository.findAll();
    }

    @Override
    public void save(CurvePoint curvePoint) {
        curvePointRepository.save(curvePoint);
    }

    @Override
    public CurvePoint findById(Integer id) {
        return curvePointRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid Id CurvePoint : " + id));
    }

    @Override
    public CurvePoint update(Integer id, CurvePoint curvePoint) {
        CurvePoint curvePointToSave = curvePointRepository.findById(id).orElseThrow(() -> new RuntimeException("Curve Point doen't exist"));
        curvePointToSave.setCurveId(curvePoint.getCurveId());
        curvePointToSave.setTerm(curvePoint.getTerm());
        curvePointToSave.setValue(curvePoint.getValue());
        return (curvePointToSave);

    }

    @Override
    public void delete(Integer id) {
        CurvePoint curvePointToDel = curvePointRepository.findById(id).orElseThrow(() -> new RuntimeException("Curve Point doen't exist"));
        curvePointRepository.delete(curvePointToDel);
    }
}
