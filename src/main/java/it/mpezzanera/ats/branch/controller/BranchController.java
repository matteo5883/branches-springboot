package it.mpezzanera.ats.branch.controller;

import it.mpezzanera.ats.branch.model.Branch;
import it.mpezzanera.ats.branch.service.BranchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService service;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Branch>> findAll() {
        List<Branch> branches = service.findAll();
        return ResponseEntity.ok()
                .body(branches);
    }

    @GetMapping(value = "all/filter", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Branch>> findFiltered(@RequestParam("text") String text) {
        if(StringUtils.isBlank(text)) {
            return findAll();
        }
        List<Branch> branches = service.findFilter(text);
        return ResponseEntity.ok()
                .body(branches);
    }
}
