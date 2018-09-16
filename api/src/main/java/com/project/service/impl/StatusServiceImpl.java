package com.project.service.impl;

import com.project.bean.Status;
import com.project.repository.StatusRepository;
import com.project.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status findById(Integer id) {
        return statusRepository.findOne(id);
    }

    @Override
    public void create(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void update(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void delete(Integer idStatus) {
        statusRepository.delete(idStatus);
    }
}
