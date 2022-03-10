package com.jeferson.gestorfinaceiro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Value("$security.jwt.signing-key")
	private String signigKey;
	@Bean
	public TokenStore tokenStore() {
		
		return new JwtTokenStore(acessTokenConverter());
	}
	
	
	@Bean
	public JwtAccessTokenConverter acessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(signigKey);
		return tokenConverter;
	}
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// TODO Auto-generated method stub
		endpoints
		.tokenStore(tokenStore())
		.accessTokenConverter(acessTokenConverter())
		.authenticationManager(authenticationManager);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		clients
		.inMemory()
		.withClient("my-angular-app")
		.secret("@321")
		.scopes("read", "write")
		.authorizedGrantTypes("password")
		.accessTokenValiditySeconds(1800);
	}

}
