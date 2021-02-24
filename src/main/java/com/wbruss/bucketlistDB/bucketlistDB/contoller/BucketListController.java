package com.wbruss.bucketlistDB.bucketlistDB.contoller;

import com.wbruss.bucketlistDB.bucketlistDB.data.BucketList;
import com.wbruss.bucketlistDB.bucketlistDB.data.BucketListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BucketListController {

    @Autowired
    BucketListRepository bucketListRepository;

    @GetMapping(value = "/")
    public ResponseEntity index() {
        return ResponseEntity.ok(bucketListRepository.findAll());
    }

    @GetMapping(value = "/bucket")
    public ResponseEntity getBucket(@RequestParam(value = "id") Long id){
        Optional<BucketList> foundBucketList = bucketListRepository.findById(id);

        if(foundBucketList.isPresent()){
            return ResponseEntity.ok(foundBucketList.get());
        }else{
            return ResponseEntity.badRequest().body("No bucket with specific id " + id + "found");
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity addToBucketList(@RequestParam(value = "name") String name, @RequestParam(value = "description") String description){
        return  ResponseEntity.ok(bucketListRepository.save(new BucketList(name, description)));
    }

    @PutMapping
    public ResponseEntity updateBucketList(@RequestParam(value = "name") String name, @RequestParam(value = "id") Long id, @RequestParam(value = "description") String description){
        Optional<BucketList> optionalBucketList = bucketListRepository.findById(id);
        if(!optionalBucketList.isPresent()){
            return ResponseEntity.badRequest().body("No Bucket with specified id " + id + " found");
        }
        BucketList foundBucketList = optionalBucketList.get();
        foundBucketList.setName(name);
        foundBucketList.setDescription(description);
        return  ResponseEntity.ok(bucketListRepository.save(foundBucketList));
    }

    @DeleteMapping
    public ResponseEntity removeBucketList(@RequestParam(value = "id") Long id){
        bucketListRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
