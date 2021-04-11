package com.vueblog.blog.controllers;

import com.vueblog.blog.util.JwtUtil;
import com.vueblog.blog.services.*;
import com.vueblog.blog.models.AuthenticationRequest;
import com.vueblog.blog.models.AuthenticationResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.http.ResponseEntity;

@RestController
class HelloWorldController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	private final BCryptPasswordEncoder bCrypt;

	public HelloWorldController(){
		this.bCrypt = new BCryptPasswordEncoder(11);
	}

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
		try {
			if(this.bCrypt.matches(authenticationRequest.getPassword(),userDetails.getPassword())){
				final String jwt = jwtTokenUtil.generateToken(userDetails);

				return ResponseEntity.ok(new AuthenticationResponse(jwt));
			}
			else{
				throw new Exception("Incorrect username or password");
			}
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		

		
	}

}