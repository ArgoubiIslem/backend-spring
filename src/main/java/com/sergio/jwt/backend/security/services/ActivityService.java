package com.sergio.jwt.backend.security.services;




import com.sergio.jwt.backend.models.Activity;

import com.sergio.jwt.backend.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Optional<Activity> getActivityById(Long id) {
        return activityRepository.findById(id);
    }


    public Activity  saveOrUpdateActivity(Activity activity) {

        return activityRepository.save(activity);
    }



    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }
}




