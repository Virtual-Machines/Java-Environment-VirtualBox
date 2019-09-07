package com.app.service.generic;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.constant.CoreConstants;
import com.app.model.dto.AuthorityDto;
import com.app.model.dto.UserDto;
import com.app.service.UserService;

/**
 * Authenticates user to Spring Security
 * 
 * @author David García Prados
 *
 */
@Service
@Transactional
public class UserAuthenticationServiceImpl implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) {

		UserDto userDto = userService.getUserByUsername(username, false); // Fake deleted users are not
		// included

		UserBuilder builder = null;
		if (userDto != null) {

			builder = User.withUsername(username);
			builder.disabled(!userDto.getUsrEnabled()); // Disabled users cannot login
			builder.password(userDto.getUsrPassword());
			List<String> authorities = new LinkedList<>();
			for (AuthorityDto autho : userDto.getAuthorities()) {
				authorities.add(CoreConstants.PREFIX_OF_ROLE + autho.getRole().getRolCode());
			}
			builder.authorities(authorities.stream().toArray(String[]::new));
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}

}
