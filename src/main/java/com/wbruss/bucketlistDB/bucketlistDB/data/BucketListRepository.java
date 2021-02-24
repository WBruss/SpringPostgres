package com.wbruss.bucketlistDB.bucketlistDB.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketListRepository extends JpaRepository<BucketList, Long> {
}
