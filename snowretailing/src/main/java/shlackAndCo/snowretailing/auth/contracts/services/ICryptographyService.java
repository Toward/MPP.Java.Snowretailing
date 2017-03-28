package shlackAndCo.snowretailing.auth.contracts.services;

import org.osgi.service.component.annotations.Component;

@Component
public interface ICryptographyService {
    String encrypt(String data);

    String decrypt(String data);
}
