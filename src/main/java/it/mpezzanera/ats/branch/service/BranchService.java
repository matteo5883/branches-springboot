package it.mpezzanera.ats.branch.service;

import it.mpezzanera.ats.branch.dto.BranchDTO;
import it.mpezzanera.ats.branch.model.Branch;
import it.mpezzanera.ats.branch.repository.BranchRepository;
import it.mpezzanera.ats.branch.transformer.BranchTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository repository;

    public List<Branch> findAll(){
        List<Branch> branches = repository.findAll();
        if(branches == null || branches.isEmpty()){
            BranchDTO[] responseEntity = getBranchDTO();
            if(responseEntity != null){
                for(BranchDTO dto: responseEntity){
                    branches.add(BranchTransformer.fromDtoToModel(dto));
                }
                repository.saveAll(branches);
            }
        }
        return branches;
    }

    public List<Branch> findFilter(String filter){
        List<Branch> branches = repository.textSearch(filter);
        return branches;
    }

    private BranchDTO[] getBranchDTO() {
        String url = "https://www.dropbox.com/s/6fg0k2wxwrheyqk/ATMs?dl=1";
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jackson2HttpMessageConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(jackson2HttpMessageConverter);
        return restTemplate.getForObject(url, BranchDTO[].class);
    }
}
