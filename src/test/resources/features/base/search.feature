@Feature1
Feature: Book Search

  @Smoke @Test1 @function2
  Scenario: V1 Correct non-zero number of books found by author
    Given I have the following books in the store
      | The Devil in the White City          | Erik Larson |
      | The Lion, the Witch and the Wardrobe | C.S. Lewis  |
      | In the Garden of Beasts              | Erik Larson |
    When I search for books by author Erik Larson
    Then I find 2 books

  @Smoke @Regression @Test2 @function1
  Scenario: V2 Correct non-zero number of books found by author
    Given I have the following books in the store
      | title                                | author      |
      | The Devil in the White City          | Erik Larson |
      | The Lion, the Witch and the Wardrobe | C.S. Lewis  |
      | In the Garden of Beasts              | Erik Larson |
    When I search for books by author Erik Larson
    Then I find 2 books

  @Regression @Test6
  Scenario: V6 Correct non-zero number of books found by author
    Given I have the following books in the store
      | title                                | author      |
      | The Devil in the White City          | Erik Larson |
      | The Lion, the Witch and the Wardrobe | C.S. Lewis  |
      | In the Garden of Beasts              | Erik Larson |
    When I search for books by author Erik Larson
    Then I find 2 books
