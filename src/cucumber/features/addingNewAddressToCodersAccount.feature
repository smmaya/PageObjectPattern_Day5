Feature: Coders Lab

  Scenario: Dodanie adresu
    Given zalogowany na coderslab w zakladce dodaj adres
    When dodanie nowego adresu
    Then wyswietlenie wiadomosci o dodaniu adresu

#  Scenario Outline: user can search any keyword
#    Given an open browser with google.com
#    When a keyword <searchTerm> is entered in input field
#    Then the first one should contains "<searchResult>"
#    And close browser
#
#    Examples:
#      | searchTerm                      | searchResult |
#      | selenium                        | selenium     |
#      | lewandowski                     | lewandowski  |
#      | oijaendfgiun48392y7tbzsedfrg97b |              |
#      | site:coderslab.pl python        | coderslab    |