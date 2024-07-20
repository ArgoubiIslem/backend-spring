package com.sergio.jwt.backend.controllers;

import com.sergio.jwt.backend.models.Activity;

import com.sergio.jwt.backend.security.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activities")
public class MaintenanceController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public ResponseEntity<List<Activity>> getAllActivities() {
        try {
            List<Activity> activities = activityService.getAllActivities();
            return ResponseEntity.ok(activities);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
        try {
            Optional<Activity> activity = activityService.getActivityById(id);
            return activity.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        Activity createdActivity = activityService.saveOrUpdateActivity(activity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdActivity);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable("id") Long id, @RequestBody Activity activity) {
        if (!activityService.getActivityById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        activity.setId(id);
        Activity updateActivity = activityService.saveOrUpdateActivity(activity);
        return ResponseEntity.ok(updateActivity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        try {
            Optional<Activity> existingActivity = activityService.getActivityById(id);
            if (existingActivity.isPresent()) {
                activityService.deleteActivity(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
