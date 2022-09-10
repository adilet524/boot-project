package bootproject.peaksoft.service;

import bootproject.peaksoft.dao.UserDao;
import bootproject.peaksoft.entities.SecurityUser;
import bootproject.peaksoft.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User name not found!");
        }
        return new SecurityUser(user);
    }
}
