Feature: Coders Lab

  Scenario: Tworzenie konta
    Given wejscie na strone hotel-testlab.coderslab.pl
    When tworzenie konta nowego użytkownika
    Then przekierowanie do strony profilu i wyświetlenie wiadomości o utworzeniu konta
