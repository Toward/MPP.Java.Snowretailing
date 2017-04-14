package coreUnitTests.services;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.models.EquipmentModel;
import shlackAndCo.snowretailing.core.services.BrandService;
import shlackAndCo.snowretailing.core.services.EquipmentService;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentEntity;
import shlackAndCo.snowretailing.dal.enums.EquipmentTypes;
import shlackAndCo.snowretailing.dal.repositories.BrandRepository;
import shlackAndCo.snowretailing.dal.repositories.EquipmentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class EquipmentServiceTests {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void ctor_equipmentRepositoryIsNull_throwIllegalArgumentException(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("equipmentRepository is null");
        EquipmentService testedService = new EquipmentService(null, null, null);
    }
    @Test
    public void ctor_brandRepositoryIsNull_throwIllegalArgumentException(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("brandRepository is null");
        EquipmentService testedService = new EquipmentService(Mockito.mock(EquipmentRepository.class),null,null);
    }
    @Test
    public void ctor_typeRepositoryIsNull_throwIllegalArgumentException(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("typeRepository is null");
        EquipmentService testedService = new EquipmentService(Mockito.mock(EquipmentRepository.class),Mockito.mock(BrandRepository.class),null);
    }


}
