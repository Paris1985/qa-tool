@Feature2
Feature: Book Search

  @Regression @Test3 @function1
  Scenario: V3 Correct non-zero number of books found by author
    Given I have the following books in the store
      | The Devil in the White City          | Erik Larson |
      | The Lion, the Witch and the Wardrobe | C.S. Lewis  |
      | In the Garden of Beasts              | Erik Larson |
    When I search for books by author Erik Larson
    Then I find 2 books

  @Smoke @Test4
  Scenario: V4 Correct non-zero number of books found by author
    Given I have the following books in the store
      | title                                | author      |
      | The Devil in the White City          | Erik Larson |
      | The Lion, the Witch and the Wardrobe | C.S. Lewis  |
      | In the Garden of Beasts              | Erik Larson |
    When I search for books by author Erik Larson
    Then I find 2 books

  @Smoke @Test5 @function1
  Scenario: V5 Correct non-zero number of books found by author
    Given I have the following books in the store
      | title                                | author      |
      | The Devil in the White City          | Erik Larson |
      | The Lion, the Witch and the Wardrobe | C.S. Lewis  |
      | In the Garden of Beasts              | Erik Larson |
    When I search for books by author Erik Larson
    Then I find 2 books
