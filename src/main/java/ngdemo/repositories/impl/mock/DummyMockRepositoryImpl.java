package ngdemo.repositories.impl.mock;

import ngdemo.domain.User;
import ngdemo.repositories.contract.DummyRepository;

import javax.ejb.Stateless;

@Stateless
public class DummyMockRepositoryImpl extends GenericMockRepository<User> implements DummyRepository
{

    @Override
    public User getDefaultUser() {
        User user = new User();
        user.setFirstName("JonFromREST");
        user.setLastName("DoeFromREST");
        return user;
    }
}