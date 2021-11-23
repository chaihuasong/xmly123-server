package com.htz.xmly.repositories;

import com.htz.xmly.entries.VisitCount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VisitCountRepository extends MongoRepository<VisitCount, String> {
    VisitCount findByIdEquals(String id);
    VisitCount findByDateAndTypeEquals(String date, String type);
}
