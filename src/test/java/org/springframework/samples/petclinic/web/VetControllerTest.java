package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {
    @Mock
    ClinicService clinicService;
    @Mock
    Map<String, Object> model; // mock object for showVetList(Map<String, Object> model);
    @InjectMocks
    VetController vetController;

    // Mock Data
    List<Vet> vetList = new ArrayList<>();


    @BeforeEach
    void setUp() {
    // create vet and add to list
        vetList.add(new Vet());
    // mock behavior of clinic service calls to findVets()
        // because we're Unit testing this controller - and findVets is the responsibliity of the service, we mock it'
        // behavior to isolate only the controller
        given(clinicService.findVets()).willReturn(vetList);

    }

    @Test
    void showVetList() {
        // when - initiating the behavior we're testing
        String view = vetController.showVetList(model);

        // then - verifying that the mocked service is calling the right methods (behaving the way it should)
        then(clinicService).should().findVets(); // 'should()' implicitly expects 1 call - you can use 'times()' if you need more than one call)
        then(model).should().put(anyString(), any());

        // verify response - is the state of the application what it should be?
        assertThat("vets/vetList").isEqualToIgnoringCase(view);
    }

    @Test
    void showJsonVetList() {
        // when
        Vets vets = vetController.showJsonVetList();

        // then
        then(clinicService).should().findVets();

        // verify response
        assertThat(vets.getVetList()).hasSize(1);

    }

    @Test
    void showXmlVetList() {
        // when
        Vets vets = vetController.showXmlVetList();

        // then
        then(clinicService).should().findVets();
        assertThat(vets.getVetList()).hasSize(1);
    }
}
