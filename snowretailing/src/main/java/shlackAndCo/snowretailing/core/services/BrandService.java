package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBrandRepository;
import shlackAndCo.snowretailing.core.contracts.models.IBrandModel;
import shlackAndCo.snowretailing.core.contracts.services.IBrandService;
import shlackAndCo.snowretailing.core.models.BrandModel;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class BrandService implements IBrandService {
    private final IBrandRepository brandRepository;

    @Autowired
    public BrandService(@Qualifier("brandRepository") IBrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @Override
    public Collection<IBrandModel> getAll() {
        Collection<IBrandEntity> brandEntities = brandRepository.getAll();
        return brandEntities.stream().map(x -> new BrandModel(x)).collect(Collectors.toList());
    }

    @Override
    public IBrandModel getById(int id) {
        IBrandEntity brandEntity = brandRepository.getById(id);
        return new BrandModel(brandEntity);
    }

    @Override
    public int create(IBrandModel model) {
        return brandRepository.create(Map(model));
    }

    public void edit(int brandId, IBrandModel model) {
        IBrandEntity entity = Map(model);
        entity.setId(brandId);
        brandRepository.update(entity);
    }

    public void delete(int brandId) {
        brandRepository.delete(brandId);
    }

    private IBrandEntity Map(IBrandModel model){
        IBrandEntity result = new BrandEntity();
        result.setId(model.getId());
        result.setBrandName(model.getBrandName());
        return result;
    }
}
