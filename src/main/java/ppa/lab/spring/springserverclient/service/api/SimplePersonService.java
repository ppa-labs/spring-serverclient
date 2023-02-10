package ppa.lab.spring.springserverclient.service.api;

import ppa.lab.spring.springserverclient.exception.ServiceException;
import ppa.lab.spring.springserverclient.model.dto.SimplePersonDto;

import java.util.Optional;

public interface SimplePersonService {

    Optional<SimplePersonDto> getSimplePerson(Long id) throws ServiceException;

    SimplePersonDto getSimplePerson(String firstName, String lastName) throws ServiceException;
}