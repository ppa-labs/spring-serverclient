package ppa.lab.spring.springserverclient.service;

import org.springframework.stereotype.Service;
import ppa.lab.spring.springserverclient.exception.ServiceException;
import ppa.lab.spring.springserverclient.model.dto.SimplePersonDto;
import ppa.lab.spring.springserverclient.model.repository.SimplePersonRepository;
import ppa.lab.spring.springserverclient.service.api.SimplePersonService;
import ppa.spring.domain.bean.SimplePerson;

import java.util.Optional;

@Service
public class DefautlSimplePersonService implements SimplePersonService {
    private SimplePersonRepository simplePersonRepository;

    public DefautlSimplePersonService(SimplePersonRepository simplePersonRepository) {
        this.simplePersonRepository = simplePersonRepository;
    }

    @Override public Optional<SimplePersonDto> getSimplePerson(Long id) {

        Optional<SimplePerson> simplePerson = simplePersonRepository.findById(id);
        if(simplePerson.isPresent()) {
            return Optional.of(mapSimplePerson(simplePerson.get()));
        }
        return Optional.empty();
    }

    @Override public SimplePersonDto getSimplePerson(String firstName, String lastName) throws ServiceException {
        SimplePerson simplePerson = simplePersonRepository.findByFirstNameAndLastName(firstName, lastName);
        if(simplePerson == null) {
            throw new ServiceException(String.format("la personne [%s,%s] n'a pas été trouvée.", firstName, lastName));
        }

        return mapSimplePerson(simplePerson);
    }

    private SimplePersonDto mapSimplePerson (SimplePerson simplePerson) {
        SimplePersonDto simplePersonDto = new SimplePersonDto();

        simplePersonDto.setId(simplePerson.getId());
        simplePersonDto.setFirstName(simplePerson.getFirstName());
        simplePersonDto.setLastName(simplePerson.getLastName());

        return simplePersonDto;
    }
}
