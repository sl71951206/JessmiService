package pe.jessmi.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jessmi.entity.RoleEntity;
import pe.jessmi.entity.UserEntity;
import pe.jessmi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	@Transactional
	public void insert(UserEntity user) {
		repository.save(user);
	}

	@Override
	@Transactional(readOnly=true)
	public UserEntity findById(Integer userId) {
		return repository.findById(userId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<UserEntity> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void update(UserEntity user) {
		repository.save(user);
	}

	@Override
	@Transactional
	public void delete(Integer userId) {
		repository.deleteById(userId);
	}
	
	//

	@Override
	@Transactional(readOnly=true)
	public UserEntity findByUsername(String username) {
		return repository.findByUsername(username);
	}
	
	//

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userDb = this.findByUsername(username);
		if (userDb != null) {
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			for(RoleEntity role : userDb.getRoles()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getType()));
			}
			User user = new User(userDb.getUsername(), userDb.getPassword(), authorities);
			return user;
		}
		throw new UsernameNotFoundException("¡Error, username no existe!");
	}

}
