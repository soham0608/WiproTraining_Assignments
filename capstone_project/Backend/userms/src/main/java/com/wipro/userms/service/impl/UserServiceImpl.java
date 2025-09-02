package com.wipro.userms.service.impl;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.wipro.userms.dto.Token;
import com.wipro.userms.entity.User;
import com.wipro.userms.repo.UserRepo;
import com.wipro.userms.service.UserService;
import com.wipro.userms.util.AppConstant;
import com.wipro.userms.util.EncryptUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User findById(int id) {
		Optional<User> userOpt = userRepo.findById(id);
		if (userOpt.isPresent()) {
			return userOpt.get();
		}
		return null;
	}

	@Override
	public void save(User user) {
		if (user.getPassWord() != null) {
			String salt = org.springframework.security.crypto.bcrypt.BCrypt.gensalt();
			user.setSalt(salt);
			String encryptedPass = EncryptUtil.getEncryptedPassword(user.getPassWord(), salt);
			user.setPassWord(encryptedPass);
		}
		userRepo.save(user);
	}

	@Override
	public void deleteById(int id) {
		userRepo.deleteById(id);
	}

	@Override
	public Token login(User user) {
		User userSalt = userRepo.findByUserId(user.getUserId());

		if (userSalt == null) {
	        return null;
	    }
		
		System.out.println("db salt=" + userSalt);
		String encrypTestPassword = EncryptUtil.getEncryptedPassword(user.getPassWord(), userSalt.getSalt());
		User userData = userRepo.findByUserIdAndPassWord(user.getUserId(), encrypTestPassword);
		if (userData != null) {
			String userId = String.valueOf(userData.getId());
			String role = (userData.getUserType() == 0) ? "ADMIN" : "CUSTOMER";
			
			String jwtToken = "Bearer " + getJWTToken(userId, role);
			System.out.println("token=" + jwtToken);
			Token token = new Token();
			token.setToken(jwtToken);
			token.setRole(role);
			return token;
		}
		return null;
	}

	private String getJWTToken(String userId, String role) {
		Key key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(AppConstant.SECRET));
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		return Jwts.builder()
				.setId("jwtExample")
				.setSubject(userId)
				.claim("role", role)
				.claim("authorities", grantedAuthorities.stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList()))
				.setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 600000)).signWith(key)
				.compact();
	}

}