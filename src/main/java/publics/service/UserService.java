package publics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publics.model.User;
import publics.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAllAd() {
        return repo.findAll();
    }

    public User findById(int id) {
        User ad = repo.findById(id).get();
        return ad;
    }
}
