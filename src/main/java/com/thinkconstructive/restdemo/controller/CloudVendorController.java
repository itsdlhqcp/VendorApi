package com.thinkconstructive.restdemo.controller;


import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController
{

    CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

// read specific cloud vendor details
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {

        return  cloudVendorService.getCloudVendor(vendorId);

    }

    // Read all cloud vendor details
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails()
    {

        return  cloudVendorService.getAllCloudVendors();
    }

   // Vendor CREATE API
    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully!";
    }

// vendor update
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
       cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor updated Successfully!";
    }

    // vendor deleted
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor deleted Successfully!";
    }
}
