package ngdemo.service.impl;


import ngdemo.domain.User;
import ngdemo.repositories.contract.DummyRepository;
import ngdemo.service.contract.DummyService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DummyServiceImpl implements DummyService {

    @Inject
    private DummyRepository dummyRepository;

    @Override
    public User getDefaultUser() {
        Object defaultUser = this.dummyRepository.getDefaultUser();
        return this.dummyRepository.getDefaultUser();
    }

}
