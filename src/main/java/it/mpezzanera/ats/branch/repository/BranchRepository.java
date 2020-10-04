package it.mpezzanera.ats.branch.repository;

import it.mpezzanera.ats.branch.model.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BranchRepository extends MongoRepository<Branch, String> {

    @Query("{ $text : { $search : ?0, $caseSensitive : false } }")
    List<Branch> textSearch(String text);

}
