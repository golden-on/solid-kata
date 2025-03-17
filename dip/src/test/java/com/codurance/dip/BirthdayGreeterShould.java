package com.codurance.dip;

import static com.codurance.dip.EmployeeBuilder.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.MonthDay;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BirthdayGreeterShould {
    private static final int CURRENT_MONTH = 7;
    private static final int CURRENT_DAY_OF_MONTH = 9;
    private static final MonthDay TODAY = MonthDay.of(CURRENT_MONTH, CURRENT_DAY_OF_MONTH);

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private Clock clock;

    @InjectMocks
    private BirthdayGreeter birthdayGreeter;

    @Mock
    private Sendable emailSender;

    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();

    @Test
    public void should_send_greeting_email_to_employee() {
        System.setOut(new PrintStream(consoleContent));
        given(clock.monthDay()).willReturn(TODAY);
        Employee employee = anEmployee().build();
        given(employeeRepository.findEmployeesBornOn(MonthDay.of(
                CURRENT_MONTH,
                CURRENT_DAY_OF_MONTH
        ))).willReturn(Collections.singletonList(employee));
        
        willAnswer(invocation -> {
            Email email = invocation.getArgument(0);
            System.out.print("To:" + email.getTo() + ", Subject: " + email.getSubject() + ", Message: " + email.getMessage());
            return null;
        }).given(emailSender).send(any(Email.class));

        birthdayGreeter.sendGreetings();

        String actual = consoleContent.toString();
        assertThat(actual)
                .isEqualTo("To:" + employee.getEmail() + ", Subject: Happy birthday!, Message: Happy birthday, dear " + employee.getFirstName() + "!");

    }


}