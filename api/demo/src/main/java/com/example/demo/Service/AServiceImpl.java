package com.example.demo.Service;

import com.example.demo.entity.Boss;

import com.example.demo.repository.TeacherRepository;
import com.example.demo.repository.StaffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AServiceImpl implements AService {
    private static final Logger logger = LoggerFactory.getLogger(AServiceImpl.class);

    private final TeacherRepository aRepository;
    private final StaffRepository cRepository;

    public AServiceImpl(TeacherRepository aRepository, StaffRepository cRepository) {
        this.aRepository = aRepository;
        this.cRepository = cRepository;

    }


    @Override
    public void updateAOfB(Long id, Boss a) {
    }

    @Override
    public void updateAOfC(Long id, Boss a) {
    }


}
