package it.mpezzanera.ats.branch.transformer;

import it.mpezzanera.ats.branch.dto.AddressDTO;
import it.mpezzanera.ats.branch.dto.BranchDTO;
import it.mpezzanera.ats.branch.model.Address;
import it.mpezzanera.ats.branch.model.Branch;
import it.mpezzanera.ats.branch.model.GeoLocation;
import org.springframework.beans.BeanUtils;

public class BranchTransformer {

    public static Branch fromDtoToModel(BranchDTO dto) {
        Branch model = new Branch();
        BeanUtils.copyProperties(dto, model);
        Address addresModel = new Address();
        AddressDTO addressDTO = dto.getAddress();
        BeanUtils.copyProperties(addressDTO, addresModel);
        GeoLocation geoLocationModel = new GeoLocation();
        BeanUtils.copyProperties(addressDTO.getGeoLocation(), geoLocationModel);
        addresModel.setGeoLocation(geoLocationModel);
        model.setAddress(addresModel);
        return model;
    }

}
