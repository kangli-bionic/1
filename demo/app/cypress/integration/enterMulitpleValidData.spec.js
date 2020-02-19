import {
    deleteAllFizzBuzzItems,
} from '../support/utils';

context('Enter multiple valid data', () => {
    beforeEach(() => {
        cy.visit()
    })

    function insertNewFizzBuzzItem(input) {
        cy.get('[data-testid=fizzbuzz-input]').type(input);
        cy.get('[data-testid=fizzbuzz-button-submit]').click();
        cy.wait(3000);
    }

    it('Should type in unordered numbers and the numbers should be displayed in ascending order', () => {
        // arrange
        deleteAllFizzBuzzItems();
        const inputList = [222,2,3,333,5,7,333,9,10,23];
        const sortedUnique = Array.from(new Set(inputList)).sort((a,b) => a - b);

        // act
        inputList.forEach(insertNewFizzBuzzItem);
        cy.wait(1500);

        // assert
        cy.get('[data-testid=fizzbuzz-display-input-value]').each(($el, i) => {
            cy.wrap($el).contains(sortedUnique[i]);
        });
    });
})
